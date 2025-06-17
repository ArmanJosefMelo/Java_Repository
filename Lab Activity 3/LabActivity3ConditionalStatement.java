import java.util.Scanner;

public class LabActivity3ConditionalStatement {

    public static void main(String[] arg) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("Enter your first name: ");
        String firstName = inputScanner.nextLine(); // Employee's First Name Scanner

        System.out.print("Enter your last name: ");
        String lastName = inputScanner.nextLine(); // Employee's Last Name Scanner

        System.out.print("Enter your age: ");
        int employeeAge = inputScanner.nextInt(); // Employee's Age Scanner

            if (employeeAge >= 65) { // Terminates program if age is equal or more than 65
                System.out.println("Senior Citizens are not allowed.");
                System.exit(0);
            }
            else if (employeeAge < 18) { // Terminates program if age is less than 18
                System.out.println("Minors are not allowed.");
                System.exit(0);
            }
        
        System.out.print("Enter hours worked: ");
        float hoursWorked = inputScanner.nextFloat(); // Hours Worked Scanner

            if (hoursWorked > 24) { // Terminates program if works hours is greater than 24
                System.out.println("Number of hours worked cannot exceed more than 24 hours.");
                System.exit(0);
            }
            else if (hoursWorked <= 0) { // Terminates program if work hours is less than 0
                System.out.println("Wrong input of daily work hours.");
                System.exit(0);
            }

        System.out.print("Enter hourly wage: ");
        float hourlyWage = inputScanner.nextFloat(); // Hourly Wage Scanner

        System.out.print("Enter role code (1-Manager, 2-Supervisor, 3-Staff, 4-Intern): "); // Role Code
        int roleCode = inputScanner.nextInt();

        System.out.println("Employee Information");
        System.out.println("--------------------");

        // Formulas

        int retireAge = employeeAge - 65; // Years to Retirement
        double dailySalary = Math.round(hourlyWage * hoursWorked); // Daily Salary
        double weeklySalary = dailySalary * 5; // Weekly Salary
        double monthlySalary = weeklySalary * 4; // Monthly Salary
        double grossSalary = monthlySalary * 12; // Gross Yearly Salary
        double netSalary = 0; // Net Yearly Salary
            if (grossSalary > 250000) {
                netSalary = grossSalary - (1500 + grossSalary * 0.32); // If more than 250000
            }
            else { // If less than or equal to 250000
                netSalary = grossSalary - 1500;
            }
 
        // Outputs
 
        System.out.println("Full Name: " + lastName.toUpperCase() + ", " + firstName.toUpperCase()); 
        System.out.println("Age: " + employeeAge);

        switch (roleCode) {
            case 1:
                System.out.println("Position: Manager");
                break;
            case 2:
                System.out.println("Position: Supervisor");
                break;
            case 3:
                System.out.println("Position: Staff");
                break;
            case 4:
                System.out.println("Position: Intern");
                break;
            default:
                System.out.println("Position: Undefined");
                break;
        }

        System.out.println("Years to Retirement: " + Math.abs(retireAge)); 
        System.out.println("Daily Salary: PHP " + dailySalary);
        System.out.println("Weekly Salary: PHP " + weeklySalary);
        System.out.println("Monthly Salary: PHP " + monthlySalary);
        System.out.println("Gross Yearly Salary: PHP " + grossSalary);
        System.out.println("Net Yearly Salary: PHP " + netSalary);
 
    }

}
