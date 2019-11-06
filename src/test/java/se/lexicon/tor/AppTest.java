package se.lexicon.tor;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;

import org.junit.Test;


public class AppTest {

    @Test
    public void test() {
        //arrange
        //act
        //assert
        assertTrue(true);
    }

    //-----------------------------------------------addition-----------------------------------------------
    @Test
    public void testAddSingle() {
        //arrange
        double num1 = 2.4, num2 = 5.1, expected = 7.5;
        //act
        double result = BasicCalculator.add(num1, num2);
        //assert
        assertEquals(expected, result, 0);
    }

    @Test
    public void testAddSingleNegative() {
        //arrange
        double num1 = -2.4, num2 = 5.1, expected = 2.7;
        //act
        double result = BasicCalculator.add(num1, num2);
        //assert
        assertEquals(expected, result, 0.01);
    }

    @Test
    public void testAddSeveral() {
        //arrange
        double num1 = 2.4, num2 = 5.1, num3 = 1, num4 = 3.2, num5 = 4.9, expected = 16.6;
        //act
        double result = BasicCalculator.add(num1, num2, num3, num4, num5);
        //assert
        assertEquals(expected, result, 0);
    }

    //-----------------------------------------------subtraction-----------------------------------------------

    @Test
    public void testSubSingle() {
        //arrange
        double num1 = 8.2, num2 = 3.2, expected = 5;
        //act
        double result = BasicCalculator.sub(num1, num2);
        //assert
        assertEquals(expected, result, 0.1);
    }

    @Test
    public void testSubSingleNegative() {
        //arrange
        double num1 = 8.2, num2 = -3.2, expected = 11.4;
        //act
        double result = BasicCalculator.sub(num1, num2);
        //assert
        assertEquals(expected, result, 0.1);
    }

    @Test
    public void testSubSeveral() {
        //arrange
        double num1 = 23, num2 = 5.1, num3 = 1, num4 = 3.2, num5 = 4.9, expected = 8.8;
        //act
        double result = BasicCalculator.sub(num1, num2, num3, num4, num5);
        //assert
        assertEquals(expected, result, 0.1);
    }

    //-----------------------------------------------Multiply-----------------------------------------------

    @Test
    public void testMulPosPos() {
        //arrange
        double num1 = 2, num2 = 5.1, expected = 10.2;
        //act
        double result = BasicCalculator.mul(num1, num2);
        //assert
        assertEquals(expected, result, 0.1);
    }

    @Test
    public void testMulPosNeg() {
        //arrange
        double num1 = -2, num2 = 5.1, expected = -10.2;
        //act
        double result = BasicCalculator.mul(num1, num2);
        //assert
        assertEquals(expected, result, 0.1);
    }

    @Test
    public void testMulNegNeg() {
        //arrange
        double num1 = -2, num2 = -5.1, expected = 10.2;
        //act
        double result = BasicCalculator.mul(num1, num2);
        //assert
        assertEquals(expected, result, 0.1);
    }

    @Test
    public void testMulZero() {
        //arrange
        double num1 = 0, num2 = 5.1, expected = 0;
        //act
        double result = BasicCalculator.mul(num1, num2);
        //assert
        assertEquals(expected, result, 0);
    }

    //-----------------------------------------------divide-----------------------------------------------

    @Test
    public void testDivPosPos() {
        //arrange
        double num1 = 4.6, num2 = 2, expected = 2.3;
        //act
        double[] result = BasicCalculator.div(num1, num2);
        //assert
        assertEquals(0, result[1], 0.0);
        assertEquals(expected, result[0], 0.1);
    }

    @Test
    public void testDivPosNeg() {
        //arrange
        double num1 = 4.6, num2 = -2, expected = -2.3;
        //act
        double[] result = BasicCalculator.div(num1, num2);
        //assert
        assertEquals(0, result[1], 0.0);
        assertEquals(expected, result[0], 0.1);
    }

    @Test
    public void testDivByZero() {
        //arrange
        double num1 = 4.6, num2 = 0, expected = 4.6;
        //act
        double[] result = BasicCalculator.div(num1, num2);
        //assert
        assertEquals(result[1], -1, 0.0);
        assertEquals(expected, result[0], 0.1);
    }

    @Test
    public void testDivZeroBy() {
        //arrange
        double num1 = 0, num2 = 2, expected = 0;
        //act
        double[] result = BasicCalculator.div(num1, num2);
        //assert
        assertEquals(0, result[1], 0.0);
        assertEquals(expected, result[0], 0.1);
    }

    //-----------------------------------------------power-of-----------------------------------------------

    @Test
    public void testPowPosPos() {
        //arrange
        double num1 = 4, num2 = 2, expected = 16;
        //act
        double result = BasicCalculator.pow(num1, num2);
        //assert
        assertEquals(expected, result, 0.1);
    }

    @Test
    public void testPowPosNeg() {
        //arrange
        double num1 = 4, num2 = -2, expected = 0.0625;
        //act
        double result = BasicCalculator.pow(num1, num2);
        //assert
        assertEquals(expected, result, 0.00001);
    }

    @Test
    public void testPowNegPos() {
        //arrange
        double num1 = -4, num2 = 2, expected = 16;
        //act
        double result = BasicCalculator.pow(num1, num2);
        //assert
        assertEquals(expected, result, 0.1);
    }

    @Test
    public void testPowNegPosUneven() {
        //arrange
        double num1 = -2, num2 = 3, expected = -8;
        //act
        double result = BasicCalculator.pow(num1, num2);
        //assert
        assertEquals(expected, result, 0.1);
    }

    //-----------------------------------------------sqrt-----------------------------------------------

    @Test
    public void testSqrtPos() {
        //arrange
        double num1 = 4, expected = 2;
        //act
        double[] result = BasicCalculator.sqrt(num1);
        //assert
        assertEquals(result[1], 0, 0.0);
        assertEquals(expected, result[0], 0.1);
    }

    @Test
    public void testSqrtNeg() {
        //arrange
        double num1 = -4, expected = -4;
        //act
        double[] result = BasicCalculator.sqrt(num1);
        //assert
        assertEquals(result[1], -1, 0.0);
        assertEquals(expected, result[0], 0);
    }

    @Test
    public void testSqrtZero() {
        //arrange
        double num1 = 0, expected = 0;
        //act
        double[] result = BasicCalculator.sqrt(num1);
        //assert
        assertEquals(result[1], 0, 0.0);
        assertEquals(expected, result[0], 0.1);
    }

    //-----------------------------------------------add-to-array-----------------------------------------------

    @Test
    public void testAddToArray() {
        //arrange
        double[] array = {3.2,5.6,3.2,1.1};
        double number = 3.9;
        double[] expected = {3.2,5.6,3.2,1.1,3.9};
        //act
        double[] result = BasicCalculator.addToArray(array,number);
        //assert
        assertArrayEquals(expected, result, 0);
    }

}
