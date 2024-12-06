package application;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import model.Activity;
import model.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        // registro do JavaTime module
        objectMapper.registerModule(new JavaTimeModule());
    }

    // metodo para carregar atividades do JSON
    public static List<Activity> loadActivities() {
        try {
            File file = new File("src/resources/atividades.json");
            if (file.exists()) {
                return objectMapper.readValue(file, new TypeReference<List<Activity>>() {});
            } else {
                System.out.println("Arquivo de atividades não encontrado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(); 
    }

    // metodo para salvar atividades no JSON
    public static void saveActivities(List<Activity> activities) {
        try {
            File file = new File("src/resources/atividades.json");
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, activities);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

 // carrega usuários do JSON
    public static List<User> loadUsers() {
        try {
            File file = new File("src/resources/usuarios.json");
            if (file.exists()) {
                return objectMapper.readValue(file, new TypeReference<List<User>>() {});
            } else {
                System.out.println("Arquivo de usuários não encontrado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(); 
        
    }

}
