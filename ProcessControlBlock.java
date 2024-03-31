class ProcessControlBlock {
    public String processID;
    public int priority;
    public double arrivalTime;
    public double cpuBurst;
    public double startTime;
    public double terminationTime;
    public double turnaroundTime;
    public double waitingTime;
    public double responseTime;

    public static int processCount = 1;

    public ProcessControlBlock( int priority, double arrivalTime, double cpuBurst) {
        this.processID = "P" + (ProcessControlBlock.processCount++);
        this.priority = priority;
        this.arrivalTime = arrivalTime;
        this.cpuBurst = cpuBurst;
        this.startTime = -1; // Initialize to -1 indicating not yet started
        this.terminationTime = -1; // Initialize to -1 indicating not yet terminated
    }

   
  
    // Calculate turnaround time
    public void calculateTurnaroundTime() {
        this.turnaroundTime = this.terminationTime - this.arrivalTime;
    }

    // Calculate waiting time
    public void calculateWaitingTime() {
        this.waitingTime = this.turnaroundTime - this.cpuBurst;
    }

    // Calculate response time
    public void calculateResponseTime() {
        this.responseTime = this.startTime - this.arrivalTime;
    }

    


    
    @Override
    public String toString() {
        return "Process ID: " + processID +
                "\nPriority: " + priority +
                "\nArrival Time: " + arrivalTime +
                "\nCPU Burst: " + cpuBurst +
                "\nStart Time: " + startTime +
                "\nTermination Time: " + terminationTime +
                "\nTurnaround Time: " + turnaroundTime +
                "\nWaiting Time: " + waitingTime +
                "\nResponse Time: " + responseTime;
    }
}