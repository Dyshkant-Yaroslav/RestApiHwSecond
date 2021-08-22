package rest.testing;

import entities.Author;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.CustomAuthor;
import utils.PropertiesReader;
import utils.Client;

import java.util.List;


public class Tests  {

    CustomAuthor customAuthor = new CustomAuthor();
    PropertiesReader reader = new PropertiesReader();
    Client client = new Client();
    CustomAsserts customAsserts = new CustomAsserts();
    String jsonCreatedAuthor = customAuthor.authorToJson(getCreatedAuthor());
    String jsonUpdatedAuthor = customAuthor.authorToJson(getUpdatedAuthor());

    @BeforeMethod
    public void setup() {
        RestAssured.baseURI = reader.getBaseUri();
    }

    @Test(priority = 1)
    public void createNewAuthorPositive() {
        client.createRequestPost(jsonCreatedAuthor, reader.getUriAuthorPath());
        client.createResponseAuthorEntity();
        customAsserts.assertCode(201, client.getResponse());
        customAsserts.assertAuthor(client.getResponseAuthor(), getCreatedAuthor());
    }

    @Test(priority = 2)
    public void createNewAuthorNegative() {
        client.createRequestPost(jsonCreatedAuthor, reader.getUriAuthorPath());
        client.createResponseErrorEntity();
        customAsserts.assertCode(409, client.getResponse());
       customAsserts.assertError( client.getResponseError(), reader.getResponseBodyErrorTextAlreadyExist());
    }

    @Test(priority = 3)
    public void getAuthorByIDPositive() {
        client.createRequestGet(reader.getUriAuthorPathWithCorrectId());
        client.createResponseAuthorEntity();
        Assert.assertEquals(reader.getAuthorId(), client.getResponseAuthor().getAuthorId());
    }

    @Test(priority = 4)
    public void getAuthorByIDNegative() {
        client.createRequestGet(reader.getUriAuthorPathWithIncorrectId());
        client.createResponseErrorEntity();
        customAsserts.assertCode(404, client.getResponse());
       customAsserts.assertError( client.getResponseError(), reader.getResponseBodyErrorTextDoesNotExist());
    }


    @Test(priority = 5)
    public void changeAuthorPositive() {
        client.createRequestPut(jsonUpdatedAuthor, reader.getUriAuthorPath());
        client.createResponseAuthorEntity();
        customAsserts.assertCode(200, client.getResponse());
        customAsserts.assertAuthor(client.getResponseAuthor(), getUpdatedAuthor());
    }

    @Test(priority = 6)
    public void changeAuthorNegative() {
        client.createRequestPut(jsonUpdatedAuthor, reader.getUriAuthorPathWithIncorrectId());
        client.createResponseErrorEntity();
        customAsserts.assertCode(405, client.getResponse());
        customAsserts.assertError( client.getResponseError(), reader.getResponseBodyErrorTextNotSupported());
    }

    @Test(priority = 7)
    public void deleteAuthorByIDPositive() {
        client.createRequestDelete(reader.getUriAuthorPathWithCorrectId());
        customAsserts.assertCode(204, client.getResponse());
    }

    @Test(priority = 8)
    public void deleteAuthorByIDNegative() {
        client.createRequestDelete(reader.getUriAuthorPathWithIncorrectId());
        client.createResponseErrorEntity();
        customAsserts.assertCode(404, client.getResponse());
       customAsserts.assertError( client.getResponseError(), reader.getResponseBodyErrorTextDoesNotExist());
    }

    @Test(priority = 9)
    public void get30AuthorsFromFirstPageOrderedByAsc() {
        client.createRequestGet(reader.getUriAuthorPathAllAuthors());
        List<Author> authors = client.getResponse().jsonPath().getList("$", Author.class);
        for (Author author : authors) {
            System.out.println(author);
            Assert.assertNotNull(author);
            Assert.assertNotEquals(author.getAuthorId(), 0);
            Assert.assertNotNull(author.getAuthorName().getFirst());
            Assert.assertNotNull(author.getAuthorName().getSecond());
            Assert.assertNotNull(author.getNationality());
            Assert.assertNotNull(author.getBirth().getDate());
            Assert.assertNotNull(author.getBirth().getCountry());
            Assert.assertNotNull(author.getBirth().getCity());
            Assert.assertNotNull(author.getAuthorDescription());
        }
    }

    private Author getCreatedAuthor(){
        return customAuthor.createAuthor(reader.getAuthorId(), reader.getCreatedAuthorFirstName(),
                reader.getCreatedAuthorSecondName(), reader.getCreatedAuthorNationality(), reader.getCreatedAuthorBirthDate()
                , reader.getCreatedAuthorBirthCountry(), reader.getCreatedAuthorBirthCity(), reader.getCreatedAuthorDescription());
    }

    private Author getUpdatedAuthor() {
        return customAuthor.createAuthor(reader.getAuthorId(), reader.getUpdatedAuthorFirstName(),
                reader.getUpdatedAuthorSecondName(), reader.getUpdatedAuthorNationality(), reader.getUpdatedAuthorBirthDate()
                , reader.getUpdatedAuthorBirthCountry(), reader.getUpdatedAuthorBirthCity(), reader.getUpdatedAuthorDescription());
    }
}
