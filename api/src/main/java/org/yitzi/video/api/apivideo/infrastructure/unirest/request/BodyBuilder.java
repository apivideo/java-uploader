package org.yitzi.video.api.apivideo.infrastructure.unirest.request;

import kong.unirest.HttpRequest;
import kong.unirest.HttpRequestWithBody;


public interface BodyBuilder {
    HttpRequest build(HttpRequestWithBody request);
}
