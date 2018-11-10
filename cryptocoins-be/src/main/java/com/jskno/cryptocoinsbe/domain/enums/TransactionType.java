package com.jskno.cryptocoinsbe.domain.enums;

public enum TransactionType {

    PURCHASE(1, "Purchase Operation"),
    SALE(2, "Sale Operation");

    private int operationId;
    private String description;

    TransactionType(int operationId, String description) {
        this.operationId = operationId;
        this.description = description;
    }

    public int getOperationId() {
        return operationId;
    }

    public String getDescription() {
        return description;
    }
}
