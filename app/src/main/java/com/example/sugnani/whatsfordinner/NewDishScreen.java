package com.example.sugnani.whatsfordinner;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;


import java.sql.Array;
import java.util.ArrayList;


public class NewDishScreen extends Activity {
    Button saveButton;
    ArrayList<String> ingredients;
    ArrayList<String> ingre;
    SharedPreferences mPrefs;
    SharedPreferences.Editor prefsEditor;
    EditText name, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, des;

    @Override
    public void onCreate(Bundle savedInstanceState){

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        View layout = View.inflate(this, R.layout.newdish_screen, null);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newdish_screen);
        mPrefs = getPreferences(MODE_PRIVATE);
        prefsEditor = mPrefs.edit();


        name=(EditText)findViewById(R.id.recipeName);
        i1=(EditText)layout.findViewById(R.id.editText);
        i2=(EditText)findViewById(R.id.editText2);
        i3=(EditText)findViewById(R.id.editText3);
        i4=(EditText)findViewById(R.id.editText4);
        i5=(EditText)findViewById(R.id.editText5);
        i6=(EditText)findViewById(R.id.editText6);
        i7=(EditText)findViewById(R.id.editText7);
        i8=(EditText)findViewById(R.id.editText8);
        i9=(EditText)findViewById(R.id.editText9);
        i10=(EditText)findViewById(R.id.editText10);
        des=(EditText)findViewById(R.id.description);
        saveButton=(Button)findViewById(R.id.button);

        saveButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                    String n = name.getText().toString();
                    String one = i1.getText().toString();
                    String two = i2.getText().toString();
                    String three = i3.getText().toString();
                    String four = i4.getText().toString();
                    String five = i5.getText().toString();
                    String six = i6.getText().toString();
                    String seven = i7.getText().toString();
                    String eight = i8.getText().toString();
                    String nine = i9.getText().toString();
                    String ten = i10.getText().toString();
                    String descrp = des.getText().toString();

                    ingredients.add(one);
                    ingredients.add(two);
                    ingredients.add(three);
                    ingredients.add(four);
                    ingredients.add(five);
                    ingredients.add(six);
                    ingredients.add(seven);
                    ingredients.add(eight);
                    ingredients.add(nine);
                    ingredients.add(ten);

                    Recipe recipe = new Recipe(n, ingredients, descrp);

                saveObject(recipe);
                Toast.makeText(getApplicationContext(),"Recipe has been saved.", Toast.LENGTH_LONG).show();
            }
        });
    }
   public void saveObject(Recipe newRecipe){
        Gson gson = new Gson();
        String json = gson.toJson(newRecipe);
        prefsEditor.putString(newRecipe.getName(), json);
        prefsEditor.commit();
    }


}
