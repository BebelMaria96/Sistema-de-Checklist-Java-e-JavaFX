package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class Activity {
    @JsonProperty("userId")
    private int userId;

    @JsonProperty("service")
    private String service;

    @JsonProperty("epis")
    private String epis;

    @JsonProperty("dateTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dateTime;

    // construtor para deserialização
    public Activity() {
    }

    // construtor com argumentos
    public Activity(int userId, String service, String epis, LocalDateTime dateTime) {
        this.userId = userId;
        this.service = service;
        this.epis = epis;
        this.dateTime = dateTime;
    }

    // Getters e Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getEpis() {
        return epis;
    }

    public void setEpis(String epis) {
        this.epis = epis;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    // metodo toString para depuração
    @Override
    public String toString() {
        return "Activity{" +
                "userId=" + userId +
                ", service='" + service + '\'' +
                ", epis='" + epis + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
