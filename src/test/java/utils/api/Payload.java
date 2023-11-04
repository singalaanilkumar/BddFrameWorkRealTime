package utils.api;

public class Payload {

    public static String addEmployee(String name,String salary,String age){
        return " \"{\\\"name\\\":\\\""+name+"\\\",\\\"salary\\\":\\\""+salary+"\\\",\\\"age\\\":\\\""+age+"\\\"}\" " ;
    }
}
