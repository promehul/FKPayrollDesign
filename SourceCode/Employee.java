package assignmentJava;

import java.time.*;

public class Employee {
    
    enum PaymentMethod {MAIL, PICKUP, DEPOSIT};
    
     private String firstName;
     private String lastName;
     private LocalDateTime dateOfJoining;

     private PaymentMethod payBy;
     private String mailAddress;
     private String accountDetails;

     private double weeklyDues;

     private double nextPayAmount;
     private double prevPayAmount;
     private LocalDateTime prevDayPay;

     Employee() {
         this.firstName = "";
         this.lastName = "";
         this.dateOfJoining = LocalDateTime.now();
         this.payBy = PaymentMethod.PICKUP;
     }

     public void setFirstName(String firstName){
         this.firstName = firstName;
     }

     public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setPaymentMethod(PaymentMethod payBy, String details){
        this.payBy = payBy;
        if(payBy == PaymentMethod.MAIL)
            this.mailAddress = details;
        else
          if(payBy == PaymentMethod.DEPOSIT)
            this.accountDetails = details;    
    }

    public void updateNextPayAmount(double amount){
        this.nextPayAmount += amount;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public double getNextPayAmount() {
        return this.nextPayAmount;
    }

    public static void main(String[] args){
        Employee emp = new Employee();
        System.out.println(emp.firstName+" "+emp.lastName);
        System.out.println(emp.payBy+" "+emp.prevDayPay);
        System.out.println(emp.nextPayAmount+" "+emp.dateOfJoining);
    }
}

