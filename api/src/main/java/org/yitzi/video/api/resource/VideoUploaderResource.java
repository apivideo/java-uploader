package org.yitzi.video.api.resource;

import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.io.InputStream;

@Path("/videos")
public class VideoUploaderResource {

//    @GET
//    @Path("videos/upload-form/{videoID}")
//    public String getUploadPage() {
////      if videoID is valid
////      return template
//
//    }

    @POST
    @Path("/{videoID}")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public void uploadVideo(@FormDataParam("file") InputStream file, @FormDataParam("file") FormDataBodyPart fileMeta,
                            @FormDataParam("file") FormDataContentDisposition fileDetail) {

    }

    @GET
    @Path("videos/uploader")
    public String getUploadURL(@FormDataParam("apiKey") String apiKey, @FormDataParam("customerEmail") String customerEmail) {
//        generate unique video id
//        insert into table with user id
        return "videoID";
    }
}
