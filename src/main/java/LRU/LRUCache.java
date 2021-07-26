package LRU;

import java.util.HashMap;

public class LRUCache {

    private Node head;

    private Node end;

    private int limit;

    private HashMap<String, Node> hashMap;

    public LRUCache(int limit) {
        this.limit = limit;
        hashMap = new HashMap<>();
    }


    /**
     * 取值
     *
     * @param key
     * @return
     */
    public String get(String key) {
        Node node = hashMap.get(key);
        if (node == null) {
            return "-1";
        }
        //返回之前把节点移动到链尾
        moveNodeTail(node);
        return node.value;
    }


    /**
     * 存值
     *
     * @param key
     * @param value
     */
    public void put(String key, String value) {
        Node node = hashMap.get(key);
        if (node != null) {
            //节点已存在更新里面的值
            node.value = value;
            //移动到链尾
            moveNodeTail(node);
        } else {
            //不存在，首先判断容量，容量满的情况下先删除不常用的，然后插入新节点，容量不满的情况下直接插入
            if (hashMap.size() >= limit) {
                //从链表中移除最不常用的
                String oldKey = deleteNode(head);
                //从hashmap中移除
                hashMap.remove(oldKey);
            }
            node = new Node(key, value);
            //添加到链尾
            addTailNode(node);
            //添加到hashmap
            hashMap.put(key, node);
        }
    }


    /**
     * 刷新被访问的节点位置
     * @param node
     */
    private void moveNodeTail(Node node) {
        //如果已经是队尾的节点无需移动
        if (node == end) {
            return;
        }
        //先从原位置删掉
        deleteNode(node);
        //放到链尾
        addTailNode(node);
    }


    /**
     * 移除节点
     *
     * @param node
     */
    public String deleteNode(Node node) {
        if (node == head && node == end) {
            //移除唯一的节点
            head = null;
            end = null;
        } else if (node == end) {
            //移除尾节点
            end = end.pre;
            end.next = null;
        } else if (node == head) {
            //移除头节点
            head = head.next;
            head.pre = null;
        } else {
            //移除中间节点
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        return node.key;
    }

    /**
     * 尾部插入节点
     *
     * @param node
     */
    public void addTailNode(Node node) {
        if (end != null) {
            end.next = node;
            node.pre = end;
            node.next = null;
        }
        end = node;
        if (head == null) {
            head = node;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put("1", "1");
        cache.put("2", "2");
        System.out.println(cache.get("1"));
        cache.put("3", "3");
        System.out.println(cache.get("2"));
        cache.put("4", "4");
        System.out.println(cache.get("1"));
        System.out.println(cache.get("3"));
        System.out.println(cache.get("4"));
    }

}