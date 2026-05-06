package com.example.campushub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    // 1. Declare variables
    CardView cardLostFound, cardFaculty, cardNoticeBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2. Initialize variables (MATCH THESE WITH XML IDs)
        cardLostFound = findViewById(R.id.cardLostFound);
        cardFaculty = findViewById(R.id.cardFaculty);
        cardNoticeBoard = findViewById(R.id.cardNoticeBoard);

        // 3. Set Click Listeners
        if (cardLostFound != null) {
            cardLostFound.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, LostFoundActivity.class);
                startActivity(intent);
            });
        }

        if (cardFaculty != null) {
            cardFaculty.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, FacultyActivity.class);
                startActivity(intent);
            });
        }

        if (cardNoticeBoard != null) {
            cardNoticeBoard.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, NoticeBoardActivity.class);
                startActivity(intent);
            });
        }
    }
}