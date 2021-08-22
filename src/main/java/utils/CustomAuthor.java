package utils;

import com.google.gson.Gson;
import entities.Author;

public class CustomAuthor {

    private Author customAuthor = new Author();
    private Author.Name customAuthorName = new Author.Name();
    private Author.Birth customAuthorBirth = new Author.Birth();
    private Gson gson = new Gson();


    public Author createAuthor(int id, String first, String second, String nationality, String date,
                               String country, String city, String description){
        customAuthor.setAuthorId(id);
        customAuthor.setAuthorName(createAuthorName(first, second));
        customAuthor.setNationality(nationality);
        customAuthor.setBirth(createAuthorBirth(date, country, city));
        customAuthor.setAuthorDescription(description);
        return customAuthor;
    }

    private Author.Name createAuthorName(String first, String second) {
        customAuthorName.setFirst(first);
        customAuthorName.setSecond(second);
        return customAuthorName;
    }

    private Author.Birth createAuthorBirth(String date, String country, String city) {
        customAuthorBirth.setDate(date);
        customAuthorBirth.setCountry(country);
        customAuthorBirth.setCity(city);
        return customAuthorBirth;
    }

    public String authorToJson(Author author) {
        return gson.toJson(author);
    }

}
