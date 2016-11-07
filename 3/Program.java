class Program {
	public static void main(String[] args) {
		int a = 6;
		int b = 7;

		b = a;

		b = 8;

		// a - 6

		int array1[] = {2, 5, -5, 2};
		int array2[] = array1;

		array2[3] = 6;

		System.out.println(array1[3]);
	}
}