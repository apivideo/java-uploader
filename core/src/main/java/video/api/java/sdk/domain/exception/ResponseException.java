package video.api.java.sdk.domain.exception;

import kong.unirest.JsonNode;

public class ResponseException extends Exception {
    private final JsonNode responseBody;
    private final int status;

    public ResponseException(String message, JsonNode responseBody, int status) {
        super(message);
        this.responseBody = responseBody;
        this.status       = status;
    }

    public JsonNode getResponseBody() {
        return responseBody;
    }

    public int getStatus() {
        return status;
    }
}
