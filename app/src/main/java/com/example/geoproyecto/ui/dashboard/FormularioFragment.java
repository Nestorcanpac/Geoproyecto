package com.example.geoproyecto.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.geoproyecto.databinding.FragmentDashboardBinding;
import com.example.geoproyecto.databinding.LayoutIncidenciaBinding;
import com.example.geoproyecto.ui.home.Propina;
import com.example.geoproyecto.ui.home.SharedViewModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FormularioFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private FirebaseUser authUser;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        SharedViewModel sharedViewModel = new ViewModelProvider(
                requireActivity()
        ).get(SharedViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        sharedViewModel.getUser().observe(getViewLifecycleOwner(), user -> {
            authUser = user;

            if (user != null) {
                DatabaseReference base = FirebaseDatabase.getInstance( "https://geoproyecto-731d1-default-rtdb.europe-west1.firebasedatabase.app").getReference();

                DatabaseReference users = base.child("users");
                DatabaseReference uid = users.child(authUser.getUid());
                DatabaseReference incidencies = uid.child("propinametida");

                FirebaseRecyclerOptions<Propina> options = new FirebaseRecyclerOptions.Builder<Propina>()
                        .setQuery(incidencies, Propina.class)
                        .setLifecycleOwner(this)
                        .build();

                IncidenciaAdapter adapter = new IncidenciaAdapter(options);

                binding.rvIncidencies.setAdapter(adapter);
                binding.rvIncidencies.setLayoutManager(
                new LinearLayoutManager(requireContext())
                );


            }
        });

        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    class IncidenciaAdapter extends FirebaseRecyclerAdapter<Propina, IncidenciaAdapter.IncidenciaViewholder> {
        public IncidenciaAdapter(@NonNull FirebaseRecyclerOptions<Propina> options) {
            super(options);
        }

        @Override
        protected void onBindViewHolder(
        @NonNull IncidenciaViewholder holder, int position, @NonNull Propina model
            ) {
            holder.binding.propina.setText(model.getPropina());
            holder.binding.nombreTexto.setText(model.getNombre());
            holder.binding.txtAdreca.setText(model.getDireccio());
        }

        @NonNull
        @Override
        public IncidenciaViewholder onCreateViewHolder(
        @NonNull ViewGroup parent, int viewType
            ) {
            return new IncidenciaViewholder(LayoutIncidenciaBinding.inflate(
                    LayoutInflater.from(parent.getContext()),
                    parent, false));
        }

        class IncidenciaViewholder extends RecyclerView.ViewHolder {
            LayoutIncidenciaBinding binding;

            public IncidenciaViewholder(LayoutIncidenciaBinding binding) {
                super(binding.getRoot());
                this.binding = binding;
            }
        }
    }

}


