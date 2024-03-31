import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class driver {

    public static ArrayList<ProcessControlBlock> Q1 = new ArrayList<>();
    public static ArrayList<ProcessControlBlock> Q2 = new ArrayList<>();
    public static List<ProcessControlBlock> schedulingOrder = new ArrayList<>();
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
                

                  reportInformation(); 
                  
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




    private static void reportInformation(){

        if (Q1.isEmpty() && Q2.isEmpty()) {
            System.out.println("No processes to schedule.");
            return;
        }



        
        scheduleProcesses();


        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Report.txt"))) {
        // Write scheduling order to file and display in console
        for (ProcessControlBlock process : schedulingOrder) {
            System.out.println("Process ID: " + process.processID);
            System.out.println("Priority: " + process.priority);
            System.out.println("Arrival time: " + process.arrivalTime);
            System.out.println("CPU burst time: " + process.cpuBurst);
            System.out.println("Start time: " + process.startTime);
            System.out.println("Termination time: " + process.terminationTime);
            System.out.println("Turnaround time: " + process.turnaroundTime);
            System.out.println("Waiting time: " + process.waitingTime);
            System.out.println("Response time: " + process.responseTime);
            System.out.println();


            writer.write("Process ID: " + process.processID);
            writer.newLine();
            writer.write("Priority: " + process.priority);
            writer.newLine();
            writer.write("Arrival time: " + process.arrivalTime);
            writer.newLine();
            writer.write("CPU burst time: " + process.cpuBurst);
            writer.newLine();
            writer.write("Start time: " + process.startTime);
            writer.newLine();
            writer.write("Termination time: " + process.terminationTime);
            writer.newLine();
            writer.write("Turnaround time: " + process.turnaroundTime);
            writer.newLine();
            writer.write("Waiting time: " + process.waitingTime);
            writer.newLine();
            writer.write("Response time: " + process.responseTime);
            writer.newLine();
            writer.newLine();
        }



        
        // Calculate and display average turnaround time, waiting time, and response time
        int totalTurnaroundTime = 0;
        int totalWaitingTime = 0;
        int totalResponseTime = 0;
        for (ProcessControlBlock process : schedulingOrder) {
            totalTurnaroundTime += process.turnaroundTime;
            totalWaitingTime += process.waitingTime;
            totalResponseTime += process.responseTime;
        }
        double avgTurnaroundTime = (double) totalTurnaroundTime / schedulingOrder.size();
        double avgWaitingTime = (double) totalWaitingTime / schedulingOrder.size();
        double avgResponseTime = (double) totalResponseTime / schedulingOrder.size();

        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
        System.out.println("Average Waiting Time: " + avgWaitingTime);
        System.out.println("Average Response Time: " + avgResponseTime);

        writer.write("Average Turnaround Time: " + avgTurnaroundTime);
        writer.newLine();
        writer.write("Average Waiting Time: " + avgWaitingTime);
        writer.newLine();
        writer.write("Average Response Time: " + avgResponseTime);
        writer.newLine();




    }// end witing 
    catch (IOException e) {
        System.out.println("An error occurred while writing to the file: " + e.getMessage());
    }

    }





    private static void scheduleProcesses(){


    }






























  }// end class 
  