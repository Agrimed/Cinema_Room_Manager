import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arraySize = scanner.nextInt();

        int[] firstArray = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            firstArray[i] = scanner.nextInt();
        }

        int[] secondArray = new int[2];

        for (int j = 0; j < 2; j++) {
            secondArray[j] = scanner.nextInt();
        }


        for (int i = 0; i < arraySize-1; i++) {
            if (
                    firstArray[i] == secondArray[0] & firstArray[i+1] == secondArray[1]
                    || firstArray[i] == secondArray[1] & firstArray[i+1] == secondArray[0]
            ) {
                System.out.println("true");
                return;
            }
        }
        System.out.println("false");
    }
}