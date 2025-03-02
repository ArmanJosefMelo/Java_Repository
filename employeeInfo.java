import java.util.Scanner;

public abstract class employeeInfo {
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

        float dailySalary = hourlyWage * hoursWorked; // Formula for Daily Salary

        System.out.println("Full Name: " + firstName + lastName);   // Full Name Output
        System.out.println("Age: " + employeeAge);                  // Age Output
        System.out.printf("Daily Salary: PHP " + dailySalary);      // Daily Salary Output
    }
}

