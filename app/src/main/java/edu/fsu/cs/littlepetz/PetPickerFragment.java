package edu.fsu.cs.littlepetz;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

import java.io.File;
import java.net.URI;
import java.util.Objects;

public class PetPickerFragment extends Fragment {

    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction = null;
    Fragment newFragment;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.pet_picker, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        view.findViewById(R.id.bunny).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mFragmentTransaction = getFragmentManager().beginTransaction();

                Bundle bundle = new Bundle();
                HomeFragment fragobj = new HomeFragment();
                bundle.putString("petType", "bunny");
                fragobj.setArguments(bundle);
                mFragmentTransaction.setReorderingAllowed(true);
                mFragmentTransaction.addToBackStack(null);

                mFragmentTransaction.replace(R.id.nav_host_fragment, fragobj, "HomeFrag").commit();

            }
        });

        //do something else
    }

}