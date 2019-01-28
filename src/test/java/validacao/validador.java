package validacao;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import DataBase.Conexao;
import DataBase.Queries;
import io.restassured.response.Response;

public class validador extends Conexao {

	public boolean validarBodyRequest(Response response) {
		Map<String, String> jsonResponse = response.jsonPath().getMap("$");

		boolean resultado = jsonResponse.get("servidor").equals("10.60.30.23")
				|| jsonResponse.get("banco").equals("Valhalla") == true
				|| jsonResponse.get("situacao").equals("Agendado") == true;
		return resultado;
	}

	public void validarDadosBanco(Response response) throws SQLException, ClassNotFoundException {
		Map<String, String> jsonResponse = response.jsonPath().getMap("$");
		String processID = jsonResponse.get("processoId");
	  
        Class.forName(driver);	
        Connection con = DriverManager.getConnection(url, user, passwd);

        Statement stmt = con.createStatement();

       // sql = Queries.BUSCAR_DADOS_REDUCAO;
        
        sql = "SELECT * FROM ReducaoBase WHERE processoId = '" + processID + "'";

      
        ResultSet res = stmt.executeQuery(sql);
        
        String resFinal = null;
        
        while (res.next()) {
         resFinal = res.getString("processoId");
         
        }
        
        assertEquals(processID, resFinal );


        con.close();
	}
}
