package pojo;

public class EmployeeData {
    private String name;
    private String salary;
    private String age;
    private int id;

    // Default constructor
    public EmployeeData() {}

    public String getName() {
        return name;
    }


    public String getSalary() {
        return salary;
    }


    public String getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "EmployeeData{" +
                "name='" + name + '\'' +
                ", salary='" + salary + '\'' +
                ", age='" + age + '\'' +
                ", id=" + id +
                '}';
    }
}
