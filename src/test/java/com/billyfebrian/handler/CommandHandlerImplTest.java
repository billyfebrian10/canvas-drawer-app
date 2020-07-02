package com.billyfebrian.handler;

import static com.billyfebrian.constant.CanvasDrawerConstant.Error.INVALID_COMMAND;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

import com.billyfebrian.exception.CanvasDrawerException;
import com.billyfebrian.object.Canvas;
import com.billyfebrian.processor.CanvasDrawer;
import com.billyfebrian.processor.DrawLineExecutor;
import com.billyfebrian.processor.DrawRectangleExecutor;
import com.billyfebrian.processor.FillAreaExecutor;
import com.billyfebrian.validator.CanvasCommandValidator;
import com.billyfebrian.validator.FillCommandValidator;
import com.billyfebrian.validator.LineAndRectangleCommandValidator;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CommandHandlerImplTest {

    @Mock
    CanvasCommandValidator canvasCommandValidator;

    @Mock
    LineAndRectangleCommandValidator lineAndRectangleCommandValidator;

    @Mock
    FillCommandValidator fillCommandValidator;

    @Mock
    DrawLineExecutor drawLineExecutor;

    @Mock
    DrawRectangleExecutor drawRectangleExecutor;

    @Mock
    FillAreaExecutor fillAreaExecutor;

    @InjectMocks
    CommandHandlerImpl commandHandler = new CommandHandlerImpl();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void handle_shouldCallCanvasDrawer_whenCommandStartWithC() {
        String[] command = new String[] {"C", "2", "2"};
        Assertions.assertThatCode(() -> commandHandler.handle(command)).doesNotThrowAnyException();
    }

    @Test
    public void handle_shouldPrintInvalidCommand_whenCommandInvalid() {
        String[] command = new String[] {"D", "2", "2"};
        commandHandler.handle(command);
        Assertions.assertThat(outContent.toString()).isEqualTo(INVALID_COMMAND + System.lineSeparator());
    }

    @Test
    public void handle_shouldCallLineCommandExecutor_whenCommandIsL()
        throws CanvasDrawerException {
        String[] canvasCommand = new String[]{"C", "3", "3"};
        String[] command = new String[] {"L", "2", "2", "2", "2"};
        doNothing().when(lineAndRectangleCommandValidator).validateArgument(any(String[].class),
            any(Canvas.class));
        commandHandler.handle(command);
        verify(lineAndRectangleCommandValidator).validateArgument(eq(command), any(Canvas.class));
        verify(drawLineExecutor).execute(eq(command), any(Canvas.class));
    }

    @Test
    public void handle_shouldCallLineCommandExecutor_whenCommandIsR()
        throws CanvasDrawerException {
        String[] canvasCommand = new String[]{"C", "3", "3"};
        String[] command = new String[] {"R", "2", "2", "2", "2"};
        doNothing().when(lineAndRectangleCommandValidator).validateArgument(any(String[].class),
            any(Canvas.class));
        commandHandler.handle(command);
        verify(lineAndRectangleCommandValidator).validateArgument(eq(command), any(Canvas.class));
        verify(drawRectangleExecutor).execute(eq(command), any(Canvas.class));
    }

    @Test
    public void handle_shouldCallLineCommandExecutor_whenCommandIsF()
        throws CanvasDrawerException {
        String[] canvasCommand = new String[]{"C", "3", "3"};
        String[] command = new String[] {"B", "2", "2", "o"};
        doNothing().when(fillCommandValidator).validateArgument(any(String[].class),
            any(Canvas.class));
        commandHandler.handle(command);
        verify(fillCommandValidator).validateArgument(eq(command), any(Canvas.class));
        verify(fillAreaExecutor).execute(eq(command), any(Canvas.class));
    }

}