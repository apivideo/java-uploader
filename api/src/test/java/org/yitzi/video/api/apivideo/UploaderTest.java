package org.yitzi.video.api.apivideo;

import org.junit.jupiter.api.Test;
import org.yitzi.video.api.Uploader;
import video.api.java.sdk.domain.exception.ResponseException;

class UploaderTest {

    @Test
    void upload() throws ResponseException {
        new Uploader().upload("XevyeUNNDV66E67QmTk23hOwryfdejOHI5U8M1tHXND", "test tag 5", "src/test/resources/My Video 1.mp4");
    }
}