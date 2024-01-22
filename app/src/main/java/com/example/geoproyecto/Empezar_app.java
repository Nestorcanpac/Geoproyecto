package com.example.geoproyecto;

import static androidx.core.content.PermissionChecker.checkPermission;

import android.content.pm.PackageManager;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.geoproyecto.databinding.EmpezarAppBinding;
import com.example.geoproyecto.ui.home.SharedViewModel;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;




public class Empezar_app extends Fragment {

    private MediaPlayer mp;

    private EmpezarAppBinding binding;

    private SharedViewModel sharedViewModel;

    private ActivityResultLauncher<String[]> locationPermissionRequest;


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

        int audioRawId = R.raw.inicio;
        mp = MediaPlayer.create(requireContext(),audioRawId);
        mp.start();






        ImageView imageViewArriba=view.findViewById(R.id.ImagenEmpezar);
        imageViewArriba.setImageResource(R.drawable.teleee);


        Button boton=view.findViewById(R.id.Empezar);
        boton.setBackgroundColor(Color.parseColor("#FF0000"));

        boton.setOnClickListener(v -> {
            NavController navController= Navigation.findNavController(view);
            navController.navigate(R.id.action_empezar_app_to_pasos);
        });
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }





}
