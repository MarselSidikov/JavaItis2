class StudentsUtils {
	public static void sort(Student[] student) {
		for (int i = 0; i < student.length; i++) {
            for (int j = 0; j < student.length - 1; j++) {
                if (student[j].calcAverage() < student[j + 1].calcAverage()) {
                    swap(student, j, j + 1);
                }
            }
        }
	}

    private static void swap(Student[] students, int i, int j){
        Student temp = students[i];
        students[i] = students[j];
        students[j] = temp;
    }
}