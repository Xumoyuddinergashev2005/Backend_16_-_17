package org.example.backend_16.model;

public enum Status {
    IN_PROGRESS,
    COMPLETED,
    TODO;



    public static Status fromString(String value) {
        for (Status status : Status.values()) {
            if (status.name().equals(value)){
                return status;
            }
        }
        throw new RuntimeException("No enum constant " + value);
    }
}
