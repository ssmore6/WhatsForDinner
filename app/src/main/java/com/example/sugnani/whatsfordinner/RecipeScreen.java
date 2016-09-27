package com.example.sugnani.whatsfordinner;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.gson.Gson;


public class RecipeScreen extends Activity {
    SharedPreferences mPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_screen);
        mPrefs = getPreferences(MODE_PRIVATE);

    }

    public Recipe getObject(){
        Gson gson = new Gson();
        String json = mPrefs.getString("Recipe","");
        Recipe object = gson.fromJson(json, Recipe.class);
        return object;
    }
}
