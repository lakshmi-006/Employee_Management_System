import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class EmployeeManagementSystem{
    public static void main(String[] args){
        Scanner sc =  new Scanner(System.in);
        ArrayList<Employee>employees = new ArrayList<>();
        
        boolean running = true;
        while(running){
            System.out.println("=================================");
            System.out.println("   EMPLOYEE MANAGEMENT SYSTEM");
            System.out.println("=================================");
        
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");

            System.out.println("Enter choice: ");
            if(!sc.hasNextInt()){
                System.out.println("Invalid input, Enter valid number.");
                sc.next();
                continue;
            }
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    addemployee(sc, employees);
                    break;

                case 2:
                    viewemployee(employees);
                    break;

                case 3:
                    searchemp(sc,employees);
                    break;

                case 4:
                    updateemp(sc, employees);
                    break;

                case 5:
                    deleteemp(sc,employees);
                    break;

                case 6:
                    System.out.println("Exiting Employee Management System...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice, Try Again....");
            }

        }
    }
    static void addemployee(Scanner sc,ArrayList<Employee>employees){
        System.out.println("Add Employee");
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        boolean exist = false;
        for(Employee i : employees){
            if(i.getid()==id){
                exist = true;
                break;
            }
        }
        if(exist){
            System.out.println("ID already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Dept: ");
        String dept = sc.nextLine();

        System.out.print("Enter Salary: ");
        Double salary = sc.nextDouble();
        if(salary<0){
            System.out.println("Salary cannot be negative.");
            return;
        }

        System.out.println("Select employee type: ");
        System.out.println("1. FullTime");
        System.out.println("2. PartTime");
        System.out.println("Enter Type: ");
        int type = sc.nextInt();
        Employee e;

        if(type == 1){
            System.out.print("Enter annual bonus: ");
            double ab = sc.nextDouble();
            if(ab<0){
                System.out.println("Annual bonus cannot be negative.");
                return;
            }
            e = new Fulltimeemployee(id, name, dept, salary,ab);
        }else if(type == 2){
            System.out.print("Enter hourlyRate: ");
            double hr = sc.nextDouble();
            if(hr<0){
                System.out.println("Hourly rate cannot be negative.");
                return;
            }
            System.out.print("Enter hoursWorked: ");
            int hw = sc.nextInt();
            if(hw<0){
                System.out.println("Hours worked cannot be negative.");
            }

            e = new Parttimeemployee(id, name, dept, salary, hr, hw);
        }else{
            System.out.println("Invalid type");
            return;
        }
        employees.add(e);

        System.out.println("Employee added successfully");
    }

    static void viewemployee(ArrayList<Employee>employees){
        if(employees.isEmpty()){
            System.out.println("No Employees available.");
        }else{
            System.out.println("Employee List");
            for(Employee i:employees){
                System.out.println("=================================");
                i.display();
                System.out.println("Calculated Salary: "+i.calculateSalary());
                System.out.println("=================================");
            }
        }
    }

    static void searchemp(Scanner sc,ArrayList<Employee>employees){
        System.out.print("Enter Employee ID to Search: ");
        int search = sc.nextInt();
        boolean s = false;
        for(Employee i:employees){
            if(i.getid()==search){
                s = true;
                System.out.println("Employee found");
                i.display();
                break;
            }
        }
        if(!s){
            System.out.println("Employee not found");
        }
    }

    static void updateemp(Scanner sc,ArrayList<Employee>employees){
        System.out.print("Enter Employee ID to update: ");
        int update = sc.nextInt();
        sc.nextLine();

        boolean u = false;
        for(Employee i:employees){
            if(i.getid()==update){
                System.out.print("Enter new dept: ");
                String newdept = sc.nextLine();

                System.out.print("Enter new salary: ");
                Double newsalary = sc.nextDouble();
                if(newsalary<0){
                    System.out.print("Salary cannot be negative.");
                    return;
                }

                i.setdept(newdept);
                i.setsalary(newsalary);
                if (i instanceof Fulltimeemployee) {
                    Fulltimeemployee fulltime = (Fulltimeemployee) i;
                    System.out.print("Enter new annual bonus: ");
                    double newbonus = sc.nextDouble();
                    if(newbonus<0){
                        System.out.print("Annual bonus cannot be negative.");
                        return;
                    }
                    fulltime.annualbonus = newbonus;

                } else if (i instanceof Parttimeemployee) {
                    Parttimeemployee parttime = (Parttimeemployee) i;

                    System.out.print("Enter new hourly rate: ");
                    double newrate = sc.nextDouble();
                    if(newrate<0){
                        System.out.println("Hourly rate cannot be negative.");
                        return;
                    }
                    parttime.hourlyrate = newrate;

                    System.out.print("Enter new hours worked: ");
                    int newhour = sc.nextInt();
                    if(newhour<0){
                        System.out.println("Hours worked cannot be negative.");
                        return;
                    }
                    parttime.hoursworked = newhour;
                }
                u=true;

                System.out.println("Employee updated successfully!");
                break;
            }
        }
        if(!u){
            System.out.println("Employee not found");
        }
    }

    static void deleteemp(Scanner sc,ArrayList<Employee>employees){
        System.out.println("Enter id to delete: ");
        int delete = sc.nextInt();
        boolean d = false;
        Iterator<Employee>iterator = employees.iterator();
        while(iterator.hasNext()){
            Employee i = iterator.next();
            if(i.getid()==delete){
                iterator.remove();
                d=true;

                System.out.println("Deleted");
                break;
            }
        } 
        if(!d){
            System.out.println("id not found");
        }
    }
}