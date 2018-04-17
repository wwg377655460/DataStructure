package Array;

public class Array<E> {

    private E[] data;
    private int size;

    /**
     * 初始化数组
     *
     * @param capacity 数组的容量
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参数的构造方法，默认数组容量为10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组中元素的个数
     *
     * @return 数组中元素的个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的容量
     *
     * @return 数组的容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 返回数组是否为空
     *
     * @return 数组是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向所有元素后添加一个新元素
     *
     * @param e 新元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 向第一个位置添加一个新元素
     *
     * @param e 新元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在第index个位置插入一个新元素e
     *
     * @param index 插入的位置
     * @param e     新元素
     */
    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size");
        }

        if (size == data.length) {
            resize(2 * data.length);
        }

        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = e;
        size++;
    }

    /**
     * 获取index索引位置的元素
     *
     * @param index 索引位置
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Require index >= 0 and index < size");
        }

        return data[index];
    }

    /**
     * 获取数组最后一个元素
     * @return 数组最后一个元素
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 获取数组第一个元素
     * @return 数组第一个元素
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 修改index索引位置的元素为e
     *
     * @param index 索引位置
     * @param e     替换元素
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Require index >= 0 and index < size");
        }

        data[index] = e;
    }

    /**
     * 查找数组是否有元素e
     *
     * @param e 元素
     * @return 是否有元素e
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return true;
        }
        return false;
    }

    /**
     * 查找数组中元素e所在的索引
     *
     * @param e 元素
     * @return 元素e所在的索引, 不存在返回-1
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    /**
     * 从数组中删除index位置的元素
     *
     * @param index 索引
     * @return 删除的元素
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Require index >= 0 and index < size");
        }

        E ret = data[index];

        System.arraycopy(data, index + 1, data, index, size - (index + 1));
        size--;
        data[size] = null; // 不是必须的，涉及到gc

        if (size == data.length / 4 && data.length / 2 != 0) { // 防止复杂度震荡
            resize(data.length / 2);
        }
        return ret;
    }

    /**
     * 从数组中删除第一个元素
     *
     * @return 删除的元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素
     *
     * @return 删除的元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 从数组中删除元素e
     *
     * @param e 元素
     */
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }
}
