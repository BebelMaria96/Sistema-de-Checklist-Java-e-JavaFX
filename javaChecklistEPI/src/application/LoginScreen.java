package application;

import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.User;

public class LoginScreen {

    public void start(Stage primaryStage) {
        // layouts
        VBox root = new VBox(20); 
        root.setPadding(new Insets(20));

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label emailLabel = new Label("E-mail:");
        TextField emailInput = new TextField();
        emailInput.setPromptText("Digite seu e-mail");

        Label passwordLabel = new Label("Senha:");
        PasswordField passwordInput = new PasswordField();
        passwordInput.setPromptText("Digite sua senha");

        // botao de login
        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> {
            try {
                String email = emailInput.getText().trim();
                String password = passwordInput.getText().trim();

                List<User> users = DataManager.loadUsers();

                // filtro de usuario com e-mail e senha correspondentes
                User authenticatedUser = users.stream()
                    .filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password))
                    .findFirst()
                    .orElse(null);


                // autenticacao
                if (authenticatedUser != null) {
                    System.out.println("Login bem-sucedido para: " + authenticatedUser.getEmail());
                    new InitialScreen(authenticatedUser.getId()).start(primaryStage);
                } else {
                    showAlert(Alert.AlertType.ERROR, "Credenciais inválidas!", "Por favor, verifique suas credenciais e tente novamente.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                showAlert(Alert.AlertType.ERROR, "Erro", "Ocorreu um erro ao tentar fazer login.");
            }
        });

        // gridPane
        grid.add(emailLabel, 0, 0);
        grid.add(emailInput, 1, 0);
        grid.add(passwordLabel, 0, 1);
        grid.add(passwordInput, 1, 1);
        grid.add(loginButton, 1, 2);
        grid.setStyle("-fx-background-color: lightgray;");

        root.getChildren().add(grid);

        // cena
        Scene scene = new Scene(root, 350, 400);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        primaryStage.setTitle("Tela de Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // alertas
    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
