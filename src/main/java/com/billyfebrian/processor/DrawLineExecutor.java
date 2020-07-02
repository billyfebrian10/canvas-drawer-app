package com.billyfebrian.processor;

import static com.billyfebrian.constant.CanvasDrawerConstant.BOUNDARY_COLOR;

import com.billyfebrian.object.Canvas;
import com.billyfebrian.util.CanvasDrawerUtil;

public class DrawLineExecutor implements CommandExecutor {

    @Override
    public void execute(String[] command, Canvas canvas) {
        int xFrom = Integer.parseInt(command[1]) - 1;
        int yFrom = Integer.parseInt(command[2]) - 1;
        int xTo = Integer.parseInt(command[3]) - 1;
        int yTo = Integer.parseInt(command[4]) - 1;

        int[] xCoords = new int[]{xFrom, xTo};
        int[] yCoords = new int[]{yFrom, yTo};

        CanvasDrawerUtil.swapIfFromCoordinateIsGreaterThanToCoordinate(xCoords);
        CanvasDrawerUtil.swapIfFromCoordinateIsGreaterThanToCoordinate(yCoords);

        for (int x = xCoords[0]; x <= xCoords[1]; x++) {
            canvas.getCoordinates()[yFrom][x] = BOUNDARY_COLOR;
        }
        for (int y = yCoords[0]; y <= yCoords[1]; y++) {
            canvas.getCoordinates()[y][xTo] = BOUNDARY_COLOR;
        }
        CanvasDrawer.drawCanvas(canvas);

    }

}
