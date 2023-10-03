package BubbleSort;
import java.util.Random;
import java.util.Scanner;

/* 1.Keep your program decomposed. Implement methods for such tasks:
        1.Array output
        2.Creation of an array of given length with random values
        3.Creation of an array of given length with values from user input
        4.Bubble sort method
   2.Create main method with such flow:
        1.Ask user to input number of elements.
        2.Ask if user wants to generate values or input by himself/herself.
        3.Create an array in a chosen way.
        4.Output given array.
        5.Sort the array.
        6.Output sorted array.
        7.Ask if user wants to repeat (from #1).*/
public class Main {
    //Part1.1
    public static void printArray(int[] array) {
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
    //Part1.2
    public static int[] randomArray(int size) {
        Random random = new Random();
        int[] randomArray = new int[size];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(101);
        }
        return randomArray;
    }
    //Part1.3
        public static int[] inputArray(int size){
            Scanner in = new Scanner(System.in);
            int[] array = new int[size];
            System.out.println("Enter elements of array: ");
            for (int i=0;i<size;i++){
                array[i] = in.nextInt();
            }
            return array;
        }
    //Part1.4
    static void bubbleSort(int[] array, int size)
    {
        int temp;
        boolean swapped;
        for (int i = 0; i < size - 1; i++) {
            swapped = false;
            for (int j = 0; j < size - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }

    //Extra
    //Reading user String input
    public static String getUserString() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
    //Reading user Sting input adding possible question
    public static String getUserString(String caption) {
        System.out.println(caption);
        return getUserString();
    }
    //Reading user answer to question with yes/no answer
    public static boolean getUserAnswer(String question) {
        String input = getUserString(question + " (Y/N):");
        return input.equalsIgnoreCase("Y");
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] array;
        do {
            System.out.println("Please decide number of elements you want in array: ");
            int size = in.nextInt();
            in.nextLine();
            if (getUserAnswer("Do you want to enter array manually ")) {
                array = inputArray(size);
            } else {
                array = randomArray(size);
            }
            printArray(array);
            bubbleSort(array, size);
            printArray(array);
        }
        while (getUserAnswer("Do you want to repeat: "));


        }


    }
/*  Without Optimization:
    Initial array 21 37 72 13 42
    Outer loop, iteration 1:
    21 37 72 13 42
    Inner loop:
    Iteration 1: (21) (37) 72 13 42
    Iteration 2: 21 (37) (72) 13 42
    Iteration 3: 21 37 (13) (72) 42
    Iteration 4: 21 37 13 (42) (72)

    Outer loop, iteration 2:
    21 37 13 42 72
    Iteration 1: (21) (37) 13 42 72
    Iteration 2: 21 (13) (37) 42 72
    Iteration 3: 21 13 (37) (42) 72
    Iteration 4: 21 13 37 (42) (72)

    Outer loop, iteration 3:
    21 13 37 42 72
    Iteration 1: (13) (21) 37 42 72
    Iteration 2: 13 (21) (37) 42 72
    Iteration 3: 13 21 (37) (42) 72
    Iteration 4: 13 21 37 (42) (72)

    Outer loop, iteration 4:
    21 13 37 42 72
    Iteration 1: (13) (21) 37 42 72
    Iteration 2: 13 (21) (37) 42 72
    Iteration 3: 13 21 (37) (42) 72
    Iteration 4: 13 21 37 (42) (72)

    Outer loop, iteration 5:
    21 13 37 42 72
    Iteration 1: (13) (21) 37 42 72
    Iteration 2: 13 (21) (37) 42 72
    Iteration 3: 13 21 (37) (42) 72
    Iteration 4: 13 21 37 (42) (72)

    With optimization:
    Initial array 21 37 72 13 42
    Outer loop, iteration 1:
    21 37 72 13 42
    Inner loop:
    Iteration 1: (21) (37) 72 13 42
    Iteration 2: 21 (37) (72) 13 42
    Iteration 3: 21 37 (13) (72) 42
    Iteration 4: 21 37 13 (42) (72)

    Outer loop, iteration 2:
    21 37 13 42 72
    Iteration 1: (21) (37) 13 42 72
    Iteration 2: 21 (13) (37) 42 72
    Iteration 3: 21 13 (37) (42) 72

    Outer loop, iteration 3:
    21 13 37 42 72
    Iteration 1: (13) (21) 37 42 72
    Iteration 2: 13 (21) (37) 42 72

    Outer loop, iteration 4:
    21 13 37 42 72
    Iteration 1: (13) (21) 37 42 72

 */