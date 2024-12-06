package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Activity;

import java.time.LocalDateTime;
import java.util.List;

public class RegisterActivityScreen {
    private final int usuarioId;

    public RegisterActivityScreen(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void start(Stage primaryStage) {
        // layout principal
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(15);
        grid.setHgap(10);

        // selecao do serviço
        Label serviceLabel = new Label("Selecione o Serviço:");
        ComboBox<String> serviceComboBox = new ComboBox<>();
        serviceComboBox.getItems().addAll("Manutenção", "Emergência", "Corte");

        // EPIs
        Label epiLabel = new Label("EPIs Necessários:");
        VBox epiBox = new VBox(10);

        // checklist
        serviceComboBox.setOnAction(e -> {
            epiBox.getChildren().clear();
            switch (serviceComboBox.getValue()) {
                case "Manutenção" -> epiBox.getChildren().addAll(
                        createCheckBox("Capacete"),
                        createCheckBox("Luvas"), 
                        createCheckBox("Cinto de Segurança"), 
                        createCheckBox("Roupa Antichamas"), 
                        createCheckBox("Botas"), 
                        createCheckBox("Óculos"));
                case "Emergência" -> epiBox.getChildren().addAll(
                        createCheckBox("Capacete"),
                        createCheckBox("Cinto de Segurança"), 
                        createCheckBox("Roupa Antichamas"), 
                        createCheckBox("Botas"), 
                        createCheckBox("Máscara"));
                case "Corte" -> epiBox.getChildren().addAll(
                        createCheckBox("Luvas"), 
                        createCheckBox("Cinto de Segurança"), 
                        createCheckBox("Roupa Antichamas"), 
                        createCheckBox("Botas"), 
                        createCheckBox("Máscara"));
            }
        });

        // botao para salvar a atividade
        Button saveButton = new Button("Salvar");
        saveButton.setOnAction(e -> {
            String service = serviceComboBox.getValue();
            String epis = String.join(", ",
                    epiBox.getChildren().stream()
                            .filter(node -> node instanceof CheckBox && ((CheckBox) node).isSelected())
                            .map(node -> ((CheckBox) node).getText())
                            .toList());

            if (service == null || epis.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Erro", "Por favor, selecione um serviço e pelo menos um EPI.");
                return;
            }

            // cria e salva a nova atividade
            Activity newActivity = new Activity(usuarioId, service, epis, LocalDateTime.now());
            List<Activity> activities = DataManager.loadActivities();
            activities.add(newActivity);
            DataManager.saveActivities(activities);

            showAlert(Alert.AlertType.INFORMATION, "Sucesso", "Atividade salva com sucesso!");
        });

        // botao que volta para tela inicial
        Button backButton = new Button("Voltar");
        backButton.setOnAction(e -> new InitialScreen(usuarioId).start(primaryStage));

        // componentes do layout
        grid.add(serviceLabel, 0, 0);
        grid.add(serviceComboBox, 1, 0);
        grid.add(epiLabel, 0, 1);
        grid.add(epiBox, 1, 1);
        grid.add(saveButton, 1, 2);
        grid.add(backButton, 0, 2);

        // cena
        Scene scene = new Scene(grid, 500, 400);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        primaryStage.setTitle("Registrar Atividade");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private CheckBox createCheckBox(String text) {
        CheckBox checkBox = new CheckBox(text);
        checkBox.getStyleClass().add("check-box");
        return checkBox;
    }

    // alertas
    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
