package com.company;

/**
 * Created by liza on 15/12/2016.
 */
public interface Task<T> {
    public T getResult();
    public void execute();
}
