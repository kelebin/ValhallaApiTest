package DataBase;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Propriedade {
public static void main(String[] args) throws IOException {
	Properties prop = new Properties();
	prop.setProperty("chave", "valor");
	FileWriter file = new FileWriter("config.properties");
	prop.store(file, "Autor: Kevin Ferreira");
	file.close();
}
}
