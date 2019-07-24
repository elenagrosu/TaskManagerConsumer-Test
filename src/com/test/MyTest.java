package com.test;

import com.company.StdAvg;
import com.company.Student;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MyTest {
    StdAvg stdBusinessLogic = new StdAvg();
    Student student = new Student("Elena", "TI", 11);

    @Test
    public void testAvgCalculation() {
        double appraisal = stdBusinessLogic.calculateAppraisal(student);
        System.out.println("Test result:" + appraisal);
        assertEquals(500, appraisal, 0.0);

    }

    @Test
    public void testAvgCalculation1() {
        double appraisal = stdBusinessLogic.calculateAppraisal(student);
        System.out.println("Test result:" + appraisal);
        assertEquals(600, appraisal, 0.0);

    }

}
