package com.edwin.nexus_api.DTO;

public class UserRequestDTO {
    private String username;
    private String staffId;
    private String emailAddress;

    public UserRequestDTO(String username, String staffId, String emailAddress) {
        this.username = username;
        this.staffId = staffId;
        this.emailAddress = emailAddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
