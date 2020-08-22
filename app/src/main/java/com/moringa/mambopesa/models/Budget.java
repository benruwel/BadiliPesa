package com.moringa.mambopesa.models;

import java.util.List;

public class Budget {

    public Double allocatedBudget;
    public Double totalExpenses;
    public Double balance;
    public List<Expense> expenseList;

    public Budget(){}

    public Budget(Double allocatedBudget, Double totalExpenses, Double balance, List<Expense> expenseList) {
        this.allocatedBudget = allocatedBudget;
        this.totalExpenses = totalExpenses;
        this.balance = balance;
        this.expenseList = expenseList;
    }

    public Double getAllocatedBudget() {
        return allocatedBudget;
    }

    public void setAllocatedBudget(Double allocatedBudget) {
        this.allocatedBudget = allocatedBudget;
    }

    public Double getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(Double totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }

    public void setExpenseList(List<Expense> expenseList) {
        this.expenseList = expenseList;
    }
}
