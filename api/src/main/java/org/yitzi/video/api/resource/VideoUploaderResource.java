package org.yitzi.video.api.resource;

import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.yitzi.video.core.access.VideoAccess;
import org.yitzi.video.core.util.StringUtils;

import javax.ws.rs.*;
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
    @Path("/uploader")
    public String getUploadURL(@QueryParam("api_key") String apiKey, @QueryParam("customer_email") String customerEmail) {
        String url = StringUtils.generateUniqueString();
        VideoAccess videoAccess = VideoAccess.getInstance();
        int adminID = videoAccess.upsertAdmin(apiKey);
        int placeHolderID = videoAccess.insertVideoPlaceHolder(url, customerEmail);
        videoAccess.insertAdminVideoRelationship(adminID, placeHolderID);
        return url;
    }
}
