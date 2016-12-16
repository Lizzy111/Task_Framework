package com.company;

/**
 * Created by liza on 15/12/2016.
 */
public class NumberValidator<Number> implements Validator<Number> {
    boolean valid;

    @Override

    public boolean isValid(Number element) {
        if(element instanceof Integer){
            Integer tempElement = (Integer) element;
            if (tempElement > 0) {
                return valid = true;
            }
        }else {
            Long tempElement = (Long) element;
            if (tempElement > 0) {
                return valid = true;
            }
        }
        return valid = false;
    }
}
