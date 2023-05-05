package ke.co.safaricom.dao;

import ke.co.safaricom.config.DatabaseConfig;
import org.sql2o:sql2o;

public class HeroDao {
    private static sql2o sql2o = DatabaseConfig.getDatabaseObject();

}