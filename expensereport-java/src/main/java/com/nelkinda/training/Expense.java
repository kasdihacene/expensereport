package com.nelkinda.training;

class Expense {
    ExpenseType type;
    int amount;

    public String computeMealOverExpensesMarker() {
        return this.type == ExpenseType.DINNER && this.amount > 5000
                || this.type == ExpenseType.BREAKFAST && this.amount > 1000 ?
                "X" :
                " ";
    }
}
