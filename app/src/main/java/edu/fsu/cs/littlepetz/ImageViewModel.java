package edu.fsu.cs.littlepetz;

import androidx.lifecycle.ViewModel;

//This class is used in order to send information to and from fragments in the main activity
// ViewModel is used as opposed to Interface in order to retain information over the entirety of the activity lifecycle in a
// seperate class that retains info until the activity is destroyed completely
public class ImageViewModel extends ViewModel
    {

        private String animalType = "";


        //**********
        //* getter for animalType
        //**********
        public String getAnimalType() {
            return animalType;
        }

        //**********
        //* setter for animalType
        //**********
        public void setAnimalType(String animalType) {
            this.animalType = animalType;
        }




    }
