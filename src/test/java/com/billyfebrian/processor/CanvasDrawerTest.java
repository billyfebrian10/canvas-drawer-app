package com.billyfebrian.processor;

import com.billyfebrian.object.Canvas;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CanvasDrawerTest {

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
    public void initCanvas_shouldInitCanvas_givenValidArgument(){
        Canvas canvas = CanvasDrawer.initCanvas(new String[]{"C","2", "3"});
        Assertions.assertThat(canvas).isNotNull();
        Assertions.assertThat(canvas.getWidth()).isEqualTo(2);
        Assertions.assertThat(canvas.getHeight()).isEqualTo(3);
    }

    @Test
    public void drawCanvas_shouldDraw2x2Canvas_givenWidthAndHeightIs2(){
        Canvas canvas = new Canvas(1,1);
        CanvasDrawer.drawCanvas(canvas);
        String expected =
            "---" + System.lineSeparator() +
            "| |" + System.lineSeparator() +
            "---" + System.lineSeparator();
        Assert.assertEquals(expected,outContent.toString());
    }

}