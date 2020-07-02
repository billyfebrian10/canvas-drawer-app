package com.billyfebrian.handler;

import static com.billyfebrian.constant.CanvasDrawerConstant.Command.CREATE_CANVAS;
import static com.billyfebrian.constant.CanvasDrawerConstant.Command.CREATE_LINE;
import static com.billyfebrian.constant.CanvasDrawerConstant.Command.CREATE_RECTANGLE;
import static com.billyfebrian.constant.CanvasDrawerConstant.Command.FILL_COLOR;
import static com.billyfebrian.constant.CanvasDrawerConstant.Error.INVALID_COMMAND;

import com.billyfebrian.exception.CanvasDrawerException;
import com.billyfebrian.object.Canvas;
import com.billyfebrian.processor.CanvasDrawer;
import com.billyfebrian.processor.CommandExecutor;
import com.billyfebrian.processor.DrawLineExecutor;
import com.billyfebrian.processor.DrawRectangleExecutor;
import com.billyfebrian.processor.FillAreaExecutor;
import com.billyfebrian.validator.CanvasCommandValidator;
import com.billyfebrian.validator.FillCommandValidator;
import com.billyfebrian.validator.LineAndRectangleCommandValidator;

public class CommandHandlerImpl implements CommandHandler {

    private Canvas canvas;
    private CanvasCommandValidator canvasCommandValidator;
    private LineAndRectangleCommandValidator lineAndRectangleCommandValidator;
    private FillCommandValidator fillCommandValidator;
    private DrawLineExecutor drawLineExecutor;
    private DrawRectangleExecutor drawRectangleExecutor;
    private FillAreaExecutor fillAreaExecutor;

    public CommandHandlerImpl() {
        canvasCommandValidator = new CanvasCommandValidator();
        lineAndRectangleCommandValidator = new LineAndRectangleCommandValidator();
        fillCommandValidator = new FillCommandValidator();
        drawLineExecutor = new DrawLineExecutor();
        drawRectangleExecutor = new DrawRectangleExecutor();
        fillAreaExecutor = new FillAreaExecutor();
    }

    @Override
    public void handle(String[] command) {
        try {
            switch (command[0]) {
                case CREATE_CANVAS :
                    new CanvasCommandValidator().validateArgument(command, canvas);
                    canvas = CanvasDrawer.initCanvas(command);
                    CanvasDrawer.drawCanvas(canvas);
                    break;
                case CREATE_LINE :
                    lineAndRectangleCommandValidator.validateArgument(command, canvas);
                    drawLineExecutor.execute(command, canvas);
                    break;
                case CREATE_RECTANGLE :
                    lineAndRectangleCommandValidator
                        .validateArgument(command, canvas);
                    drawRectangleExecutor.execute(command, canvas);
                    break;
                case FILL_COLOR :
                    fillCommandValidator.validateArgument(command, canvas);
                    fillAreaExecutor.execute(command, canvas);
                    break;
                default:
                    throw new CanvasDrawerException(INVALID_COMMAND);
            }
        }catch (CanvasDrawerException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
