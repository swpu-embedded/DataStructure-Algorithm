package 大厂算法题.高频题;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/lru-cache/
 * @author rnang0
 * @date 2020/11/18
 **/
public class _146_LRU缓存机制 {

    private static class Node {
        public int key;
        public int value;

        public Node prev;
        public Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }
    }

    private Map<Integer, Node> map;
    private int capacity;
    // 虚拟头结点
    private Node first;

    // 虚拟尾结点
    private Node last;

    public _146_LRU缓存机制(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        first = new Node();
        last = new Node();
        // 初始化
        first.next = last;
        last.prev = first;
    }

    /**
     * 获取key对应的值
     * @param key
     * @return
     */
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }

        removeNode(node);
        addAfterFirst(node);

        return node.value;
    }

    /**
     * 从链表中删除
     * @param node
     */
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * 加在first的后面
     * @param node
     */
    private void addAfterFirst(Node node) {
        node.next = first.next;
        first.next.prev = node;

        first.next = node;
        node.prev = first;
    }

    /**
     * put进去一个值
     * 1.无该值，则put进去且更新成最新
     * 2.有该值，更新成最新
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            // 更新完后，也要删除，头插
            removeNode(node);
            addAfterFirst(node);
        } else {
            if (map.size() == capacity) {
                // 淘汰掉尾部节点
                Node remove = map.remove(last.prev.key);
                removeNode(remove);
            }

            map.put(key, node = new Node(key, value));
            addAfterFirst(node);
        }
    }
}
