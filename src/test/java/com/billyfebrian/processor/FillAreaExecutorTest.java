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
public class FillAreaExecutorTest {

    Canvas canvas = new Canvas(4, 4);

    FillAreaExecutor fillAreaExecutor = new FillAreaExecutor();

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
            "|oooo|" + System.lineSeparator() +
            "|xxxo|" + System.lineSeparator() +
            "|x xo|" + System.lineSeparator() +
            "|xxxo|" + System.lineSeparator() +
            "------" + System.lineSeparator();
        setBorder(canvas);
        fillAreaExecutor.execute(new String[]{"B", "1", "1", "o"}, canvas);
        Assertions.assertThat(outContent.toString()).isEqualTo(expected);
    }

    @Test
    public void execute_expectDrawLine_givenValidArgument2(){
        String expected =
            "------" + System.lineSeparator() +
            "|    |" + System.lineSeparator() +
            "|xxx |" + System.lineSeparator() +
            "|xox |" + System.lineSeparator() +
            "|xxx |" + System.lineSeparator() +
            "------" + System.lineSeparator();
        setBorder(canvas);
        fillAreaExecutor.execute(new String[]{"B", "2", "3", "o"}, canvas);
        Assertions.assertThat(outContent.toString()).isEqualTo(expected);
    }

    @Test
    public void execute_expectDrawLine_givenValidArgument3(){
        String expected =
            "------" + System.lineSeparator() +
            "|    |" + System.lineSeparator() +
            "|xxx |" + System.lineSeparator() +
            "|x x |" + System.lineSeparator() +
            "|xxx |" + System.lineSeparator() +
            "------" + System.lineSeparator();
        setBorder(canvas);
        fillAreaExecutor.execute(new String[]{"B", "1", "2", "o"}, canvas);
        Assertions.assertThat(outContent.toString()).isEqualTo(expected);
    }
    @Test
    public void execute_expectDrawLine_givenValidArgument4(){
        String expected =
            "------" + System.lineSeparator() +
                "|oooo|" + System.lineSeparator() +
                "|xxxo|" + System.lineSeparator() +
                "|x xo|" + System.lineSeparator() +
                "|xxxo|" + System.lineSeparator() +
                "------" + System.lineSeparator();
        setBorder(canvas);
        fillAreaExecutor.execute(new String[]{"B", "4", "4", "o"}, canvas);
        Assertions.assertThat(outContent.toString()).isEqualTo(expected);
    }
    @Test
    public void execute_expectDrawLine_givenValidArgument5(){
        String expected =
            "------" + System.lineSeparator() +
                "|oooo|" + System.lineSeparator() +
                "|xxxo|" + System.lineSeparator() +
                "|x xo|" + System.lineSeparator() +
                "|xxxo|" + System.lineSeparator() +
                "------" + System.lineSeparator();
        setBorder(canvas);
        fillAreaExecutor.execute(new String[]{"B", "2", "1", "o"}, canvas);
        Assertions.assertThat(outContent.toString()).isEqualTo(expected);
    }
    private void setBorder(Canvas canvas) {
        canvas.getCoordinates()[1][0] = 'x';
        canvas.getCoordinates()[2][0] = 'x';
        canvas.getCoordinates()[3][0] = 'x';
        canvas.getCoordinates()[1][1] = 'x';
        canvas.getCoordinates()[1][2] = 'x';
        canvas.getCoordinates()[2][2] = 'x';
        canvas.getCoordinates()[3][1] = 'x';
        canvas.getCoordinates()[3][2] = 'x';
    }
}