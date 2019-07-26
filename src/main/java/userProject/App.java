package userProject;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */

@SpringBootApplication
public class App 
{
    static Logger log = Logger.getLogger(App.class.getName());

    public static void main( String[] args )
    {
        log.debug("main method");
        SpringApplication.run(App.class, args);    }



}
