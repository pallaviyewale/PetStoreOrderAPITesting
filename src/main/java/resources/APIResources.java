package resources;

public enum APIResources {
	
	PlaceStoreOrder("https://petstore.swagger.io/v2/store/order"),
	GetStoreOrer("https://petstore.swagger.io/v2/store/order/7"),
	DeleteStoreOrder("https://petstore.swagger.io/v2/store/order/1");
	private String resource;
	
	APIResources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}
	

}
