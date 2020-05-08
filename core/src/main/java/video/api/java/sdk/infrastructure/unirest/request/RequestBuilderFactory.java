package video.api.java.sdk.infrastructure.unirest.request;

import kong.unirest.HttpMethod;

public class RequestBuilderFactory {
    private String baseUri;

    public RequestBuilderFactory(String baseUri) {
        this.baseUri = baseUri;
    }

    public RequestBuilder create(HttpMethod method, String relativePath) {
        return new RequestBuilder(baseUri, method, relativePath);
    }
}
