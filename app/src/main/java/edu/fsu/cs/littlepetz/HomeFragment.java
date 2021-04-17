package edu.fsu.cs.littlepetz;

import android.app.Fragment;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.fragment.NavHostFragment;

import org.w3c.dom.Text;

import java.util.Locale;
import java.util.Objects;


public class HomeFragment extends Fragment {

    ImageView imageView;
 
    TextView nameTextView;
    private TextView mTextViewFeedingCountDown;
    private TextView mTextViewThirstCountDown;
    private TextView mTextViewHappyCountDown;

    CountDownTimer FeedingCountDownTimer;
    CountDownTimer ThirstCountDownTimer;
    CountDownTimer HappyCountDownTimer;

    boolean isCounterRunning  = true;


    ProgressBar HungerBar;
    ProgressBar ThirstBar;
    ProgressBar HappyBar;
    Button feed;
    Button water;
    Button pet;
    public static final String MYPREF = "MyPref";
    int hungerStatus;
    int thirstStatus;
    int happyStatus;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.home_fragment, container, false);
        // Toast still not working Toast mytoast = new Toast(v.getContext());

        //create imageview object
        HappyBar = (ProgressBar) v.findViewById(R.id.happinessBar);
        HungerBar = (ProgressBar) v.findViewById(R.id.hungerBar);
        ThirstBar = (ProgressBar) v.findViewById(R.id.thirstBar);

        //create UI objects
         hungerStatus = 100;
         thirstStatus = 100;
         happyStatus = 100;

        HungerBar.setProgress(hungerStatus);
        ThirstBar.setProgress(thirstStatus);
        HappyBar.setProgress(happyStatus);



        imageView = (ImageView) v.findViewById(R.id.petImage);
        nameTextView = (TextView) v.findViewById(R.id.homeName);

        //Visual Representations of the count downs
        mTextViewFeedingCountDown = (TextView) v.findViewById(R.id.feedingtimer);
        mTextViewThirstCountDown = (TextView) v.findViewById(R.id.thirsttimer);
        mTextViewHappyCountDown = (TextView) v.findViewById(R.id.happytimer);






        Bundle bundle = getArguments();

        SharedPreferences prefs = getActivity().getSharedPreferences(MYPREF, 0);

        // if the bundle is not null (picked pet from MainFragment)

        if (null != bundle) {
            String petType = bundle.getString("petType");
            String petName = bundle.getString("petName");

            //retrieve pet name from bundle and alter the textview in HomeFragment
            nameTextView.setText(petName);

            petImagePicker(petType);

            Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
            ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
            Log.i("toolbar", String.valueOf(toolbar));
            Objects.requireNonNull(((AppCompatActivity) getActivity()).getSupportActionBar()).setDisplayShowTitleEnabled(false);

            //create shared preference editor and add pet name to be retrieved by MainActivity to detrmine if a user has
            // already picked a pet
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString(HomeActivity.PET_NAME, petName);

            //insert rest of data to be retrieved in HomeActivity to reinitialize HomeFragment
            editor.putString(HomeActivity.PET_TYPE,petType);
            editor.putInt(HomeActivity.HUNGER_LEVEL,HungerBar.getProgress());
            editor.putInt(HomeActivity.THIRST_LEVEL,ThirstBar.getProgress());
            editor.putInt(HomeActivity.HAPPINESS_LEVEL,HappyBar.getProgress());

            editor.apply();

        }
 
            //Figuring out the Progress Bar------------------------------

            feed = v.findViewById(R.id.feedButton);
            feed.setOnClickListener(view -> {
                FeedingCountDownTimer.cancel();
                FeedingCountDownTimer.start();
                if (hungerStatus < 100) {
                    hungerStatus += 25;
                    HungerBar.setProgress(hungerStatus);
                }
            });
            water = v.findViewById(R.id.hydrateButton);
            water.setOnClickListener(view -> {
                ThirstCountDownTimer.cancel();
                ThirstCountDownTimer.start();
                if (thirstStatus < 100) {
                    thirstStatus += 25;
                    ThirstBar.setProgress(thirstStatus);
                }
            });

            pet = v.findViewById(R.id.happyButton);
            pet.setOnClickListener(view -> {
                HappyCountDownTimer.cancel();
                HappyCountDownTimer.start();
                if (happyStatus < 100) {
                    happyStatus += 25;
                    HappyBar.setProgress(happyStatus);
                }
            });
           //Figuring out the Progress Bar------------------------------
       //Toast Not working yet mytoast.setDuration(Toast.LENGTH_LONG);

        //Code the runs the Count Downs
        FeedingCountDownTimer = new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                mTextViewFeedingCountDown.setText( " " + millisUntilFinished / 1000);
                int time = (int) (millisUntilFinished/1000);

            }
            public void onFinish() {
                if (hungerStatus != 0) {
                hungerStatus -= 25;
                HungerBar.setProgress(hungerStatus);}
                this.cancel();
                this.start();            }

        }.start();

        ThirstCountDownTimer = new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                mTextViewThirstCountDown.setText(" " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                if (thirstStatus != 0) {
                    thirstStatus -= 25;
                    ThirstBar.setProgress(thirstStatus);}
                this.cancel();
                this.start();            }

        }.start();

        HappyCountDownTimer = new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                mTextViewHappyCountDown.setText(" " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                if (happyStatus != 0) {
                    happyStatus -= 25;
                    HappyBar.setProgress(happyStatus);}
                this.cancel();
                this.start();            }

        }.start();

        // add name and pet type to content provider
        Uri mNewUri;

        ContentValues mNewValues = new ContentValues();

        //if values in shared preferences are not the default value aka ""
        if (!prefs.getString(HomeActivity.PET_TYPE, "").equals("") && !prefs.getString(HomeActivity.PET_NAME, "").equals(""))
        {
            //insert values from shared pref into content provider
            mNewValues.put(FriendProvider.COLUMN_PETTYPE, prefs.getString(HomeActivity.PET_TYPE, ""));
            mNewValues.put(FriendProvider.COLUMN_PETNAME, prefs.getString(HomeActivity.PET_NAME, ""));

            Log.i("provider", "inside");
            mNewUri = getActivity().getContentResolver().insert(
                    FriendProvider.CONTENT_URI, mNewValues);
        }



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

