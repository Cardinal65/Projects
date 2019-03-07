import java.util.Scanner;

public class GPA_Calculator {
    public static final double AP = 4.3;
    public static final double A = 4;
    public static final double AM = 3.7;
    public static final double BP = 3.3;
    public static final double B = 3;
    public static final double BM = 2.7;
    public static final double CP = 2.3;
    public static final double C = 2;
    public static final double CM = 1.7;
    public static final double DP = 1.3;
    public static final double D = 1;
    public static final double DM = .7;
    public static final double F = 0;
    private static String[] classes;
    private static int[] credits;
    private static double[] grades;

    public static void initiateClasses(int numClasses) {
        Scanner in = new Scanner(System.in);
        classes = new String[numClasses];
        grades = new double[numClasses];
        credits = new int[numClasses];
        for (int i = 0; i < classes.length; i++) {
            System.out.printf("What is class %d? ", i+1);
            classes[i] = in.nextLine();
            System.out.printf("Credits? ");
            credits[i] = in.nextInt();
            String overflow = in.nextLine();
        }
        for (int i = 0; i < grades.length; i++) {
            System.out.printf("What is your current grade for %s? ", classes[i]);
            grades[i] = in.nextDouble();
        }
    }

    private static void printGradeChart() {
      System.out.printf("A+ = %.2f\n", AP);
      System.out.printf("A  = %.2f\n", A);
      System.out.printf("A- = %.2f\n", AM);
      System.out.printf("B+ = %.2f\n", BP);
      System.out.printf("B  = %.2f\n", B);
      System.out.printf("B- = %.2f\n", BM);
      System.out.printf("C+ = %.2f\n", CP);
      System.out.printf("C  = %.2f\n", C);
      System.out.printf("C- = %.2f\n", CM);
      System.out.printf("D+ = %.2f\n", DP);
      System.out.printf("D  = %.2f\n", D);
      System.out.printf("D- = %.2f\n", DM);
      System.out.printf("F  = %.2f\n", F);
    }

    private static double calculateGPA() {
        double gpa = -1;
        int totalCredits = 0;
        double totalPoints = 0;
        for (int i = 0; i < classes.length; i++) {
            totalCredits += credits[i];
            totalPoints += grades[i]*credits[i];
        }

        gpa = totalPoints/totalCredits;
        //returns -1 if an error occured
        return gpa;
    }

    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("How many classes are you taking? ");
        int x = in.nextInt();
        printGradeChart();
        initiateClasses(x);
        System.out.printf("Your current GPA is %.2f", calculateGPA());
    }
}
