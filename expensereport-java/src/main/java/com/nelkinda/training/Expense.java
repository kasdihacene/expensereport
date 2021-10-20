package com.nelkinda.training;


import static java.lang.System.out;

class Expense {

    ExpenseType type;
    int amount;

    public Expense(ExpenseType type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    void print() {
        out.println(type.value() + "\t" + amount + "\t" + type.exceedLimit(amount));
    }
}
