package validacao;

import java.util.List;
import java.util.Map;

import io.restassured.response.Response;

public class validador {

	public boolean validarBodyRequest(Response response) {
		Map<String, String> jsonResponse = response.jsonPath().getMap("$");
		boolean resultado = jsonResponse.get("servidor").equals("10.60.30.23")
				|| jsonResponse.get("banco").equals("Valhalla") == true
				|| jsonResponse.get("situacao").equals("Agendado") == true;
		return resultado;
	}
}
