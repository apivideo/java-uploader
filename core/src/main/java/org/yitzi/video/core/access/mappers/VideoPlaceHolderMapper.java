package org.yitzi.video.core.access.mappers;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import org.yitzi.video.core.model.VideoGroup;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VideoPlaceHolderMapper implements RowMapper<VideoGroup> {

    @Override
    public VideoGroup map(ResultSet rs, StatementContext ctx) throws SQLException {
        return new VideoGroup(rs.getInt("id"), rs.getString("client_tag"));
    }
}
