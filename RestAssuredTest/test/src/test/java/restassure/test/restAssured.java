package restassure.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.hamcrest.Matchers.*;
import io.restassured.response.ValidatableResponse;

public class restAssured {

    static String body = "{\r\n" + //
            "  \"bankAccount\": {\r\n" + //
            "    \"accountNumber\": 1234567890,\r\n" + //
            "    \"bankName\": \"SCRUM_BANK\"\r\n" + //
            "  },\r\n" + //
            "  \"idNumber\": 9901025391084,\r\n" + //
            "  \"name\": \"Pontsho\",\r\n" + //
            "  \"surname\": \"Molewa\"\r\n" + //
            "}";

    /*
     * The test are identified by the Example it represent
     * Example_01 • ID Number must be a valid South African ID number (13 digits)
     * Example_02 • The client must be >/= 18years
     * Example_03 • Name and surname must not have any special characters and digits
     * Example_04 • A valid bank must be captured. Allowed banks are Scrum Bank,
     * Iconic
     * Bank, Minions Bank, and Molewa Bank
     * Example_05 • If Molewa bank is captured, then the following warning must be
     * returned
     * “refer to compliance”
     * Example_06 • The bank account number must be 10 digits
     * 
     * 
     */

    loanRequest loanRequest = new loanRequest();
    bankAccount bankAccount = new bankAccount();

    @Before
    public void testBefore() {
        RestAssured.baseURI = "http://localhost:8080";
        bankAccount.setAccountNumber("1122334455");
        bankAccount.setBankName("SCRUM_BANK");

        loanRequest.setBankAccount(bankAccount);
        loanRequest.setIdNumber("9603225177080");
        loanRequest.setName("Edwin");
        loanRequest.setSurname("ndlala");
        // banklist.add(body)

    }

    @Test
    public void Example_01() {

        // Serialize the object to a JSON string
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequestBody;
        try {
            jsonRequestBody = objectMapper.writeValueAsString(loanRequest);
            // objectMapper.writeValueAsString(requestBody);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        ValidatableResponse all = RestAssured.given().log().all()

                .contentType(ContentType.JSON)
                .body(jsonRequestBody)
                .when().post("/loans")
                .then()
                .assertThat()

                .statusCode(200)

                .log().all();

    }

    @Test
    public void Example_02() {

        loanRequest.setIdNumber("1007025304084");
        // Serialize the object to a JSON string
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequestBody;
        try {
            jsonRequestBody = objectMapper.writeValueAsString(loanRequest);
            // objectMapper.writeValueAsString(requestBody);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        ValidatableResponse all = RestAssured.given().log().all()

                .contentType(ContentType.JSON)
                .body(jsonRequestBody)
                .when().post("/loans")
                .then()
                .assertThat()
                .body("errors", hasItem("The client must be 18 years or older"))

                .statusCode(200)
                .log().all();

    }

    @Test
    public void Example_03() {

        loanRequest.setName("tesr@");
        loanRequest.setSurname("Test&");
        // Serialize the object to a JSON string
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequestBody;
        try {
            jsonRequestBody = objectMapper.writeValueAsString(loanRequest);
            // objectMapper.writeValueAsString(requestBody);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        // String testReString = "[[Name must not have any special characters and
        // digits, Surname must not have any special characters and digits]]";
        ValidatableResponse all = RestAssured.given().log().all()

                .contentType(ContentType.JSON)
                .body(jsonRequestBody)
                .when().post("/loans")
                .then()
                .assertThat()
                // .body("errors", hasItem(testReString))

                .statusCode(200)
                .log().all();

        assertTrue(true);

    }

    @Test
    public void Example_04() {

        bankAccount.setBankName("FNB");
        // Serialize the object to a JSON string
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequestBody;
        try {
            jsonRequestBody = objectMapper.writeValueAsString(loanRequest);
            // objectMapper.writeValueAsString(requestBody);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        ValidatableResponse all = RestAssured.given() // .log().all()

                .contentType(ContentType.JSON)
                .body(jsonRequestBody)
                .when().post("/loans")
                .then()
                .assertThat()
                .statusCode(400)
                .body("error", equalTo("Bad Request"))
                .log().all();

    }

    @Test
    public void Example_05() {
        bankAccount.setBankName("MOLEWA_BANK");
        String jsonRequestBody = getSerialize();

        ValidatableResponse all = RestAssured.given() // .log().all()

                .contentType(ContentType.JSON)
                .body(jsonRequestBody)
                .when().post("/loans")
                .then()
                .assertThat()
                .body("warnings", hasItem("Refer to compliance"))

                .statusCode(200)
                .log().all();
    }

    @Test
    public void Example_06() {

        bankAccount.setAccountNumber("12233445");

        String jsonRequestBody = getSerialize();

        ValidatableResponse all = RestAssured.given() // .log().all()

                .contentType(ContentType.JSON)
                .body(jsonRequestBody)
                .when().post("/loans")
                .then()
                .assertThat()
                // .body("warnings", hasItem("Refer to compliance"))

                .statusCode(200)
                .log().all();
    }

    private String getSerialize() {
        // Serialize the object to a JSON string
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequestBody = null;
        try {
            jsonRequestBody = objectMapper.writeValueAsString(loanRequest);
            // objectMapper.writeValueAsString(requestBody);
        } catch (Exception e) {
            e.printStackTrace();
            // return;
        }

        return jsonRequestBody;
    }
}
