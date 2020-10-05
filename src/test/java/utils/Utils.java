package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {

	public RequestSpecification requestSpecification() throws IOException {

		PrintStream log = new PrintStream(new FileOutputStream("log.txt"));
		RequestSpecification requestSpec = new RequestSpecBuilder().setBaseUri(getQATURl())
				.addQueryParam("key", "qaclick123").addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log)).setContentType(ContentType.JSON).build();
		return requestSpec;
	}

	public ResponseSpecification responseSpecification() {
		ResponseSpecification responseSpec = new ResponseSpecBuilder().expectStatusCode(200)
				.expectContentType(ContentType.JSON).expectStatusLine("HTTP/1.1 200 OK").build();
		return responseSpec;
	}

	public String getQATURl() throws IOException {
		FileInputStream fis = new FileInputStream("./env.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("baseUrl");
		return url;
	}
	
	public String getJSonPath(Response response,String key)
	{
		String resp=response.asString();
		JsonPath js=new JsonPath(resp);
		return js.getString(key);
	}

}
