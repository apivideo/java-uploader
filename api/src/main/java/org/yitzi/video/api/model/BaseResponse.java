package org.yitzi.video.api.model;

public class BaseResponse {

    private boolean success;
    private String message;

    public BaseResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
