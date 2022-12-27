package com.example.testseatreservation;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String BOOKED_COLOR = "#FF0000";

    private EditText row, col;
    private Button btn1;

    private Button[][] seatViews = new Button[5][5];

    private static final int[][] boardIds =
            {{R.id.seat11, R.id.seat12, R.id.seat13, R.id.seat14, R.id.seat15},
                    {R.id.seat21, R.id.seat22, R.id.seat23, R.id.seat24, R.id.seat25},
                    {R.id.seat31, R.id.seat32, R.id.seat33, R.id.seat34, R.id.seat35},
                    {R.id.seat41, R.id.seat42, R.id.seat43, R.id.seat44, R.id.seat45},
                    {R.id.seat51, R.id.seat52, R.id.seat53, R.id.seat54, R.id.seat55}};

    private final Board board = new Board();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        row = findViewById(R.id.row);
        col = findViewById(R.id.col);
        btn1 = findViewById(R.id.button);

        for (int i = 0; i < boardIds.length; i++) {
            for (int j = 0; j < boardIds[i].length; j++) {
                seatViews[i][j] = findViewById(boardIds[i][j]);
            }
        }

        board.createSeats(boardIds);
        updateSeats();

        btn1.setOnClickListener(v -> bookSeat());
    }

    private void bookSeat() {
        BookResult bookResult = board.bookSeat(col.getText().toString(), row.getText().toString());
        if (!bookResult.isSuccess()) {
            Toast.makeText(this, bookResult.getMessage(), Toast.LENGTH_SHORT).show();
            return;
        }

        updateSeats();
    }

    private void updateSeats() {
        Seat[][] seats = board.getSeats();
        for (Seat[] seat : seats) {
            for (Seat value : seat) {
                Log.d(String.valueOf(value), "seat");
                Button seatView = seatViews[value.getyPos()][value.getxPos()];
                //seatView.setText(value.getLabel());
                if (value.isBooked()) {
                    seatView.setBackgroundColor(Color.parseColor(BOOKED_COLOR));
                    seatView.setText("X");
                }
            }
        }
    }

}