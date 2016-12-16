package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liza on 15/12/2016.
 */
public class ExecutorImpl<T> implements Executor {

   static List<LongTask<Number>> validResults;
   static List<LongTask<Number>> invalidResults;
    List<LongTask<Number>> tasks;

    public ExecutorImpl() {
        validResults = new ArrayList();
        invalidResults = new ArrayList();
        tasks= new ArrayList();
    }

    @Override
    public void addTask(Task task) throws Exception {

        LongTask<Number> longTask= (LongTask<Number>) task;

        if(longTask.isExecuted){
            throw new Exception();
        }
        tasks.add(longTask);

    }

    @Override
    public void addTask(Task task, Validator validator) throws Exception{
        LongTask<Number> longTask= (LongTask<Number>) task;
        if(longTask.isExecuted){
            throw new Exception();
        }
        tasks.add(longTask);
    }

    @Override
    public void execute() {

        for (Object elem: tasks ) {
            if(elem instanceof LongTask){
                ((LongTask) elem).execute();
            }
        }
    }

    @Override
    public List getValidResults()  throws Exception {

        return validResults;
    }

    @Override
    public List getInvalidResults() throws Exception{
//        if(!isExecuted){
//            throw new Exception();
//        }
        return invalidResults;
    }
}
