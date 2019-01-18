
package Utils;

public class UrlUtils {

	public static String urlReducao = "http://localhost:8080/v2/api-valhalla/reducaoBase/";
	
	//public static String urlReducao = "http://10.5.3.202:8080/v2/api-valhalla/reducaoBase/";

	public static String getUrlReducaoNormal() {
		return urlReducao + "modoNormal";
	}

	public static String getUrlReducaoExtrema() {
		return urlReducao + "modoExtremo";
	}

	public static String getUrlReducaoRecuperacao() {
		return urlReducao + "modoRecuperacao";
	}

}