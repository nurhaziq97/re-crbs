package com.haziq.crbs.payload.response;

import java.util.List;

public class JwtAuthResponse {
    private String token;
    private final String type = "Bearer";
    private String email;
    private Long id;
    private List<String> role;

    public JwtAuthResponse(String token, String email, Long id, List<String> role) {
        this.token = token;
        this.email = email;
        this.id = id;
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }
}
