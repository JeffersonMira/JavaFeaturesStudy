package personal.trainings.algorithms;

public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        LinkedList.Node head = linkedList.head();

        linkedList.add( new LinkedList.Node("1"));
        linkedList.add( new LinkedList.Node("2"));
//        linkedList.add( new LinkedList.Node("3"));
//        linkedList.add( new LinkedList.Node("4"));
//        linkedList.add( new LinkedList.Node("5"));
//        linkedList.add( new LinkedList.Node("6"));
//        linkedList.add( new LinkedList.Node("7"));

        //finding the middle element of linked list in a single pass

        LinkedList.Node current = head;
        int length = 0;
        LinkedList.Node middle = head;

        while(current.next() != null){
            length++;

            //it avoids the first element, so the second is the middle.. needs to be tested more
            if(length%2==0){
                middle=middle.next();
            }

            current = current.next();
        }

        if(length%2==1){
            middle = middle.next();
        }

        System.out.println("Length of list : "+ length);
        System.out.println("middle element of list" + middle);
    }
}

class LinkedList{
    private Node head;
    private Node tail;

    public LinkedList(){
        this.head = new Node<String>("head");
        tail = head;
    }

    public Node head(){
        return this.head;
    }

    public void add(Node node){
        tail.next = node;
        tail = node;
    }

    public static class Node<T>{
        private Node next;
        private T data;

        public Node(T data){
            this.data = data;
        }

        public T getData(){
            return this.data;
        }

        public Node next(){
            return next;
        }

        public void setNext(Node next){
            this.next = next;
        }

        public String toString(){
            return this.data.toString();
        }

    }
}
