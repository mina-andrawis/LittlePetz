package edu.fsu.cs.littlepetz;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

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
            String petName = bundle.getString("petName");
            //Log.d("bundleName",petName);

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

            //retrieve pet name from bundle and alter the textview in HomeFragment
            //TextView nameTextView = (TextView) getActivity().findViewById(R.id.nameText);
            //nameTextView.setText(petName);
        }
        return v;

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }



}