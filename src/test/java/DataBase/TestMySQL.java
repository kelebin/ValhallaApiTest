package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestMySQL {
	//Propriedade prop;

	public static void main(String[] args) {
        String sql;
   
        String server = "10.60.30.23";
        String port = "1433";               
        String database = "Valhalla";

        // Configuracao dos parametros de autenticacao
        String user = "UserValhalla";
        String passwd = "UserValhalla";

        try {
        //dataSource.setUrl("jdbc:sqlserver://10.60.30.23:1433;user=UserValhalla;password=UserValhalla");
        	String url = "jdbc:sqlserver://" + server + ":" + port + ";database=" + database;
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDataSource";

            // Abre-se a conex�o com o Banco de Dados
            Class.forName(driver);	
            Connection con = DriverManager.getConnection(url, user, passwd);

            // Cria-se Statement com base na conexao
            Statement stmt = con.createStatement();

            // Exemplo: navegando e exibindo os dados
            sql = "SELECT TOP 10 * FROM baseDados  ";

            // Executa-se a consulta dos campos 
            ResultSet res = stmt.executeQuery(sql);
            
            Integer idBaseDados;
            String baseDados;
            String servidor;
            String usuario;

            while (res.next()) {
            	idBaseDados = res.getInt("idBaseDados");
            	baseDados = res.getString("Base");
            	servidor = res.getString("servidor");
            	usuario = res.getString("usuario");
                System.out.println(  idBaseDados + " - "+ baseDados + " - "+ servidor  +" - "+ usuario);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}