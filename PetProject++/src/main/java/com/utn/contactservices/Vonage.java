public class SMS {
    public static void enviarMensaje(String destinatario, String cuerpo) {

        String VONAGE_API_KEY = "a29603b3";
        String VONAGE_API_SECRET = "fCC5FORsT98QFP7y"; //data privada igual q contraseña del mail, guardarla mejor
        String VONAGE_BRAND_NAME = "Servicios.Vonage APIs";

        /*
        VonageClient client = VonageClient.builder().apiKey("a29603b3").apiSecret("fCC5FORsT98QFP7y").build();
        TextMessage message = new TextMessage(VONAGE_BRAND_NAME, destinatario, cuerpo);

        SmsSubmissionResponse response = client.getSmsClient().submitMessage(message);

        if (response.getMessages().get(0).getStatus() == MessageStatus.OK) {
            System.out.println("Message sent successfully.");
        } else {
            System.out.println("Message failed with error: " + response.getMessages().get(0).getErrorText());
        }
        */

        //ESTE COBRA EN EUROS, NO TESTEAR DEMASIADO
    }
}
