import java.util.ArrayList;
import java.util.Scanner;

public class driver {

    private static ArrayList<ProcessControlBlock> Q1 = new ArrayList<>();
    private static ArrayList<ProcessControlBlock> Q2 = new ArrayList<>();
    public static Scanner input = new Scanner(System.in);

public static void main(String[] args) {
        
    int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Enter process' information");
            System.out.println("2. Report detailed information about each process and different scheduling criteria");
            System.out.println("3. Exit the program");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    processInfo();
                    break;
                case 2:
                    // add code 
                    break;
                case 3:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        } while (choice != 3);
        
    }




    private static void processInfo() {
        System.out.print("Enter the number of processes: ");
        int numProcesses = input.nextInt();

        for (int i = 1; i <= numProcesses; i++) {
            System.out.println("Enter details for process P" + i + ":");
            System.out.print("Priority (1 or 2): ");
            int priority = input.nextInt();
            System.out.print("Arrival Time: ");
            double arrivalTime = input.nextDouble();
            System.out.print("CPU Burst Time: ");
            double cpuBurst = input.nextDouble();

            ProcessControlBlock pcb = new ProcessControlBlock( priority, arrivalTime, cpuBurst);
            System.out.println(pcb.toString());

            // Add the process to the appropriate queue
            if (priority == 1)
                Q1.add(pcb);
            else
                Q2.add(pcb);
        }
    }

































  }// end class 
  