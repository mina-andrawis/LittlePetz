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
import android.widget.Button;
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
 
    TextView nameTextView;
    ProgressBar HungerBar;
    ProgressBar ThirstBar;
    ProgressBar HappyBar;
    Button feed;
    Button water;
    Button pet;
    public static final String MYPREF = "MyPref";
    int hungerStatus = 0;
    int thirstStatus = 0;
    int happyStatus = 0;

   

 

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.home_fragment, container, false);

 




        //create imageview object

        //create UI objects
 
        imageView = (ImageView) v.findViewById(R.id.petImage);
        nameTextView = (TextView) v.findViewById(R.id.homeName);

        HappyBar = (ProgressBar) v.findViewById(R.id.happinessBar);
        HungerBar = (ProgressBar) v.findViewById(R.id.hungerBar);
        thirstBar = (ProgressBar) v.findViewById(R.id.thirstBar);


        Bundle bundle = getArguments();

        if (null != bundle) {
            String petType = bundle.getString("petType");
            String petName = bundle.getString("petName");

            //retrieve pet name from bundle and alter the textview in HomeFragment
            nameTextView.setText(petName);

            petImagePicker(petType);

           //Figuring out the Progress Bar------------------------------


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


<<<<<<< Updated upstream
 
            //Figuring out the Progress Bar------------------------------
            HungerBar=(ProgressBar) v.findViewById(R.id.hungerBar);
            ThirstBar=(ProgressBar) v.findViewById(R.id.thirstBar);
            HappyBar=(ProgressBar) v.findViewById(R.id.happinessBar);

            feed = v.findViewById(R.id.feedButton);
            feed.setOnClickListener(view -> {
                if (hungerStatus <= 100) {
                    hungerStatus += 25;
                    HungerBar.setProgress(hungerStatus);
                }
                if(hungerStatus > 100){
                    hungerStatus = 0;
                    HungerBar.setProgress(hungerStatus);
                }
            });
            water = v.findViewById(R.id.hydrateButton);
            water.setOnClickListener(view -> {
                if (thirstStatus <= 100) {
                    thirstStatus += 25;
                    ThirstBar.setProgress(thirstStatus);
                }
                if(thirstStatus > 100){
                    thirstStatus = 0;
                    ThirstBar.setProgress(thirstStatus);
                }
            });

            pet = v.findViewById(R.id.happyButton);
            pet.setOnClickListener(view -> {
                if (happyStatus <= 100) {
                    happyStatus += 25;
                    HappyBar.setProgress(happyStatus);
                }
                if(happyStatus > 100){
                    happyStatus = 0;
                    HappyBar.setProgress(happyStatus);
                }
            });
           //Figuring out the Progress Bar------------------------------


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
=======

        //Figuring out the Progress Bar------------------------------
        HungerBar=(ProgressBar) v.findViewById(R.id.hungerBar);
        ThirstBar=(ProgressBar) v.findViewById(R.id.thirstBar);
        HappyBar=(ProgressBar) v.findViewById(R.id.happinessBar);

        feed = v.findViewById(R.id.feedButton);
        feed.setOnClickListener(view -> {
            if (hungerStatus <= 100) {
                hungerStatus += 25;
                HungerBar.setProgress(hungerStatus);
                Log.i("feed", String.valueOf(hungerStatus));
            }
            if(hungerStatus > 100){
                hungerStatus = 0;
                HungerBar.setProgress(hungerStatus);
            }
        });
        water = v.findViewById(R.id.hydrateButton);
        water.setOnClickListener(view -> {
            if (thirstStatus <= 100) {
                thirstStatus += 25;
                ThirstBar.setProgress(thirstStatus);
            }
            if(thirstStatus > 100){
                thirstStatus = 0;
                ThirstBar.setProgress(thirstStatus);
            }
        });

        pet = v.findViewById(R.id.happyButton);
        pet.setOnClickListener(view -> {
            if (happyStatus <= 100) {
                happyStatus += 25;
                HappyBar.setProgress(happyStatus);
            }
            if(happyStatus > 100){
                happyStatus = 0;
                HappyBar.setProgress(happyStatus);
            }
        });
        
>>>>>>> Stashed changes
        return v;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {



        super.onViewCreated(view, savedInstanceState);

        nameTextView = view.findViewById(R.id.homeName);
        imageView = (ImageView) view.findViewById(R.id.petImage);

        HappyBar = (ProgressBar) view.findViewById(R.id.happinessBar);
        HungerBar = (ProgressBar) view.findViewById(R.id.hungerBar);
        ThirstBar = (ProgressBar) view.findViewById(R.id.thirstBar);

        SharedPreferences prefs = getActivity().getSharedPreferences(HomeActivity.MYPREF,0);

        nameTextView.setText(prefs.getString(HomeActivity.PET_NAME, ""));
        petImagePicker(prefs.getString(HomeActivity.PET_TYPE,""));
        HappyBar.setProgress(prefs.getInt(HomeActivity.HAPPINESS_LEVEL,0));
        HungerBar.setProgress(prefs.getInt(HomeActivity.HUNGER_LEVEL,0));
        ThirstBar.setProgress(prefs.getInt(HomeActivity.THIRST_LEVEL,0));

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

