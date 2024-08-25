package ir.freeland.springboot.requestresponsebody;

import org.springframework.web.bind.annotation.GetMapping;

public class RegistrationController {

	 
    @GetMapping("/register")
    public String showRegistrationForm() {
        return "requestresponsebody/register"; 
    }
    
	
}
