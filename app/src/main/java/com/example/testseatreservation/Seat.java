package com.example.testseatreservation;

public class Seat {
    private final int id;
    private final String label;
    private boolean booked;
    private int xPos;
    private int yPos;

    public Seat(int id, String label, int xPos, int yPos) {
        this.id = id;
        this.label = label;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", booked=" + booked +
                ", xPos=" + xPos +
                ", yPos=" + yPos +
                '}';
    }
}
