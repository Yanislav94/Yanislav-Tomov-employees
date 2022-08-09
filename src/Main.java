import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    static String path = "C:\\Users\\ytomo\\Documents\\Repos\\Resources\\EmployeeData.csv";
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-dd-MM");

    public static void main(String[] args) {

        List<EmployeeProject> employeeProjectList = getDataFromCSVFile(path, formatter);
        List<JoinedWork> joinedWorkList = new ArrayList<>();
        //sorting list by project ID, then by Employee ID
        sortList(employeeProjectList);

        for (int i = 0; i < employeeProjectList.size() - 1; i++) {
            for (int j = i + 1; j < employeeProjectList.size() - 1; j++) {

                EmployeeProject firstEmployeeProject = employeeProjectList.get(i);
                EmployeeProject secondEmployeeProject = employeeProjectList.get(j);

                int firstProjectID = employeeProjectList.get(i).getProjectID(); int secondProjectID = employeeProjectList.get(j).getProjectID();
                int firstEmployeeID = employeeProjectList.get(i).getEmployeeID(); int secondEmployeeID = employeeProjectList.get(j).getEmployeeID();

                if (firstProjectID == secondProjectID) {
                    LocalDate start = max(firstEmployeeProject.getDateFrom(), secondEmployeeProject.getDateFrom());
                    LocalDate end = min(firstEmployeeProject.getDateTo(), secondEmployeeProject.getDateTo());
                    //making sure I don't get negative dates
                    if (end.isAfter(start)) {
                        long daysBetween = Duration.between(start.atStartOfDay(), end.atStartOfDay()).toDays();
                        joinedWorkList.add(new JoinedWork(firstEmployeeID, secondEmployeeID, daysBetween));
                    }
                }
            }
        }

        System.out.println(joinedWorkList.get(0).toString());

    }

    static List<EmployeeProject> getDataFromCSVFile(String path, DateTimeFormatter formatter) {
        List<EmployeeProject> list = new ArrayList<>();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM", Locale.ENGLISH);
            String line = "";
            BufferedReader br = new BufferedReader(new FileReader(path));

            while ((line = br.readLine()) != null) {
                if (!line.contains("EmpID")) {
                    String[] values = line.split(",");
                    int empID = Integer.parseInt(values[0]);
                    int projectID = Integer.parseInt(values[1]);
                    LocalDate dateFrom = LocalDate.parse(values[2], formatter);
                    LocalDate dateTo = LocalDate.now();
                    if (!values[3].equals("NULL")) {
                        dateTo = LocalDate.parse(values[3], formatter);
                    }

                    EmployeeProject employeeProject = new EmployeeProject(
                            empID, projectID, dateFrom, dateTo
                    );
                    list.add(employeeProject);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static LocalDate min(LocalDate a, LocalDate b) {
        return a == null ? b : (b == null ? a : (a.isBefore(b) ? a : b));
    }
    public static LocalDate max(LocalDate a, LocalDate b) {
        return a == null ? b : (b == null ? a : (a.isAfter(b) ? a : b));
    }
    static void sortList(List<EmployeeProject> employeeProjects) {
        employeeProjects.sort(Comparator.comparing(EmployeeProject::getProjectID)
                .thenComparing(EmployeeProject::getEmployeeID));
    }

}