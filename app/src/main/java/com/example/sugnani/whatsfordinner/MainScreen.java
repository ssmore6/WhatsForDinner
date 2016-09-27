package com.example.sugnani.whatsfordinner;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainScreen extends AppCompatActivity {
    ImageButton dinnerButton;
    ImageButton menuButton;
    ImageButton recipeButton;
    ImageButton groceriesButton;
    ImageButton newdishButton;
    PopupWindow popupWindow;
    LayoutInflater layoutInflater;
    RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        addListenerOnButton();
    }

    public void newdishScreen(View v){

        Intent startNewActivity= new Intent(this, NewDishScreen.class);
        startActivity(startNewActivity);
    }
    public void menuScreen(View v){

        Intent startNewActivity= new Intent(this, MenuScreen.class);
        startActivity(startNewActivity);
    }
    public void groceriesScreen(View v){

        Intent startNewActivity= new Intent(this, GroceriesScreen.class);
        startActivity(startNewActivity);
    }
    public void recipeScreen(View v){

        Intent startNewActivity= new Intent(this, RecipeScreen.class);
        startActivity(startNewActivity);
    }

    public void addListenerOnButton(){
        dinnerButton = (ImageButton) findViewById(R.id.dinnerButton);
        relativeLayout = (RelativeLayout) findViewById(R.id.relative);
        dinnerButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                ViewGroup container = (ViewGroup)layoutInflater.inflate(R.layout.popup_alert, null);

                popupWindow = new PopupWindow(container, 700, 700, true);
                popupWindow.showAtLocation(relativeLayout, Gravity.NO_GRAVITY, 200, 800);
                container.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        popupWindow.dismiss();
                        return true;
                    }
                });
            }
        });
    }
}
