package Models;

public class Employes {
    String employeNameDepID,employeMobile,employeName,employeDepartment,employeBuliding,employeFloor,employeTitle,employeExtesion,employeMail;

    public Employes(String employeNameDepID, String employeName, String employeDepartment, String employeBuliding, String employeFloor, String employeTitle, String employeExtesion, String employeMail,String employeMobile) {
        this.employeNameDepID = employeNameDepID;
        this.employeName = employeName;
        this.employeDepartment = employeDepartment;
        this.employeBuliding = employeBuliding;
        this.employeFloor = employeFloor;
        this.employeTitle = employeTitle;
        this.employeExtesion = employeExtesion;
        this.employeMail = employeMail;
        this.employeMobile = employeMobile;
    }

    public String getEmployeMobile() {
        return employeMobile;
    }

    public void setEmployeMobile(String employeMobile) {
        this.employeMobile = employeMobile;
    }

    public String getEmployeNameDepID() {
        return employeNameDepID;
    }

    public void setEmployeNameDepID(String employeNameDepID) {
        this.employeNameDepID = employeNameDepID;
    }

    public String getEmployeName() {
        return employeName;
    }

    public void setEmployeName(String employeName) {
        this.employeName = employeName;
    }

    public String getEmployeDepartment() {
        return employeDepartment;
    }

    public void setEmployeDepartment(String employeDepartment) {
        this.employeDepartment = employeDepartment;
    }

    public String getEmployeBuliding() {
        return employeBuliding;
    }

    public void setEmployeBuliding(String employeBuliding) {
        this.employeBuliding = employeBuliding;
    }

    public String getEmployeFloor() {
        return employeFloor;
    }

    public void setEmployeFloor(String employeFloor) {
        this.employeFloor = employeFloor;
    }

    public String getEmployeTitle() {
        return employeTitle;
    }

    public void setEmployeTitle(String employeTitle) {
        this.employeTitle = employeTitle;
    }

    public String getEmployeExtesion() {
        return employeExtesion;
    }

    public void setEmployeExtesion(String employeExtesion) {
        this.employeExtesion = employeExtesion;
    }

    public String getEmployeMail() {
        return employeMail;
    }

    public void setEmployeMail(String employeMail) {
        this.employeMail = employeMail;
    }
}
