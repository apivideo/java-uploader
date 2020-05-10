package video.api.java.sdk.infrastructure.unirest.request;

import kong.unirest.HttpRequest;
import kong.unirest.HttpRequestWithBody;


public interface BodyBuilder {
    HttpRequest build(HttpRequestWithBody request);
}
