package com.example.campushub;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class FacultyAdapter extends RecyclerView.Adapter<FacultyAdapter.FacultyViewHolder> {

    private List<Faculty> facultyList;

    public FacultyAdapter(List<Faculty> facultyList) {
        this.facultyList = facultyList;
    }

    @NonNull
    @Override
    public FacultyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_faculty, parent, false);
        return new FacultyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FacultyViewHolder holder, int position) {
        Faculty faculty = facultyList.get(position);

        // Setting the text from the Faculty object
        holder.name.setText(faculty.getName());
        holder.cabin.setText(faculty.getCabin());
        holder.email.setText(faculty.getEmail());

        // Logic for the CALL button (Connects to College Office)
        holder.btnCall.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            // Defaulting to a placeholder for DYPCET office; change to actual if needed
            intent.setData(Uri.parse("tel:919876543210"));
            v.getContext().startActivity(intent);
        });

        // Logic for the MESSAGE (WhatsApp) button
        holder.btnMsg.setOnClickListener(v -> {
            String phoneNumber = "919876543210";
            String message = "Hello, I am a student contacting regarding: " + faculty.getName();
            String url = "https://api.whatsapp.com/send?phone=" + phoneNumber + "&text=" + Uri.encode(message);

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return facultyList.size();
    }

    public static class FacultyViewHolder extends RecyclerView.ViewHolder {
        TextView name, cabin, email;
        Button btnCall, btnMsg;

        public FacultyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txtFacultyName);
            cabin = itemView.findViewById(R.id.txtFacultyCabin);
            email = itemView.findViewById(R.id.txtFacultyEmail);
            btnCall = itemView.findViewById(R.id.btnCall);
            btnMsg = itemView.findViewById(R.id.btnMsg);
        }
    }
}