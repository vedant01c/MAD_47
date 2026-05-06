package com.example.campushub;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class FacultyActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);

        RecyclerView rv = findViewById(R.id.recyclerViewFaculty);
        rv.setLayoutManager(new LinearLayoutManager(this));

        List<Faculty> list = new ArrayList<>();
        list.add(new Faculty("Kishor Mane", "HOD Office", "kmane@dypcet.ac.in"));
        list.add(new Faculty("Shobha Patil", "CSE Dept - Cabin 1", "spatil@dypcet.ac.in"));
        list.add(new Faculty("Sharayu Patil", "CSE Dept - Cabin 2", "sharayu.p@dypcet.ac.in"));
        list.add(new Faculty("AmolKumar Jadhav", "CSE Dept - Cabin 3", "ajadhav@dypcet.ac.in"));
        list.add(new Faculty("Vishal Mangave", "IT Dept - Cabin 1", "vmangave@dypcet.ac.in"));
        list.add(new Faculty("Santosh Kore", "IT Dept - Cabin 2", "skore@dypcet.ac.in"));

        rv.setAdapter(new FacultyAdapter(list));
    }
}