package com.utn.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivosUtils {
    public static List<String> devolverContenido(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        List<String> cadenaCompleta = new ArrayList<String>();
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            cadenaCompleta.add(cadena);
        }
        b.close();
        return cadenaCompleta;
    }

    public static void escribirContenido(String cadena, String archivo) throws FileNotFoundException, IOException {
        FileWriter f = new FileWriter(archivo);
        BufferedWriter b = new BufferedWriter(f);

        b.write(cadena);
        b.close();
    }

    public static boolean busquedaBinariaString(List<String> arreglo, String valorBuscado){
        int valorCentral = 0;
        int valorInferior = 0;
        int valorSuperior = arreglo.size() - 1;

        while(valorInferior <= valorSuperior){
            valorCentral = (valorSuperior + valorInferior)/2;

            //if (arreglo.get(valorCentral) == valorBuscado){
            if (arreglo.get(valorCentral).equals(valorBuscado)){
                return true;
            }
            else if(valorBuscado.compareTo(arreglo.get(valorCentral)) < 0){
                valorSuperior = valorCentral - 1;
            }
            else{
                valorInferior = valorCentral + 1;
            }
        }

        return false;
    }
}
