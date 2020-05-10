package video.api.java.sdk.domain.analytics;

public class OperatingSystem {
    public final String name;
    public final String shortname;
    public final String version;

    public OperatingSystem(String name, String shortname, String version) {
        this.name      = name;
        this.shortname = shortname;
        this.version   = version;
    }
}
