package payroll;
import Employee.Employee;

public class Boss {
	public void payEmployee(Employee e) {
		e.mailCheck();
	}
	
	public static void main(String[] args) {
		Boss boss = new Boss();
		boss.payEmployee(new Employee());
	}
}
