package com.billyfebrian.validator;

import com.billyfebrian.exception.CanvasDrawerException;
import com.billyfebrian.object.Canvas;

public interface InputValidator {
    void validateArgument(String[] arguments, Canvas canvas) throws CanvasDrawerException;
}
