package com.example.testseatreservation;

import android.util.Log;

import java.util.Objects;

public class Board {
    private Seat[][] seats;

    public void createSeats(int[][] boardIds) {
        int colCount = boardIds.length;
        int rowCount = boardIds[0].length;
        seats = new Seat[colCount][rowCount];
        for (int i = 0; i < colCount; i++) {
            for (int j = 0; j < rowCount; j++) {
                int seatId = boardIds[i][j];
                String label = "" + ((i % rowCount) * rowCount + j + 1);
                Log.d(String.valueOf(label), "label");
                seats[i][j] = new Seat(seatId, label, i, j);
            }
        }
    }

    public Seat[][] getSeats() {
        return seats;
    }

    public BookResult bookSeat(String colText, String rowText) {
        BookResult validationResult = validate(colText, rowText);
        if (!validationResult.isSuccess()) return validationResult;

        Seat seat = validationResult.getSeat();
        seat.setBooked(true);

        return BookResult.success(seat);
    }

    private BookResult validate(String colText, String rowText) {
        Integer colNo = strToInt(colText);
        Integer rowNo = strToInt(rowText);

        if (colNo == null || rowNo == null) {
            return BookResult.error("잘못된 입력입니다. 다시 입력하세요.");
        }

        if ((colNo > 5 || colNo < 1) || (rowNo > 5 || rowNo < 1)) {
            return BookResult.error("잘못된 입력입니다. 다시 입력하세요.");
        }

        Seat seat = Objects.requireNonNull(seats[colNo - 1][rowNo - 1]);
        if (seat.isBooked()) {
            return BookResult.error("예약이 완료된 자리입니다. 다시 예약하세요.");
        }

        return BookResult.success(seat);
    }

    private Integer strToInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
