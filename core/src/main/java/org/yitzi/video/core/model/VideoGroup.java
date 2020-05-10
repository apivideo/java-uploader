package org.yitzi.video.core.model;

public class VideoGroup {

    private int id;
    private String tag;

    public VideoGroup(int id, String tag) {
        this.id = id;
        this.tag = tag;
    }

    public int getId() {
        return id;
    }

    public String getTag() {
        return tag;
    }
}
