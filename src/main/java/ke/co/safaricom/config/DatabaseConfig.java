package ke.co.safaricom.config;


import org.sql2o.Sql2o;

public class DatabaseConfig {
    private final static String DB_URL = "//jdbc:postgresql://localhost:5433/main";

    private final static String DB_USER = "postgres";

    private final static String DB_PASS = "null";

    private final static Sql2o sql2o = new Sql2o(DB_URL, DB_USER, DB_PASS);

    public static Sql2o getDatabaseObject() {
        return DatabaseConfig.sql2o;
    }
}

