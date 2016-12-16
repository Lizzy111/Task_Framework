package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Task<Integer>> intTasks = new ArrayList<>();
        intTasks.add(new LongTask<Integer>(1));
        intTasks.add(new LongTask<Integer>(-2));
        intTasks.add(new LongTask<Integer>(3));
        test(intTasks);
    }

    public static void test(List<Task<Integer>> intTasks) {
        Executor<Number> numberExecutor = new ExecutorImpl<>();


        try {
            for (Task<Integer> intTask : intTasks) {
                numberExecutor.addTask(intTask);
            }
            numberExecutor.addTask(new LongTask(10L), new NumberValidator());
        } catch (Exception e) {
            System.err.println("Method execute() had been already called");
        }

        numberExecutor.execute();


        try {
            System.out.println("Valid results:");
            for (Object number: numberExecutor.getValidResults()) {
                if(number instanceof LongTask){
                    System.out.println(((LongTask) number).getResult());
                }

            }
            System.out.println("Invalid results:");
            for (Object number : numberExecutor.getInvalidResults()) {
                if(number instanceof LongTask){
                    System.out.println(((LongTask) number).getResult());
                }
            }
        } catch (Exception e) {
            System.err.println("Method execute() hadnt been called");
        }

    }
}
