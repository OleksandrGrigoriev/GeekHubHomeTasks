package org.homework2;

import java.util.Scanner;

public class Homework2 {

    private static final  String[] SUBJECT = {"Math", "Science", "History"};
    public static final int AMOUNT_OF_COLUMNS_IN_INFO_TABLE = 4;
    public static int AMOUNT_OF_ROWS_IN_INFO_TABLE;
    public static void main(String[] args) {
        if (args.length == 0 || args[0] == null || Integer.parseInt(args[0]) <= 0) {
            System.out.println("Please, provide number of students via commandline arguments (must be positive integer number)!");
            System.exit(1);
        }

        AMOUNT_OF_ROWS_IN_INFO_TABLE = Integer.parseInt(args[0]);

        int numberOfStudents = Integer.parseInt(args[0]);
        String[][] informationAboutStudents;

        informationAboutStudents = enterInformationAboutStudents(numberOfStudents);
        averageGradesOutput(informationAboutStudents);
    }

    public static String[][] enterInformationAboutStudents(int numberOfStudents) {
        Scanner scanner = new Scanner(System.in);
        String[][] result = new String[numberOfStudents][AMOUNT_OF_COLUMNS_IN_INFO_TABLE];

        for (int studentIndex = 1; studentIndex <= numberOfStudents; studentIndex++) {
            System.out.printf("Enter information for student #%d%n", studentIndex);
            for (int column = 0; column < AMOUNT_OF_COLUMNS_IN_INFO_TABLE; column++) {

                printMessageAboutInsertingData(column);

                result[studentIndex - 1][column] = scanner.nextLine();
                if (column == 0 && (result[studentIndex - 1][column].isBlank())) {
                    System.out.println("Enter a correct name (non empty string)!");
                    column--;
                } else if (column != 0){
                    int grade = Integer.parseInt(result[studentIndex - 1][column]);
                    if (grade < 0 || grade > 100) {
                        System.out.println("Enter correct grade (0 - 100)!");
                        column--;
                    }
                }
            }
        }
        scanner.close();
        return result;
    }

    public static void averageGradesOutput(String[][] informationAboutStudents) {
        System.out.println();
        System.out.println("Average grade for Each Student:");
        for (int studentIndex = 0; studentIndex < informationAboutStudents.length; studentIndex++) {
            System.out.print(informationAboutStudents[studentIndex][0] + ": ");
            int averageGrade = 0;
            for (int gradeColumn = 1; gradeColumn < informationAboutStudents[studentIndex].length; gradeColumn++) {
                averageGrade += Integer.parseInt(informationAboutStudents[studentIndex][gradeColumn]);
            }
            System.out.println(averageGrade/SUBJECT.length);
        }

        System.out.println();

        System.out.println("Average grade for Each Subject:");
        for (int columnInTable = 1; columnInTable < AMOUNT_OF_COLUMNS_IN_INFO_TABLE; columnInTable++) {
            System.out.print(SUBJECT[columnInTable - 1] + ": ");
            int averageGrade = 0;
            for (int studentIndex = 0; studentIndex < informationAboutStudents.length; studentIndex++) {
                averageGrade += Integer.parseInt(informationAboutStudents[studentIndex][columnInTable]);
            }
            System.out.println(averageGrade/(double)informationAboutStudents.length);
        }
    }

    public static void printMessageAboutInsertingData(int columnOfInfoTable) {
        if (columnOfInfoTable == 0) {
            System.out.print("Student's name: ");
        }
        if (columnOfInfoTable == 1) {
            System.out.print("Math grade (0 - 100): ");
        }
        if (columnOfInfoTable == 2) {
            System.out.print("Science grade (0 - 100): ");
        }
        if (columnOfInfoTable == 3) {
            System.out.print("History grade (0 - 100): ");
        }
    }
}

