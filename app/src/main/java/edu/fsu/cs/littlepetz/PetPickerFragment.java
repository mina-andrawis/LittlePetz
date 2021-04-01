package edu.fsu.cs.littlepetz;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.fragment.app.FragmentManager;
import androidx.navigation.fragment.NavHostFragment;

import org.w3c.dom.Text;

import java.io.File;
import java.net.URI;
import java.util.Objects;

public class PetPickerFragment extends Fragment implements View.OnClickListener {

    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction = null;
    Fragment newFragment;
    private String name = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.pet_picker, container, false);

        return v;    }

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


    public void clickToNamePet(String  b){
        Bundle bundle = new Bundle();
           String type = b;
            HomeFragment fragobj = new HomeFragment();


            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("What will you name your pet?");

            final EditText input = new EditText(getActivity());
            input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);

            builder.setView(input);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    name = input.getText().toString();

                    bundle.putString("petType",b);
                    bundle.putString("petName",name);


                    fragobj.setArguments(bundle);
                    mFragmentTransaction = getFragmentManager().beginTransaction();

                    //replace fragment_container (found in HomeActivity) with the newly created fragobj with arguements then commit
                    mFragmentTransaction.replace(R.id.fragment_container, fragobj, "HomeFrag");
                    mFragmentTransaction.addToBackStack(null);
                    mFragmentTransaction.commit();



                }
            });
            builder.show();

        }

    // onClick lister for pets in pet pikcer fragment
    @Override
    public void onClick(View v) {

        //Log.i("ID", String.valueOf(v.getId()));
        String animalType = " ";
        getActivity().setContentView(R.layout.activity_home);

        HomeFragment fragobj = new HomeFragment();

        switch (v.getId()){
            case (R.id.bunny):
                animalType = "bunny";
                clickToNamePet(animalType);
                break;

            case (R.id.bird):
                animalType = "bird";
                clickToNamePet(animalType);
                break;

            case (R.id.cat):
                animalType = "cat";
                clickToNamePet(animalType);
                break;

            case (R.id.dog):
                animalType = "dog";
                clickToNamePet(animalType);
                break;

            case (R.id.fish):
                animalType = "fish";
                clickToNamePet(animalType);
                break;
        }



    }
}