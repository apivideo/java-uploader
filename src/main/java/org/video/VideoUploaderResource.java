package org.video;

import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.io.InputStream;

@Path("videos")
public class VideoUploaderResource {

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public void uploadVideo(@FormDataParam("file") InputStream file, @FormDataParam("file") FormDataBodyPart fileMeta,
                            @FormDataParam("file") FormDataContentDisposition fileDetail) {
    }
}
