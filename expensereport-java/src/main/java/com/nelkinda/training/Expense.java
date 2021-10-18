package com.nelkinda.training;

class Expense {
    private static final String X_MARKER = "X";
    private static final String NO_MARKER = " ";
    private static final int DINNER_MAX_AMOUNT = 5000;
    private static final int BREAKFAST_MAX_AMOUNT = 1000;

    ExpenseType type;
    int amount;

    public String computeMealOverExpensesMarker() {
        return this.type ==
                ExpenseType.DINNER && this.amount > DINNER_MAX_AMOUNT ||
                this.type == ExpenseType.BREAKFAST && this.amount > BREAKFAST_MAX_AMOUNT ?
                X_MARKER :
                NO_MARKER;
    }
}
