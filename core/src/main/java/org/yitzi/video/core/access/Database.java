package org.yitzi.video.core.access;

import org.skife.jdbi.v2.DBI;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Database {

    private static DataSource postgresDataSource;

    public static DBI getDBI() {
        if (postgresDataSource == null) {
            lookupDataSource();
        }
        return new DBI(postgresDataSource);
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
