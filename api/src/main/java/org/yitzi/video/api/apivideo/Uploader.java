package org.yitzi.video.api.apivideo;

import org.yitzi.video.api.apivideo.domain.exception.ResponseException;
import org.yitzi.video.api.apivideo.domain.video.VideoInput;

import java.io.File;

public class Uploader {

    public void upload(String apiKey, String title, String tag, String pathName) throws ResponseException {
        Client client = new ClientFactory().create(apiKey);
        VideoInput videoInput = new VideoInput();
        videoInput.title = title;
        videoInput.tags.add(tag);
        client.videos.upload(new File(pathName), videoInput);
    }
}
