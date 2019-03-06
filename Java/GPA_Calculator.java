import java.util.Scanner;

public class GPA_Calculator {
    private static String[] classes;
    private static double[] grades;

    public static void initiateClasses(int numClasses) {
        Scanner in = new Scanner(System.in);
        classes = new String[numClasses];
        grades = new double[numClasses];
        for (int i = 0; i < classes.length; i++) {
            System.out.printf("What is class %d? ", i+1);
            classes[i] = in.nextLine();
        }
        for (int i = 0; i < grades.length; i++) {
            System.out.printf("What is your current grade percentage for %s? ", classes[i]);
            grades[i] = in.nextDouble();
        }
    }

    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("How many classes are you taking? ");
        int x = in.nextInt();
        initiateClasses(x);
    }
}
