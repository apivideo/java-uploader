package org.yitzi.video.www.web.site;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/upload")
@Produces(MediaType.TEXT_HTML)
public class UploadPageService {

    @GET
    @Path("/{uniqueUrl}")
    public String showUploadPage(@PathParam("uniqueUrl") String uniqueURL) {
        UploadPageContent uploadPageContent = new UploadPageContent();
        uploadPageContent.setUniqueURL(uniqueURL);
        return uploadPageContent.render();
    }
}
