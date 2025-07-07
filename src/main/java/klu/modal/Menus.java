package klu.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menus")
public class Menus {

    @Id
    @Column(name = "mid")
    private Long mid;

    @Column(name = "mtitle", nullable = false)
    private String mtitle;

    @Column(name = "micon")
    private String micon;

    // Getters and Setters
    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public String getMtitle() {
        return mtitle;
    }

    public void setMtitle(String mtitle) {
        this.mtitle = mtitle;
    }

    public String getMicon() {
        return micon;
    }

    public void setMicon(String micon) {
        this.micon = micon;
    }

    // Optional: toString method
    @Override
    public String toString() {
        return "Menus [mid=" + mid + ", mtitle=" + mtitle + ", micon=" + micon + "]";
    }
}
