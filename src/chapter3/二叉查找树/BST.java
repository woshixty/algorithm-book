package chapter3.二叉查找树;

/**
 * 基于二叉查找的符号表
 * @param <Key>
 * @param <Value>
 */
public class BST <Key extends Comparable<Key>, Value> {
    //二叉查找树的根节点
    private Node root;

    private class Node {
        //键
        private Key key;
        //值
        private Value val;
        //指向子树的链接
        private Node left, right;
        //以该节点为根的子树中结点总数
        private int N;

        public Node(Key key, Value val, int n) {
            this.key = key;
            this.val = val;
            N = n;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    //以下为查找和排序方法的实现

    public Value get(Key key) {
        return get(root, key);
    }

    //在以x为根为结点的子树中查找并返回Key所对应的值
    //找不到就返回null
    public Value get(Node x, Key key) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return get(x.left, key);
        else if (cmp > 0)
            return get(x.right, key);
        else
            return x.val;
    }

    public void put(Key key, Value val) {
        //查找key，找到就更新他的值，否则就创建一个新的结点
//        put(root, key, val);  万一新插入的结点成为了根结点
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null)
            return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = put(x.left, key, val);
        else if (cmp > 0)
            x.right = put(x.right, key, val);
        else
            x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }


}
