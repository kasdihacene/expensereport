package com.nelkinda.training;


class MealExpense extends Expense {

    @Override
    public String computeMealOverExpensesMarker() {
        return this.type ==
                ExpenseType.DINNER && this.amount > DINNER_MAX_AMOUNT ||
                this.type == ExpenseType.BREAKFAST && this.amount > BREAKFAST_MAX_AMOUNT ?
                X_MARKER :
                NO_MARKER;
    }

    @Override
    public boolean isMeal() {
        return true;
    }
}
