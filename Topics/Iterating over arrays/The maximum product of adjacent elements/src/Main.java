import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arraySize = scanner.nextInt();

        int[] array = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            array[i] = scanner.nextInt();
        }

        int max = 0;

        for (int i = 0; i < arraySize-1; i++) {
            int multiplication = array[i] * array[i+1];
            if (multiplication > max) {
                max = multiplication;
            }
        }
        System.out.println(max);
    }
}