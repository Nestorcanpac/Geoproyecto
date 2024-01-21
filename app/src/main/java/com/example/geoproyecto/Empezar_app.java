package com.example.geoproyecto;

import android.graphics.Color;
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

import com.example.geoproyecto.databinding.EmpezarAppBinding;

public class Empezar_app extends Fragment {

    private EmpezarAppBinding binding;



    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = EmpezarAppBinding.inflate(inflater, container, false);
        return binding.getRoot();





    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        ImageView imageViewArriba=view.findViewById(R.id.ImagenEmpezar);
        imageViewArriba.setImageResource(R.drawable.teleee);


        Button boton=view.findViewById(R.id.Empezar);
        boton.setBackgroundColor(Color.parseColor("#FF0000"));

        boton.setOnClickListener(v -> {
            NavController navController= Navigation.findNavController(view);
            navController.navigate(R.id.action_empezar_app_to_navigation_home);
        });
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }




}
