package org.yitzi.video.core.access;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import video.api.java.sdk.domain.video.Video;

public class VideoAccess {

    private static VideoAccess instance;
    private VideoDAO videoDAO;

    public VideoAccess() {
        Jdbi jdbi = Database.getJdbi();
        videoDAO = jdbi.onDemand(VideoDAO.class);
    }

    public static synchronized VideoAccess getInstance() {
        if (instance == null) {
            instance = new VideoAccess();
        }
        return instance;
    }

    public int upsertAdmin(String apiKey) {
        return videoDAO.upsertAdmin(apiKey);
    }

    public int insertVideoPlaceHolder(String url, String tag) {
        return videoDAO.insertVideoPlaceHolder(url, tag);
    }

    public void insertAdminVideoRelationship(int adminID, int videoID) {
        videoDAO.insertAdminVideoRelationship(adminID, videoID);
    }

    interface VideoDAO {

        //        language=SQL
        @GetGeneratedKeys
        @SqlUpdate("INSERT INTO admins (api_key) VALUES (:apiKey) ON CONFLICT (api_key) DO UPDATE SET api_key = :apiKey")
        int upsertAdmin(@Bind("apiKey") String apiKey);

        //        language=SQL
        @GetGeneratedKeys
        @SqlUpdate("INSERT INTO videos (unique_url, client_tag) VALUES (:url, :tag)")
        int insertVideoPlaceHolder(@Bind("url") String url, @Bind("tag") String tag);

        //        language=SQL
        @SqlQuery("SELECT * FROM videos WHERE unique_url = :uniqueURL")
        Video getVideoMetaFromURL(@Bind("uniqueURL") String uniqueURL);

        // language=SQL
        @SqlUpdate("INSERT INTO video_client_admin_relationships ( admin_id, video_id) VALUES (:adminID, :videoID)")
        void insertAdminVideoRelationship(@Bind("adminID") int adminID, @Bind("videoID") int videoID);
    }
}
