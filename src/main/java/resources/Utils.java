package resources;

import config.ConfigHelper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {

	RequestSpecification reqSpec;
	static ResponseSpecification resSpec;
	
	public static XmlPath rawToXML(Response r)
	{
		String res = r.asString();
		XmlPath x = new XmlPath(res);
		return x;
	}

	public static String rawToJson(Response response,String key)
	{
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		return js.get(key).toString();
	}
	
	public RequestSpecification requestSpecifications()
	{
    	RestAssured.baseURI = ConfigHelper.getConfHelp().getHOST();
    	reqSpec = new RequestSpecBuilder().setBaseUri(ConfigHelper.getConfHelp().getHOST()).setContentType(ContentType.JSON).build();
    	return reqSpec;
	}
	
	public static ResponseSpecification responseSpecifications()
	{
		resSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
    	return resSpec;
	}
}
