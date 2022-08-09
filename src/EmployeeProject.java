import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class EmployeeProject {

    private int employeeID;
    private int projectID;
    private LocalDate dateFrom;
    private LocalDate dateTo;


    public EmployeeProject(int employeeID, int projectID, LocalDate dateFrom, LocalDate dateTo) {
        this.employeeID = employeeID;
        this.projectID = projectID;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }


    @Override
    public String toString() {
        return "EmployeeProject{" +
                "employeeID=" + employeeID +
                ", projectID=" + projectID +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                '}';
    }
}
