package entities;

public class ResponseError {

    private String timeStamp;
    private int statusCode;
    private String error;
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return "Error{" +
                "timeStamp='" + timeStamp + '\'' +
                ", statusCode=" + statusCode +
                ", error='" + error + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }

}
