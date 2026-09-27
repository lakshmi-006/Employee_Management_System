public class Fulltimeemployee extends Employee {

    double annualbonus;

    Fulltimeemployee(int emp_id, String emp_name, String department,double salary, double annualbonus) {

        super(emp_id, emp_name, department, salary);

        this.annualbonus = annualbonus;
    }
    @Override 
    public void display(){
        super.display();
        System.out.println("Employee type: FullTime");
        System.out.println("Annual bonus: "+ annualbonus);
    }
    public double calculateSalary(){
        return getsalary() + annualbonus;
    }
}
