import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    ArrayList<Integer> grades = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    void addGrade(int grade) {
        grades.add(grade);
    }

    double getAverage() {
        int sum = 0;
        for (int g : grades) sum += g;
        return grades.isEmpty() ? 0 : (double) sum / grades.size();
    }

    int getHighest() {
        int max = grades.get(0);
        for (int g : grades) if (g > max) max = g;
        return max;
    }

    int getLowest() {
        int min = grades.get(0);
        for (int g : grades) if (g < min) min = g;
        return min;
    }

    void displayReport() {
        System.out.println("\n--- Student Report ---");
        System.out.println("Name      : " + name);
        System.out.println("Grades    : " + grades);
        System.out.println("Average   : " + getAverage());
        System.out.println("Highest   : " + getHighest());
        System.out.println("Lowest    : " + getLowest());
    }
}

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter student name: ");
            String name = sc.nextLine();

            Student s = new Student(name);

            System.out.print("Enter number of subjects: ");
            int sub = sc.nextInt();

            for (int j = 0; j < sub; j++) {
                System.out.print("Enter grade for subject " + (j + 1) + ": ");
                int grade = sc.nextInt();
                s.addGrade(grade);
            }
            sc.nextLine();

            students.add(s);
        }

        System.out.println("\n======= SUMMARY REPORT =======");
        for (Student s : students) {
            s.displayReport();
        }
    }
}