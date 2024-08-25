package ir.freeland.spring.initialspring.annotation;

import org.springframework.stereotype.Service;

/**
 * Simple output handler for printing
 *
 * Used only for demonstration purposes :P
 */
@Service
public class Print {
  public void output(String value) {
    System.out.println("Print: " + value);
  }
}
