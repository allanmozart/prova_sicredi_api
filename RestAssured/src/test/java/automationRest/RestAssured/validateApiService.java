package automationRest.RestAssured;

import static io.restassured.RestAssured.*;
import org.hamcrest.Matchers;
import org.junit.Test;

public class validateApiService {

	@Test
	public void invalidFormatZipCode()
	{
	
		given().
		when().
			get( "https://viacep.com.br/ws/RS/Gravatai/Barroso/json/").
		then()
			.assertThat().body("size", Matchers.is(2));
		}
	
	}