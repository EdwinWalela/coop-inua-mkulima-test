package com.edwin.nexus_api.DTO;

public class UserRequestDTO {
    private int id;
    private String emailAddress;

    public UserRequestDTO() {
    }

    public UserRequestDTO(int id, String emailAddress) {
        this.id = id;
        this.emailAddress = emailAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
