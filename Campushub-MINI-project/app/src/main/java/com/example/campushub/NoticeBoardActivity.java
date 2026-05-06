package com.example.campushub;

import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class NoticeBoardActivity extends AppCompatActivity {
    RecyclerView rv;
    FacultyAdapter adapter;
    List<Faculty> noticeList;
    DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_board);

        rv = findViewById(R.id.rvNoticeBoard);
        rv.setLayoutManager(new LinearLayoutManager(this));
        noticeList = new ArrayList<>();
        adapter = new FacultyAdapter(noticeList);
        rv.setAdapter(adapter);

        // MATCH THIS NAME TO YOUR LOSTFOUNDACTIVITY
        db = FirebaseDatabase.getInstance().getReference("CampusReports");

        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    noticeList.clear();
                    for (DataSnapshot data : snapshot.getChildren()) {
                        ItemModel item = data.getValue(ItemModel.class);
                        if (item != null) {
                            noticeList.add(new Faculty(item.itemName, "Status: " + item.status, "Location: " + item.location));
                        }
                    }
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(NoticeBoardActivity.this, "No reports found in DB", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // This will trigger if your RULES are wrong
                Toast.makeText(NoticeBoardActivity.this, "Database Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}