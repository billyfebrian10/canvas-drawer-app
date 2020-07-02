package com.billyfebrian.validator;

import static com.billyfebrian.constant.CanvasDrawerConstant.Error.ARGUMENT_NOT_VALID;

import com.billyfebrian.exception.CanvasDrawerException;
import com.billyfebrian.object.Canvas;
import com.billyfebrian.util.CanvasDrawerUtil;

public class CanvasCommandValidator implements InputValidator {

    @Override
    public void validateArgument(String[] arguments, Canvas canvas) throws CanvasDrawerException {
        if (arguments.length != 3) {
            throw new CanvasDrawerException(ARGUMENT_NOT_VALID);
        }
        CanvasDrawerUtil.validateAndGetNumber(arguments[1]);
        CanvasDrawerUtil.validateAndGetNumber(arguments[2]);
    }
}
