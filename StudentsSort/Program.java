/**
 * Created by Daniil on 08.11.2016.
 */
public class Program {

    public static void main(String[] args) {
        int marksOfMarsel[] = {1, 3, 3, 5, 2};
        int marksOfAnya[]   = {3, 5, 5, 5, 3};
        int marksOfMisha[]  = {4, 3, 4, 3, 4};
        int marksOfOleg[]   = {3, 4, 2, 3, 3};
        int marksOfAlmaz[]  = {5, 3, 5, 3, 4};

        Student students[] = new Student[5];
        students[0] = new Student("Anya",marksOfAnya);
        students[1] = new Student("Misha", marksOfMisha);
        students[2] = new Student("Oleg", marksOfOleg);
        students[3] = new Student("Almaz", marksOfAlmaz);
        students[4] = new Student("Marsel", marksOfMarsel);

        StudentsUtils.sort(students);

        for (int i = 0; i< students.length; i++){
            System.out.println(students[i].getName() + " " + students[i].calcAverage());
        }
    }
}
