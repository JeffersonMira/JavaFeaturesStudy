package personal.trainings.interview.dequeueMap;

import java.util.HashMap;
import java.util.Map;

public class TestClass{
    public static void main(String[] args) {

        Dequeue<Integer> dequeue = new Dequeue<>();


        dequeue.addLast(1);
        dequeue.addLast(2);
        dequeue.addLast(3);
        dequeue.addLast(4);
        System.out.println(dequeue.pollFirst());
        System.out.println(dequeue.pollFirst());
        System.out.println(dequeue.pollFirst());
        System.out.println(dequeue.pollFirst());
    }
}

class Dequeue<T> implements IDequeue{

    private Map<Integer, T> storage = new HashMap<>();
    private Integer right = 0;
    private Integer left = 0;

    @Override
    public void addFirst(Object e) {
        storage.put(left, (T) e);
        left = left-1;
    }

    @Override
    public void addLast(Object e) {
        storage.put(right, (T) e);
        right = right+1;
    }

    @Override
    public Object pollFirst() {
        T first = storage.remove(left);
        left = left +1;
        return first;
    }

    @Override
    public Object pollLast() {
        T last = storage.remove(right);
        right = right -1;
        return last;
    }
}
