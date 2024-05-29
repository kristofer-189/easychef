package id.ac.binus.easychef;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView view;
    ArrayList<Food> foodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = findViewById(R.id.foodCarousel_repeater);
        set_foods();
        FoodCarouselAdapter adapter = new FoodCarouselAdapter(foodList, item -> {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
        });
        view.setAdapter(adapter);
        view.setLayoutManager(new LinearLayoutManager(this));
    }

    private void set_foods() {
        foodList = new ArrayList<>();

        // Spaghetti
        ArrayList<RecipeStep> recipeSteps = new ArrayList<>();
        recipeSteps.add(new RecipeStep(1, "Cook the spaghetti", -1));
        recipeSteps.add(new RecipeStep(2, "Done", -1));
        Recipe recipe = new Recipe(2, recipeSteps);
        ArrayList<String> ingredients = new ArrayList<>();
        ingredients.add("400g of spaghetti");
        ingredients.add("4 liters of water");
        ingredients.add("1 tablespoon of salt");
        Food food = new Food("Fried Rice", "Pasta", "Spaghetti with Marinara Sauce", ingredients, 10, recipe, R.drawable.thumb_1001);
        foodList.add(food);
        food = new Food("Fried Rice", "Pasta", "Spaghetti with Marinara Sauce", ingredients, 10, recipe, R.drawable.thumb_1001);
        foodList.add(food);
    }
}