import java.util.Scanner;

public class NumberSeries {

    public static long getRoomNumber(int busId, int seatId) {
        return (long) (0.5 * (busId + seatId) * (busId + seatId + 1) + seatId);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of buses (include Bus 0 for existing guests): ");
        int numBuses = scanner.nextInt();

        System.out.print("Enter number of people per bus: ");
        int peoplePerBus = scanner.nextInt();

        System.out.println("\n--- Room Assignments ---");
        for (int b = 0; b < numBuses; b++) {
            for (int s = 1; s <= peoplePerBus; s++) {
                long room = getRoomNumber(b, s);
                System.out.printf("Bus %d, Seat %d -> Room %d\n", b, s, room);
            }
        }

        scanner.close();
    }
}
