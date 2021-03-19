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

public class PetPickerFragment extends Fragment implements View.OnClickListener {

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


        ImageView bunnyImage = (ImageView) view.findViewById(R.id.bunny);
        ImageView birdImage = (ImageView) view.findViewById(R.id.bird);
        ImageView catImage = (ImageView) view.findViewById(R.id.cat);
        ImageView dogImage = (ImageView) view.findViewById(R.id.dog);
        ImageView fishImage = (ImageView) view.findViewById(R.id.fish);


        bunnyImage.setOnClickListener(this);        //set on onclick listener for bunny image
        birdImage.setOnClickListener(this);        //set on onclick listener for bird image
        catImage.setOnClickListener(this);        //set on onclick listener for cat image
        dogImage.setOnClickListener(this);        //set on onclick listener for dog image
        fishImage.setOnClickListener(this);        //set on onclick listener for fish image

    }

    // onClick lister for pets in pet pikcer fragment
    @Override
    public void onClick(View v) {

        //Log.i("ID", String.valueOf(v.getId()));

        mFragmentTransaction = getFragmentManager().beginTransaction();

        Bundle bundle = new Bundle();
        HomeFragment fragobj = new HomeFragment();

        switch (v.getId()){
            case (R.id.bunny):
                bundle.putString("petType", "bunny");
                fragobj.setArguments(bundle);

                //replace nav_host_fragment (found in content_main) with the newly created fragobj with arguements then commit
                mFragmentTransaction.replace(R.id.nav_host_fragment, fragobj, "HomeFrag").commit();
                break;

            case (R.id.bird):
                bundle.putString("petType", "bird");
                fragobj.setArguments(bundle);

                //replace nav_host_fragment (found in content_main) with the newly created fragobj with arguements then commit
                mFragmentTransaction.replace(R.id.nav_host_fragment, fragobj, "HomeFrag").commit();
                break;

            case (R.id.cat):
                bundle.putString("petType", "cat");
                fragobj.setArguments(bundle);

                //replace nav_host_fragment (found in content_main) with the newly created fragobj with arguements then commit
                mFragmentTransaction.replace(R.id.nav_host_fragment, fragobj, "HomeFrag").commit();
                break;
            case (R.id.dog):
                bundle.putString("petType", "dog");
                fragobj.setArguments(bundle);

                //replace nav_host_fragment (found in content_main) with the newly created fragobj with arguements then commit
                mFragmentTransaction.replace(R.id.nav_host_fragment, fragobj, "HomeFrag").commit();
                break;
            case (R.id.fish):
                bundle.putString("petType", "fish");
                fragobj.setArguments(bundle);

                //replace nav_host_fragment (found in content_main) with the newly created fragobj with arguements then commit
                mFragmentTransaction.replace(R.id.nav_host_fragment, fragobj, "HomeFrag").commit();
                break;

        }
        mFragmentTransaction.setReorderingAllowed(true);
        mFragmentTransaction.addToBackStack(null);


    }
}