/*
 * WEEK 7 - TASK 4
 * Problem: Design Browser History
 * Platform: LeetCode 1472
 *
 * Question:
 * Design a browser history supporting visit, back, and forward operations.
 *
 * Solution:
 * Use an ArrayList and an index representing the current page. When a new
 * page is visited, remove all forward history and append the new page.
 */

import java.util.*;

class BrowserHistory {
    private final List<String> history = new ArrayList<>();
    private int current = 0;

    public BrowserHistory(String homepage) {
        history.add(homepage);
    }

    public void visit(String url) {
        while (history.size() > current + 1) {
            history.remove(history.size() - 1);
        }
        history.add(url);
        current++;
    }

    public String back(int steps) {
        current = Math.max(0, current - steps);
        return history.get(current);
    }

    public String forward(int steps) {
        current = Math.min(history.size() - 1, current + steps);
        return history.get(current);
    }
}
