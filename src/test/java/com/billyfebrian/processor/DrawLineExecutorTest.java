package com.billyfebrian.processor;

import com.billyfebrian.object.Canvas;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(JUnit4.class)
public class DrawLineExecutorTest {

    Canvas canvas = new Canvas(3, 3);

    DrawLineExecutor drawLineExecutor = new DrawLineExecutor();

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
    public void execute_expectDrawLine_givenValidArgument(){
        String expected =
            "-----" + System.lineSeparator() +
            "|   |" + System.lineSeparator() +
            "|xxx|" + System.lineSeparator() +
            "|   |" + System.lineSeparator() +
            "-----" + System.lineSeparator();
        drawLineExecutor.execute(new String[]{"L", "1", "2", "3", "2"}, canvas);
        Assertions.assertThat(outContent.toString()).isEqualTo(expected);
    }

    @Test
    public void execute_expectDrawLine_givenValidArgument2(){
        String expected =
            "-----" + System.lineSeparator() +
            "|   |" + System.lineSeparator() +
            "|xxx|" + System.lineSeparator() +
            "|   |" + System.lineSeparator() +
            "-----" + System.lineSeparator();
        drawLineExecutor.execute(new String[]{"L", "3", "2", "1", "2"}, canvas);
        Assertions.assertThat(outContent.toString()).isEqualTo(expected);
    }

    @Test
    public void execute_expectDrawLine_givenValidArgument3(){
        String expected =
            "-----" + System.lineSeparator() +
            "|x  |" + System.lineSeparator() +
            "|xxx|" + System.lineSeparator() +
            "|   |" + System.lineSeparator() +
            "-----" + System.lineSeparator();
        drawLineExecutor.execute(new String[]{"L", "3", "2", "1", "1"}, canvas);
        Assertions.assertThat(outContent.toString()).isEqualTo(expected);
    }

    @Test
    public void execute_expectDrawLine_givenValidArgument4(){
        String expected =
            "-----" + System.lineSeparator() +
            "|xxx|" + System.lineSeparator() +
            "|  x|" + System.lineSeparator() +
            "|   |" + System.lineSeparator() +
            "-----" + System.lineSeparator();
        drawLineExecutor.execute(new String[]{"L", "1", "1", "3", "2"}, canvas);
        Assertions.assertThat(outContent.toString()).isEqualTo(expected);
    }

}