package org.yitzi.video.api.apivideo;

import org.yitzi.video.api.apivideo.domain.exception.ResponseException;
import org.yitzi.video.api.apivideo.domain.video.VideoInput;

import java.io.File;

public class Uploader {

    public void upload(String apiKey, String email, String pathName) throws ResponseException {
        Client client = new ClientFactory().create(apiKey);
        VideoInput videoInput = new VideoInput();
        videoInput.tags.add(email);
        client.videos.upload(new File(pathName), videoInput);
    }
}
