package com.nelkinda.training;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

class ExpenseReportTest {

    @Test
    void should_print_report_for_dinner_meal_not_exceeding_limit() {
        // Arrange
        final ByteArrayOutputStream outputStream = buildConsoleCapture();

        ExpenseReport expenseReport = new ExpenseReport();
        Expense expense = new Expense();
        expense.amount = 4000;
        expense.type = ExpenseType.DINNER;

        // Act
        List<Expense> expenses = List.of(expense);
        Date date = new GregorianCalendar(2021, 2, 11).getTime();
        expenseReport.printReport(expenses, date);

        // Assert
        String[] consoleOutputs = outputStream.toString().split("\n");
        Assertions.assertEquals("Expenses Thu Mar 11 00:00:00 CET 2021", consoleOutputs[0]);
        Assertions.assertEquals(String.format("Dinner\t%d\t ", expense.amount), consoleOutputs[1]);
        Assertions.assertEquals(String.format("Meal expenses: %d", expense.amount), consoleOutputs[2]);
        Assertions.assertEquals(String.format("Total expenses: %d", expense.amount), consoleOutputs[3]);

    }

    @Test
    void should_print_report_for_dinner_meal_over_expense() {
        // Arrange
        final ByteArrayOutputStream outputStream = buildConsoleCapture();

        ExpenseReport expenseReport = new ExpenseReport();
        Expense expense = new Expense();
        expense.amount = 5001;
        expense.type = ExpenseType.DINNER;

        // Act
        List<Expense> expenses = List.of(expense);
        Date date = new GregorianCalendar(2021, 2, 11).getTime();
        expenseReport.printReport(expenses, date);

        // Assert
        String[] consoleOutputs = outputStream.toString().split("\n");
        Assertions.assertEquals("Expenses Thu Mar 11 00:00:00 CET 2021", consoleOutputs[0]);
        Assertions.assertEquals(String.format("Dinner\t%d\tX", expense.amount), consoleOutputs[1]);
        Assertions.assertEquals(String.format("Meal expenses: %d", expense.amount), consoleOutputs[2]);
        Assertions.assertEquals(String.format("Total expenses: %d", expense.amount), consoleOutputs[3]);

    }

    @Test
    void should_print_report_for_dinner_meal_over_expense_and_breakfast() {
        // Arrange
        final ByteArrayOutputStream outputStream = buildConsoleCapture();

        ExpenseReport expenseReport = new ExpenseReport();
        Expense dinnerExpense = new Expense();
        dinnerExpense.amount = 5001;
        dinnerExpense.type = ExpenseType.DINNER;

        Expense breakfastExpense = new Expense();
        breakfastExpense.amount = 300;
        breakfastExpense.type = ExpenseType.BREAKFAST;

        // Act
        List<Expense> expenses = new ArrayList<>();
        expenses.add(dinnerExpense);
        expenses.add(breakfastExpense);

        Date date = new GregorianCalendar(2021, 2, 11).getTime();
        expenseReport.printReport(expenses, date);

        // Assert
        String[] consoleOutputs = outputStream.toString().split("\n");
        Assertions.assertEquals("Expenses Thu Mar 11 00:00:00 CET 2021", consoleOutputs[0]);
        Assertions.assertEquals(String.format("Dinner\t%d\tX", dinnerExpense.amount), consoleOutputs[1]);
        Assertions.assertEquals(String.format("Breakfast\t%d\t ", breakfastExpense.amount), consoleOutputs[2]);
        Assertions.assertEquals(String.format("Meal expenses: %d", breakfastExpense.amount + dinnerExpense.amount), consoleOutputs[3]);
        Assertions.assertEquals(String.format("Total expenses: %d", dinnerExpense.amount + breakfastExpense.amount), consoleOutputs[4]);

    }

    @Test
    void should_print_report_for_dinner_meal_over_expense_and_rental_car() {
        // Arrange
        final ByteArrayOutputStream outputStream = buildConsoleCapture();

        ExpenseReport expenseReport = new ExpenseReport();
        Expense dinnerExpense = new Expense();
        dinnerExpense.amount = 5001;
        dinnerExpense.type = ExpenseType.DINNER;

        Expense carRentExpense = new Expense();
        carRentExpense.amount = 300;
        carRentExpense.type = ExpenseType.CAR_RENTAL;

        // Act
        List<Expense> expenses = new ArrayList<>();
        expenses.add(dinnerExpense);
        expenses.add(carRentExpense);

        Date date = new GregorianCalendar(2021, 2, 11).getTime();
        expenseReport.printReport(expenses, date);

        // Assert
        String[] consoleOutputs = outputStream.toString().split("\n");
        Assertions.assertEquals("Expenses Thu Mar 11 00:00:00 CET 2021", consoleOutputs[0]);
        Assertions.assertEquals(String.format("Dinner\t%d\tX", dinnerExpense.amount), consoleOutputs[1]);
        Assertions.assertEquals(String.format("Car Rental\t%d\t ", carRentExpense.amount), consoleOutputs[2]);
        Assertions.assertEquals(String.format("Meal expenses: %d", dinnerExpense.amount), consoleOutputs[3]);
        Assertions.assertEquals(String.format("Total expenses: %d", dinnerExpense.amount + carRentExpense.amount), consoleOutputs[4]);

    }

    private ByteArrayOutputStream buildConsoleCapture() {
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        return outputStream;
    }

}