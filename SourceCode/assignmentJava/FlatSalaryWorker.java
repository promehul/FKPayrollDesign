package assignmentJava;

import java.time.*;

public class FlatSalaryWorker extends Employee {
    private double monthlySalary;
    private float commissionRate;
    private double commissionSalary;

    FlatSalaryWorker(double monthlySalary) {
        super();
        this.monthlySalary = monthlySalary;
        this.updateNextPayAmount(monthlySalary);
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }
    
    public void setCommissionRate(float commissionRate){
        this.commissionRate = commissionRate;
    }

    public void giveAwayCommissionSalary(){
        System.out.println("The worker's commission salary is "+this.commissionSalary);
        this.commissionSalary = 0.0;
    }

    public void updateCommissionSalary(double sales) {
        this.commissionSalary += (this.commissionRate*sales)/100;
    }

    public double getCommissionSalary(){
        return this.commissionSalary;
    }

    

    public void submitSalesReceit(double sales) {
        SalesReceit receit = new SalesReceit(this, sales);
        this.updateCommissionSalary(sales);
    }

    public static void main(String[] args){
        FlatSalaryWorker worker = new FlatSalaryWorker(1000.0);
        worker.setCommissionRate(5);
        worker.submitSalesReceit(1000);
        System.out.println(worker.getCommissionSalary());
        worker.submitSalesReceit(100);
        System.out.println(worker.getCommissionSalary());
    }
}

class SalesReceit {
    FlatSalaryWorker worker;
    LocalDateTime time;
    double sales;

    SalesReceit(FlatSalaryWorker worker, double sales) {
        this.worker = worker;
        this.time = LocalDateTime.now();
        this.sales = sales;
    }
}