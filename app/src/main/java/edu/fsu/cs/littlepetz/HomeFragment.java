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

        if(null!=bundle) {
            String petType = bundle.getString("petType");

            switch (petType){
                case ("bunny"):
                imageView.setImageResource(R.drawable.bunny);
                break;

                case ("bird"):
                    imageView.setImageResource(R.drawable.bird);
                    break;

                case ("cat"):
                    imageView.setImageResource(R.drawable.cat);
                    break;

                case ("dog"):
                    imageView.setImageResource(R.drawable.dog);
                    break;

                case ("fish"):
                    imageView.setImageResource(R.drawable.fish);
                    break;

            }

        }
        return v;

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }



}