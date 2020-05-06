package org.yitzi.video.api.apivideo.domain.analytics;

public class Device {
    public final String type;
    public final String vendor;
    public final String model;

    public Device(String type, String vendor, String model) {
        this.type   = type;
        this.vendor = vendor;
        this.model  = model;
    }
}
