package com.NSiTeam.WolframNS.libraries;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SimpleCalculationsTest {




    @Test
    public void testSum() {

        SimpleCalculations simpleCalculations = new SimpleCalculations();

      //  assertEquals(1.0, simpleCalculations.calculate("1"), 0.0001);
        assertEquals(2.0, simpleCalculations.calculate("1+1"), 0.0001);
       // assertEquals(4.0, simpleCalculations.calculate("2*2"), 0.0001);
      //  assertEquals(2.5, simpleCalculations.calculate("5/2"), 0.0001);
      //  assertEquals(-9.25, simpleCalculations.calculate("3 / 4 + 6 - (9 + 7)"), 0.0001);

    }

    @Test
    public void testMultiplication() {

        SimpleCalculations simpleCalculations = new SimpleCalculations();

        assertEquals(4.0, simpleCalculations.calculate("2*2"), 0.0001);

    }

    @Test
    public void testSubtraction() {

        SimpleCalculations simpleCalculations = new SimpleCalculations();

        assertEquals(-2.0, simpleCalculations.calculate("2-4"), 0.0001);

    }

    @Test
    public void testDivision() {

        SimpleCalculations simpleCalculations = new SimpleCalculations();

        assertEquals(0.666667, simpleCalculations.calculate("2/3"), 0.0001);

    }

    @Test
    public void testExpressionWithBrakets() {

        SimpleCalculations simpleCalculations = new SimpleCalculations();

        assertEquals(6.0, simpleCalculations.calculate("2+2*2"), 0.0001);
        assertEquals(8.0, simpleCalculations.calculate("(2+2)*2"), 0.0001);
        assertEquals(0.3, simpleCalculations.calculate("3 /(4 + 6)"), 0.0001);
        assertEquals(-25.25, simpleCalculations.calculate("3 / 4 + 6 - (9 + 7) * 2"), 0.0001);
        assertEquals(4, simpleCalculations.calculate("4 + 8/23 * (9 - 4 - 5)"), 0.0001);
    }



}
