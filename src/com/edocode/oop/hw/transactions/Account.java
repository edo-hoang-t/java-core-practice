package com.edocode.oop.hw.transactions;

import java.util.Arrays;

public class Account {
    private int id;
    private Transaction[] transactions;
    private int curArrayId;

    {
        this.curArrayId = 0;
        this.transactions = new Transaction[10];
    }

    public Account(int id) {
        this.id = id;
    }

    private class Transaction {
        private Account accountFrom;
        private Account accountTo;
        private double moneyAmount;
        private StandardAccountOperations operation;

        public Transaction(Account accountFrom, Account accountTo, double moneyAmount, StandardAccountOperations operation) {
            this.accountFrom = accountFrom;
            this.accountTo = accountTo;
            this.moneyAmount = moneyAmount;
            this.operation = operation;
        }

        public Account getAccountFrom() {
            return accountFrom;
        }

        public Account getAccountTo() {
            return accountTo;
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "accountFrom=" + accountFrom +
                    ", accountTo=" + accountTo +
                    ", moneyAmount=" + moneyAmount +
                    ", operation=" + operation +
                    '}';
        }
    }

    private void addTransaction(Transaction transaction) {
        if (transaction == null) return;
        if (this.curArrayId >= this.transactions.length)
            this.transactions = Arrays.copyOf(this.transactions, this.transactions.length << 1);
        this.transactions[this.curArrayId++] = transaction;
    }

    private void receiveMoneyFromAccount(Account accountFrom, double moneyAmount) {
        Transaction receiveTrans = new Transaction(accountFrom, this, moneyAmount, StandardAccountOperations.MONEY_TRANSFER_RECEIVE);
        addTransaction(receiveTrans);
    }

    public void sendMoneyToAccount(Account accountTo, double moneyAmount) {
        Transaction sendTrans = new Transaction(this, accountTo, moneyAmount, StandardAccountOperations.MONEY_TRANSFER_SEND);
        addTransaction(sendTrans);

        accountTo.receiveMoneyFromAccount(this, moneyAmount);
    }

    public void withdrawMoney(double moneyAmount) {
        Transaction trans = new Transaction(this, null, moneyAmount, StandardAccountOperations.WITHDRAW);
        addTransaction(trans);
    }

    public Transaction[] getTransactions() {
        return Arrays.copyOf(this.transactions, this.curArrayId);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                '}';
    }
}
