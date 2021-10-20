package com.nelkinda.training;

public class OtherExpense extends Expense {
    
    @Override
    public String computeMealOverExpensesMarker() {
        return NO_MARKER;
    }

    @Override
    boolean isMeal() {
        return false;
    }

}
