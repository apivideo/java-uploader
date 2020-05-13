package org.yitzi.video.core.access;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import javax.sql.DataSource;
import java.net.URISyntaxException;

public class Database {

    private static DataSource postgresDataSource;
    private static Jdbi jdbi;

    static Jdbi getJdbi() throws URISyntaxException {
        if (jdbi == null) {
            if (postgresDataSource != null) {
                jdbi = Jdbi.create(postgresDataSource);
            }
            else {
                jdbi = getDBConnection();
            }
            jdbi.installPlugin(new SqlObjectPlugin());
        }
        return jdbi;
    }

    private static Jdbi getDBConnection() throws URISyntaxException {
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        try {
            Class.forName("org.postgresql.Driver");
            return Jdbi.create(dbUrl);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
