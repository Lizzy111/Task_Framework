package com.company;

import java.util.List;

/**
 * Created by liza on 15/12/2016.
 */
public interface Executor<T> {

    void addTask(Task task) throws Exception;
    void addTask(Task task, Validator validator) throws Exception;

    void execute();

    List getValidResults()throws Exception;
    List getInvalidResults()throws Exception;
}
