package id.ac.binus.easychef;

import java.io.Serializable;
import java.util.ArrayList;

public class Recipe implements Serializable {
    private int stepCount;
    private ArrayList<RecipeStep> steps;

    public Recipe(int stepCount, ArrayList<RecipeStep> steps) {
        this.stepCount = stepCount;
        this.steps = steps;
    }

    public int getStepCount() {
        return stepCount;
    }

    public void setStepCount(int stepCount) {
        this.stepCount = stepCount;
    }

    public ArrayList<RecipeStep> getSteps() {
        return steps;
    }

    public void setSteps(ArrayList<RecipeStep> steps) {
        this.steps = steps;
    }
}
