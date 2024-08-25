package ir.freeland.spring.validator;

import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;

public class EXPAppValidatorInput {

  @Min(1)
  @Max(10)
  private int numberBetweenOneAndTen;

  // Note that this is actually not a valid IP address pattern, since
  // it allows values greater than 255 per octet.
  @Pattern(regexp = "^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$")
  private String ipAddress;
  
  @Pattern(regexp = "^[a-zA-Z]+$")
  private String name;
  
  @URL
  private String website;
  
  @Size(min = 2, max = 50)
  private String family;
  
  @Email
  private String email;

  public String getWebsite() {
	return website;
}

public void setWebsite(String website) {
	this.website = website;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getFamily() {
	    return family;
	  }

  public void setFamily(String family) {
	    this.family = family;
	  }

   public String getName() {
	    return name;
	  }

  public void setName(String name) {
	    this.name = name;
	  }

  public int getNumberBetweenOneAndTen() {
    return numberBetweenOneAndTen;
  }

  public void setNumberBetweenOneAndTen(int numberBetweenOneAndTen) {
    this.numberBetweenOneAndTen = numberBetweenOneAndTen;
  }

   public String getIpAddress() {
    return ipAddress;
  }

  public void setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
  }
}
