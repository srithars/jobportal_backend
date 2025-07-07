package klu.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

    @Column(name = "fullname", nullable = false)
    private String fullname;

    @Id
    @Column(name = "emailid", nullable = false, unique = true)
    private String emailid;

    @Column(name = "role")
    private int role;

    @Column(name = "password", nullable = false)
    private String password;

    // Getters and Setters
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Optional: toString method
    @Override
    public String toString() {
        return "User [fullname=" + fullname + ", emailid=" + emailid + ", role=" + role + ", password=" + password + "]";
    }
}
