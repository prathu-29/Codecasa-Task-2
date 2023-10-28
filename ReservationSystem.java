import java.util.Scanner;

class ReservationSystem {
    private static class Reservation {
        private String passengerName;
        private int trainNumber;
        private String classType;

        public Reservation(String passengerName, int trainNumber, String classType) {
            this.passengerName = passengerName;
            this.trainNumber = trainNumber;
            this.classType = classType;
        }
    }

    private static Reservation[] reservations = new Reservation[100];
    private static int reservationCount = 0;

    public static void makeReservation(String passengerName, int trainNumber, String classType) {
        Reservation reservation = new Reservation(passengerName, trainNumber, classType);
        reservations[reservationCount++] = reservation;
    }

    public static void cancelReservation(int pnrNumber) {
        System.out.println("Cancellation requested for PNR number: " + pnrNumber);
    }
}

class BookingTheTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your login ID: ");
        String loginId = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        System.out.print("Enter your name: ");
        String passengerName = scanner.nextLine();
        System.out.print("Enter train number: ");
        int trainNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter class type: ");
        String classType = scanner.nextLine();

        ReservationSystem.makeReservation(passengerName, trainNumber, classType);
        System.out.println("Reservation is successfully completed");
        System.out.print("Do you want to cancel a reservation? (yes/no): ");
        String cancelChoice = scanner.nextLine().toLowerCase();

        if (cancelChoice.equals("yes")) {
            System.out.print("Enter PNR number for cancellation: ");
            int pnrNumber = scanner.nextInt();
            scanner.nextLine();
            ReservationSystem.cancelReservation(pnrNumber);
        }

        scanner.close();
    }
}