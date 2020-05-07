package org.yitzi.video.api.apivideo;

import org.junit.jupiter.api.Test;
import org.yitzi.video.api.apivideo.domain.exception.ResponseException;

class UploaderTest {

    @Test
    void upload() throws ResponseException {
        new Uploader().upload("XevyeUNNDV66E67QmTk23hOwryfdejOHI5U8M1tHXND", "My Test Title","test tag 1", "src/test/resources/My Video 1.mp4");
    }
}