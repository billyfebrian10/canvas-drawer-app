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

@RunWith(JUnit4.class)
public class DrawRectangleExecutorTest {

    Canvas canvas = new Canvas(4, 4);

    DrawRectangleExecutor drawLineExecutor = new DrawRectangleExecutor();

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
            "------" + System.lineSeparator() +
            "|    |" + System.lineSeparator() +
            "|xxx |" + System.lineSeparator() +
            "|x x |" + System.lineSeparator() +
            "|xxx |" + System.lineSeparator() +
            "------" + System.lineSeparator();
        drawLineExecutor.execute(new String[]{"R", "1", "2", "3", "4"}, canvas);
        Assertions.assertThat(outContent.toString()).isEqualTo(expected);
    }

    @Test
    public void execute_expectDrawLine_givenValidArgument2(){
        String expected =
            "------" + System.lineSeparator() +
            "|    |" + System.lineSeparator() +
            "|xxx |" + System.lineSeparator() +
            "|x x |" + System.lineSeparator() +
            "|xxx |" + System.lineSeparator() +
            "------" + System.lineSeparator();
        drawLineExecutor.execute(new String[]{"R", "3", "4", "1", "2"}, canvas);
        Assertions.assertThat(outContent.toString()).isEqualTo(expected);
    }

}