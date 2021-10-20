package com.nelkinda.training;

enum ExpenseType {

    DINNER("Dinner", 5000, true) {
        @Override
        String exceedLimit(int amount) {
            return amount > 5000 ? X_MARKER : NO_MARKER;
        }
    },
    BREAKFAST("Breakfast", 1000, true) {
        @Override
        String exceedLimit(int amount) {
            return amount > 1000 ? X_MARKER : NO_MARKER;
        }
    },
    CAR_RENTAL("Car Rental", 0, false) {
        @Override
        String exceedLimit(int amount) {
            return NO_MARKER;
        }
    };

    private final String value;
    private final int amountLimit;
    private final boolean isMeal;
    private static final String X_MARKER = "X";
    private static final String NO_MARKER = " ";

    ExpenseType(String value, int amountLimit, boolean isMeal) {
        this.value = value;
        this.amountLimit = amountLimit;
        this.isMeal = isMeal;
    }

    String value() {
        return value;
    }

    boolean isMeal() {
        return isMeal;
    }


    abstract String exceedLimit(int amount);

}
