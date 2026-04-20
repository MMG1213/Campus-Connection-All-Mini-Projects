import java.util.*;

class LibrarySystem {
    static Map<Integer, String> books = new HashMap<>();
    static Set<Integer> issued = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int id = 1;
        while (true) {
            System.out.println("1.Add 2.Issue 3.Return 4.View 5.Exit");
            int ch = sc.nextInt();
            sc.nextLine();
            if (ch == 1) {
                System.out.print("Enter book name: ");
                String name = sc.nextLine();
                books.put(id, name);
                System.out.println("Book ID: " + id);
                id++;
            } else if (ch == 2) {
                System.out.print("Enter book id: ");
                int b = sc.nextInt();
                if (books.containsKey(b) && !issued.contains(b)) {
                    issued.add(b);
                    System.out.println("Issued");
                } else {
                    System.out.println("Unavailable");
                }
            } else if (ch == 3) {
                System.out.print("Enter book id: ");
                int b = sc.nextInt();
                if (issued.contains(b)) {
                    issued.remove(b);
                    System.out.println("Returned");
                } else {
                    System.out.println("Not issued");
                }
            } else if (ch == 4) {
                for (int i : books.keySet()) {
                    if (issued.contains(i))
                        System.out.println(i + " " + books.get(i) + " (Issued)");
                    else
                        System.out.println(i + " " + books.get(i) + " (Available)");
                }
            } else {
                break;
            }
        }
    }
}
