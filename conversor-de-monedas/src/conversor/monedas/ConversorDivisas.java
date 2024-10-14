package conversor.monedas;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ConversorDivisas {

    private static final String API_KEY = "fc8c6ee56ad61d32565d4727";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    // Menu Principal
    static void mostrarMenu() {
        System.out.println("\n**************************************************\n");
        System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
        System.out.println("\n**************************************************\n");
        System.out.println("1) Dolar =>> Peso Argentino  ");
        System.out.println("2) Peso Argentino =>> Dolar   ");
        System.out.println("3) Dolar =>> Real Brasileño  ");
        System.out.println("4) Real Brasileño =>> Dolar  ");
        System.out.println("5) Dolar =>> Peso Colombiano ");
        System.out.println("6) Peso Colombiano =>> Dolar ");
        System.out.println("7) Salir");
        System.out.println("\n**************************************************\n");
        System.out.print("Elige una Opcion válida, del 1 al 7: ");
    }


    static void convertirUSDToARS(Scanner scanner) throws IOException {
        System.out.print("Ingresa el monto a convertir (USD): ");
        double montoUSD = scanner.nextDouble();

        String url = BASE_URL + "USD";
        JsonObject jsonobj = makeRequest(url);

        double tipoCambioARS = jsonobj.getAsJsonObject("conversion_rates").get("ARS").getAsDouble();
        double montoARS = montoUSD * tipoCambioARS;
        System.out.println("El Valor " + montoUSD + " [USD] Corresponde al Valor Final de =>> " + montoARS + " [ARS]");
    }

    static void convertirARSToUSD(Scanner scanner) throws IOException {
        System.out.print("Ingresa el monto a convertir (ARS): ");
        double montoARS = scanner.nextDouble();

        String url = BASE_URL + "ARS";
        JsonObject jsonobj = makeRequest(url);

        double tipoCambioUSD = jsonobj.getAsJsonObject("conversion_rates").get("USD").getAsDouble();
        double montoUSD = montoARS * tipoCambioUSD;

        System.out.println("El Valor " + montoARS + " [ARS] Corresponde al Valor Final de =>> " + montoUSD + " [USD]");
    }

    static void convertirUSDToBRL(Scanner scanner) throws IOException {
        System.out.print("Ingresa el monto a convertir (USD): ");
        double montoUSD = scanner.nextDouble();

        String url = BASE_URL + "USD";
        JsonObject jsonobj = makeRequest(url);

        double tipoCambioBRL = jsonobj.getAsJsonObject("conversion_rates").get("BRL").getAsDouble();
        double montoBRL = montoUSD * tipoCambioBRL;

        System.out.println("El Valor " + montoUSD + " [USD] Corresponde al Valor Final de =>> " + montoBRL + " [BRL]");
    }

    static void convertirBRLToUSD(Scanner scanner) throws IOException {
        System.out.print("Ingresa el monto a convertir (BRL): ");
        double montoBRL = scanner.nextDouble();

        String url = BASE_URL + "BRL";
        JsonObject jsonobj = makeRequest(url);

        double tipoCambioUSD = jsonobj.getAsJsonObject("conversion_rates").get("USD").getAsDouble();
        double montoUSD = montoBRL * tipoCambioUSD;
        System.out.println("El Valor " + montoBRL + " [BRL] Corresponde al Valor Final de =>> " + montoUSD + " [USD]");
    }

    static void convertirUSDToCOP(Scanner scanner) throws IOException {
        System.out.print("Ingresa el monto a convertir (USD): ");
        double montoUSD = scanner.nextDouble();

        String url = BASE_URL + "USD";
        JsonObject jsonobj = makeRequest(url);

        double tipoCambioCOP = jsonobj.getAsJsonObject("conversion_rates").get("COP").getAsDouble();
        double montoCOP = montoUSD * tipoCambioCOP;

        System.out.println("El Valor " + montoUSD + " [USD] Corresponde al Valor Final de =>> " + montoCOP + " [COP]");
    }

    static void convertirCOPToUSD(Scanner scanner) throws IOException {
        System.out.print("Ingresa el monto a convertir (COP): ");
        double montoCOP = scanner.nextDouble();

        String url = BASE_URL + "COP";
        JsonObject jsonobj = makeRequest(url);

        double tipoCambioUSD = jsonobj.getAsJsonObject("conversion_rates").get("USD").getAsDouble();
        double montoUSD = montoCOP * tipoCambioUSD;

        System.out.println("El Valor " + montoCOP + " [COP] Corresponde al Valor Final de =>> " + montoUSD + " [USD]");
    }

    private static JsonObject makeRequest(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        try (InputStreamReader reader = new InputStreamReader(request.getInputStream())) {
            JsonElement root = JsonParser.parseReader(reader);
            JsonObject jsonobj = root.getAsJsonObject();


            String reqResult = jsonobj.get("result").getAsString();
            if (!"success".equals(reqResult)) {
                throw new IOException("Error: API request unsuccessful");
            }

            return jsonobj;
        }
    }
}
