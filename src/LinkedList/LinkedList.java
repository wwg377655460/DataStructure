package LinkedList;

public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    ", next=" + next +
                    '}';
        }
    }

    // 使用虚拟头结点
    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    /**
     * 获取链表元素个数
     *
     * @return 链表元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断链表是否为空
     *
     * @return 链表是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表头添加元素
     *
     * @param e 元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在索引为index的位置插入元素
     * 在链表中是一个不常用的操作
     *
     * @param index 索引
     * @param e     元素
     */
    public void add(int index, E e) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index");


        Node prev = dummyHead;
        for (int i = 0; i < index; i++)
            prev = prev.next;

//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;

        prev.next = new Node(e, prev.next);

        size++;
    }

    /**
     * 在链表末尾添加元素
     *
     * @param e 元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获取index索引位置的元素
     * @param index 索引
     * @return 元素
     */
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Illegal index");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;

        return cur.e;
    }
}
