package video.api.java.sdk.domain.analytics;

import java.util.Calendar;

public class PlayerSessionEvent {
    public final String   type;
    public final Calendar emittedAt;
    public final Integer  at;
    public final Integer  from;
    public final Integer  to;

    public PlayerSessionEvent(String type, Calendar emittedAt, Integer at, Integer from, Integer to) {
        this.type      = type;
        this.emittedAt = emittedAt;
        this.at        = at;
        this.from      = from;
        this.to        = to;
    }
}
