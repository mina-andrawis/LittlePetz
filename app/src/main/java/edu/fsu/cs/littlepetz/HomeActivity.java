package edu.fsu.cs.littlepetz;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModel;
//import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Objects;

public class HomeActivity extends AppCompatActivity {

    SharedPreferences sharedpreferences;
    ProgressBar hungerBar, thirstBar, happinessBar;
    TextView nameView;
    String petType;

    public static final String MYPREF = "MyPref";
    public static final String PET_NAME = "petName";
    public static final String PET_TYPE = "petType";
    public static final String HUNGER_LEVEL = "hungerLevel";
    public static final String THIRST_LEVEL = "thirstLevel";
    public static final String HAPPINESS_LEVEL = "happinessLevel";

    SharedPreferences mPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // initialize prefrence and retrieve UI elements as objects

        //replace container with homefragment
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new HomeFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();



    }


}
