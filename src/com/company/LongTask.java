package com.company;

/**
 * Created by liza on 15/12/2016.
 */
public class LongTask<T> implements Task {
    T result;
    boolean isExecuted = false;

    public LongTask(T result) {
        this.result = result;
    }

    @Override
    public T getResult() {
        return result;
    }

    @Override
    public void execute() {
        NumberValidator<Number> numberValidator= new NumberValidator<>();
        if(numberValidator.isValid((Number) this.result)){
            ExecutorImpl.validResults.add((LongTask<Number>) this);
        }else{
            ExecutorImpl.invalidResults.add((LongTask<Number>) this);
        }
        System.out.println("Task is executing");
        isExecuted = true;
    }
}
