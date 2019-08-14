package pl.sda.servlets;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import utils.HibernateUtils;

import javax.servlet.ServletException;
import java.io.File;

public class Application {

    public static void main(String[] args) throws ServletException, LifecycleException {
        HibernateUtils.getInTransaction(t -> null);

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(9091);
        String webAppPath =
                new File("src/main/webapp/").getAbsolutePath();
        Context context = tomcat.addWebapp("", webAppPath);
        String classesPath = new File("target/classes").getAbsolutePath();
        WebResourceRoot resources = new StandardRoot(context);
        DirResourceSet resourceSet =
                new DirResourceSet(resources,
                        "/WEB-INF/classes",
                        classesPath,
                        "/");
        resources.addPreResources(resourceSet);
        context.setResources(resources);

        tomcat.start();
        tomcat.getServer().await();
    }
}
