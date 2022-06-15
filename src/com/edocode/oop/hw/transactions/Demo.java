package com.edocode.oop.hw.transactions;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        Account accountFrom = new Account(1);
        Account accountTo = new Account(2);

        accountFrom.sendMoneyToAccount(accountTo, 500);
        accountTo.withdrawMoney(300);

        System.out.println(Arrays.toString(accountFrom.getTransactions()));
        System.out.println(Arrays.toString(accountTo.getTransactions()));
    }
}
