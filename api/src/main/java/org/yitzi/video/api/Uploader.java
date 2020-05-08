package org.yitzi.video.api;


import video.api.java.sdk.Client;
import video.api.java.sdk.ClientFactory;
import video.api.java.sdk.domain.exception.ResponseException;
import video.api.java.sdk.domain.video.Video;

import java.io.File;

public class Uploader {

    public void upload(String apiKey, String tag, String pathName) throws ResponseException {
        Client client = new ClientFactory().create(apiKey);
        Video videoInput = new Video();
        videoInput.tags.add(tag);
        client.videos.upload(new File(pathName), videoInput);
    }
}
