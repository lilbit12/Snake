package sample;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Game {

    private Scene gameScene;
    private HBox rowPane;


    public Game() {
        rowPane = new HBox();

        for (int i = 0; i < 100; i++) {
            VBox tmp = new VBox();
            for (int j = 0; j < 100 ; j++) {

                tmp.getChildren().add(new Label(i+""));
            }
            rowPane.getChildren().add(tmp);
        }


        FileInputStream fis = null;
        try {
            fis = new FileInputStream("C:\\Users\\Radosław Kwiatkowski\\Downloads\\lcc-java-fp-houses-1.1.0-RANGE\\Snake\\src\\apple.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Image apple = new Image(fis);
        ImageView iv3 = new ImageView();
        iv3.setImage(apple);
        
        int colIndex = (int)(Math.random() * 100);
        int rowIndex = (int)(Math.random() * 100);

        ((Label)((VBox)rowPane.getChildren().get(50)).getChildren().get(0)).setText("K");

        gameScene = new Scene(rowPane,700,600);
        gameScene.getStylesheets().add(getClass().getResource("buttons.css").toExternalForm());
    }

    public Scene getGameScene() {
        return gameScene;
    }

}


