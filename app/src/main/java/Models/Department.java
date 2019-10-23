package Models;

public class Department {

    String depId,departmentName;

    public Department(String depId, String departmentName) {
        this.depId = depId;
        this.departmentName = departmentName;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
