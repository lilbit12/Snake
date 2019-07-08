package sample;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Game {

    private Scene gameScene;
    private HBox columnPane;
    private int currentAppleX;
    private int currentAppleY;
    private int currentLemonX;
    private int currentLemonY;
    private int rowNumbers;
    private int colNumbers;
    private Label appleLabel;



    public Game() {

        rowNumbers = 20;
        colNumbers = 24;

        Group root = new Group();
        columnPane = new HBox();


        for (int i = 0; i <= colNumbers; i++) {
            VBox rowPane = new VBox();
            for (int j = 0; j <= rowNumbers ; j++) {
                Label tmp = new Label();
                tmp.setPrefWidth(30);
                tmp.setPrefHeight(30);
                rowPane.getChildren().add(tmp);
            }


            columnPane.getChildren().add(rowPane);
        }
        root.getChildren().add(columnPane);

        String appleUrl = Game.class.getClassLoader().getResource("sample/resources/apple.png").toExternalForm();
        String lemonUrl = Game.class.getClassLoader().getResource("sample/resources/Lemon.png").toExternalForm();

        ImageView appleIcon = new ImageView(appleUrl);
        ImageView lemonIcon = new ImageView(lemonUrl);

        setCurrentAppleX((int)(Math.random() * colNumbers));
        setCurrentAppleY((int)(Math.random() * rowNumbers));




        appleLabel = ((Label)((VBox)columnPane.getChildren().get(getCurrentAppleX())).getChildren().get(getCurrentAppleY()));
        appleLabel.setGraphic(appleIcon);


        int tmpX = (int)(Math.random() * colNumbers);
        int tmpY = (int)(Math.random() * rowNumbers);
        if((tmpX != getCurrentAppleX() && tmpY != getCurrentAppleY()));{
            setCurrentLemonX(tmpX);
            setCurrentLemonY(tmpY);
            ((Label)((VBox)columnPane.getChildren().get(getCurrentLemonX())).getChildren().get(getCurrentLemonY())).setGraphic(lemonIcon);
        }


        gameScene = new Scene(root,720,600);
        gameScene.getStylesheets().add(getClass().getResource("buttons.css").toExternalForm());

        root.setOnMouseClicked( event -> {

            System.out.println(event.getSceneX() + " " + event.getSceneY());

            setCurrentAppleX((int)(event.getSceneX()/24));
            setCurrentAppleY((int)(event.getSceneY()/20));

            appleLabel = ((Label) ((VBox)columnPane.getChildren().get(getCurrentAppleX())).getChildren().get(getCurrentAppleY()));
            appleLabel.setGraphic(appleIcon);

        });

        columnPane.setOnMouseClicked( event -> System.out.println(event.getSource()+":"+ event.getSceneY()));
    }


    public Scene getGameScene() {
        return gameScene;
    }

    public int getCurrentAppleX() {
        return currentAppleX;
    }

    public void setCurrentAppleX(int currentAppleX) {
        this.currentAppleX = currentAppleX;
    }

    public int getCurrentAppleY() {
        return currentAppleY;
    }

    public void setCurrentAppleY(int currentAppleY) {
        this.currentAppleY = currentAppleY;
    }

    public int getCurrentLemonX() {
        return currentLemonX;
    }

    public void setCurrentLemonX(int currentLemonX) {
        this.currentLemonX = currentLemonX;
    }

    public int getCurrentLemonY() {
        return currentLemonY;
    }

    public void setCurrentLemonY(int currentLemonY) {
        this.currentLemonY = currentLemonY;
    }
}


