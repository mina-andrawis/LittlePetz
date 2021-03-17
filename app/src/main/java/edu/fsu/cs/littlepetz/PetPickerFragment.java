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

                Fragment frag = getFragmentManager().findFragmentByTag(MainActivity.IMAGE_FRAGMENT_TAG);

                mFragmentTransaction = getFragmentManager().beginTransaction();
                Fragment newFragment = new HomeFragment();


                Bundle bundle = new Bundle();
                bundle.putCharSequence("key", "bunny");
                HomeFragment fragobj = new HomeFragment();
                fragobj.setArguments(bundle);
                mFragmentTransaction.setReorderingAllowed(true);
                mFragmentTransaction.addToBackStack(null);

                //replace hav_host_fragment with HomeFragment
                mFragmentTransaction.replace(R.id.nav_host_fragment, newFragment, "HomeFrag").commit();

                //NavHostFragment.findNavController(PetPickerFragment.this).navigate(R.id.action_PetPicker_to_HomeFragment);
            }
        });

        //do something else
    }

}