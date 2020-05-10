package org.yitzi.video.api.domain;

import org.yitzi.video.api.Uploader;
import org.yitzi.video.core.access.VideoAccess;
import org.yitzi.video.core.model.VideoGroup;
import video.api.java.sdk.domain.exception.ResponseException;

public class UploadToAPIVideo {

    public void uploadToAPIVideo(String url, String pathName) {
        VideoAccess videoAccess = VideoAccess.getInstance();
        VideoGroup videoGroup = videoAccess.getVideoPlaceHolderFromURL(url);
        String apiKey = videoAccess.getApiKey(videoGroup.getId());
        Uploader uploader = new Uploader();
        try {
            uploader.upload(apiKey, videoGroup.getTag(), pathName);
        }
        catch (ResponseException ignored) {
        }
    }
}
