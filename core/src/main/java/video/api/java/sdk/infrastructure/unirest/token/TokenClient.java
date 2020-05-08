package video.api.java.sdk.infrastructure.unirest.token;

import kong.unirest.JsonNode;
import video.api.java.sdk.domain.exception.ResponseException;
import video.api.java.sdk.infrastructure.unirest.AuthRequestExecutor;
import video.api.java.sdk.infrastructure.unirest.request.RequestBuilder;
import video.api.java.sdk.infrastructure.unirest.request.RequestBuilderFactory;

import static kong.unirest.HttpMethod.POST;

public class TokenClient {
    private final RequestBuilderFactory requestBuilderFactory;
    private final AuthRequestExecutor   requestExecutor;

    public TokenClient(RequestBuilderFactory requestBuilderFactory, AuthRequestExecutor requestExecutor) {
        this.requestBuilderFactory = requestBuilderFactory;
        this.requestExecutor       = requestExecutor;
    }

    public String get() throws ResponseException {
        RequestBuilder request = requestBuilderFactory
                .create(POST, "/tokens");

        JsonNode responseBody = requestExecutor.executeJson(request);

        // TODO use serializer
        return responseBody.getObject().getString("token");
    }
}
