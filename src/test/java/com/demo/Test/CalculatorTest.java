package com.demo.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    Calculator calculator = new Calculator();

      @Test
    public void multiplyTest(){
          assertEquals(20,calculator.multiply(10,2));
      }

      @Test
    public void divideTest(){
          assertEquals(2,calculator.divide(5,2));
        //  assertEquals(0,calculator.divide(8,0));//Arthmetic Exception
      }
}
