package com.utn.contactservices;

public class TipoDeComunicacion {
    public static String asunto(String situacion) {
        switch (situacion) {
            case "M-QREscaneado":
                return "QR de mascota escaneado";

            case "M-MascotaReconocida":
                return "Mascota reconocida por el dueño";

            case "M-InteresDeAdopcion":
                return "Hay alguien interesado en adoptar tu mascota";

            case "M-SugerenciasAdopcion":
                return "Buscando una mascota? Te traemos algunas sugerencias";

            default:
                return " ";
        }
    }

    public static String cuerpo(String situacion) {
        String cuerpoDeMensaje;
        String inputDeUsuario;
        Scanner scanner = new Scanner(System.in);

        switch (situacion) {
            case "M-MascotaReconocida":
                System.out.print("Redacte su mensaje para el rescatista: \t ");
                inputDeUsuario = scanner.nextLine();
                cuerpoDeMensaje = "Mascota reconocida por el dueño \t " + inputDeUsuario;
                return cuerpoDeMensaje;
        }
    };
    //Construir bien los mensajes con datos de formularios y publicaciones
    public static String cuerpo(String situacion, Usuario usuario) {
        String cuerpoDeMensaje;
        String inputDeUsuario;
        Scanner scanner = new Scanner(System.in);

        switch (situacion) {
            case "M-QREscaneado":
                System.out.print("Redacte su mensaje para el dueño de la mascota\t: ")
                inputDeUsuario = scanner.nextLine();
                return "Se ha escaneado el QR de su mascota \t " + inputDeUsuario;

            case "M-InteresDeAdopcion":
                System.out.print("Redacte su mensaje para el dueño de la mascota\t: ")
                inputDeUsuario = scanner.nextLine();
                String datosInteresado = This.obtenerDatosInteresado(Usuario);
                cuerpoDeMensaje = "Un usuario ha mostrado interés en adoptar su mascota \t " + inputDeUsuario + datosInteresado;
                return cuerpoDeMensaje;

            case "M-SugerenciasAdopcion":
                return /*This.armarListaSugerencias(usuario)*/ " ";

            default:
                inputDeUsuario = scanner.nextLine();
                return inputDeUsuario;
        }
    }
}