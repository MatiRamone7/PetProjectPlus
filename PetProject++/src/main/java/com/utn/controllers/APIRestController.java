package com.utn.controllers;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.utn.models.forms.Direccion;
import com.utn.models.forms.FormularioMascotaPerdida;
import com.utn.models.users.Usuario;
import com.utn.transithomes.AdapterApiRestHogaresDeTransito;
import com.utn.transithomes.Hogar;
import com.utn.transithomes.ListadoDeRefugios;
import com.utn.transithomes.Ubication;
import com.utn.models.mascotas.Mascota;
import com.utn.services.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class APIRestController {

	private static final int qrTamAncho = 400;
	private static final int qrTamAlto = 400;
	private static final String formato = "png";
	private static final String ruta = "C:\\Users\\matil\\Desktop\\miCodigoQR3.png";
	private static final String pathFormulario = "https://aulasvirtuales.frba.utn.edu.ar/";

	@GetMapping("generarQRFormulario")
	public void GenerateQR() throws IOException {
		//es donde se aloja la informacion del qr
		BitMatrix matriz;
		//es la clase que me va a generar el q con la informacion
		Writer writer = new QRCodeWriter();

		try {
			//aca codifica la infromacion del qr data(url a codificar), el formato de lo q queremos, los otros dos valor son el tamano
			matriz = writer.encode(pathFormulario, BarcodeFormat.QR_CODE, qrTamAncho, qrTamAlto);
		} catch (WriterException e) {
			e.printStackTrace(System.err);
			return;
		}

		// crea una representacion de la imagen em memoria
		BufferedImage imagen = new BufferedImage(qrTamAncho,
				qrTamAlto, BufferedImage.TYPE_INT_RGB);

		for (int y = 0; y < qrTamAlto; y++) {
			for (int x = 0; x < qrTamAncho; x++) {
				//la ultima parte permite trabajar con los 8 bits mas significativos
				int valor = (matriz.get(x, y) ? 0 : 1) & 0xff;
				//creamos la imagen
				imagen.setRGB(x, y, (valor == 0 ? 0 : 0xFFFFFF));
			}
		}

		//almaceno la imagen en un archivo
		FileOutputStream qrCode = new FileOutputStream(ruta);

		ImageIO.write(imagen, formato, qrCode);
		//System.out.println("Listo!");
		qrCode.close();
	}

	/**
	 * Informar sobre mascota perdida.
	 */

	@Autowired
	IPetService petService;

	@Autowired
	IPublicationService publicationService;

	@PostMapping("/informarMascotaPerdida/{idMascota}")
	public void InformPet(@PathVariable Integer idMascota) throws IOException {
		Mascota mascota = petService.GetPetById(idMascota);

		HashMap<String, String> defaultMessage = new HashMap<>();
		defaultMessage.put("texto", "Se le notifica al usuario que se encontró su mascota");

		Publication nuevaPubli = new Publication();

		if (mascota.getQr() == null) {
			publicationService.CreatePublication(nuevaPubli);
		} else if (mascota.getQr() != null) {
			this.NotifyUser(defaultMessage, idMascota);
		}
	}

	/**
	 * Contacto con el dueño por QR de mascota.
	 */
	public void NotifyUser(HashMap map, Integer idMascota) throws IOException {
		String texto = (String) map.get("texto");
		Mascota mascota = petService.GetPetById(idMascota);
		Usuario usuarioAContactar = mascota.getUsuarioId();

		//usuarioAContactar.contactar();
	}

	/**
	 * Llamar a API de hogares de transito. Esto se movió a el FormularioMascotaPerdida pero dejo esto por si tenemos problemas con el formulario

	@GetMapping("getHogaresTransito")
	public static List<Hogar>  getHogaresTransito() throws IOException {
		AdapterApiRestHogaresDeTransito serviciosRefugios = AdapterApiRestHogaresDeTransito.getInstancia();

		List<String> listaDeCaracteristicas = new ArrayList<>();
		listaDeCaracteristicas.add("manso");
		Ubication lugar = new Ubication("Siempre Viva", -34.634306, -58.511310);
		FormularioMascotaPerdida unaFormularioMascotaPerdida = new FormularioMascotaPerdida("Perro", "Grande", lugar, listaDeCaracteristicas);	 //ejemplo de formulario que ya no se va ausar creo --> ver la clase Hogar
		List<Hogar> listadaAuxiliar = new ArrayList<>();

		ListadoDeRefugios listadoDeRefugios;

		List listaFiltrada;
		int offset = 0;
		try {
			while (true) {
				offset++;

				listadoDeRefugios = serviciosRefugios.listadoDeRefugios(offset);

				listaFiltrada = listadoDeRefugios.hogares.stream().filter(hogar -> hogar.cumpleRequisitosDelHogar(unaFormularioMascotaPerdida)).collect(Collectors.toList());

				listadaAuxiliar.addAll(listaFiltrada);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listadaAuxiliar;
	}*/

	/**
	 * Geocoding API
	 */

	public static Ubication getCoordenadasDeEstaDireccion(Direccion direccion) {

		String urlToRead = 	direccion.getCalle() + "+" +
							String.valueOf(direccion.getNumero()) + ",+" +
							direccion.getCiudad().getNombre() + ",+" +
							direccion.getCiudad().getProvincia().getNombre();

		URL url;
		HttpURLConnection conn;
		BufferedReader rd;
		String line;
		String result = "";
		try {
			url = new URL("http://maps.googleapis.com/maps/api/geocode/json?address=" + urlToRead + ",+CA&key=");
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((line = rd.readLine()) != null) {
				result += line;
			}
			rd.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		//En el result viene los datos con una estructura llamada JSON (que es eso de las llaves { y dentro propiedades:valores, etc...
		//aqui abajo voy navegando por el objeto result y transformandolo hasta que llego a la "location" y ahi leo las propiedades lat y lng
		HashMap properties = new Gson().fromJson(result, HashMap.class);
		List resultados = (List) properties.get("results");
		LinkedTreeMap informacion = (LinkedTreeMap) resultados.get(0); //solo debe venir un elemento y estara en la posicion 0
		LinkedTreeMap geometryInfo = (LinkedTreeMap) informacion.get("geometry");
		LinkedTreeMap locationInfo = (LinkedTreeMap) geometryInfo.get("location");
		System.out.println("La latitud es: " + locationInfo.get("lat")); //LAtitud
		System.out.println("la longitud es: " +locationInfo.get("lng")); //longitud
		//Double aux = new Double(locationInfo.get("lat").toString());
		//double lat = aux.doubleValue();

		Ubication ubicacion = new Ubication(urlToRead,-34.6, -58.5);
		return ubicacion;
	}


}
