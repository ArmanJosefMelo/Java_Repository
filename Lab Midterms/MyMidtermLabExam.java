import java.util.Scanner;

public class MyMidtermLabExam {

    
    static String[] ticketArray = {" ", " ", " ", " ", " "};
    static String issueDesc = (" ");
    static String urgencyLvl = (" ");
    static String ticketStatus = (" ");
    static int menuOption = 0;
    static int reportTotal = 0;
    static int reportPending = 0;
    static int reportSolved = 0;
    static int orderList = 1;
    static int i = 0;

    // Ticket Adding
    static void addTicket() {
        Scanner inputScanner = new Scanner(System.in);

            System.out.print("Enter issue description: ");
            issueDesc = inputScanner.nextLine();
    
            System.out.print("Enter urgency level ( High / Medium / Low): ");
            urgencyLvl = inputScanner.nextLine();

            ticketStatus = ("Pending");

            switch (urgencyLvl) {
                case "High":
                    ticketArray [i++] = "[ " + urgencyLvl + " ] " + " - Status: " + ticketStatus;
                    reportTotal++;
                    reportPending++;
                    System.out.println("Ticket Added Successfully");
                    break;
                case "Medium":
                    ticketArray [i++] = "[ " + urgencyLvl + " ] " + " - Status: " + ticketStatus;
                    reportTotal++;
                    reportPending++;
                    System.out.println("Ticket Added Successfully");
                    break;
                case "Low":
                    ticketArray [i++] = "[ " + urgencyLvl + " ] " + " - Status: " + ticketStatus;
                    reportTotal++;
                    reportPending++;
                    System.out.println("Ticket Added Successfully");
                    break;
                default:
                    System.out.println("Invalid Urgency Input");
                    break;
        }
    }

    // Ticket Status Updating
    static void updateTicketStatus() {
        Scanner inputScanner = new Scanner(System.in);

        for (String i : ticketArray)
        System.out.println(orderList++ + ". " + i);
        System.out.println();

        System.out.print("Enter a ticket number to update: ");
        int chooseTicket = inputScanner.nextInt();
        inputScanner.nextLine(); // Due to Java skipping the next scanner, this line is added to prevent this issue.

        System.out.print("Enter new status ( In Progress / Resolved ): ");
        String ticketStatus = inputScanner.nextLine();

        switch (ticketStatus) {
            case "In Progress":
                ticketArray [i++] = "[ " + urgencyLvl + " ] " + " - Status: " + ticketStatus;
                break;
            case "Resolved":
                ticketArray [chooseTicket - 1] = ticketArray [chooseTicket - 1] + ticketStatus;
                reportPending = reportPending - 1;
                reportSolved++;
                break;
            default:
                System.out.println("Invalid Status Update.");
                break;
        }
    }

    // Shows Ticket List
    static void showTicket() {

        System.out.println("--- All Tickets ---");

        for (String i : ticketArray)
        System.out.println(orderList++ + ". " + i);
        }
    

    // Report Generator
    static void generateReport() {

        System.out.println("--- Ticket Report ---");

        System.out.println("Total Tickets: " + reportTotal);
        System.out.println("Pending Tickets: " + reportPending);
        System.out.println("Resolved tickets: " + reportSolved);
    }

    // Main Menu
    public static void main(String[] arg) {
        Scanner inputScanner = new Scanner(System.in);

        do {
            System.out.println("=== IT Ticket System ===");
            System.out.println("1. Add Ticket");
            System.out.println("2. Update Ticket Status");
            System.out.println("3. Show All Tickets");
            System.out.println("4. Generate Report");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            menuOption = inputScanner.nextInt();
            System.out.println();
            
            switch (menuOption) {
                case 1:
                    if (i == ticketArray.length) {
                        System.out.println("Max Ticket Limit reached.");
                        break;
                    }
                        addTicket();
                        System.out.println();
                    break;
                case 2:
                    updateTicketStatus();
                    orderList = 1;
                    System.out.println();
                    break;
                case 3:
                    showTicket();
                    orderList = 1;
                    System.out.println();
                    break;
                case 4:
                    generateReport();
                    System.out.println();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid menu option, please select a valid option.");
                    break;
            }
        }
        while (menuOption != 5);

        // Closing Message
        System.out.println("Exiting... Thank you!");
        System.exit(0);
    }
}
