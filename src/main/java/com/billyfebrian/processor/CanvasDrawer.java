package com.billyfebrian.processor;

import static com.billyfebrian.constant.CanvasDrawerConstant.SIDE_BORDER;
import static com.billyfebrian.constant.CanvasDrawerConstant.TOP_BORDER;

import com.billyfebrian.object.Canvas;

public class CanvasDrawer{

    private CanvasDrawer() {}

    public static Canvas initCanvas (String[] command) {
        int width = Integer.parseInt(command[1]);
        int height = Integer.parseInt(command[2]);
        return new Canvas(width, height);
    }

    public static void drawCanvas(Canvas canvas) {
        drawTopAndBottomBorder(canvas.getWidth());
        for (int i = 0; i<canvas.getHeight(); i++) {
            System.out.print(SIDE_BORDER);
            for(int j = 0; j<canvas.getWidth(); j++) {
                System.out.print(canvas.getCoordinates()[i][j]);
            }
            System.out.print(SIDE_BORDER);
            System.out.println();
        }
        drawTopAndBottomBorder(canvas.getWidth());
    }

    private static void drawTopAndBottomBorder(int width){
        for (int i = 0; i < (width + 2); i++) {
            System.out.print(TOP_BORDER);
        }
        System.out.println();
    }

}
