package in.starbow.doorwe;

import android.widget.RatingBar;

public class SetMenuItem {
    private int imageID;
    private String title;
    //TODO: error check
    private Integer ratingBar;
    private float current_price;
    private float last_price;

    public SetMenuItem(int imageID, String title, Integer ratingBar, float current_price, float last_price) {
        this.imageID = imageID;
        this.title = title;
        this.ratingBar = ratingBar;
        this.current_price = current_price;
        this.last_price = last_price;
    }

    public int getImageID() {
        return imageID;
    }

    public String getTitle() {
        return title;
    }

    public Integer getRatingBar() {
        return ratingBar;
    }

    public float getCurrent_price() {
        return current_price;
    }

    public float getLast_price() {
        return last_price;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRatingBar(Integer ratingBar) {
        this.ratingBar = ratingBar;
    }

    public void setCurrent_price(float current_price) {
        this.current_price = current_price;
    }

    public void setLast_price(float last_price) {
        this.last_price = last_price;
    }
}
