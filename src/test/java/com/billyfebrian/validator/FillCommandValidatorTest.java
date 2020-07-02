package com.billyfebrian.validator;

import static com.billyfebrian.constant.CanvasDrawerConstant.Error.ARGUMENT_NOT_VALID;
import static com.billyfebrian.constant.CanvasDrawerConstant.Error.CANVAS_NOT_DRAWN;
import static com.billyfebrian.constant.CanvasDrawerConstant.Error.INPUT_OUTSIDE_CANVAS_HEIGHT;
import static com.billyfebrian.constant.CanvasDrawerConstant.Error.INPUT_OUTSIDE_CANVAS_WIDTH;

import com.billyfebrian.exception.CanvasDrawerException;
import com.billyfebrian.object.Canvas;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class FillCommandValidatorTest {

    private FillCommandValidator fillCommandValidator = new FillCommandValidator();

    private Canvas canvas;

    @Before
    public void init(){
        canvas = new Canvas(20, 4);
    }

    @Test
    public void validateArgument_expectThrowCanvasNotDrawnError_givenCanvasIsNull() {
        Assertions
            .assertThatThrownBy(
                () -> fillCommandValidator.validateArgument(new String[]{"B", "10", "10",
                    "o"}, null))
            .isInstanceOf(CanvasDrawerException.class)
            .hasMessage(CANVAS_NOT_DRAWN);
    }

    @Test
    public void validateArgument_expectThrowArgumentNotValidError_givenArgumentsTooLong() {
        Assertions
            .assertThatThrownBy(
                () -> fillCommandValidator.validateArgument(new String[]{"B", "10", "10", "C", "2"},
                    canvas))
            .isInstanceOf(CanvasDrawerException.class)
            .hasMessage(ARGUMENT_NOT_VALID);
    }

    @Test
    public void validateArgument_expectThrowArgumentNotValidError_givenArgumentsTooShort() {
        Assertions
            .assertThatThrownBy(
                () -> fillCommandValidator.validateArgument(new String[]{"B", "10", "10"}, canvas))
            .isInstanceOf(CanvasDrawerException.class)
            .hasMessage(ARGUMENT_NOT_VALID);
    }

    @Test
    public void validateArgument_expectThrowArgumentNotValidError_givenXCoordinateOutOfBound() {
        String expectedMessage = String.format(INPUT_OUTSIDE_CANVAS_WIDTH, 21, canvas.getWidth());
        Assertions
            .assertThatThrownBy(
                () -> fillCommandValidator.validateArgument(new String[]{"B", "21", "10", "i"},
                    canvas))
            .isInstanceOf(CanvasDrawerException.class)
            .hasMessage(expectedMessage);
    }
    @Test
    public void validateArgument_expectThrowArgumentNotValidError_givenXCoordinateMinus() {
        String expectedMessage = String.format(INPUT_OUTSIDE_CANVAS_WIDTH, -1, canvas.getWidth());
        Assertions
            .assertThatThrownBy(
                () -> fillCommandValidator.validateArgument(new String[]{"B", "-1", "10", "i"},
                    canvas))
            .isInstanceOf(CanvasDrawerException.class)
            .hasMessage(expectedMessage);
    }
    @Test
    public void validateArgument_expectThrowArgumentNotValidError_givenXCoordinateZero() {
        String expectedMessage = String.format(INPUT_OUTSIDE_CANVAS_WIDTH, 0, canvas.getWidth());
        Assertions
            .assertThatThrownBy(
                () -> fillCommandValidator.validateArgument(new String[]{"B", "0", "10", "i"},
                    canvas))
            .isInstanceOf(CanvasDrawerException.class)
            .hasMessage(expectedMessage);
    }

    @Test
    public void validateArgument_expectThrowArgumentNotValidError_givenYCoordinateOutOfBound() {
        String expectedMessage = String.format(INPUT_OUTSIDE_CANVAS_HEIGHT, 5, canvas.getHeight());
        Assertions
            .assertThatThrownBy(
                () -> fillCommandValidator.validateArgument(new String[]{"B", "1", "5", "i"},
                    canvas))
            .isInstanceOf(CanvasDrawerException.class)
            .hasMessage(expectedMessage);
    }
    @Test
    public void validateArgument_expectThrowArgumentNotValidError_givenYCoordinateMinus() {
        String expectedMessage = String.format(INPUT_OUTSIDE_CANVAS_HEIGHT, -1, canvas.getHeight());
        Assertions
            .assertThatThrownBy(
                () -> fillCommandValidator.validateArgument(new String[]{"B", "1", "-1", "i"},
                    canvas))
            .isInstanceOf(CanvasDrawerException.class)
            .hasMessage(expectedMessage);
    }
    @Test
    public void validateArgument_expectThrowArgumentNotValidError_givenYCoordinateZero() {
        String expectedMessage = String.format(INPUT_OUTSIDE_CANVAS_HEIGHT, 0, canvas.getHeight());
        Assertions
            .assertThatThrownBy(
                () -> fillCommandValidator.validateArgument(new String[]{"B", "10", "0", "i"},
                    canvas))
            .isInstanceOf(CanvasDrawerException.class)
            .hasMessage(expectedMessage);
    }

    @Test
    public void validateArgument_expectNoExceptionThrown_givenInputValid() {
        Assertions.assertThatCode(
            () -> fillCommandValidator.validateArgument(new String[]{"B", "10", "3", "o"}, canvas))
            .doesNotThrowAnyException();
    }

}