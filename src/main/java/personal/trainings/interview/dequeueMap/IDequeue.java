package personal.trainings.interview.dequeueMap;

//  interface  IDequeue<T> using HashMap as storage.

public interface IDequeue<T> {
    /**
     * Inserts the specified element at the front of this deque
     * @param e
     */
    void addFirst(T e);

    /**
     * Inserts the specified element at the end of this deque
     * @param e
     */
    void addLast(T e);

    /**
     * Retrieves and removes the first element of this deque, or returns null if this deque is empty.
     * @return T
     */
    T pollFirst();

    /**
     * Retrieves and removes the last element of this deque, or returns null if this deque is empty.
     * @return T
     */
    T pollLast();
}