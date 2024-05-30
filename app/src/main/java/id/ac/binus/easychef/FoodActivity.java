package id.ac.binus.easychef;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class FoodActivity extends AppCompatActivity {

    ImageButton backBtn, favBtn, likeBtn;
    ImageView iconImg;
    TextView nameTxt, difficultyTxt, likesTxt, descTxt;
    Button startBtn;

    RecyclerView view;
    Food food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        findViews();
        Intent intent = getIntent();
        food = (Food) intent.getSerializableExtra("food");
        setItems();
        IngredientsCarouselAdapter adapter = new IngredientsCarouselAdapter(food.getIngredients());
        view.setAdapter(adapter);
        view.setLayoutManager(new LinearLayoutManager(this));
        setButtonAction();
    }

    private void setButtonAction() {
        backBtn.setOnClickListener(e -> { finish(); });
        favBtn.setOnClickListener(e -> {
            Toast.makeText(this, "Not implemented", Toast.LENGTH_SHORT).show();
        });
        likeBtn.setOnClickListener(e -> {
            Toast.makeText(this, "Not implemented", Toast.LENGTH_SHORT).show();
        });
        startBtn.setOnClickListener(e -> {
            Intent intent = new Intent(FoodActivity.this, RecipeActivity.class);
            intent.putExtra("recipe", food.getRecipes());
            startActivity(intent);
        });
    }

    private void setItems() {
        iconImg.setImageResource(food.getImage());
        nameTxt.setText(food.getName());
        difficultyTxt.setText("Difficulty: " + food.getDifficulty());
        likesTxt.setText(String.valueOf(food.getLikes()));
        descTxt.setText(food.getDescription());
    }

    private void findViews() {
        view = findViewById(R.id.food_ingredientsRecycler);
        backBtn = findViewById(R.id.backBtn);
        favBtn = findViewById(R.id.food_favBtn);
        likeBtn = findViewById(R.id.food_likeBtn);
        iconImg = findViewById(R.id.food_iconImg);
        nameTxt = findViewById(R.id.food_nameTxt);
        difficultyTxt = findViewById(R.id.food_difficultyTxt);
        likesTxt = findViewById(R.id.food_likesTxt);
        descTxt = findViewById(R.id.food_descTxt);
        startBtn = findViewById(R.id.food_startBtn);
    }
}