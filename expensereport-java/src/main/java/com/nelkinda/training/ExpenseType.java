package com.nelkinda.training;

enum ExpenseType {
    DINNER("Dinner"),
    BREAKFAST("Breakfast"),
    CAR_RENTAL("Car Rental");

    private final String value;

    ExpenseType(String value) {
        this.value = value;
    }

    String value(){
        return value;
    }
}
