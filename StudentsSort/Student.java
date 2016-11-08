public class Student {
    private final int MAX_MARKS_COUNT = 10;
    private final String DEFAULT_NAME = "DEFAULT";

    private String name;
    private int[] marks;
    private int countOfMarks;

    public Student() {
        this.name = DEFAULT_NAME;
        this.marks = new int[MAX_MARKS_COUNT];
    }
    
    public Student(String name, int[] marks) {
        this.name = name;
        copyMarks(marks);
    }

    public Student(Student original) {
        this.name = original.name;
        copyMarks(original.marks);
    }

    private void copyMarks(int marks[]) {
        this.marks = new int[marks.length];
        for (int i = 0; i < marks.length; i++) {
            this.marks[i] = marks[i];
        }
    }

    public String getName() {
        return this.name;
    }

    public int getMarkByIndex(int index) {
        return this.marks[index];
    }

    public double calcAverage() {
        int sum = 0;
        for (int i = 0; i < this.marks.length; i++){
            sum += this.marks[i];
        }
        return 1.0*sum / this.marks.length;
    }
}

