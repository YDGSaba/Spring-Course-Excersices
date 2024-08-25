package ir.freeland.spring.usebean;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//public class UsebeanApplication {
//  public static void main(String[] args) {
//    InternetbankServices internetbankServices = new InternetbankServices();
//
//    internetbankServices.doCardToCard("6274.1211.6623.6810","6037.9919.1267.1343");
//    }
//}
@SpringBootApplication
public class UsebeanApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsebeanApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(InternetbankServices internetbankServices) {
        return args -> {
            internetbankServices.doCardToCard("6274.1211.6623.6810", "6037.9919.1267.1343");
        };
    }
}