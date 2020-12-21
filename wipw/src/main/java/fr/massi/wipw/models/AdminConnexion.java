package fr.massi.wipw.models;

public class AdminConnexion {
    private Admin admin;
    private boolean status;
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Admin getAdmin() {
        return admin;
    }

    public boolean isStatus() {
        return status;
    }
}
