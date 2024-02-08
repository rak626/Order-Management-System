package com.dev.inktown.model;

public enum OrderStatus {
    NEW(0),
    ASSIGNED(1),
    IN_PROGRESS(2),
    COMPLETED(3),
    DECLINED(4),
    REVIEWED(5),
    DELIVERED(6);

    private final int internalId;

    OrderStatus(int id) {
        this.internalId = id;
    }

    public int getInternalId() {
        return internalId;
    }
}
