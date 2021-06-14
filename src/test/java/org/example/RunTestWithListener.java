package org.example;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class RunTestWithListener {
    public static void main(String args[]){
        TestListenerAdapter tls = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[]{Calculator_Tests.class});
        testng.addListener(tls);
        testng.run();
        System.out.println("Passed Test Cases-- "+tls.getPassedTests().get(0).getName());
        System.out.println("Passed Test Cases-- "+tls.getPassedTests().get(1).getName());
    }

}
