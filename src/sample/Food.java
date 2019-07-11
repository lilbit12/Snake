package sample;

import javafx.scene.image.ImageView;

public class Food {

    private String imgUrl;
    private ImageView foodIcon;
    private int currentXPosition;
    private int currentYPosition;

    public Food(){

    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public ImageView getFoodIcon() {
        return foodIcon;
    }

    public void setFoodIcon(ImageView foodIcon) {
        this.foodIcon = foodIcon;
        this.foodIcon.setFitHeight(30);
        this.foodIcon.setFitWidth(30);
    }

    public int getCurrentXPosition() {
        return currentXPosition;
    }

    public void setCurrentXPosition(int currentXPosition) {
        this.currentXPosition = currentXPosition;
    }

    public int getCurrentYPosition() {
        return currentYPosition;
    }

    public void setCurrentYPosition(int currentYPosition) {
        this.currentYPosition = currentYPosition;
    }
}
