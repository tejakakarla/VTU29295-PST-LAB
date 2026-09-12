/*
 * WEEK 7 - TASK 10
 * Problem: Throne Inheritance
 * Platform: LeetCode 1600
 *
 * Question:
 * Design a throne inheritance system supporting birth, death, and retrieval of
 * the current inheritance order. A person's children appear immediately after
 * that person and are ordered by birth; deceased people are skipped.
 *
 * Solution:
 * Store each person's children in birth order and maintain a set of dead names.
 * Perform a depth-first traversal from the king, adding living people to the
 * inheritance order before recursively visiting their children.
 */

import java.util.*;

class ThroneInheritance {
    private final String kingName;
    private final Map<String, List<String>> children = new HashMap<>();
    private final Set<String> dead = new HashSet<>();

    public ThroneInheritance(String kingName) {
        this.kingName = kingName;
        children.put(kingName, new ArrayList<>());
    }

    public void birth(String parentName, String childName) {
        children.computeIfAbsent(parentName, k -> new ArrayList<>()).add(childName);
        children.putIfAbsent(childName, new ArrayList<>());
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        dfs(kingName, order);
        return order;
    }

    private void dfs(String person, List<String> order) {
        if (!dead.contains(person)) {
            order.add(person);
        }

        for (String child : children.getOrDefault(person, Collections.emptyList())) {
            dfs(child, order);
        }
    }
}
