package com.billyfebrian.constant;

public class CanvasDrawerConstant {

    private CanvasDrawerConstant() {}

    public static final String SPACE = " ";
    public static final char TOP_BORDER = '-';
    public static final char SIDE_BORDER = '|';
    public static final char BOUNDARY_COLOR = 'x';
    public static final char X_COORDINATE_TYPE = 'x';
    public static final char Y_COORDINATE_TYPE = 'y';

    public static class Command {

        private Command() {}

        public static final String CREATE_CANVAS = "C";
        public static final String CREATE_LINE = "L";
        public static final String CREATE_RECTANGLE = "R";
        public static final String FILL_COLOR = "B";
        public static final String QUIT = "Q";
        public static final String PREFIX = "enter command: ";
    }

    public static class Error {
        private Error() {}
        public static final String INVALID_COMMAND = "Invalid command";
        public static final String ARGUMENT_NOT_VALID = "Arguments are not valid";
        public static final String CANVAS_NOT_DRAWN = "Please draw canvas first";
        public static final String INPUT_NOT_VALID_NUMBER = "%s is not valid number";
        public static final String INPUT_OUTSIDE_CANVAS_WIDTH = "Input %d is outside canvas width"
            + " (%d)";
        public static final String INPUT_OUTSIDE_CANVAS_HEIGHT = "Input %d is outside canvas "
            + "height (%d)";
    }

}
