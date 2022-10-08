package com.fareye.training.helper;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class TitleValidator implements ConstraintValidator<TitleValidation, String>
{
    public boolean isValid(String title, ConstraintValidatorContext cxt) {
        List list = Arrays.asList(new String[]{"RED","GREEN","BLUE"});
        return list.contains(title);
    }
}