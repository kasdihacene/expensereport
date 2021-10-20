package com.nelkinda.training;

import java.util.Date;
import java.util.List;

public class ExpenseReport {
    public void printReport(List<Expense> expenses, Date date) {
        int total = 0;
        int mealExpenses = 0;

        System.out.println("Expenses " + date);

        for (Expense expense : expenses) {

            if (expense.type.isMeal()) {
                mealExpenses += expense.amount;
            }
            total += expense.amount;

            expense.print();
        }


        System.out.println("Meal expenses: " + mealExpenses);
        System.out.println("Total expenses: " + total);
    }

}
