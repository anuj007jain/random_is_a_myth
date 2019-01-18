package com.InterviewProblems;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class BlackRock_Bank_Accounts {

    private static final String TEXT =  "I am a {0} account with {1,number,#} units of {2} currency";

    static class BankAccount {

        AccountType accountType;
        String currency;
        int units;

        public String getCurrency() {
            return currency;
        }

        public int getUnits() {
            return units;
        }

        public AccountType getAccountType() {
            return accountType;
        }

        public void setAccountType(AccountType accountType) {
            this.accountType = accountType;
        }
    }

    static class AccountType {

        public AccountType(String name) {
            this.name = name;
        }

        String name;

        public String getName() {
            return name;
        }
    }

    static class SavingsAccount extends BankAccount {

        @Override
        public void setAccountType(AccountType accountType) {
            super.setAccountType(accountType);
        }

        public SavingsAccount(String currency, int units) {
            this.currency = currency;
            this.units = units;
            setAccountType(new AccountType("Savings"));
        }
    }

    static class CheckingAccount extends BankAccount {

        @Override
        public void setAccountType(AccountType accountType) {
            super.setAccountType(accountType);
        }

        public CheckingAccount(String currency, int units) {
            this.currency = currency;
            this.units = units;
            setAccountType(new AccountType("Checking"));
        }
    }

    static class BrokerageAccount extends BankAccount {

        @Override
        public void setAccountType(AccountType accountType) {
            super.setAccountType(accountType);
        }

        public BrokerageAccount(String currency, int units) {
            this.currency = currency;
            this.units = units;
            setAccountType(new AccountType("Brokerage"));
        }
    }

    public static void main(String args[] ) throws Exception {

        List<BankAccount> accounts = new ArrayList<BankAccount>();
        accounts.add(new SavingsAccount("USD",3));//Savings
        accounts.add(new SavingsAccount("EUR",2));//Savings
        accounts.add(new CheckingAccount("HUF",100));//Checking
        accounts.add(new CheckingAccount("COP",10000));//Checking
        accounts.add(new BrokerageAccount("GBP",2));//Brokerage
        accounts.add(new BrokerageAccount("INR",600));//Brokerage

        accounts.stream().forEach(
                account -> System.out.println(
                        MessageFormat.format(TEXT,
                                new Object[]{
                                        account.getAccountType().getName(),//make this work
                                        account.getUnits(),//make this work
                                        account.getCurrency()//make this work
                                })));
    }

}
