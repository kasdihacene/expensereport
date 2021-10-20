package com.nelkinda.training;


class MealExpense extends Expense {

    public MealExpense(ExpenseType type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    @Override
    public String computeMealOverExpensesMarker() {
        return
                this.type.exceedLimit(amount) ?
                        X_MARKER :
                        NO_MARKER;
    }

    @Override
    public boolean isMeal() {
        return true;
    }
}
