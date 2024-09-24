package com.example.new_app_2;
import com.example.new_app_2.Recipe;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBox;
    private RadioGroup radioGroup;
    private SeekBar seekBar;
    private RatingBar ratingBar;
    private Switch switchButton;
    private ListView recipeListView;
    public ArrayList<Recipe> recipeList;
    private ListView listView;
    private MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox = findViewById(R.id.checkbox);
        radioGroup = findViewById(R.id.radiogroup);
        seekBar = findViewById(R.id.seekbar);
        ratingBar = findViewById(R.id.ratingbar);
        switchButton = findViewById(R.id.switchbutton);
        recipeListView = findViewById(R.id.recipe_list);

        recipeList = new ArrayList<>();

        // Set up checkbox for ingredients and dietary restrictions
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Update recipe list based on checked ingredients and dietary restrictions
                filterRecipes();
            }
        });

        // Set up radiobutton for meal type selection
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Update recipe list based on selected meal type
                filterRecipes();
            }
        });

        // Set up seekbar for adjusting number of servings
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Update recipe list based on adjusted number of servings
                filterRecipes();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Implement logic for onStartTrackingTouch
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Implement logic for onStopTrackingTouch
            }
        });

        // Set up ratingbar for rating recipes
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                // Update recipe ratings and reviews
                updateRecipeRating(rating);
            }
        });

        // Set up switch button for enabling/disabling dietary restriction filters
        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Update recipe list based on enabled/disabled dietary restriction filters
                filterRecipes();
            }
        });

        // Load initial recipe list
        loadRecipes();

        // Create adapter and set it to the listview
        adapter = new MyAdapter(this, recipeList);
        recipeListView.setAdapter(adapter);

        // Button to display selected options
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displaySelectedOptions();
            }
        });
    }

    private void filterRecipes() {
        // Implement logic to filter recipes based on user input and preferences
        // Update recipeList and notify recipeAdapter
        adapter.notifyDataSetChanged();
    }

    private void updateRecipeRating(float rating) {
        // Implement logic to update recipe ratings and reviews
    }

    private void loadRecipes() {
        List<String> foodItems1 = new ArrayList<>();
        foodItems1.add("Pizza");
        foodItems1.add("Burger");

        List<String> foodItems2 = new ArrayList<>();
        foodItems2.add("Sandwich");
        foodItems2.add("Salad");

        List<String> foodItems3 = new ArrayList<>();
        foodItems3.add("Fries");
        foodItems3.add("Chicken Wings");

        recipeList.add(new Recipe("Recipe 1", "Ingredients 1", "Instructions 1", foodItems1));
        recipeList.add(new Recipe("Recipe 2", "Ingredients 2", "Instructions 2", foodItems2));
        recipeList.add(new Recipe("Recipe 3", "Ingredients 3", "Instructions 3", foodItems3));
    }

    private void displaySelectedOptions() {
        String message = "Selected Options:\n";
        message += "Food Items: ";
        for (Recipe recipe : recipeList) {
            if (recipe.getFoodItems().size() > 0) {
                message += recipe.getFoodItems().toString() + "\n";
            }
        }
        if (checkBox.isChecked()) {
            message += "Ingredients and Dietary Restrictions: Checked\n";
        } else {
            message += "Ingredients and Dietary Restrictions: Not Checked\n";
        }

        int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        if (selectedRadioButtonId != -1) {
            message += "Meal Type: " + ((RadioButton) findViewById(selectedRadioButtonId)).getText() + "\n ";
        } else {
            message += "Meal Type: Not Selected\n";
        }

        message += "Number of Servings: " + seekBar.getProgress() + "\n";
        message += "Rating: " + ratingBar.getRating() + "\n";

        if (switchButton.isChecked()) {
            message += "Dietary Restriction Filters: Enabled\n";
        } else {
            message += "Dietary Restriction Filters: Disabled\n";
        }

        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                .setMessage(message)
                .setPositiveButton("OK", null)
                .create();
        alertDialog.show();
    }

}

