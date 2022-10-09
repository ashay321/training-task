package com.fareye.training.helper;

import com.fareye.training.controller.TodoController;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TitleValidator implements ConstraintValidator<DuplicateTitle, String>
{
    public boolean isValid(String title, ConstraintValidatorContext cxt) {
        return ! TodoController.titles.contains(title);

    }
}