package com.dwit.bean;

import java.util.Scanner;

/**
 * Created by Dell on 2/22/2018.
 */
public class AnimalGuessingGame {
    private static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {  /*The main method prints instructions and repeatedly plays the
                                                * animal-guessing game. As the game is played, the taxonomy tree
                                                 * grows by learning new animals.*/
        BTNode_lab1<String> root;

        question();
        root = beginning();
        do {
            play(root);
        } while (query("Do you wish to play again?"));

    }

    public static boolean query(String prompt) {  /*function to get the valid output from user if user enters invalid
                                                    answer*/
        String answer;

        System.out.print(prompt + " [Y or N]: ");
        answer = sc.nextLine().toUpperCase();
        while (!answer.startsWith("Y") && !answer.startsWith("N")) {
            System.out.print("Invalid response. Please type Y or N: ");
            answer = sc.nextLine().toUpperCase();
        }

        return answer.startsWith("Y");
    }


    public static void question() {
        System.out.println("************************************");
        System.out.println("*****Please think of an animal.*****");
        System.out.println("**I will ask some yes/no questions**");

        System.out.println("************************************");
    }


    public static void play(BTNode_lab1<String> current) {
        while (!current.isGuess()) {
            if (query(current.getData()))
                current = current.getLeft();
            else
                current = current.getRight();
        }

        System.out.print("My guess is " + current.getData() + ". ");
        if (!query("Am I right?"))
            learn(current);
        else {
            System.out.println("***********");
            System.out.println("*  I won! *");
            System.out.println("***********");
        }
    }


    public static BTNode_lab1<String> beginning() {    //Construct a small taxonomy tree with four animals.
        BTNode_lab1<String> root;
        BTNode_lab1<String> child;

        final String ROOT_QUESTION = "Does it fly?";
        final String LEFT_QUESTION = "is it bird?";
        final String RIGHT_QUESTION = "Does it live underwater?";
        final String ANIMAL1 = "pigeon";
        final String ANIMAL2 = "butterfly";
        final String ANIMAL3 = "fish";
        final String ANIMAL4 = "dog";

       // Create the root node with the question
        root = new BTNode_lab1<String>(ROOT_QUESTION, null, null);

        // Create and attach the left subtree.
        child = new BTNode_lab1<String>(LEFT_QUESTION, null, null);
        child.setLeft(new BTNode_lab1<String>(ANIMAL1, null, null));
        child.setRight(new BTNode_lab1<String>(ANIMAL2, null, null));
        root.setLeft(child);

        // Create and attach the right subtree.
        child = new BTNode_lab1<String>(RIGHT_QUESTION, null, null);
        child.setLeft(new BTNode_lab1<String>(ANIMAL3, null, null));
        child.setRight(new BTNode_lab1<String>(ANIMAL4, null, null));
        root.setRight(child);

        return root;
    }


    public static void learn(BTNode_lab1<String> current)

    {
        String guessAnimal;
        String correctAnimal;
        String newQuestion;

        guessAnimal = current.getData();
        System.out.println("I give up. What is the name of animal? ");
        correctAnimal = sc.nextLine();
        System.out.println("Please type a yes/no question that will distinguish a");
        System.out.println(correctAnimal + " from a " + guessAnimal + ".");
        newQuestion = sc.nextLine();

        current.setData(newQuestion);
        System.out.println("As a " + correctAnimal + ", " + newQuestion);
        if (query("Please answer")) {
            current.setLeft(new BTNode_lab1<String>(correctAnimal, null, null));
            current.setRight(new BTNode_lab1<String>(guessAnimal, null, null));
        } else {
            current.setLeft(new BTNode_lab1<String>(guessAnimal, null, null));
            current.setRight(new BTNode_lab1<String>(correctAnimal, null, null));
        }
    }

}
