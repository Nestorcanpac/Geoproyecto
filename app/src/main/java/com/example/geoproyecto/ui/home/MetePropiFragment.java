package com.example.geoproyecto.ui.home;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.geoproyecto.R;
import com.example.geoproyecto.databinding.FragmentHomeBinding;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MetePropiFragment extends Fragment {
    private MediaPlayer mp;
    private FragmentHomeBinding binding;
    private FirebaseUser authUser;




    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MetePropinaViewModel metePropinaViewModel = new ViewModelProvider(this).get(MetePropinaViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        SharedViewModel sharedViewModel = new ViewModelProvider(getActivity()).get(SharedViewModel.class);

        SharedViewModel.getCurrentAddress().observe(getViewLifecycleOwner(), address -> {



            binding.txtDireccio.setText(String.format(
                    "Direccion: %1$s",
                    address, System.currentTimeMillis()
            ));
        });


        int audioRawId = R.raw.monedasonido;





        sharedViewModel.getUser().observe(getViewLifecycleOwner(), user -> {
            authUser = user;
        });

        mp = MediaPlayer.create(requireContext(),audioRawId);

        binding.SubePropi.setOnClickListener(button -> {

            com.example.geoproyecto.ui.home.Propina propina= new com.example.geoproyecto.ui.home.Propina();
            Propina propina1 = new Propina();
            propina1.setDireccio(binding.txtDireccio.getText().toString());
            propina1.setNombre(binding.nombreTexto.getText().toString());
            propina1.setPropina(binding.propiintro.getText().toString()+"€");


            DatabaseReference base = FirebaseDatabase.getInstance(
                    "https://geoproyecto-731d1-default-rtdb.europe-west1.firebasedatabase.app"
            ).getReference();

            DatabaseReference users = base.child("users");
            DatabaseReference uid = users.child(authUser.getUid());
            DatabaseReference propinametida = uid.child("propinametida");

            DatabaseReference reference = propinametida.push();
            reference.setValue(propina1);
            mp.start();


        });



        return root;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        Button botontal=view.findViewById(R.id.SubePropi);
        botontal.setBackgroundColor(Color.parseColor("#FF0000"));







    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}





