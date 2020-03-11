package com.elsevier.qa.util;


import org.junit.Assert;

public class VerifyUtil {

    public static void equals(String expected, String actual) {
        System.out.println("\nVerifying the expected data :"+expected+" to be visbile in actual value :"+actual);
        Assert.assertEquals("the expected value is "+expected+" but actual is " + actual, expected.replaceAll("\\s+",""), actual.replaceAll("\\s+",""));
    }

    public static void equals(boolean exp, boolean act) {
        Assert.assertEquals("Checked the condition to be equal",exp,act);
    }

    public static void contains(String expected, String actual) {
        if(actual.replaceAll("\\s+", "").contains(expected.replaceAll("\\s+", ""))) {
            Assert.assertTrue(expected.replaceAll("\\s+","")+" is containing in actual value "+actual.replaceAll("\\s+",""),true);
        } else {
            Assert.fail(expected.replaceAll("\\s+","")+" is not containing actual value "+actual.replaceAll("\\s+",""));
        }
    }
}
