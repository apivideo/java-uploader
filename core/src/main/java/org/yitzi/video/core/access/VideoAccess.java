package org.yitzi.video.core.access;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public class VideoAccess {

    private static VideoAccess instance;
    private VideoDAO videoDAO;

    public VideoAccess() {
        DBI dbi = Database.getDBI();
        videoDAO = dbi.onDemand(VideoDAO.class);
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

        // language=SQL
        @SqlUpdate("INSERT INTO video_client_admin_relationships ( admin_id, video_id) VALUES (:adminID, :videoID)")
        void insertAdminVideoRelationship(@Bind("adminID") int adminID, @Bind("videoID") int videoID);
    }
}
