import java.util.Scanner;

public class LabActivity2EmployeeInformationSystemPart2 {
    public static void main(String[] arg) {
        Scanner inputScanner = new Scanner(System.in);
        
        System.out.print("Enter your first name: ");
        String firstName = inputScanner.nextLine(); // Employee's First Name Scanner

        System.out.print("Enter your last name: ");
        String lastName = inputScanner.nextLine(); // Employee's Last Name Scanner

        System.out.print("Enter your age: ");
        int employeeAge = inputScanner.nextInt(); // Employee's Age Scanner
        
        System.out.print("Enter hours worked: ");
        float hoursWorked = inputScanner.nextFloat(); // Hours Worked Scanner

        System.out.print("Enter hourly wage: ");
        float hourlyWage = inputScanner.nextFloat(); // Hourly Wage Scanner

        System.out.println("Employee Information");
        System.out.println("--------------------");
        
        // Formulas

        int retireAge = employeeAge - 65; // Years to Retirement
        double dailySalary = Math.round(hourlyWage * hoursWorked); // Daily Salary
        double weeklySalary = dailySalary * 5; // Weekly Salary
        double monthlySalary = weeklySalary * 4; // Monthly Salary
        double grossSalary = monthlySalary * 12; // Gross Yearly Salary
        double netSalary = grossSalary - (1500 + grossSalary * 0.32); // Net Yearly Salary

        // Outputs

        System.out.println("Full Name: " + lastName.toUpperCase() + ", " + firstName.toUpperCase());   
        System.out.println("Age: " + employeeAge);                  
        System.out.println("Years to Retirement: " + Math.abs(retireAge));  
        System.out.println("Daily Salary: PHP " + dailySalary);      
        System.out.println("Weekly Salary: PHP " + weeklySalary);
        System.out.println("Monthly Salary: PHP " + monthlySalary);
        System.out.println("Gross Yearly Salary: PHP " + grossSalary);
        System.out.println("Net Yearly Salary: PHP " + netSalary);

    }
}