import java.util.*;

class FriendSuggestion {
    static Map<String, Set<String>> graph = new HashMap<>();

    static void addUser(String u) {
        graph.putIfAbsent(u, new HashSet<>());
    }

    static void addFriend(String u, String v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    static void suggest(String user) {
        Set<String> friends = graph.get(user);
        Set<String> suggestions = new HashSet<>();
        for (String f : friends) {
            for (String ff : graph.get(f)) {
                if (!ff.equals(user) && !friends.contains(ff)) {
                    suggestions.add(ff);
                }
            }
        }
        System.out.println(suggestions);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1.AddUser 2.AddFriend 3.Suggest 4.Exit");
            int ch = sc.nextInt();
            if (ch == 1) {
                addUser(sc.next());
            } else if (ch == 2) {
                String u = sc.next(), v = sc.next();
                addUser(u);
                addUser(v);
                addFriend(u, v);
            } else if (ch == 3) {
                suggest(sc.next());
            } else break;
        }
    }
}
