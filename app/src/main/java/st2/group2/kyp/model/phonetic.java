package st2.group2.kyp.model;

import android.widget.ImageView;

/**
 * Created by pjmma on 4/17/2018.
 */

public class phonetic {
    private int img_spelling;
    private String spelling;

    public phonetic(int img_spelling, String spelling) {
        this.img_spelling = img_spelling;
        this.spelling = spelling;
    }

    public int getImg_spelling() {
        return img_spelling;
    }

    public void setImg_spelling(int img_spelling) {
        this.img_spelling = img_spelling;
    }

    public String getSpelling() {
        return spelling;
    }

    public void setSpelling(String spelling) {
        this.spelling = spelling;
    }
}
