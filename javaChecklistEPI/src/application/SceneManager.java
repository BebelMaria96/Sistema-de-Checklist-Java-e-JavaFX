package application;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Stack;

public class SceneManager {
    private static SceneManager instance;
    private final Stage primaryStage;
    private final Stack<Scene> sceneStack = new Stack<>();

    private SceneManager(Stage stage) {
        this.primaryStage = stage;
    }

    public static SceneManager getInstance(Stage stage) {
        if (instance == null) {
            instance = new SceneManager(stage);
        }
        return instance;
    }

    public void switchScene(Scene scene) {
        // adiciona a cena atual a pilha antes de trocar
        if (primaryStage.getScene() != null) {
            sceneStack.push(primaryStage.getScene());
        }
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void goBack() {
        // retorna para cena anterior
        if (!sceneStack.isEmpty()) {
            Scene previousScene = sceneStack.pop();
            primaryStage.setScene(previousScene);
            primaryStage.show();
        }
    }
}
