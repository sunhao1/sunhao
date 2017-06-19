package annotation.school.test;


import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * Created by admin on 2017/6/15.
 */
public class Export {
    public static void main(String[] args){
        Configuration cfg = new AnnotationConfiguration().configure();
        SchemaExport export = new SchemaExport(cfg);
        export.create(true,true);
    }
}
