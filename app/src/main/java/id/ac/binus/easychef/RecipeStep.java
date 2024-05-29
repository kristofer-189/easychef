package id.ac.binus.easychef;

import java.io.Serializable;

public class RecipeStep implements Serializable {
    private int stepnum, video;
    private String description;

    public RecipeStep(int stepnum, String description, int video) {
        this.stepnum = stepnum;
        this.description = description;
        this.video = video;
    }

    public int getStepnum() {
        return stepnum;
    }

    public void setStepnum(int stepnum) {
        this.stepnum = stepnum;
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
