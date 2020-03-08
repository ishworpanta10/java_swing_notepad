
public class ACMEBicycle implements Bicycle {
		int cadence; int speed ; int gear;
		
		public ACMEBicycle( ) {
			cadence=0; speed=0; gear=1;
	}
		
		public void changeCadence(int newvalue) {
		cadence=newvalue;
	}
		
		public void changeGear(int newvalue) {
		gear=newvalue;
	}
		
		public void speedUp(int increment) {
		speed =speed + increment;
	}
		
		public void applyBrakes(int decrement) {
		speed =speed - decrement;
	}
		
		void printStates() {
		System.out.println("cadence:" +cadence+ "speed:" +speed+"gear:"+gear);
	}
}