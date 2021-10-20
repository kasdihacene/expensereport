package com.nelkinda.training;

public class OtherExpense extends Expense {

    public OtherExpense(ExpenseType type, int amount){
        this.type = type;
        this.amount = amount;
    }

    @Override
    public String computeMealOverExpensesMarker() {
        return NO_MARKER;
    }

    @Override
    boolean isMeal() {
        return false;
    }

}
