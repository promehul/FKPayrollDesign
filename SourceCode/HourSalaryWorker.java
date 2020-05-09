package assignmentJava;

import java.time.*;

public class HourSalaryWorker extends Employee {
    private int hourlyRate;

    HourSalaryWorker(int hourlyRate) {
        super();
        this.hourlyRate = hourlyRate;
    }
    
    public void setHourlyRate(int hourlyRate){
        this.hourlyRate = hourlyRate;
    }

    public void submitTimeCard(float hours){
        TimeCard card = new TimeCard(this, hours);
        if(hours<=8)
            this.updateNextPayAmount((double)(this.hourlyRate*hours));
        else
            this.updateNextPayAmount(((this.hourlyRate)*8.0)+((double)(hours-8)*(this.hourlyRate)*1.5));     
    }

    public static void main(String[] args){
        HourSalaryWorker worker = new HourSalaryWorker(100);
        worker.submitTimeCard(12);
        System.out.println(worker.getNextPayAmount());
        worker.setHourlyRate(200);
        worker.submitTimeCard(8);
        System.out.println(worker.getNextPayAmount());
    }

}

class TimeCard {
    HourSalaryWorker worker;
    private LocalDateTime day;
    private float hours;

    TimeCard(HourSalaryWorker worker, float hours) {
        this.worker = worker;
        this.hours = hours;
        this.day = LocalDateTime.now();
    }
}