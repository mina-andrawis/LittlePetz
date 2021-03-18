package edu.fsu.cs.littlepetz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.Objects;

public class HomeFragment extends Fragment {

    ImageView imageView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.home_fragment, container, false);

        //create imageview object
        imageView = (ImageView) v.findViewById(R.id.petImage);

        Bundle bundle = getArguments();
        getActivity().setContentView(R.layout.home_fragment);


        if(null!=bundle) {
            String petType = bundle.getString("petType");

            if (petType.equals("bunny"))
            {
                imageView.setImageResource(R.drawable.bunny);               // ******** ERROR HERE **** //
                Log.i("imageview", String.valueOf(imageView.getDrawable()));
            }

        }
        return v;

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }



}