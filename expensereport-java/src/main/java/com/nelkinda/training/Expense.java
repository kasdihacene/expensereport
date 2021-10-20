package com.nelkinda.training;

import static java.lang.System.out;

public abstract class Expense {
    protected static final String X_MARKER = "X";
    protected static final String NO_MARKER = " ";
    protected static final int DINNER_MAX_AMOUNT = 5000;
    protected static final int BREAKFAST_MAX_AMOUNT = 1000;

    protected ExpenseType type;
    protected int amount;

    abstract String computeMealOverExpensesMarker();

    abstract boolean isMeal();

    void print() {
        out.println(type.value() + "\t" + amount + "\t" + computeMealOverExpensesMarker());
    }
}
