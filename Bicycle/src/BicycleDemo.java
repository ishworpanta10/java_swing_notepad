
public class BicycleDemo {

	public static void main(String[] args) {
		ACMEBicycle bike1 = new ACMEBicycle();
		ACMEBicycle bike2 = new ACMEBicycle();
		
		bike1.changeCadence(50);
		bike1.speedUp(2);
		bike1.changeGear(10);
		bike1.printStates();
		
		bike2.changeCadence(40);
		bike2.speedUp(10);
		bike2.changeGear(3);
		bike2.printStates();
		

	}

}