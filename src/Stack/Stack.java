package Stack;

public interface Stack<E> {

    /**
     * 获取栈中的元素数量
     * @return 元素数量
     */
    int getSize();

    /**
     * 栈是否为空
     * @return 是否为空
     */
    boolean isEmpty();

    /**
     * 入栈
     * @param e 元素
     */
    void push(E e);

    /**
     * 出栈
     * @return 出栈元素
     */
    E pop();

    /**
     * 查看栈顶元素
     * @return 栈顶元素
     */
    E peek();
}
