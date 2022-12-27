package com.example.testseatreservation;

public class BookResult {
    private final boolean success;
    private final String message;
    private Seat seat;

    private BookResult(boolean success, String message, Seat seat) {
        this.success = success;
        this.message = message;
        this.seat = seat;
    }

    public static BookResult success(Seat seat) {
        return new BookResult(true, null, seat);
    }

    public static BookResult error(String message) {
        return new BookResult(false, message, null);
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public Seat getSeat() {
        return seat;
    }
}
