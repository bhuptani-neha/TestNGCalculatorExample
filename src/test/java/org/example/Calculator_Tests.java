package org.example;
import com.epam.tat.module4.Calculator;
import com.epam.tat.module4.Calculator.*;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Calculator_Tests {

    private static Calculator calc;

    @BeforeClass
    public void Setup(){
        calc = new Calculator();
        System.out.println("SETUP");
    }

    @Test(groups = {"Arithmetic", "Positive"})
    public static void AdditionTest(){
        Assert.assertEquals(4, calc.sum(2,2));
    }

    @Test(groups = {"Arithmetic", "Positive"})
    public static void SubtractionTest(){
        Assert.assertEquals(0, calc.sub(2,2));
        Assert.assertEquals(2, calc.sub(0,-2));
        Assert.assertEquals(-3.1, calc.sub(-5.5,-2.4));
    }

    @Test(groups = {"Arithmetic", "Positive"})
    public static void MultiplicationTest(){
        Assert.assertEquals(4, calc.mult(2,2));
        Assert.assertEquals(4, calc.mult(2.,2));
        Assert.assertEquals(10, calc.mult(-5.,-2));
    }

    @Test(groups = {"Arithmetic", "Positive"})
    public static void DivideTest(){
        Assert.assertEquals(4, calc.div(8,2));
    }

    @Test (expectedExceptions = {NumberFormatException.class},groups = {"Arithmetic", "Positive"})
    public static void DivideByZero(){
        Assert.assertEquals(0, calc.div(2,0));
    }

    @Test(groups = {"Positive"})
    public static void IsPositiveIsNegativeTest(){
        Assert.assertTrue(calc.isNegative(-5));
        Assert.assertFalse(calc.isPositive(-5));

        Assert.assertTrue(calc.isNegative(-555555778));
        Assert.assertFalse(calc.isPositive(-555555778));

        Assert.assertFalse(calc.isNegative(5));
        Assert.assertTrue(calc.isPositive(5));

        Assert.assertFalse(calc.isNegative(0));
        Assert.assertFalse(calc.isPositive(0));
    }

    @Test(groups = {"Positive"})
    public  static  void PowerFunctionTest(){
        Assert.assertEquals(0.25,calc.pow(-2,-2));
    }

    @Test(groups = {"Positive"})
    public  static  void SinThetaTest(){
        Assert.assertEquals(Math.sin(-2.5),calc.sin(-2.5));
    }

    @Test(groups = {"Negative"})
    public  static  void CosThetaTest(){
        Assert.assertEquals(Math.cos(2),calc.cos(2));
    }

    @Test(groups = {"Negative"})
    public  static  void TanThetaTest(){
        Assert.assertEquals(Math.tan(2),calc.tg(2));
    }

    @Test(groups = {"Negative"})
    public  static  void CotThetaTest(){
        Assert.assertEquals(1/Math.tan(2),calc.ctg(2));
    }

    @Test(groups = {"Arithmetic", "Negative"})
    public static void NegativeMultiplicationTest(){
        Assert.assertEquals(13.2, calc.mult(-5.5,-2.4));
    }

    @Test(groups = {"Negative"})
    public static void NegativePowerTest(){
        Assert.assertEquals(Double.NaN,calc.pow(-5,-2.4));
    }

    @AfterClass
    public void TearDown(){
        System.out.println("The End");
    }


    @DataProvider(name="EndPoints")
    Object[][] EndPointData(){
        return new Object[][] {
                {5,4,9},
                {1,3,4},
                {9,7,16},
                {1,0,1},
        };
    }

    @Test(dataProvider = "EndPoints")
    public static void DatProviderAdditionTest(int a , int b, int c){

        Assert.assertEquals(c, calc.sum(a,b));
    }

}
