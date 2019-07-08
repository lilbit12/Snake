package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class GameMenu extends Application {


    public static void uruchom(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane,720,600, Color.BLUE);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        scene.getStylesheets().add(getClass().getResource("buttons.css").toExternalForm());

        Button playBtn = new Button("Play");
        Button highScore = new Button("HighScore");
        Button exitBtn = new Button("Exit");

        VBox menu = new VBox(playBtn,highScore,exitBtn);

        menu.setAlignment(Pos.CENTER);
        menu.setSpacing(20);

        gridPane.getColumnConstraints().add(new ColumnConstraints(200));
        gridPane.setBackground(Background.EMPTY);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(menu, 0, 3);




        playBtn.setOnAction(e -> {
            Game mainGame = new Game();
            primaryStage.setScene(mainGame.getGameScene());
        });

        exitBtn.setOnAction( e -> primaryStage.close());

    }


}
