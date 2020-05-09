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

     private float weeklyDues;

     private float nextPayAmount;
     private float prevPayAmount;
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

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public static void main(String[] args){
        Employee emp = new Employee();
        System.out.println(emp.firstName+" "+emp.lastName);
        System.out.println(emp.payBy+" "+emp.prevDayPay);
        System.out.println(emp.nextPayAmount+" "+emp.dateOfJoining);
    }
}

