package com.example.geoproyecto;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.geoproyecto.databinding.PasosLayoutBinding;

public class Pasos extends Fragment {

    private PasosLayoutBinding binding;

    private MediaPlayer mp;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = PasosLayoutBinding.inflate(inflater, container, false);
        return binding.getRoot();





    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int audioRawId = R.raw.sonidomultimierda;
        mp = MediaPlayer.create(requireContext(),audioRawId);


        ImageView logo1=view.findViewById(R.id.Logo1);
        logo1.setImageResource(R.drawable.teleee);

        ImageView logo2=view.findViewById(R.id.Logo2);
        logo2.setImageResource(R.drawable.teleee);

        ImageView flecha1=view.findViewById(R.id.Flecha1);
        flecha1.setImageResource(R.drawable.flecha);

        ImageView flecha2=view.findViewById(R.id.Flecha2);
        flecha2.setImageResource(R.drawable.flecha);



        Button boton=view.findViewById(R.id.botonPaso1);
        boton.setBackgroundColor(Color.parseColor("#FF0000"));
        Button boton2=view.findViewById(R.id.BotonPaso2);
        Button boton3=view.findViewById(R.id.BotonPaso3);

        boton.setOnClickListener(v -> {
            NavController navController= Navigation.findNavController(view);
            navController.navigate(R.id.action_pasos_to_navigation_home);
            mp.start();
        });

        boton2.setOnClickListener(v -> {
            NavController navController= Navigation.findNavController(view);
            navController.navigate(R.id.action_pasos_to_navigation_dashboard);
            mp.start();
        });

        boton3.setOnClickListener(v -> {
            NavController navController= Navigation.findNavController(view);
            navController.navigate(R.id.action_pasos_to_navigation_notifications);
            mp.start();
        });
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }




}
