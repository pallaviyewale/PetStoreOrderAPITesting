package resources;

public class TestDataBuild 
{
	public static String getPetOrderPostPayload(int id, int petId, int quantity)
	{
		  String b  = "{\n" +
				  "  \"id\": "+id+",\n" +
				  "  \"petId\": "+petId+",\n" +
				  "  \"quantity\": "+quantity+",\n" +
				  "  \"shipDate\": \"2020-11-06T14:44:06.929Z\",\n" +
				  "  \"status\": \"placed\",\n" +
				  "  \"complete\": true \n" +
		  "}";
		  
		  return b;
	}

}
