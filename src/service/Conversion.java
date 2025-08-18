package service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
//import service.ConsumoApi;

public class Conversion {
    private final ConsumoApi consumoApi = new ConsumoApi();

    public double convertirMoneda(String monedaInicial, String monedaConvvertida, double cantidad) {
        String url = "https://v6.exchangerate-api.com/v6/ff481dc7d6e8aa21caeab601/pair/" +
                monedaInicial + "/" + monedaConvvertida + "/" + cantidad;

        String json = consumoApi.obtenerDatos(url);

        JsonObject objeto = JsonParser.parseString(json).getAsJsonObject();
        double resultado = objeto.get("conversion_result").getAsDouble();

        return resultado;
    }
}