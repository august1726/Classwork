import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.application.Platform;
import javafx.geometry.Pos;
import java.util.Random;

/**
 * Simple JavaFX button game
 * 
 * @author August Bambenek
 */
public class DessertGame extends Application {

	private int score = 0;
	
    @Override
    public void start(final Stage stage) {
        // Step 3 & 4
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 640, 480);
        stage.setTitle("Dessert in the Desert JavaFX Game");
        
        // Step 5
        Label scoreLabel = new Label("Score: 0");
        borderPane.setTop(scoreLabel);
        BorderPane.setAlignment(scoreLabel, Pos.TOP_LEFT);

        Button exitButton = new Button("Exit");
        exitButton.setOnAction(event -> {
            Platform.exit();
        });
        borderPane.setBottom(exitButton);
        BorderPane.setAlignment(exitButton, Pos.BOTTOM_RIGHT);
        
        // Step 6
        Pane pane = new Pane();
        borderPane.setCenter(pane);
        BorderPane.setAlignment(pane, Pos.CENTER);

        // TODO: Step 7-10
        Button button1 = new Button("Dessert");
        pane.getChildren().add(button1);
        Button button2 = new Button("Desert");
        pane.getChildren().add(button2);
        Button button3 = new Button("Desert");
        pane.getChildren().add(button3);
        Button button4 = new Button("Desert");
        pane.getChildren().add(button4);
        Button button5 = new Button("Desert");
        pane.getChildren().add(button5);
        Button button6 = new Button("Desert");
        pane.getChildren().add(button6);
        Button button7 = new Button("Desert");
        pane.getChildren().add(button7);
        Button button8 = new Button("Desert");
        pane.getChildren().add(button8);
        Button[] buttons = {button1, button2, button3, button4, button5, button6, button7, button8};
        Random rand = new Random();
        for (int i = 1; i < buttons.length; i++) {
        	buttons[i].setOnMousePressed(event -> {
        		randomizeButtonPositions(rand, buttons);
        		score -= 1;
        		scoreLabel.setText("Score: " + score);
        		exitButton.requestFocus();
        	});
        }
        buttons[0].setOnMousePressed(event -> {
        	randomizeButtonPositions(rand, buttons);
        	score += 1;
        	scoreLabel.setText("Score: " + score);
        	exitButton.requestFocus();
        });
        stage.setOnShown(event -> {
        	randomizeButtonPositions(rand, buttons);
        	exitButton.requestFocus();
        });
        stage.setScene(scene);
        stage.show();
    }
    
    private void randomizeButtonPositions(Random rand, Button[] buttons) {
    	for (Button button : buttons) {
    		button.setLayoutX(rand.nextDouble() * 600);
    		button.setLayoutY(rand.nextDouble() * 400);
    	}
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
