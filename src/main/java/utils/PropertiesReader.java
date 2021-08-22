package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    Properties properties = new Properties();

    public PropertiesReader() {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream("src/main/resources/data.properties");
            properties.load(fileInputStream);
            fileInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public String getBaseUri() {
        return properties.getProperty("BASE_URI");
    }

    public String getUriAuthorPath() {
        return properties.getProperty("URI_AUTHOR_PATH");
    }

    public String getUriAuthorPathWithCorrectId() {
        return properties.getProperty("URI_AUTHOR_PATH_WITH_CORRECT_ID");
    }

    public String getUriAuthorPathWithIncorrectId() {
        return properties.getProperty("URI_AUTHOR_PATH_WITH_INCORRECT_ID");
    }

    public String getUriAuthorPathAllAuthors() {
        return properties.getProperty("URI_AUTHOR_PATH_ALL_AUTHORS");
    }


    public String getResponseBodyErrorTextAlreadyExist() {
        return properties.getProperty("RESPONSE_BODY_ERROR_TEXT_ALREADY_EXIST");
    }

    public String getResponseBodyErrorTextNotSupported() {
        return properties.getProperty("RESPONSE_BODY_ERROR_TEXT_NOT_SUPPORTED");
    }


    public  String getResponseBodyErrorTextDoesNotExist() {
        return properties.getProperty("RESPONSE_BODY_ERROR_TEXT_DOES_NOT_EXIST");
    }


    public int getAuthorId() {
        String id = properties.getProperty("AUTHOR_ID");
        return Integer.parseInt(id);
    }

    public String getCreatedAuthorFirstName() {
        return properties.getProperty("CREATED_AUTHOR_FIRST_NAME");
    }

    public String getCreatedAuthorSecondName() {
        return properties.getProperty("CREATED_AUTHOR_SECOND_NAME");
    }

    public String getCreatedAuthorNationality() {
        return properties.getProperty("CREATED_AUTHOR_NATIONALITY");
    }

    public String getCreatedAuthorBirthDate() {
        return properties.getProperty("CREATED_AUTHOR_BIRTH_DATE");
    }

    public String getCreatedAuthorBirthCountry() {
        return properties.getProperty("CREATED_AUTHOR_BIRTH_COUNTRY");
    }

    public String getCreatedAuthorBirthCity() {
        return properties.getProperty("CREATED_AUTHOR_BIRTH_CITY");
    }

    public String getCreatedAuthorDescription() {
        return properties.getProperty("CREATED_AUTHOR_DESCRIPTION");
    }

    public String getUpdatedAuthorFirstName() {
        return properties.getProperty("UPDATED_AUTHOR_FIRST_NAME");
    }

    public String getUpdatedAuthorSecondName() {
        return properties.getProperty("UPDATED_AUTHOR_SECOND_NAME");
    }

    public String getUpdatedAuthorNationality() {
        return properties.getProperty("UPDATED_AUTHOR_NATIONALITY");
    }

    public String getUpdatedAuthorBirthDate() {
        return properties.getProperty("UPDATED_AUTHOR_BIRTH_DATE");
    }

    public String getUpdatedAuthorBirthCountry() {
        return properties.getProperty("UPDATED_AUTHOR_BIRTH_COUNTRY");
    }

    public String getUpdatedAuthorBirthCity() {
        return properties.getProperty("UPDATED_AUTHOR_BIRTH_CITY");
    }

    public String getUpdatedAuthorDescription() {
        return properties.getProperty("UPDATED_AUTHOR_DESCRIPTION");
    }

}
