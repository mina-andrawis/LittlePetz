package edu.fsu.cs.littlepetz;

import androidx.lifecycle.ViewModel;

// This class is used in order to send information to and from petPicker fragment to the HomeFragment
// ViewModel is used as opposed to Interface in order to retain information over the entirety of the activity lifecycle in a
// seperate class that retains info until the activity is destroyed completely

// This must be registered in the UI Controller (aka the MainActivity) in order to bind the fragements that are displayed on it
public class PickerToHomeViewModel extends ViewModel
    {

        private String petType = "";


        //**********
        //* getter for animalType
        //**********
        public String getAnimalType() {
            return petType;
        }

        //**********
        //* setter for animalType
        //**********
        public void setAnimalType(String animalType) {
            this.petType = animalType;
        }




    }
