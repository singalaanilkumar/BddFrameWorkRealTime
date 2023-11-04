package pojo;

public class EmployeeResponse {
    private String status;
    private EmployeeData data;
    private String message;

    // Default constructor
    public EmployeeResponse() {
    }

    public String getStatus() {
        return status;
    }

    public EmployeeData getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "EmployeeResponse{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
