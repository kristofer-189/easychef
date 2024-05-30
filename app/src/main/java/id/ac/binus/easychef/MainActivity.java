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
        setFood_1001();
        setFood_1002();
    }

    private void setFood_1002() {
        ArrayList<RecipeStep> recipeSteps = new ArrayList<>();
        recipeSteps.add(new RecipeStep(1, "Recipe unavailable", R.raw.recipe_1002_1));
        Recipe recipe = new Recipe(recipeSteps.size(), recipeSteps);
        ArrayList<String> ingredients = new ArrayList<>();
        ingredients.add("Pasta");
        Food food = new Food("Spaghetti", "Pasta", "Spaghetti", "Very difficult", ingredients, 999, recipe, R.drawable.thumb_1002);
        foodList.add(food);
    }

    private void setFood_1001() {
        ArrayList<RecipeStep> recipeSteps = new ArrayList<>();
        recipeSteps.add(new RecipeStep(1, "Crack two eggs into a small bowl.", R.raw.recipe_1001_0));
        recipeSteps.add(new RecipeStep(2, "Add a pinch of salt and a garnish of pepper. Beat until mixed.", R.raw.recipe_1001_0));
        recipeSteps.add(new RecipeStep(3, "Chop the onion and garlic separately until thoroughly minced.", R.raw.recipe_1001_0));
        recipeSteps.add(new RecipeStep(4, "Heat 1 tablespoon of vegetable oil in a large skillet or wok over medium-high heat.", R.raw.recipe_1001_0));
        recipeSteps.add(new RecipeStep(5, "Add the beaten eggs and scramble until fully cooked. Remove from the pan and set aside.", R.raw.recipe_1001_0));
        recipeSteps.add(new RecipeStep(6, "Add the remaining 1 tablespoon of oil to the skillet.", R.raw.recipe_1001_0));
        recipeSteps.add(new RecipeStep(7, "Add the chopped onion and cook for 2-3 minutes until it becomes translucent.", R.raw.recipe_1001_0));
        recipeSteps.add(new RecipeStep(8, "Stir in the minced garlic and cook for another 30 seconds until fragrant.", R.raw.recipe_1001_0));
        recipeSteps.add(new RecipeStep(9, "Add vegetables. If using fresh, cook until they are tender. If using frozen, cook until heated through.", R.raw.recipe_1001_0));
        recipeSteps.add(new RecipeStep(10, "Add shredded meat, cook until heated.", R.raw.recipe_1001_0));
        recipeSteps.add(new RecipeStep(11, "Add rice to the skillet. Use a spatula to break large chunks.", R.raw.recipe_1001_0));
        recipeSteps.add(new RecipeStep(12, "Pour the soy sauce and sesame oil over the rice. Stir well to combine and ensure the rice is evenly coated.", R.raw.recipe_1001_0));
        recipeSteps.add(new RecipeStep(13, "Add the scrambled eggs back into the pan and stir to combine.", R.raw.recipe_1001_0));
        recipeSteps.add(new RecipeStep(14, "Cook for another 2-3 minutes. Season with salt and pepper to taste.", R.raw.recipe_1001_0));
        recipeSteps.add(new RecipeStep(15, "Serve hot with additional garnish if needed. Your fried rice is ready.", R.raw.recipe_1001_0));
        Recipe recipe = new Recipe(recipeSteps.size(), recipeSteps);
        ArrayList<String> ingredients = new ArrayList<>();
        ingredients.add("Cooked rice to taste, cold works best");
        ingredients.add("2 tablespoons vegetable oil");
        ingredients.add("2 large eggs");
        ingredients.add("1 small onion");
        ingredients.add("2 cloves of garlic");
        ingredients.add("1 cup of vegetables, mixed and chopped");
        ingredients.add("Soy sauce");
        ingredients.add("Sesame oil");
        ingredients.add("Salt and pepper");
        ingredients.add("Additional meat, shredded");
        Food food  = new Food("Fried Rice", "Rice", "Fried rice with eggs, vegetables, and meat", "Easy", ingredients, 16, recipe, R.drawable.thumb_1001);
        foodList.add(food);
    }
}