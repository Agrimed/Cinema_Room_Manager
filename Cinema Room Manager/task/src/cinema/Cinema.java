package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args){
        Application app = new Application();
        app.run();
    }
}

class Application {
    private final static int priceForFront = 10;
    private final static int priceForBack = 8;
    private final static int fixPrice = 10;
    private final Scanner scanner = new Scanner(System.in);
    private int numberOfRows = 0;
    private int numberOfSeats = 0;
    private int income = 0;
    private int currentIncome = 0;
    
    //-- DataSource (Persistence)  -----------------------
    private char[][] array;
    
    //-- Controller (Business Logic) ----------------
    
    
    //-- View ----------------------------

    private int getPurchasedTickets(){
        int amount = 0;

        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                if(isBooked(i, j)) amount++;
            }
        }
        return amount;
    }

    private float getPurchasedPercentage(){
        int amount = getPurchasedTickets();
        return (float) (amount*100)/(numberOfRows*numberOfSeats);
    }
    
    private int getTotalIncome(){

        if(numberOfSeats * numberOfRows <= 60){
            return numberOfRows * numberOfSeats * fixPrice;
        }

        int frontHalf = numberOfRows / 2;
        int valueOfFront = frontHalf * numberOfSeats * priceForFront;
        int backHalf = numberOfRows - frontHalf;
        int valueOfBack = backHalf * numberOfSeats * priceForBack;
        return valueOfBack + valueOfFront;
    }

    private boolean isBooked(int row, int seat){
        return array[row][seat] == 'B';
    }



    private int getPrice(int numberOfBookedRow) {

        int amountOfSeats = numberOfSeats * numberOfRows;
        if(amountOfSeats <= 60) { return fixPrice; }

        boolean isFrontHalf = numberOfBookedRow <= numberOfRows / 2;
        if (isFrontHalf){ return priceForFront; }

        return priceForBack;
        
    }

    private void printStatistic(){
        System.out.println();
        System.out.println("Number of purchased tickets: " + getPurchasedTickets());
        System.out.printf("Percentage: %.2f%%\n", getPurchasedPercentage());
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + getTotalIncome());
    }

    private void createCinema() {
        System.out.println("Enter the number of rows: ");
        numberOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row: ");
        numberOfSeats = scanner.nextInt();

        array = new char[numberOfRows][numberOfSeats];
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                array[i][j] = 'S';
            }
        }
    }

    private void bookedSeats(int bookedRaw, int bookedSeat) {
        array[bookedRaw-1][bookedSeat-1] = 'B';
    }

    private boolean isRowCorrect(int row, int seat){
        return (row > 0 && row <= numberOfRows) && (seat > 0 && seat <= numberOfRows);
    }

    private void buyTicket(){

        int bookedRaw;
        int bookedSeat;

        while (true) {
            System.out.print("Enter a row number:\n> ");
            bookedRaw = scanner.nextInt();
            System.out.print("Enter a seat number in that row:\n> ");
            bookedSeat = scanner.nextInt();
            if (!isRowCorrect(bookedRaw, bookedSeat)) {
                System.out.println("Wrong input!");
                continue;
            }
            if (isBooked(bookedRaw - 1, bookedSeat - 1)) {
                System.out.println("That ticket has already been purchased!");
                continue;
            }
            break;
        }
        bookedSeats(bookedRaw, bookedSeat);
        int price = getPrice(bookedRaw);
        currentIncome += price;
        System.out.println("Ticket price: $" + price);
    }

    private void printCinema(){
        System.out.println();
        System.out.println("Cinema:");
        
        System.out.print("  ");
        for(int i = 1; i < array[0].length + 1; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i = 0; i < array.length; i++){
            System.out.print(i + 1 + " ");
            for(int j = 0; j < array[i].length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    private int selectMenuItem() {
        System.out.println();
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");

        return scanner.nextInt();
    }
    public void run(){
        createCinema();


        int variant = -1;

        while(variant != 0){
            variant = selectMenuItem();
                    
            switch(variant) {
                case 1:
                    printCinema();
                    break;
                case 2:
                    buyTicket();
                    break;
                case 3:
                    printStatistic();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Wrong Number");
            }
        }
    }
}
