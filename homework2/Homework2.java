package org.homework2;

import java.util.Scanner;

public class Homework2 {
    public static void main(String[] args) {
        if (args.length == 0 || args[0] == null || Integer.parseInt(args[0]) <= 0) {
            System.out.println("Please, provide number of students via commandline arguments (must be positive integer number)!");
            System.exit(1);
        }

        int numberOfStudents = Integer.parseInt(args[0]);
        String[][] informationAboutStudents;

        informationAboutStudents = enterInformationAboutStudents(numberOfStudents);
        averageGrades(informationAboutStudents);
    }

    public static String[][] enterInformationAboutStudents(int numberOfStudents) {
        Scanner scanner = new Scanner(System.in);
        String[][] result = new String[numberOfStudents][4];

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.printf("Enter information for student #%d%n", i + 1);
            for (int j = 0; j < 4; j++) {

                printMessage(j);

                result[i][j] = scanner.nextLine();
                if (j == 0 && (result[i][j].isEmpty() || result[i][j].isBlank())) {
                    System.out.println("Enter a correct name (non empty string)!");
                    j--;
                } else if (j != 0){
                    int grade = Integer.parseInt(result[i][j]);
                    if (grade < 0 || grade > 100) {
                        System.out.println("Enter correct grade (0 - 100)!");
                        j--;
                    }
                }
            }
        }
        scanner.close();
        return result;
    }

    public static void averageGrades(String[][] informationAboutStudents) {
        System.out.println();
        System.out.println("Average grade for Each Student:");
        for (int i = 0; i < informationAboutStudents.length; i++) {
            System.out.print(informationAboutStudents[i][0] + ": ");
            int averageGrade = 0;
            for (int j = 1; j < informationAboutStudents[i].length; j++) {
                averageGrade += Integer.parseInt(informationAboutStudents[i][j]);
            }
            System.out.println(averageGrade/3.0);
        }

        System.out.println();
        String[] subject = {"Math", "Science", "History"};
        System.out.println("Average grade for Each Subject:");
        for (int j = 1; j < informationAboutStudents[0].length; j++) {
            System.out.print(subject[j - 1] + ": ");
            int averageGrade = 0;
            for (int i = 0; i < informationAboutStudents.length; i++) {
                averageGrade += Integer.parseInt(informationAboutStudents[i][j]);
            }
            System.out.println(averageGrade/(double)informationAboutStudents.length);
        }
    }

    public static void printMessage(int argument) {
        if (argument == 0) {
            System.out.print("Student's name: ");
        }
        if (argument == 1) {
            System.out.print("Math grade (0 - 100): ");
        }
        if (argument == 2) {
            System.out.print("Science grade (0 - 100): ");
        }
        if (argument == 3) {
            System.out.print("History grade (0 - 100): ");
        }
    }
}

