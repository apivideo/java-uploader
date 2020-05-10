package org.yitzi.video.api.resource;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.yitzi.video.api.domain.GetFileFromInputStream;
import org.yitzi.video.api.domain.UploadToAPIVideo;
import org.yitzi.video.api.model.BaseResponse;
import org.yitzi.video.api.model.VideoGroupParams;
import org.yitzi.video.core.EnvironmentProperties;
import org.yitzi.video.core.access.VideoAccess;
import org.yitzi.video.core.util.StringUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.InputStream;

@Path("/api/videos")
public class VideoUploaderResource {

    UploadToAPIVideo uploadToAPIVideo = new UploadToAPIVideo();
    GetFileFromInputStream fileFromInputStream = new GetFileFromInputStream();

    @POST
    @Path("/{uniqueURL}")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public void uploadVideo(@FormDataParam("file") InputStream file,
                            @FormDataParam("file") FormDataContentDisposition fileDetail, @PathParam("uniqueURL") String uniqueURL) {
        File uploadedFile = this.fileFromInputStream.getFileFromInputStream(file, fileDetail.getFileName());
        uploadToAPIVideo.uploadToAPIVideo(uniqueURL, uploadedFile.getPath());
    }

    @POST
    @Path("/uploader")
    @Produces(MediaType.APPLICATION_JSON)
    public BaseResponse getUploadURL(VideoGroupParams params) {
        String url = StringUtils.generateUniqueString();
        VideoAccess videoAccess = VideoAccess.getInstance();
        int adminID = videoAccess.upsertAdmin(params.getApiKey());
        int placeHolderID = videoAccess.insertVideoPlaceHolder(url, params.getTag());
        videoAccess.insertAdminVideoRelationship(adminID, placeHolderID);
        String webUrl = EnvironmentProperties.getProperty("web_url") + "/upload/" + url;
        return new BaseResponse(true, webUrl);
    }
}
