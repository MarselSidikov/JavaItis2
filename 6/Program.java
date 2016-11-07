class Program {
	public static void main(String[] args) {
		Human marsel;
		marsel = new Human();
		marsel.name = "Marsel";
		marsel.setAge(22);

		int marksOfMarsel[] = {4, 4, 5};

		marsel.marks = marksOfMarsel;

		Human oleg = marsel;
		oleg.setAge(150);
		System.out.println(marsel.getAge());
		// marsel.age = 150
	}
}