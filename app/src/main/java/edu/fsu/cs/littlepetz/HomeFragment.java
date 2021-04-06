package edu.fsu.cs.littlepetz;

import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.navigation.fragment.NavHostFragment;

import org.w3c.dom.Text;

import java.util.Objects;


public class HomeFragment extends Fragment {

    ImageView imageView;
    TextView nameView;
    public static final String MYPREF = "MyPref";

    ProgressBar happinessBar,thirstBar,hungerBar;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.home_fragment, container, false);

        //create UI objects
        imageView = (ImageView) v.findViewById(R.id.petImage);
        nameView = (TextView) v.findViewById(R.id.homeName);

        happinessBar = (ProgressBar) v.findViewById(R.id.happinessBar);
        hungerBar = (ProgressBar) v.findViewById(R.id.hungerBar);
        thirstBar = (ProgressBar) v.findViewById(R.id.thirstBar);


        Bundle bundle = getArguments();

        if (null != bundle) {
            String petType = bundle.getString("petType");
            String petName = bundle.getString("petName");

            //retrieve pet name from bundle and alter the textview in HomeFragment
            nameView.setText(petName);

            petImagePicker(petType);

            //create shared preference editor and add pet name to be retrieved by MainActivity to detrmine if a user has
            // already picked a pet
            SharedPreferences prefs = getActivity().getSharedPreferences(MYPREF, 0);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString(HomeActivity.PET_NAME, petName);

            //insert rest of data to be retrieved in HomeActivity to reinitialize HomeFragment
            editor.putString(HomeActivity.PET_TYPE,petType);
            editor.putInt(HomeActivity.HUNGER_LEVEL,hungerBar.getProgress());
            editor.putInt(HomeActivity.THIRST_LEVEL,thirstBar.getProgress());
            editor.putInt(HomeActivity.HAPPINESS_LEVEL,happinessBar.getProgress());

            editor.apply();



        }
        return v;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        nameView = view.findViewById(R.id.homeName);
        imageView = (ImageView) view.findViewById(R.id.petImage);

        happinessBar = (ProgressBar) view.findViewById(R.id.happinessBar);
        hungerBar = (ProgressBar) view.findViewById(R.id.hungerBar);
        thirstBar = (ProgressBar) view.findViewById(R.id.thirstBar);

        SharedPreferences prefs = getActivity().getSharedPreferences(HomeActivity.MYPREF,0);

        nameView.setText(prefs.getString(HomeActivity.PET_NAME, ""));
        petImagePicker(prefs.getString(HomeActivity.PET_TYPE,""));
        happinessBar.setProgress(prefs.getInt(HomeActivity.HAPPINESS_LEVEL,0));
        hungerBar.setProgress(prefs.getInt(HomeActivity.HUNGER_LEVEL,0));
        thirstBar.setProgress(prefs.getInt(HomeActivity.THIRST_LEVEL,0));

    }

    public void petImagePicker(String petType)
    {
        switch (petType) {
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


}

