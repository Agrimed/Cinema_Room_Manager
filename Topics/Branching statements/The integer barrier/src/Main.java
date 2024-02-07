import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final int border = 1000;
        Scanner scanner = new Scanner(System.in);
        int summ = 0;
        while (true) {
            int num = scanner.nextInt();
            summ += num;
            if (num == 0) {
                System.out.println(summ);
                break;
            } else if (summ >= border) {
                System.out.println(summ - border);
                break;
            }
        }
    }
}