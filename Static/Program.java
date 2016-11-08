class Program {
	public static void main(String[] args) {

		A.staticSetStaticA(45);
		A.staticShowStaticA();
		A a = new A(6);
		A b = new A(7);
		a.showStaticA();
		a.setStaticA(10);
		b.showStaticA();

		A.staticA = 100;
		b.showStaticA();
	}
}