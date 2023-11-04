package pojo;

public class Employee {
    private String name;
    private Integer salary;
    private Integer age;
    public String sqlQuery="select * from Employee ";
    String url="jdbc:mysql://localhost:3306/Zensar_Automation";
    String user="root";
    String password="root123";

    public String connection="connection successful with url ::  "+ url +",user :: "+ user +" ,password :: "+ password +"";

    public Employee(String name, Integer age, Integer salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getConnection(){
        return connection;
    }
    public String getSqlQuery() {
        return sqlQuery;
    }

    public String getName() {
        return name;
    }

    public Integer getSalary() {
        return salary;
    }

    public Integer getAge() {
        return age;
    }

    public String getInsertQuery() {
        return "insert into Employee(`name`,`age`,`salary`) values('Sriman Kode','23','500000')";
    }
}
