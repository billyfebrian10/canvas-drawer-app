package com.billyfebrian.validator;

import static com.billyfebrian.constant.CanvasDrawerConstant.Error.ARGUMENT_NOT_VALID;
import static com.billyfebrian.constant.CanvasDrawerConstant.Error.CANVAS_NOT_DRAWN;
import static com.billyfebrian.constant.CanvasDrawerConstant.X_COORDINATE_TYPE;
import static com.billyfebrian.constant.CanvasDrawerConstant.Y_COORDINATE_TYPE;

import com.billyfebrian.exception.CanvasDrawerException;
import com.billyfebrian.object.Canvas;
import com.billyfebrian.util.CanvasDrawerUtil;

public class FillCommandValidator implements InputValidator{

    @Override
    public void validateArgument(String[] arguments, Canvas canvas) throws CanvasDrawerException {
        if (canvas == null) {
            throw new CanvasDrawerException(CANVAS_NOT_DRAWN);
        }
        if (arguments.length != 4) {
            throw new CanvasDrawerException(ARGUMENT_NOT_VALID);
        }
        int x = CanvasDrawerUtil.validateAndGetNumber(arguments[1]);
        int y = CanvasDrawerUtil.validateAndGetNumber(arguments[2]);

        CanvasDrawerUtil.validateCoordinateBound(x, canvas.getWidth(), X_COORDINATE_TYPE);
        CanvasDrawerUtil.validateCoordinateBound(y, canvas.getHeight(), Y_COORDINATE_TYPE);
    }
}
