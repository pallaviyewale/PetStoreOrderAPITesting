Project - PetStoreOrderAPITesting - Pet store Order Tests

Assumptions -
1. Assumed id is between 1 to 10 as Get request for store order takes id from 1 to 10.
2. Tried to do some validations on negative petid and quantity, but not getting any error.
3. No limit for quantity and petid.
4. I had some doubts on inventory functionality, so didn't add any scenarios around inventory testing.

Project Structure -

Main -
	config - ConfigHelper - It is reading all configuration from properties file resources

	resources -
		APIResources - Getting URI for all requests 
		TestDataBuild - Building payload for all requests
		Utils - All reusable methods

Test -
	cucumber-options - TestRunner file
	
	features -
		PetStoreOrderTest - Scenarios for store order testing

	stepDefinations - 
		PetStoreOrderStepDefination - Step definations for PetStoreOrderTest scenarios

  pom.xml - All maven dependencies included - Junit, RestAssured, Cucumber

  config.properties - all required configuration


How to Run -

1. Build the maven project
2. Run TestRunner.java file as JUnit  


	
