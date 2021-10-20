package com.nelkinda.training;

enum ExpenseType {

    DINNER("Dinner", 5000, true) {
        @Override
        boolean exceedLimit(int amount) {
            return amount > 5000;
        }
    },
    BREAKFAST("Breakfast", 1000, true) {
        @Override
        boolean exceedLimit(int amount) {
            return amount > 1000;
        }
    },
    CAR_RENTAL("Car Rental", 0, false) {
        @Override
        boolean exceedLimit(int amount) {
            return false;
        }
    };

    private final String value;
    private final int amountLimit;
    private final boolean isMeal;

    ExpenseType(String value, int amountLimit, boolean isMeal) {
        this.value = value;
        this.amountLimit = amountLimit;
        this.isMeal = isMeal;
    }

    String value() {
        return value;
    }


    abstract boolean exceedLimit(int amount);
}
