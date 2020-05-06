package org.yitzi.video.api.apivideo.domain.live;

public class LiveStreamInput {
    public String  name;
    public String  playerId;
    public boolean record;

    public LiveStreamInput(String name) {
        this.name = name;
    }
}
