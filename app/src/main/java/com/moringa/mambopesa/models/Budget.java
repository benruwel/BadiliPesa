package com.moringa.mambopesa.models;

import java.util.List;

public class Budget {

    public int allocatedBudget;
    public int totalExpenses;
    public int balance;
    public List<Expense> expenseList;

    public Budget(){}

    public Budget(int allocatedBudget, int totalExpenses, int balance, List<Expense> expenseList) {
        this.allocatedBudget = allocatedBudget;
        this.totalExpenses = totalExpenses;
        this.balance = balance;
        this.expenseList = expenseList;
    }

    public int getAllocatedBudget() {
        return allocatedBudget;
    }

    public void setAllocatedBudget(int allocatedBudget) {
        this.allocatedBudget = allocatedBudget;
    }

    public int getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(int totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }

    public void setExpenseList(List<Expense> expenseList) {
        this.expenseList = expenseList;
    }
}
