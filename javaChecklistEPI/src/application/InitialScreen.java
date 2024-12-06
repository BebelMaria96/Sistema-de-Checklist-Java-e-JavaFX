package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class InitialScreen {
    private final int usuarioId;

    // construtor que aceita o ID do usuario
    public InitialScreen(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void start(Stage primaryStage) {
        // Layout principal
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(15);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);

        
        //botoes
        Button registerActivityButton = new Button("Registrar Atividade");
        registerActivityButton.setOnAction(e -> new RegisterActivityScreen(usuarioId).start(primaryStage));

        Button historyButton = new Button("Histórico de Atividades");
        historyButton.setOnAction(e -> new HistoryScreen(usuarioId).start(primaryStage));

        Button logoutButton = new Button("Sair");
        logoutButton.getStyleClass().add("logout-button");
        logoutButton.setOnAction(e -> new LoginScreen().start(primaryStage));

        // adicionando os botoes ao gridPane
        grid.add(registerActivityButton, 0, 0);
        grid.add(historyButton, 0, 1);

        // adicionando o botao de logout no canto inferior esquerdo
        HBox logoutBox = new HBox(logoutButton);
        logoutBox.setAlignment(Pos.BOTTOM_LEFT);
        grid.add(logoutBox, 0, 2);
        GridPane.setMargin(logoutBox, new Insets(50, 0, 0, 0)); 

        // configuracao da cena
        Scene scene = new Scene(grid, 400, 300);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        primaryStage.setTitle("Página Inicial");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
