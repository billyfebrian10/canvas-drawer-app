package com.billyfebrian.validator;

import static com.billyfebrian.constant.CanvasDrawerConstant.Error.ARGUMENT_NOT_VALID;
import static com.billyfebrian.constant.CanvasDrawerConstant.Error.CANVAS_NOT_DRAWN;
import static com.billyfebrian.constant.CanvasDrawerConstant.X_COORDINATE_TYPE;
import static com.billyfebrian.constant.CanvasDrawerConstant.Y_COORDINATE_TYPE;

import com.billyfebrian.exception.CanvasDrawerException;
import com.billyfebrian.object.Canvas;
import com.billyfebrian.util.CanvasDrawerUtil;

public class LineAndRectangleCommandValidator implements InputValidator {

    @Override
    public void validateArgument(String[] arguments, Canvas canvas) throws CanvasDrawerException {
        if (canvas == null) {
            throw new CanvasDrawerException(CANVAS_NOT_DRAWN);
        }
        if (arguments.length != 5) {
            throw new CanvasDrawerException(ARGUMENT_NOT_VALID);
        }
        int xFrom = CanvasDrawerUtil.validateAndGetNumber(arguments[1]);
        int yFrom = CanvasDrawerUtil.validateAndGetNumber(arguments[2]);
        int xTo = CanvasDrawerUtil.validateAndGetNumber(arguments[3]);
        int yTo = CanvasDrawerUtil.validateAndGetNumber(arguments[4]);

        CanvasDrawerUtil.validateCoordinateBound(xFrom, canvas.getWidth(), X_COORDINATE_TYPE);
        CanvasDrawerUtil.validateCoordinateBound(xTo, canvas.getWidth(), X_COORDINATE_TYPE);
        CanvasDrawerUtil.validateCoordinateBound(yFrom, canvas.getHeight(), Y_COORDINATE_TYPE);
        CanvasDrawerUtil.validateCoordinateBound(yTo, canvas.getHeight(), Y_COORDINATE_TYPE);

    }

}
