class A {
	private int a;
	public static int staticA;

	static {
		staticA = 80;
	}

	public A(int a) {
		this.a = a;
	}
	
	public static void staticSetStaticA(int value) {
		staticA = value;
	}

	public static void staticShowStaticA() {
		System.out.println(staticA);
	}
	
	public void showStaticA() {
		System.out.println(staticA);
	}

	public void setStaticA(int value) {
		staticA = value;
	}
}