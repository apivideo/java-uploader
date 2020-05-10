package video.api.java.sdk.domain.analytics;

public class PlayerSession {
    public final Info            info;
    public final Location        location;
    public final Referrer        referrer;
    public final Device          device;
    public final OperatingSystem os;
    public final Client          client;

    public PlayerSession(Info info, Location location, Referrer referrer, Device device, OperatingSystem os, Client client) {
        this.info     = info;
        this.location = location;
        this.referrer = referrer;
        this.device   = device;
        this.os       = os;
        this.client   = client;
    }
}
