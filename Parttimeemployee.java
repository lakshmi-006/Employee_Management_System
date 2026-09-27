public class Parttimeemployee extends Employee {
    double hourlyrate;
    int hoursworked;
    Parttimeemployee(int emp_id,String emp_name,String department,
        double salary,double hourlyrate,int hoursworked){
            super(emp_id, emp_name, department, salary);
            this.hourlyrate = hourlyrate;
            this.hoursworked = hoursworked;
    }
    @Override 
    public void display(){
        super.display();
        System.out.println("Employee type: PartTime");
        System.out.println("HourlyRate: "+hourlyrate);
        System.out.println("HoursWorked: "+hoursworked);
    }
    public double calculateSalary(){
        return hourlyrate*hoursworked;
    }
}
