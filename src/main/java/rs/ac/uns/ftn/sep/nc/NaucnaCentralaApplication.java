package rs.ac.uns.ftn.sep.nc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import rs.ac.uns.ftn.sep.nc.properties.NcProperties;

@SpringBootApplication
@EnableConfigurationProperties(NcProperties.class)
public class NaucnaCentralaApplication {

    public static void main(String[] args) {
        SpringApplication.run(NaucnaCentralaApplication.class, args);
    }

}
