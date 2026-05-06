package com.example.campushub;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LostFoundActivity extends AppCompatActivity {
    DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_found);

        db = FirebaseDatabase.getInstance().getReference("CampusReports");
        FloatingActionButton fab = findViewById(R.id.fabAdd);
        fab.setOnClickListener(v -> showPostDialog());
    }

    private void showPostDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_add_lost_item, null);
        builder.setView(dialogView);

        EditText etName = dialogView.findViewById(R.id.etItemName);
        EditText etLoc = dialogView.findViewById(R.id.etLocation);
        EditText etDesc = dialogView.findViewById(R.id.etDescription);
        Button btnSubmit = dialogView.findViewById(R.id.btnSubmit);

        AlertDialog dialog = builder.create();

        btnSubmit.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            String loc = etLoc.getText().toString().trim();
            String desc = etDesc.getText().toString().trim();

            if (name.isEmpty() || loc.isEmpty()) {
                Toast.makeText(this, "Fields cannot be empty!", Toast.LENGTH_SHORT).show();
                return;
            }

            String id = db.push().getKey();
            // Status is set to "Complaint Filed" here
            ItemModel report = new ItemModel(name, loc, desc, "Complaint Filed", "Check with Office");

            if (id != null) {
                db.child(id).setValue(report).addOnSuccessListener(aVoid -> {
                    Toast.makeText(this, "Complaint Registered Successfully!", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                });
            }
        });
        dialog.show();
    }
}