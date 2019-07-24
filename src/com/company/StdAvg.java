package com.company;

public class StdAvg {
    public double calculateAvgMark(Student studentDetails) {
        double yearlySalary = 0;
        yearlySalary = studentDetails.getAge() * 12;
        return yearlySalary;
    }

    // Calculate the appraisal amount of employee
    public double calculateAppraisal(Student studentDetails) {
        double appraisal = 0;

        if (studentDetails.getAge() < 10000) {
            appraisal = 500;
        } else {
            appraisal = 1000;
        }

        return appraisal;
    }

}
