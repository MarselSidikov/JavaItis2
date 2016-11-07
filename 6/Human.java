class Human {
	public String name;
	private int age;
	public int[] marks;

	public void setAge(int age) {
		if (age >= 0 && age <= 110) {
			this.age = age;
		} else {
			this.age = 0;
		}
	}

	public int getAge() {
		return this.age;
	}
}