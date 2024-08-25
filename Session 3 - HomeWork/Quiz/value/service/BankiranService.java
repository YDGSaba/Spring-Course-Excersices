package ir.freeland.spring.value.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BankiranService {

	@Value("${bankiran.address}")
	private String address;
	
	//the # symbol indicates that you are using a Spring Expression Language (SpEL) expression.
	//toUpperCase(): Converts the value to uppercase.
	@Value("#{'${bankiran.username}'.toUpperCase()}")
	private String username;
	
	/*how to get inputs?
	 * In a Spring Boot application, inputs are often provided through configuration files or environment variables. 
	 * You can access these inputs by defining properties in application.properties or application.yml files.*/
    public void setup() {
        System.out.println("bank iran address is: " + address + " username: " + username );
    }

}
