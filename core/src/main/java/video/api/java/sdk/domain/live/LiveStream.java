package video.api.java.sdk.domain.live;

import java.util.HashMap;
import java.util.Map;

public class LiveStream extends LiveStreamInput {
    public final String              liveStreamId;
    public final String              streamKey;
    public final boolean             broadcasting;
    public final Map<String, String> assets = new HashMap<>();

    public LiveStream(String name, String liveStreamId, String streamKey, boolean broadcasting) {
        super(name);
        this.liveStreamId = liveStreamId;
        this.streamKey    = streamKey;
        this.broadcasting = broadcasting;
    }
}
