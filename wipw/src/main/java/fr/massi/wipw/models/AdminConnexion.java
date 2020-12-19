package fr.massi.wipw.models;

public class AdminConnexion {
    private Admin admin;
    private boolean status;


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
