import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int raws = scanner.nextInt();
        int column = scanner.nextInt();

        int[][] array = new int[raws][column];
        for (int i = 0; i < raws; i++) {
            for (int j = 0; j < column; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        int[][] newArray = new int[column][raws];
        for (int i = 0; i < column; i++) {
            for (int j = raws - 1; j >= 0; j--) {
                newArray[i][j] = array[j][i];
                System.out.print(newArray[i][j] + " ");
            }
            System.out.println();
        }

    }
}