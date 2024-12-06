package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Activity;

import java.util.List;

public class HistoryScreen {
    private final int usuarioId;

    public HistoryScreen(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));

        ListView<String> historyList = new ListView<>();

        // carrega atividades do JSON
        List<Activity> activities = DataManager.loadActivities();

        // verifica se atividades foram carregadas e filtra atividades pelo usuario e adicionar a lista
        if (activities.isEmpty()) {
            historyList.getItems().add("Nenhuma atividade encontrada.");
        } else {
            activities.stream()
                    .filter(activity -> activity.getUserId() == usuarioId)
                    .forEach(activity -> historyList.getItems().add(
                            "Serviço: " + activity.getService() +
                                    "\nEPIs: " + activity.getEpis() +
                                    "\nData e Hora: " + activity.getDateTime()
                    ));
        }

        
        // configuracoes de cena
        Button backButton = new Button("Voltar");
        backButton.setOnAction(e -> new InitialScreen(usuarioId).start(primaryStage));

        Button logoutButton = new Button("Sair");
        logoutButton.setOnAction(e -> new LoginScreen().start(primaryStage));

        HBox buttonBox = new HBox(10);
        buttonBox.setPadding(new Insets(10));
        buttonBox.setAlignment(Pos.BOTTOM_LEFT);
        buttonBox.getChildren().addAll(backButton, logoutButton);

        root.setCenter(historyList);
        root.setBottom(buttonBox);

        Scene scene = new Scene(root, 400, 300);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        primaryStage.setTitle("Histórico de Atividades");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
