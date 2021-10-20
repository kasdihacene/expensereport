package com.nelkinda.training;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

class MealExpenseReportTest {

    @Test
    void should_print_report_for_dinner_meal_not_exceeding_limit() {
        // Arrange
        final ByteArrayOutputStream outputStream = buildConsoleCapture();

        ExpenseReport expenseReport = new ExpenseReport();
        MealExpense mealExpense = new MealExpense(ExpenseType.DINNER, 4000);

        // Act
        List<Expense> expenses = List.of(mealExpense);
        Date date = new GregorianCalendar(2021, 2, 11).getTime();
        expenseReport.printReport(expenses, date);

        // Assert
        String[] consoleOutputs = outputStream.toString().split("\n");
        Assertions.assertEquals("Expenses Thu Mar 11 00:00:00 CET 2021", consoleOutputs[0]);
        Assertions.assertEquals(String.format("Dinner\t%d\t ", mealExpense.amount), consoleOutputs[1]);
        Assertions.assertEquals(String.format("Meal expenses: %d", mealExpense.amount), consoleOutputs[2]);
        Assertions.assertEquals(String.format("Total expenses: %d", mealExpense.amount), consoleOutputs[3]);

    }

    @Test
    void should_print_report_for_dinner_meal_over_expense() {
        // Arrange
        final ByteArrayOutputStream outputStream = buildConsoleCapture();

        ExpenseReport expenseReport = new ExpenseReport();
        Expense mealExpense = new MealExpense(ExpenseType.DINNER, 5001);

        // Act
        List<Expense> expenses = List.of(mealExpense);
        Date date = new GregorianCalendar(2021, 2, 11).getTime();
        expenseReport.printReport(expenses, date);

        // Assert
        String[] consoleOutputs = outputStream.toString().split("\n");
        Assertions.assertEquals("Expenses Thu Mar 11 00:00:00 CET 2021", consoleOutputs[0]);
        Assertions.assertEquals(String.format("Dinner\t%d\tX", mealExpense.amount), consoleOutputs[1]);
        Assertions.assertEquals(String.format("Meal expenses: %d", mealExpense.amount), consoleOutputs[2]);
        Assertions.assertEquals(String.format("Total expenses: %d", mealExpense.amount), consoleOutputs[3]);

    }

    @Test
    void should_print_report_for_dinner_meal_over_expense_and_breakfast() {
        // Arrange
        final ByteArrayOutputStream outputStream = buildConsoleCapture();

        ExpenseReport expenseReport = new ExpenseReport();
        Expense dinnerMealExpense = new MealExpense(ExpenseType.DINNER, 5001);
        Expense breakfastMealExpense = new MealExpense(ExpenseType.BREAKFAST,300);

        // Act
        List<Expense> expenses = new ArrayList<>();
        expenses.add(dinnerMealExpense);
        expenses.add(breakfastMealExpense);

        Date date = new GregorianCalendar(2021, 2, 11).getTime();
        expenseReport.printReport(expenses, date);

        // Assert
        String[] consoleOutputs = outputStream.toString().split("\n");
        Assertions.assertEquals("Expenses Thu Mar 11 00:00:00 CET 2021", consoleOutputs[0]);
        Assertions.assertEquals(String.format("Dinner\t%d\tX", dinnerMealExpense.amount), consoleOutputs[1]);
        Assertions.assertEquals(String.format("Breakfast\t%d\t ", breakfastMealExpense.amount), consoleOutputs[2]);
        Assertions.assertEquals(String.format("Meal expenses: %d", breakfastMealExpense.amount + dinnerMealExpense.amount), consoleOutputs[3]);
        Assertions.assertEquals(String.format("Total expenses: %d", dinnerMealExpense.amount + breakfastMealExpense.amount), consoleOutputs[4]);

    }

    @Test
    void should_print_report_for_dinner_meal_over_expense_and_rental_car() {
        // Arrange
        final ByteArrayOutputStream outputStream = buildConsoleCapture();

        ExpenseReport expenseReport = new ExpenseReport();
        MealExpense dinnerMealExpense = new MealExpense(ExpenseType.DINNER, 5001);
        Expense carRentMealExpense = new OtherExpense(ExpenseType.CAR_RENTAL,300);

        // Act
        List<Expense> expenses = new ArrayList<>();
        expenses.add(dinnerMealExpense);
        expenses.add(carRentMealExpense);

        Date date = new GregorianCalendar(2021, 2, 11).getTime();
        expenseReport.printReport(expenses, date);

        // Assert
        String[] consoleOutputs = outputStream.toString().split("\n");
        Assertions.assertEquals("Expenses Thu Mar 11 00:00:00 CET 2021", consoleOutputs[0]);
        Assertions.assertEquals(String.format("Dinner\t%d\tX", dinnerMealExpense.amount), consoleOutputs[1]);
        Assertions.assertEquals(String.format("Car Rental\t%d\t ", carRentMealExpense.amount), consoleOutputs[2]);
        Assertions.assertEquals(String.format("Meal expenses: %d", dinnerMealExpense.amount), consoleOutputs[3]);
        Assertions.assertEquals(String.format("Total expenses: %d", dinnerMealExpense.amount + carRentMealExpense.amount), consoleOutputs[4]);

    }

    private ByteArrayOutputStream buildConsoleCapture() {
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        return outputStream;
    }

}