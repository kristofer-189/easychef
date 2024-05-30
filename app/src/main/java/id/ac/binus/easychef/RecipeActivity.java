package id.ac.binus.easychef;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;

public class RecipeActivity extends AppCompatActivity {

    int step;
    ImageButton backBtn;
    VideoView videoVideo;
    TextView descTxt, stepTxt;
    Button prevBtn, nextBtn;

    Recipe recipe;
    ArrayList<RecipeStep> steps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        findViews();
        Intent intent = getIntent();
        recipe = (Recipe) intent.getSerializableExtra("recipe");
        steps = recipe.getSteps();
        step = 1;
        setRecipe(step);
        setButtonAction();
    }

    private void setButtonAction() {
        backBtn.setOnClickListener(e -> { finish(); });
        nextBtn.setOnClickListener(e -> {
            if(step >= recipe.getStepCount()) finish();
            step++;
            setRecipe(step);
        });
        prevBtn.setOnClickListener(e -> {
            if(step <= 1) return;
            step--;
            setRecipe(step);
        });
    }

    private void setRecipe(int step) {
        RecipeStep recipeStep = steps.get(step - 1);
        videoVideo.setVideoPath("android.resource://" + getPackageName() + "/" + recipeStep.getVideo());
        descTxt.setText(recipeStep.getDescription());
        stepTxt.setText(step + " of " + recipe.getStepCount());
        videoVideo.start();
    }

    private void findViews() {
        backBtn = findViewById(R.id.recipe_backBtn);
        videoVideo = findViewById(R.id.recipe_videoVideo);
        descTxt = findViewById(R.id.recipe_descTxt);
        stepTxt = findViewById(R.id.recipe_countTxt);
        prevBtn = findViewById(R.id.recipe_prevBtn);
        nextBtn = findViewById(R.id.recipe_nextBtn);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoVideo);
        videoVideo.setMediaController(mediaController);
    }
}