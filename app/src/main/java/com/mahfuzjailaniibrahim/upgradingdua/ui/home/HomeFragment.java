package com.mahfuzjailaniibrahim.upgradingdua.ui.home;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mahfuzjailaniibrahim.upgradingdua.R;
import com.mahfuzjailaniibrahim.upgradingdua.models.Assistant;

public class HomeFragment extends Fragment {

    private HomeViewModel mViewModel;
    RecyclerView rvHome;
    FloatingActionButton fabHome;
    FirebaseRecyclerAdapter adapter;


    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvHome = view.findViewById(R.id.rv_home);
        fabHome = view.findViewById(R.id.fab_home);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        // TODO: Use the ViewModel


        fabHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.setAssistant(new Assistant("Ibrahim", "LEA", "LEA.II.007"));
            }
        });

        FirebaseRecyclerOptions options = mViewModel.getAssistants();

        adapter = new FirebaseRecyclerAdapter<Assistant, AssistantHolder>(options){
            @NonNull
            @Override
            public AssistantHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.home_item, parent, false);

                return new AssistantHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull AssistantHolder holder, int position, @NonNull Assistant model) {
                holder.tvName.setText(model.getName());
                holder.tvAddress.setText(model.getAddress());
                holder.tvNoAssistant.setText(model.getNoAssistant());
            }
        };
        adapter.notifyDataSetChanged();
        rvHome.setLayoutManager(new LinearLayoutManager(getContext()));
        rvHome.setAdapter(adapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    class AssistantHolder extends RecyclerView.ViewHolder{

        TextView tvName, tvAddress, tvNoAssistant;

        public AssistantHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvAddress = itemView.findViewById(R.id.tv_address);
            tvNoAssistant = itemView.findViewById(R.id.tv_no_assistant);
        }
    }

}
