package com.nelkinda.training;

import static java.lang.System.out;

public abstract class Expense {
    protected static final String X_MARKER = "X";
    protected static final String NO_MARKER = " ";

    protected ExpenseType type;
    protected int amount;

    abstract String computeMealOverExpensesMarker();

    void print() {
        out.println(type.value() + "\t" + amount + "\t" + computeMealOverExpensesMarker());
    }
}
