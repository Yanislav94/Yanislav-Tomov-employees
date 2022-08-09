public class JoinedWork {

    int emp1ID;
    int emp2ID;
    long timeTogether;

    public JoinedWork(int emp1ID, int emp2ID, long timeTogether) {
        this.emp1ID = emp1ID;
        this.emp2ID = emp2ID;
        this.timeTogether = timeTogether;
    }

    public int getEmp1ID() {
        return emp1ID;
    }

    public void setEmp1ID(int emp1ID) {
        this.emp1ID = emp1ID;
    }

    public int getEmp2ID() {
        return emp2ID;
    }

    public void setEmp2ID(int emp2ID) {
        this.emp2ID = emp2ID;
    }

    public long getTimeTogether() {
        return timeTogether;
    }

    public void setTimeTogether(long timeTogether) {
        this.timeTogether = timeTogether;
    }

    @Override
    public String toString() {
        return "Employees who have worked together for the longest period of time on the same project are: \n" +
                "Employee with ID - " + emp1ID +
                ", Employee with ID - " + emp2ID +
                ", Days Worked Together=" + timeTogether
                ;
    }
}
