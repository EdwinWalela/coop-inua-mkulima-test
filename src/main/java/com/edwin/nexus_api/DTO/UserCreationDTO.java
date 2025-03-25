package com.edwin.nexus_api.DTO;

public class UserCreationDTO {
    private String emailAddress;
    private String password;

    public UserCreationDTO() {
    }

    public UserCreationDTO(String emailAddress, String password) {
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
