package personal.trainings.java8.lambda;


import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaTesting {

    //WHAT IS A JAVA 8 LAMBDA EXPRESSION - another way to writing instances of anonymous classes, as Runnable, Comparable

    // What is the type of a lambda expression?
    // R: A functional Interface - Which is an interface with only one abstract method.

    //Can lambda expression be put in a variable?
    //R: Yes

    //Is lambda Expression an object?
    //R. Quite complex, but no (the operator 'new' is not used
    //R. it is an object without an identity. TODO needs to verify



    public static void main(String[] args) throws InterruptedException {
        LambdaTesting mc = new LambdaTesting();
        mc.collectionTestingLambda();
    }


    public void fileFilterTesting(){

        //CREATING ANNONIMOUS CLASS BASED ON INTERFACE WAS CHANGED. NOW IT IS MUCH MORE READABLE
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.getName().endsWith(".java");
            }

        };

        File dir = new File("c:/temp");

        File[] files = dir.listFiles(fileFilter);
        for (File f : files) {
            System.out.println(f);
        }

        //IT IS NOW THIS WAY:
        //Receives the same parameter and then the return code with the logic
        FileFilter fileFilterLambda = (File file)->  file.getName().endsWith(".java");;
    }

    public void runnableLambdaTesting() throws InterruptedException {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(
                        "Hello world from thread ["+
                                Thread.currentThread().getName()+
                                "]");
            }
        };

        Thread t  = new Thread(runnable);
        t.start();
        t.join();

        //IMPLEMENTATION USING LAMBDA
        Runnable runnableLambda = () ->{
            System.out.println(
            "Hello world from thread ["+
                    Thread.currentThread().getName() + "]");
        };
    }

    public void comparatorLambdaTesting(){
        //OLD VERSION
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        };


        //LAMBDA VERSION
        Comparator<String> compLambda = (String o1, String o2) -> Integer.compare(o1.length(), o2.length());
        //THE TYPES OF THE PARAMETERS CAN BE OMMITED
        Comparator<String> compLambdaShorter = (o1, o2) -> Integer.compare(o1.length(), o2.length());


        //USING THE COMPARATOR
        List<String> list = Arrays.asList("***", "**","******","*");
        Collections.sort(list, compLambda);
        for(String s : list){
            System.out.println(s);
        }
        list.stream().forEach(s -> System.out.println(s));

        //Simplest way of doing it
         FileFilter filter = (File fileSimple) -> fileSimple.getName().endsWith(".java");
    }

    public void methodReferencesTesting(){
        Consumer<String> c = s -> System.out.println(s);
        //it can be written just as the following line
        Consumer<String> c2 = System.out::println;

        //Basically when you get the method from the parather and use it to another method, you dont have to declare it, just as this:
        Comparator<Integer> comparator = (i1,i2) -> Integer.compare(i1,i2);
        // ==
        Comparator<Integer> comparator2 = Integer::compare;
    }

    public void collectionTestingLambda(){

        List<String> list = Arrays.asList("joao", "maria","jose","carlos");

        list.forEach(name -> System.out.println(name));
        // OR like the follwing code
        list.forEach(System.out::println);

    }
}