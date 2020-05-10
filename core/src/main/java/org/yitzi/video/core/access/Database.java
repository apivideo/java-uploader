package org.yitzi.video.core.access;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Database {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/video_api";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "sifra123";

    private static DataSource postgresDataSource;
    private static Jdbi jdbi;

    static Jdbi getJdbi() {
        if (jdbi == null) {
            lookupDataSource();
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

    private static void lookupDataSource() {
        try {
            Context envCtx = (Context) new InitialContext().lookup("java:comp/env");
            postgresDataSource = (DataSource) envCtx.lookup("jdbc/APIVideoDB");
        }
        catch (Exception ignored) {
        }
    }

    private static Jdbi getDBConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            return Jdbi.create(DB_URL, DB_USER, DB_PASSWORD);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
