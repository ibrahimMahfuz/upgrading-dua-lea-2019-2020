package com.mahfuzjailaniibrahim.upgradingdua.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.mahfuzjailaniibrahim.upgradingdua.R;
import com.mahfuzjailaniibrahim.upgradingdua.models.Assistant;

public class HomeViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    FirebaseRecyclerAdapter adapter;

    public void setAssistant(Assistant assistant){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("assistant");

        myRef.push().setValue(assistant);
    }

    FirebaseRecyclerOptions getAssistants(){
        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("assistant")
                .limitToLast(50);

        FirebaseRecyclerOptions<Assistant> options =
                new FirebaseRecyclerOptions.Builder<Assistant>()
                        .setQuery(query, Assistant.class)
                        .build();

        return options;
    }

}
