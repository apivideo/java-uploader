package org.yitzi.video.api;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.message.GZipEncoder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.EncodingFilter;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class JVideoApplication extends ResourceConfig {

    public JVideoApplication() {
        packages(true, "org.yitzi.video.api");
        register(MultiPartFeature.class);
        register(EncodingFilter.class);
        EncodingFilter.enableFor(this, GZipEncoder.class);
    }
}
