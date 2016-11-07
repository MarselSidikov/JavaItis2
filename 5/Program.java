class Program {
	public static void swap(int array[], int i, int j) {
		int temp = array[i];
		array[i] = a  rray[j];
		array[j] = temp;
	
}	public static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}

	public static void main(String[] args) {
		int x = 6;
		int y = 7;

		swap(x, y);

		System.out.println(x + " " + y);

		int myArray[] = {1, 2, 3, 4, 5};
		swap(myArray, 2, 3);
		System.out.println(myArray[2] + " " + myArray[3]);
	}
}