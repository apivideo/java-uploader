package video.api.java.sdk.infrastructure.unirest;

import kong.unirest.JsonNode;
import video.api.java.sdk.domain.exception.ResponseException;
import video.api.java.sdk.infrastructure.unirest.request.RequestBuilder;

public interface RequestExecutor {
    JsonNode executeJson(RequestBuilder requestBuilder) throws ResponseException;
}
