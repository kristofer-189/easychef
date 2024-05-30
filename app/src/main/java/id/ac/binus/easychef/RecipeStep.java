package id.ac.binus.easychef;

import java.io.Serializable;

public class RecipeStep implements Serializable {
    private int step, video;
    private String description;

    public RecipeStep(int stepnum, String description, int video) {
        this.step = stepnum;
        this.description = description;
        this.video = video;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getVideo() {
        return video;
    }

    public void setVideo(int video) {
        this.video = video;
    }
}
