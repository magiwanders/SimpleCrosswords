package sample;
// Grande: 12x22
// Piccolo: 12x12

import javafx.fxml.FXMLLoader;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.* ;
import java.io.*;

public class Main extends Application {

    private VBox root;

    private VBox vbox;
        private ToggleGroup toggleOptions;
            private RadioButton small;
            private RadioButton big;
        private Button loadWords;
        private Label label;
        private Label wordsFile;
        private Button generate;

    @Override
    public void start(Stage primaryStage) throws Exception{
        loadUI(primaryStage);

    }

    private void loadUI(Stage primaryStage) {
        root = new VBox();
        primaryStage.setTitle("Simple Crosswords Generator");
        createComponents();
        linkComponents();
        loadWords.setOnAction(e -> wordsFile.setText(loadWordsFile()));
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.show();
    }

    private void createComponents() {
        vbox = new VBox();
        toggleOptions = new ToggleGroup();
        small = new RadioButton("Small (12x12)");
        big = new RadioButton("Big (12x22)");
        loadWords = new Button("Load file with words");
        label = new Label("Loaded file:");
        wordsFile = new Label();
        generate = new Button("Generate!");
    }

    private void linkComponents() {
        root.getChildren().add(vbox);
        vbox.getChildren().add(small);
        vbox.getChildren().add(big);
            small.setToggleGroup(toggleOptions);
            small.setSelected(true);
            big.setToggleGroup(toggleOptions);

            vbox.getChildren().add(loadWords);
            vbox.getChildren().add(label);
            vbox.getChildren().add(wordsFile);
            vbox.getChildren().add(generate);
    }

    private String loadWordsFile() {
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(stage);
        return file.getAbsolutePath();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
