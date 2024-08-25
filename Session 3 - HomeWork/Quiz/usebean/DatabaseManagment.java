package ir.freeland.spring.usebean;

import org.springframework.stereotype.Repository;

@Repository
public class DatabaseManagment {
  public void save(String value) {
    System.out.println("Save to database result: " + value);
   
  }
}
