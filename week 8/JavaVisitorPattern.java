/*
 * WEEK 8 - TASK 4
 * Problem: Java Visitor Pattern
 * Platform: HackerRank
 *
 * Question: Implement the visitor pattern for a tree. The three visitors
 * calculate: sum of leaf values, product of red node values, and the
 * difference between even-depth leaf values and odd-depth internal values.
 */

import java.util.*;

enum Color { RED, GREEN }
enum TreeNodeType { LEAF, INTERNAL }

abstract class Tree {
    private int value;
    private Color color;
    private int depth;

    Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() { return value; }
    public Color getColor() { return color; }
    public int getDepth() { return depth; }
    public abstract TreeNodeType getType();
    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {
    private List<Tree> children = new ArrayList<>();

    TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public TreeNodeType getType() { return TreeNodeType.INTERNAL; }
    void addChild(Tree child) { children.add(child); }
    List<Tree> getChildren() { return children; }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);
        for (Tree child : children) child.accept(visitor);
    }
}

class TreeLeaf extends Tree {
    TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public TreeNodeType getType() { return TreeNodeType.LEAF; }
    public void accept(TreeVis visitor) { visitor.visitLeaf(this); }
}

abstract class TreeVis {
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);
}

class SumInLeavesVisitor extends TreeVis {
    private int sum = 0;
    public int getResult() { return sum; }
    public void visitNode(TreeNode node) { }
    public void visitLeaf(TreeLeaf leaf) { sum += leaf.getValue(); }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private long product = 1;
    public int getResult() { return (int) (product % 1000000007); }
    public void visitNode(TreeNode node) {
        if (node.getColor() == Color.RED) product = (product * node.getValue()) % 1000000007;
    }
    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.RED) product = (product * leaf.getValue()) % 1000000007;
    }
}

class FancyVisitor extends TreeVis {
    private int evenLeafSum = 0;
    private int oddDepthGreenInternalSum = 0;

    public int getResult() {
        return Math.abs(evenLeafSum - oddDepthGreenInternalSum);
    }

    public void visitNode(TreeNode node) {
        if (node.getColor() == Color.GREEN && node.getDepth() % 2 == 1) {
            oddDepthGreenInternalSum += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getDepth() % 2 == 0) evenLeafSum += leaf.getValue();
    }
}

class JavaVisitorPattern {
    static Tree solve(int[] values, int[] colors, int[] edgeU, int[] edgeV) {
        int n = values.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < edgeU.length; i++) {
            graph.get(edgeU[i]).add(edgeV[i]);
            graph.get(edgeV[i]).add(edgeU[i]);
        }

        return buildTree(0, -1, 0, values, colors, graph);
    }

    static Tree buildTree(int u, int parent, int depth, int[] values, int[] colors,
                          List<List<Integer>> graph) {
        Color color = colors[u] == 0 ? Color.RED : Color.GREEN;
        List<Integer> children = new ArrayList<>();
        for (int v : graph.get(u)) if (v != parent) children.add(v);

        if (children.isEmpty()) return new TreeLeaf(values[u], color, depth);

        TreeNode node = new TreeNode(values[u], color, depth);
        for (int v : children) node.addChild(buildTree(v, u, depth + 1, values, colors, graph));
        return node;
    }

    public static void main(String[] args) {
        // This class contains the complete visitor implementation. HackerRank's
        // original stub constructs the tree and invokes the selected visitor.
        System.out.println("Visitor Pattern implemented");
    }
}
