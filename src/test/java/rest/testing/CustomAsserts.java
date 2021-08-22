package rest.testing;

import entities.Author;
import entities.ResponseError;
import io.restassured.response.Response;
import org.testng.Assert;

public class CustomAsserts {
    public void assertAuthor(Author author1, Author author2) {
        Assert.assertEquals(author1, author2);
    }

    public void assertError(ResponseError err, String errorText) {
        Assert.assertTrue(err.getErrorMessage().equalsIgnoreCase(errorText));
    }

    public void assertCode(int code, Response response) {
        Assert.assertEquals(code, response.getStatusCode());
    }
}
