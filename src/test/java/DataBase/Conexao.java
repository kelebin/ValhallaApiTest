package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexao {
	//Propriedade prop;

	
	public static  String sql;
	   
	public static  String server = "10.60.30.23";
	public static  String port = "1433";               
	public static  String database = "Valhalla";

      // Configuracao dos parametros de autenticacao
	public static  String user = "UserValhalla";
	public static String passwd = "UserValhalla";
	
	public String getUrl() {
		return url;
	}

	public String getDriver() {
		return driver;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String url = "jdbc:sqlserver://" + server + ":" + port + ";database=" + database;
    public String driver = "com.microsoft.sqlserver.jdbc.SQLServerDataSource";
	
/*	public static void main(String[] args) {
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
            sql = Queries.BUSCAR_DADOS_REDUCAO;

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
    }*/
}