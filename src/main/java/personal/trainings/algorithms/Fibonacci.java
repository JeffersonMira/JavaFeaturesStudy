package personal.trainings.algorithms;

public class Fibonacci {

    public static void main(String args[]){
        printFibonacciUntil(10);
    }

    //using tail recursion
    private static void printFibonacciUntil(int position){

        for(int i = 1; i <= position; i++){
            System.out.println(getFibonacci(i) + " ");
        }
    }

    private static int getFibonacci(int n){
        if(n == 1 || n == 2) return 1;

        return getFibonacci(n - 1) + getFibonacci( n -2);
    }
}


