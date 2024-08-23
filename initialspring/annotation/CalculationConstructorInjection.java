package ir.freeland.spring.initialspring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalculationConstructorInjection {
  private final Calculator calculator;
  private final Display display;
  private final Print print;

  @Autowired
  public CalculationConstructorInjection(Calculator calculator, Display display, Print print) {
    this.calculator = calculator;
    this.display = display;
    this.print = print;
  }

  public void complexCalculation() {
    int result = calculator.plus(2, 3);

    display.output(String.format("2 + 3 = %d", result));
    print.output(String.format("2 + 3 = %d", result));
  }
}
