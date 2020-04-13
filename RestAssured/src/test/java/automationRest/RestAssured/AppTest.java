package automationRest.RestAssured;

import org.junit.Test;
import static io.restassured.RestAssured.*;
import org.hamcrest.Matchers;


public class AppTest 
{

	@Test
	public void validateZipCodeReturn()
	{
	
		given().
		when().
			get( "https://viacep.com.br/ws/91060900/json/").
		then()
			.assertThat().body("cep", Matchers.equalTo("91060-900"))
			.assertThat().body("logradouro", Matchers.equalTo("Avenida Assis Brasil 3940"))
			.assertThat().body("complemento", Matchers.equalTo(""))
			.assertThat().body("bairro", Matchers.equalTo("São Sebastião"))
			.assertThat().body("localidade", Matchers.equalTo("Porto Alegre"))
			.assertThat().body("uf", Matchers.equalTo("RS"))
			.assertThat().body("ibge", Matchers.equalTo("4314902"));
		}
	@Test
	public void unexistingZipCode()
	{
	
		given().
		when().
			get( "https://viacep.com.br/ws/91060999/json/").
		then()
			.assertThat().body("erro", Matchers.is(true));
		}

	@Test
	public void invalidFormatZipCode()
	{
	
		given().
		when().
			get( "https://viacep.com.br/ws/91060 999/json/").
		then()
			.assertThat().statusCode(400);
		}
	
	}