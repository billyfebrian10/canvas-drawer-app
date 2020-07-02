package com.billyfebrian.processor;

import static com.billyfebrian.constant.CanvasDrawerConstant.BOUNDARY_COLOR;

import com.billyfebrian.exception.CanvasDrawerException;
import com.billyfebrian.object.Canvas;
import com.billyfebrian.object.Point;
import java.util.LinkedList;
import java.util.Queue;

public class FillAreaExecutor implements CommandExecutor {

    private Queue<Point> queue;

    @Override
    public void execute(String[] command, Canvas canvas) {
        queue = new LinkedList<>();
        int x = Integer.parseInt(command[1]) - 1;
        int y = Integer.parseInt(command[2]) - 1;
        char color = command[3].charAt(0);
        fillColor(x,y, color, canvas);
        CanvasDrawer.drawCanvas(canvas);
    }

    void fillColor(int x, int y, char color, Canvas canvas) {
        char[][] coordinates = canvas.getCoordinates();
        queue.add(new Point(x, y));
        while (!queue.isEmpty()) {
            Point currentPoint = queue.remove();
            int currX = currentPoint.getX();
            int currY = currentPoint.getY();
            if ((currX >= 0 && currX < canvas.getWidth()) && (currY >= 0 && currY <= canvas.getHeight())
                && coordinates[currY][currX] != BOUNDARY_COLOR && coordinates[currY][currX] != color) {
                coordinates[currentPoint.getY()][currentPoint.getX()] = color;
                if (currX - 1 >= 0 && coordinates[currY][currX - 1] != BOUNDARY_COLOR && coordinates[currY][currX - 1] != color) {
                    queue.add(new Point(currX -1, currY));
                }
                if (currY - 1 >= 0 && coordinates[currY - 1][currX] != BOUNDARY_COLOR && coordinates[currY - 1][currX] != color) {
                    queue.add(new Point(currX, currY -1));
                }
                if (currX + 1 <= canvas.getWidth()-1  && coordinates[currY][currX + 1] != BOUNDARY_COLOR && coordinates[currY][currX + 1] != color) {
                    queue.add(new Point(currX +  1, currY));
                }
                if (currY + 1 <= canvas.getHeight()-1 && coordinates[currY + 1][currX] != BOUNDARY_COLOR && coordinates[currY + 1][currX] != color) {
                    queue.add(new Point(currX, currY + 1));
                }
            }
        }
    }
}
