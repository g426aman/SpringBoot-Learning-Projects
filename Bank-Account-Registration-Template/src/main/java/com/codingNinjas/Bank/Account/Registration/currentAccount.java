package com.codingNinjas.Bank.Account.Registration;

/**

  This class is an implementation of a "Account" Interface based on the selection 
  done in the console for account type .You need to complete this class
  based on the following tasks.

     Tasks:
   a. Create attribute amount(double) 
   b. Override the methods of Account Interface.
   c. Build the logic for all the methods based on the description mentioned in the Account Interface.

**/

public class currentAccount implements Account {
    //create attribute amount (double)
    double balance;

    public void setBalance(double balance) {
        this.balance = balance;
    }





    @Override
    public String getAccountType() {

        //return "Current" for this account type
        return "Current ";
    }

    @Override
    public void addBalance(double balance) {
        //Add the given balance to the current amount
         this.balance += balance;

    }
    @Override
    public double getBalance(){

        // return the current balance stored in amount
        return this.balance;
    }

}
