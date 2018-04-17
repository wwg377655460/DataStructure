package Queue;

public interface Queue<E> {

    /**
     * 获取队列中的元素数量
     * @return 元素数量
     */
    int getSize();

    /**
     * 队列是否为空
     * @return 是否为空
     */
    boolean isEmpty();

    /**
     * 入队
     * @param e 元素
     */
    void enQueue(E e);

    /**
     * 出队
     * @return 出队元素
     */
    E deQueue();

    /**
     * 查看队首的元素
     * @return 队首元素
     */
    E getFront();
}
