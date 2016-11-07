class Program {
	public static void main(String[] args) {
		int array[];
		array = new int[5];

		// int array[] = new int[5];

		array[0] = -4;
		array[1] = 2;
		array[2] = 6;
		array[3] = 7;
		array[4] = 2;

		// int array[] = {-4, 2, 6, 7, 2};

		/*
		int i = 0;
		while (i < 5) {
			System.out.println(array[i]);
			i++;
		}
		*/

		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}


	}
}