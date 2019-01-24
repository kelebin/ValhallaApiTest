package Utils;

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@SuppressWarnings("rawtypes")
public class RequestGenerator {
	  
	  public static final  String accessToken = "accessToken";
	
	  public String genericRequestPOST(String token, Object object,String url, Integer status) {
			
	    	String requestModel = 
	    			  RestAssured.      
	    		         given()
	    		         	  .header(accessToken, token)
	    		         	  .relaxedHTTPSValidation()
	    		              .contentType(ContentType.JSON)
	    		              .body(object)
	    		         .when()
	    		              .post(url)
	    		         .then()
	    		              .statusCode(status) 
	    		              .contentType(ContentType.JSON).extract().asString();
	    	return requestModel;
	    }
	  
	  public String genericRequestGET(String token,Map request,String url, Integer status) {
			
	    	String requestModel = 
	    			  RestAssured.      
	    		         given()
	    		         	  .header(accessToken, token)
	    		              .contentType(ContentType.JSON)
	    		         .when()
	    		              .get(url)
	    		         .then()
	    		              .statusCode(status) 
	    		              .contentType(ContentType.JSON).extract().asString();
	    	return requestModel;
	    }
	  
	  public String genericRequestPUT(String token,Map request,String url, Integer status) {
			
	    	String requestModel = 
	    			  RestAssured.      
	    		         given()
	    		         	  .header(accessToken, token)
	    		              .contentType(ContentType.JSON)
	    		              .body(request)
	    		         .when()
	    		              .put(url)
	    		         .then()
	    		              .statusCode(status) 
	    		              .contentType(ContentType.JSON).extract().asString();
	    	return requestModel;
	    }
}
