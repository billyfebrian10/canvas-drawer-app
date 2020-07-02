package com.billyfebrian.util;

import static com.billyfebrian.constant.CanvasDrawerConstant.Error.INPUT_NOT_VALID_NUMBER;
import static com.billyfebrian.constant.CanvasDrawerConstant.Error.INPUT_OUTSIDE_CANVAS_HEIGHT;
import static com.billyfebrian.constant.CanvasDrawerConstant.Error.INPUT_OUTSIDE_CANVAS_WIDTH;
import static com.billyfebrian.constant.CanvasDrawerConstant.X_COORDINATE_TYPE;

import com.billyfebrian.exception.CanvasDrawerException;
import com.billyfebrian.object.Coordinates;

public class CanvasDrawerUtil {

    private CanvasDrawerUtil() {}

    public static void swapIfFromCoordinateIsGreaterThanToCoordinate(int[] coordinate) {
        if (coordinate[0] > coordinate[1]){
            coordinate[0] = coordinate[0] + coordinate[1];
            coordinate[1] = coordinate[0] - coordinate[1];
            coordinate[0] = coordinate[0] - coordinate[1];
        }
    }

    public static Coordinates getCoordinateFromCommand(String[] command) {

        int xFrom = Integer.parseInt(command[1]) - 1;
        int yFrom = Integer.parseInt(command[2]) - 1;
        int xTo = Integer.parseInt(command[3]) - 1;
        int yTo = Integer.parseInt(command[4]) - 1;

        int[] xCoords = new int[]{xFrom, xTo};
        int[] yCoords = new int[]{yFrom, yTo};

        CanvasDrawerUtil.swapIfFromCoordinateIsGreaterThanToCoordinate(xCoords);
        CanvasDrawerUtil.swapIfFromCoordinateIsGreaterThanToCoordinate(yCoords);

        return new Coordinates(xCoords, yCoords);
    }

    public static int validateAndGetNumber(String number) throws CanvasDrawerException {
        try {
            return Integer.parseInt(number);
        }catch (NumberFormatException ex) {
            throw new CanvasDrawerException(String.format(INPUT_NOT_VALID_NUMBER, number));
        }
    }

    public static void validateCoordinateBound(int coordinate, int canvasBound, char type)
        throws CanvasDrawerException {
        String format = INPUT_OUTSIDE_CANVAS_HEIGHT;
        if (type == X_COORDINATE_TYPE) {
            format = INPUT_OUTSIDE_CANVAS_WIDTH;
        }
        if (coordinate < 1 || coordinate > canvasBound) {
            throw new CanvasDrawerException(String.format(format, coordinate, canvasBound));
        }
    }

}
