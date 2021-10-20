package com.nelkinda.training;

import java.util.Date;
import java.util.List;

public class ExpenseReport {
    public void printReport(List<Expense> expenses, Date date) {
        int total = 0;
        int mealExpenses = 0;

        System.out.println("Expenses " + date);

        for (Expense mealExpense : expenses) {

            if (mealExpense.isMeal()) {
                mealExpenses += mealExpense.amount;
            }
            total += mealExpense.amount;

            mealExpense.print();
        }


        System.out.println("Meal expenses: " + mealExpenses);
        System.out.println("Total expenses: " + total);
    }

}
