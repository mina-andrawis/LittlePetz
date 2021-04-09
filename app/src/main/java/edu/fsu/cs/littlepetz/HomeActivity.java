package edu.fsu.cs.littlepetz;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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

        //only called when user first opens app
        //initialize toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        Log.i("Toolbar", String.valueOf(toolbar));
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);


        //replace container with homefragment
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new HomeFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_friends) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }





}
