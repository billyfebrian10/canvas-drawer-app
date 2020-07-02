package com.billyfebrian.processor;

import static com.billyfebrian.constant.CanvasDrawerConstant.BOUNDARY_COLOR;
import com.billyfebrian.object.Canvas;
import com.billyfebrian.object.Coordinates;
import com.billyfebrian.util.CanvasDrawerUtil;

public class DrawRectangleExecutor implements CommandExecutor {

    @Override
    public void execute(String[] command, Canvas canvas) {
        Coordinates coordinates = CanvasDrawerUtil.getCoordinateFromCommand(command);

        for (int y = coordinates.getY()[0]; y <= coordinates.getY()[1]; y++) {
            for (int x = coordinates.getX()[0]; x <= coordinates.getX()[1]; x++) {
                if ((y == coordinates.getY()[0] || y == coordinates.getY()[1]) || (
                    x == coordinates.getX()[0] || x == coordinates.getX()[1])) {
                    canvas.getCoordinates()[y][x] = BOUNDARY_COLOR;
                }
            }
        }
        CanvasDrawer.drawCanvas(canvas);
    }
}
