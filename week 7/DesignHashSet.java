/*
 * WEEK 7 - TASK 5
 * Problem: Design HashSet
 * Platform: LeetCode 705
 *
 * Question:
 * Design a HashSet without using Java's built-in HashSet. Support add, remove,
 * and contains for integer keys.
 *
 * Solution:
 * Use a boolean array because the problem's key range is bounded from 0 to
 * 1,000,000. A true value means the key is present.
 */

class MyHashSet {
    private final boolean[] present;

    public MyHashSet() {
        present = new boolean[1_000_001];
    }

    public void add(int key) {
        present[key] = true;
    }

    public void remove(int key) {
        present[key] = false;
    }

    public boolean contains(int key) {
        return present[key];
    }
}
