package id.ac.binus.easychef;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageButton searchBtn;
    RecyclerView view;
    ArrayList<Food> foodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = findViewById(R.id.foodCarousel_repeater);
        set_foods();
        FoodCarouselAdapter adapter = new FoodCarouselAdapter(foodList, item -> {
            Intent intent = new Intent(MainActivity.this, FoodActivity.class);
            intent.putExtra("food", item);
            startActivity(intent);
        });
        view.setAdapter(adapter);
        view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        searchBtn = findViewById(R.id.searchBtn);
        searchBtn.setOnClickListener(e -> {
            Toast.makeText(this, "Not implemented", Toast.LENGTH_SHORT).show();
        });
    }

    private void set_foods() {
        foodList = new ArrayList<>();

        // setFood_1001();

        // Fried Rice

        // Spaghetti
        ArrayList<RecipeStep> recipeSteps = new ArrayList<>();
        recipeSteps.add(new RecipeStep(1, "Cook the spaghetti", R.raw.recipe_1002_1));
        recipeSteps.add(new RecipeStep(2, "Done", R.raw.recipe_1002_1));
        Recipe recipe = new Recipe(2, recipeSteps);
        ArrayList<String> ingredients = new ArrayList<>();
        ingredients.add("400g of spaghetti");
        ingredients.add("4 liters of water");
        ingredients.add("1 tablespoon of salt");
        Food food = new Food("Fried Rice", "Rice", "Chicken fried rice with spring onions and eggs", "Easy", ingredients, 16, recipe, R.drawable.thumb_1001);
        foodList.add(food);
        food = new Food("Spaghetti", "Pasta", "Spaghetti with Marinara Sauce", "Easy", ingredients, 10, recipe, R.drawable.thumb_1002);
        foodList.add(food);
    }

    private void setFood_1001() {
        ArrayList<RecipeStep> recipeSteps = new ArrayList<>();
        recipeSteps.add(new RecipeStep(0, "", 0));
    }
}