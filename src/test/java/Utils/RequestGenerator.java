package Utils;

import java.util.Map;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

@SuppressWarnings("rawtypes")
public class RequestGenerator {
	  
	  public static final  String accessToken = "accessToken";
	
	  public Response genericRequestPOST(String token, Object body,String url, Integer status) {
	
	  RestAssured.defaultParser = Parser.JSON;	
	  
	  return   			  RestAssured.      
	    		         given()
	    		         	  .header(accessToken, token)
	    		         	  .relaxedHTTPSValidation()
	    		              .contentType(ContentType.JSON)
	    		              .body(body)
	    		         .when()
	    		              .post(url)
	    		         .then()
	    		              .statusCode(status) 
	    		              .contentType(ContentType.JSON)
	    		              .extract()
	    		              .response();
	    }
	  
	  public String genericRequestPOST2(String token, Object body,String url, Integer status) {
			
		  RestAssured.defaultParser = Parser.JSON;	
		  
		  String requestModel =    			  RestAssured.      
		    		         given()
		    		         	  .header(accessToken, token)
		    		         	  .relaxedHTTPSValidation()
		    		              .contentType(ContentType.JSON)
		    		              .body(body)
		    		         .when()
		    		              .post(url)
		    		         .then()
		    		              .statusCode(status) 
		    		              .contentType(ContentType.JSON)
		    		              .extract()
		    		              .asString();
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
