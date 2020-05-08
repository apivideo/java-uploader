package org.yitzi.video.core.access;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Database {

    private static DataSource postgresDataSource;
    private static Jdbi jdbi;


    static Jdbi getJdbi() {
        if (jdbi == null) {
            lookupDataSource();
            jdbi = Jdbi.create(postgresDataSource);
            jdbi.installPlugin(new SqlObjectPlugin());
        }
        return jdbi;
    }

    private static void lookupDataSource() {
        try {
            Context envCtx = (Context) new InitialContext().lookup("java:comp/env");
            postgresDataSource = (DataSource) envCtx.lookup("jdbc/APIVideoDB");
        }
        catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
