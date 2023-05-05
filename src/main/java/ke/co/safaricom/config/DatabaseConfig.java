package ke.co.safaricom.config;

import org.Sql2o.sql2o;

public class DatabaseConfig {
    private String DB_URL ="//jdbc:postgresql://host/port/database";

    private String DB_USER = "";

    private String DB_PASS = "";

    private Sql2o sql2o = new Sql2o(this.DB_URL, DB_USER, DB_PASS);

    public static Sql2o getDatabaseObject(){
        return DatabaseConfig.sql2o;
    }
}
