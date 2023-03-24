package Main;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Играем в игру, я загадываю случайное число.\n" +
                "Программа делает свои попытки чтобы угадать число, потом ты пытаешься угадать число.\n" +
                "Чтобы облегчить тебе задачу, я буду говорить БОЛЬШЕ или МЕНЬШЕ.\n");

        Scanner sc = new Scanner(System.in);
        System.out.println("""
                \nВыбери сложность:
                1 - очень легко
                2 - легко
                3 - нормально 
                4 - тяжко
                5 - почти невозможно\n""");
        int slojnost = sc.nextInt();
        Random random = new Random();
        int randomNumber;
        int lowDiapozon = 1;
        int hihgDiapozon = 100;
        int choice = (lowDiapozon + hihgDiapozon) / 2;
        int counter = 0;
        randomNumber = random.nextInt(100) + 1;
        while (true) {
            if (choice > randomNumber) {
                hihgDiapozon = choice;
                choice = (lowDiapozon + hihgDiapozon) / 2;
                counter++;

            } else if (choice < randomNumber) {
                lowDiapozon = choice;
                choice = (lowDiapozon + hihgDiapozon) / 2;
                counter++;

            } else {
                counter++;
                break;
            }
        }
        switch (slojnost) {
            case 1 -> counter += 2;
            case 2 -> counter += 1;
            case 4 -> counter -= 1;
            case 5 -> counter -= 2;
        }
        System.out.println("Программа справилась за : " + counter + " попыток.");
        System.out.println("Посмотрим сколько тебе нужно будет попыток.");
        int playerCounter = 0;


        while (true) {
            System.out.println("\nТы делаешь - " + (playerCounter + 1) + " попытку.");
            System.out.print("Введи свое число: ");
            choice = sc.nextInt();
            if (choice > randomNumber) {
                System.out.println("Загаданное число МЕНЬШЕ.\n");
                playerCounter++;

            } else if (choice < randomNumber) {
                System.out.println("Загаданное число БОЛЬШЕ.\n");
                playerCounter++;

            } else {
                System.out.println("\nТЫ УГАДАЛ");
                playerCounter++;
                break;
            }
        }

        if (playerCounter > counter) {
            System.out.println("ИТОГ - Ты проебал программе.");
        }
        if (playerCounter < counter) {
            System.out.println("ИТОГ - Ты выиграл!!!");
        } else {
            System.out.println("ИТОГ - ничья");
        }
    }
}

