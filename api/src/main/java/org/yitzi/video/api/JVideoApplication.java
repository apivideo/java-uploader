package org.yitzi.video.api;


import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class JVideoApplication extends ResourceConfig {

    public JVideoApplication() {
        packages(true, "org.yitzi.video.api");
        register(MultiPartFeature.class);
    }
}
