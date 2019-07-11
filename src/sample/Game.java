package sample;


import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Game {

    private Scene gameScene;
    private HBox columnPane;
    private int rowNumbers;
    private int colNumbers;
    private Apple apple;
    private Lemon lemon;


    public Game(int width,int height) {

        apple = new Apple();
        apple.setImgUrl(Game.class.getClassLoader().getResource("sample/resources/apple.png").toExternalForm());
        apple.setFoodIcon(new ImageView(apple.getImgUrl()));

        lemon = new Lemon();
        lemon.setImgUrl(Game.class.getClassLoader().getResource("sample/resources/Lemon.png").toExternalForm());
        lemon.setFoodIcon(new ImageView(lemon.getImgUrl()));

        colNumbers = width/30;
        rowNumbers = height/30;


        columnPane = new HBox();

        gameScene = new Scene(columnPane,width,height);
        gameScene.getStylesheets().add(getClass().getResource("buttons.css").toExternalForm());

        for (int i = 0; i < colNumbers; i++) {

            VBox rowPane = new VBox();
            for (int j = 0; j < rowNumbers ; j++) {
                Label tmp = new Label();
                tmp.setPrefWidth(30);
                tmp.setPrefHeight(30);
                rowPane.getChildren().add(tmp);
            }
            columnPane.getChildren().add(rowPane);
        }

        setNewPositionForFood(apple,lemon);


        gameScene.setOnMouseClicked( event -> {

            System.out.println(event.getSceneX()/30 + " x " + event.getSceneY()/30);
            int x = (int) event.getSceneX() /30;
            int y = (int) event.getSceneY() /30;


            if (x== apple.getCurrentXPosition() && y == apple.getCurrentYPosition()){

                setNewPositionForFood(apple);

            } else  if (x==lemon.getCurrentXPosition() && y == lemon.getCurrentYPosition()){

                setNewPositionForFood(lemon);
            }
        });
    }


    public Scene getGameScene() {
        return gameScene;
    }

    public void setRandomCoordinates(Food ... foods){

        for (int i = 0; i < foods.length; i++) {
            foods[i].setCurrentXPosition((int)(Math.random() * colNumbers));
            foods[i].setCurrentYPosition((int)(Math.random() * rowNumbers));
        }
    }

    public void setNewPositionForFood(Food ... foods) {

        for (int i = 0; i < foods.length ; i++) {

            setRandomCoordinates(foods[i]);
            ((Label)((VBox)columnPane.getChildren().get(foods[i].getCurrentXPosition())).getChildren().get(foods[i].getCurrentYPosition())).setGraphic(null);
            ((Label)((VBox)columnPane.getChildren().get(foods[i].getCurrentXPosition())).getChildren().get(foods[i].getCurrentYPosition())).setGraphic(foods[i].getFoodIcon());
        }
    }
}


