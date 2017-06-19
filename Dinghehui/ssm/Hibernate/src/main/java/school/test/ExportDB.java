package school.test;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * Created by admin on 2017/6/14.
 */
public class ExportDB {
    public static void main(String[] args){
        Configuration cfg = new Configuration().configure();
        SchemaExport export = new SchemaExport(cfg);
        export.create(true,true);
    }
}
