package st2.group2.kyp.model;

/**
 * Created by pjmma on 4/14/2018.
 */

public class word {
    private String en,pronouce,vnm,love;

    public word(String en, String pronouce, String vnm, String love) {
        this.en = en;
        this.pronouce = pronouce;
        this.vnm = vnm;
        this.love = love;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getPronouce() {
        return pronouce;
    }

    public void setPronouce(String pronouce) {
        this.pronouce = pronouce;
    }

    public String getVnm() {
        return vnm;
    }

    public void setVnm(String vnm) {
        this.vnm = vnm;
    }

    public String getLove() {
        return love;
    }

    public void setLove(String love) {
        this.love = love;
    }
}
