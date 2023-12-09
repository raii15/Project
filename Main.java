package com.example.architectureproject;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class PersonalityTest {
    static int questionNumber = 1;

    public static void main(String[] args) {
        String[] extroversionVsIntroversionTest;
        String[] sensingVsIntuitionTest;
        String[] thinkingVsFeelingTest;
        String[] judgingVsPerceivingTest;

        try {
            extroversionVsIntroversionTest = readQuestionsFromFile("extroversion_vs_introversion.txt");
            sensingVsIntuitionTest = readQuestionsFromFile("sensing_vs_intuition.txt");
            thinkingVsFeelingTest = readQuestionsFromFile("thinking_vs_feeling.txt");
            judgingVsPerceivingTest = readQuestionsFromFile("judging_vs_perceiving.txt");

            int[] extrovertVsIntrovertAnswersStorage = new int[5];
            int[] sensingVsIntuitionsAnswersStorage = new int[5];
            int[] thinkingVsFeelingAnswersStorage = new int[5];
            int[] judgingVsPerceivingAnswersStorage = new int[5];

            StringBuilder result = new StringBuilder();

            iterate(extroversionVsIntroversionTest, extrovertVsIntrovertAnswersStorage);
            iterate(sensingVsIntuitionTest, sensingVsIntuitionsAnswersStorage);
            iterate(thinkingVsFeelingTest, thinkingVsFeelingAnswersStorage);
            iterate(judgingVsPerceivingTest, judgingVsPerceivingAnswersStorage);
            int sumOfAsInExtroversion = sum(extrovertVsIntrovertAnswersStorage);
            int sumOfAsInSensing = sum(sensingVsIntuitionsAnswersStorage);
            int sumOfAsInThinking = sum(thinkingVsFeelingAnswersStorage);
            int sumOfAsInJudging = sum(judgingVsPerceivingAnswersStorage);


            // append personality type accordingly
            if (sumOfAsInExtroversion < 3) result.append("I");
            else {
                result.append("E");
            }

            if (sumOfAsInSensing < 3) result.append("N");
            else {
                result.append("S");
            }

            if (sumOfAsInThinking < 3) result.append("F");
            else {
                result.append("T");
            }

            if(sumOfAsInJudging < 3) result.append("P");
            else{
                result.append("J");
            }


            // print personality results in a table.
            System.out.println("\nYour choice at a glance\n");
            System.out.printf("|%5s | %3s | %3s | %3s | %3s | %3s | %3s | %3s | %3s | %3s | %3s | %3s |%n", " ", "A", "B",
                    " ", "A", "B", " ", "A", "B", " ", "A", "B");
            int numbering = 1;
            System.out.printf("%s%n", "-".repeat(74));
            for (int i = 0; i< extrovertVsIntrovertAnswersStorage.length; i++) {
                System.out.printf("|%5d | %3s | %3s | %3d | %3s | %3s | %3d | %3s | %3s | %3d | %3s | %3s |%n", numbering++,
                        placeCheckmark(extrovertVsIntrovertAnswersStorage[i],1),
                        placeCheckmark(extrovertVsIntrovertAnswersStorage[i], 2),
                        numbering++, placeCheckmark(sensingVsIntuitionsAnswersStorage[i], 1),
                        placeCheckmark(sensingVsIntuitionsAnswersStorage[i], 2),
                        numbering++,
                        placeCheckmark(thinkingVsFeelingAnswersStorage[i], 1),
                        placeCheckmark(thinkingVsFeelingAnswersStorage[i], 2), numbering++,
                        placeCheckmark(judgingVsPerceivingAnswersStorage[i], 1),
                        placeCheckmark(judgingVsPerceivingAnswersStorage[i], 2));
            }

            System.out.printf("%s%n", "-".repeat(74));
            System.out.printf("|%5s | %3d | %3d | %3s | %3d | %3d | %3s | %3d | %3d | %3s | %3d | %3d |%n", "TOTAL",
                    countNumbers(extrovertVsIntrovertAnswersStorage, 1), countNumbers(extrovertVsIntrovertAnswersStorage, 0),
                    " ", countNumbers(sensingVsIntuitionsAnswersStorage, 1), countNumbers(sensingVsIntuitionsAnswersStorage, 0), " ",
                    countNumbers(thinkingVsFeelingAnswersStorage, 1),
                    countNumbers(thinkingVsFeelingAnswersStorage, 0), " ",
                    countNumbers(judgingVsPerceivingAnswersStorage, 1), countNumbers(judgingVsPerceivingAnswersStorage, 0));
            System.out.printf("%s%n", "-".repeat(74));
            System.out.printf("|%5s | %3s | %3s | %3s | %3s | %3s | %3s | %3s | %3s | %3s | %3s | %3s |%n", " ", "E", "I",
                    " ", "S", "N", " ", "T", "F", " ", "J", "P");

            System.out.println("Your personality type is " + result);
            System.out.print("For your personality interpretation, visit : ");
            System.out.println("https://www.truity.com/page/16-personality-types-myers-briggs");



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String[] readQuestionsFromFile(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        StringBuilder stringBuilder = new StringBuilder();

        while (scanner.hasNextLine()) {
            stringBuilder.append(scanner.nextLine()).append("\n");
        }

        scanner.close();
        return stringBuilder.toString().split("\n");
    }

    public static void iterate(String[] questions, int[] answers) {
        Scanner scanner = new Scanner(System.in);
        String optionAorB;
        for (int number = 0; number < questions.length; number++) {
            System.out.printf("Question %d%n", questionNumber++);
            System.out.println(questions[number]);
            System.out.println("Pick an option: A(agree) or B(disagree)");
            optionAorB = getOption(scanner);
            if ((optionAorB.equalsIgnoreCase("A"))) {
                answers[number] = 1;
            }
        }
    }



    public static String getOption(Scanner input) {
        String option;
        while (true) {
            try {
                option = input.nextLine();
                if (option.trim().equalsIgnoreCase("A".trim()) || option.trim().equalsIgnoreCase("B".trim())) {
                    return option;
                } else {
                    throw new IllegalArgumentException("Wrong choice; choose A or B");
                }
            } catch (IllegalArgumentException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }





    public static String placeCheckmark(int num, int position){
        return (num == 1 && position == 1) || (num == 0 && position == 2) ? String.format("%c", '\u2713') : "";
    }







    public static int sum(int[] intArrays){
        int sum = 0;
        for(int number : intArrays) sum += number;
        return sum;
    }


    public static int countNumbers(int[] numArray, int number){
        int count = 0;
        for(int num : numArray){
            if(num == number) count++;
        }
        return count;
    }



}


