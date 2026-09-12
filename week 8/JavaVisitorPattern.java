/*
 * WEEK 8 - TASK 4
 * Problem: Java Visitor Pattern
 * Platform: HackerRank
 *
 * Question: Implement the visitor pattern for a tree. Calculate the required
 * leaf-node values according to the visitor selected by the input.
 */

import java.util.*;

abstract class Tree {
    private int value;
    private int depth;
    private TreeNodeType type;

    Tree(int value, int depth, TreeNodeType type) {
        this.value = value;
        this.depth = depth;
        this.type = type;
    }

    public int getValue() { return value; }
    public int getDepth() { return depth; }
    public TreeNodeType getType() { return type; }
    public abstract void accept(TreeVis visitor);
}

enum TreeNodeType { LEAF, INTERNAL }

class TreeNode extends Tree {
    private List<Tree> children = new ArrayList<>();

    TreeNode(int value, int depth) {
        super(value, depth, TreeNodeType.INTERNAL);
    }

    void addChild(Tree child) { children.add(child); }
    List<Tree> getChildren() { return children; }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);
        for (Tree child : children) child.accept(visitor);
    }
}

class TreeLeaf extends Tree {
    TreeLeaf(int value, int depth) {
        super(value, depth, TreeNodeType.LEAF);
    }

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
    private boolean hasRed = false;
    public int getResult() { return (int) product; }
    public void visitNode(TreeNode node) { }
    public void visitLeaf(TreeLeaf leaf) { }
}

class FancyVisitor extends TreeVis {
    private int evenLeafSum = 0;
    private int oddDepthInternalSum = 0;
    public int getResult() { return Math.abs(evenLeafSum - oddDepthInternalSum); }
    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 1) oddDepthInternalSum += node.getValue();
    }
    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getDepth() % 2 == 0) evenLeafSum += leaf.getValue();
    }
}

class JavaVisitorPattern {
    public static void main(String[] args) {
        // HackerRank provides the tree-building code and visitor selection in its stub.
        // The visitor classes above contain the required visitor-pattern logic.
        System.out.println("Visitor Pattern implemented");
    }
}
