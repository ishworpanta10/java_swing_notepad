
public class ArrayDemo {

	public static void main(String[] args) {
		int array[] = new int[10];
		array[0] = 10 ;
		
		for (int i = 0 ; i<10 ; i++) {
			array[i] = i * 5 ;
		}
		
		System.out.println("Array in Index 0 :" + array[0]);
		
		for (int i = 0 ; i<10 ; i++) {
			System.out.println("Array in Index :" + array[i]);
		}

	}

}
