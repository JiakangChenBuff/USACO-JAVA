import java.util.*;
public class invite {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int G = sc.nextInt();

        Queue<Integer> invited = new LinkedList<>();
        boolean[] vis = new boolean[N + 1];

        ArrayList<HashSet<Integer>> groups = new ArrayList<HashSet<Integer>>();
        for (int i = 0; i < G; i++) {
            int c = sc.nextInt();
            HashSet<Integer> curr = new HashSet<>();
            for (int j = 0; j < c; j++) {
                curr.add(sc.nextInt());
            }
            if (c == 1) {
                for (Integer cow : curr) {
                    vis[cow] = true;
                    invited.add(cow);
                }
            }
            groups.add(curr);
        }

        HashMap<Integer, ArrayList<HashSet<Integer>>> cowToGroups = new HashMap<>();
        for (HashSet<Integer> group : groups) {
            for (Integer cow : group) {
                ArrayList<HashSet<Integer>> arr = cowToGroups.getOrDefault(cow, new ArrayList<>());
                arr.add(group);
                cowToGroups.put(cow, arr);
            }
        }

        invited.add(1);
        int count = 0;
        while (!invited.isEmpty()) {
            int curr = invited.poll();
            count++;
            for (HashSet<Integer> group : cowToGroups.get(curr)) {
                group.remove(curr);
                if (group.size() == 1) {
                    for (Integer cow : group) {
                        if (!vis[cow]) {
                            vis[cow] = true;
                            invited.add(cow);
                        }
                    }
                }
            }
        }
        System.out.println(count);
        sc.close();
    }
}
