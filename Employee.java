public class Employee {
    private int emp_id;
    private String emp_name;
    private String department;
    private double salary;

    Employee(int emp_id,String emp_name,String department,Double salary){
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.department = department;
        this.salary = salary;
    }

    public int getid(){
        return emp_id;
    }
    public String getname(){
        return emp_name;
    }
    public String getdept(){
        return department;
    }
    public double getsalary(){
        return salary;
    }

    public void setname(String emp_name){
        this.emp_name = emp_name;
    }
    public void setdept(String department){
        this.department = department;
    }
    public void setsalary(Double salary){
        this.salary = salary;
    }
    public void display(){
        System.out.println("Name: "+emp_name);
        System.out.println("Id: "+emp_id);
        System.out.println("Department: "+department);
        System.out.println("Salary: "+salary);
    }
    public double calculateSalary(){
        return getsalary();
    }
}