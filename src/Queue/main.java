package Queue;


import Array.Array;

import java.util.Random;

public class main {

    public static void main(String[] args) {
//        ArrayQueue<Integer> stack = new ArrayQueue<Integer>();
//
//        for (int i = 0; i < 10; i++) {
//            stack.enQueue(i);
//            System.out.println(stack);
//
//            if (i % 3 == 2) {
//                stack.deQueue();
//                System.out.println(stack);
//            }
//        }

//        LoopQueue<Integer> queue = new LoopQueue<>();
//
//        for (int i = 0; i < 10; i++) {
//            queue.enQueue(i);
//            System.out.println(queue);
//
//            if (i % 3 == 2) {
//                queue.deQueue();
//                System.out.println(queue);
//            }
//        }

        int opCount = 1000000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testDiffQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue, time: " + time1 + " s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testDiffQueue(loopQueue, opCount);
        System.out.println("LoopQueue, time: " + time2 + " s");

        /*
        ==================Result==========================
        int opCount = 100000;
        ArrayQueue, time: 1.193497887 s
        LoopQueue, time: 0.07096854 s

        int opCount = 1000000;
        ArrayQueue, time: 208.341388739 s
        LoopQueue, time: 0.066083596 s
        */
    }

    /**
     * 测试两个队列的性能
     *
     * @param queue   队列
     * @param opCount 操作数
     * @return 消耗时间(s)
     */
    private static double testDiffQueue(Queue<Integer> queue, int opCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++)
            queue.enQueue(random.nextInt(Integer.MAX_VALUE));
        for (int i = 0; i < opCount; i++)
            queue.deQueue();

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
}
