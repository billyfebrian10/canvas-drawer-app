package com.billyfebrian.processor;

import com.billyfebrian.exception.CanvasDrawerException;
import com.billyfebrian.object.Canvas;

public interface CommandExecutor {

    void execute(String[] command, Canvas canvas);
}
