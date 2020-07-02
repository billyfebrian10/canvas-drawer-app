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
public class LineAndRectangleCommandValidatorTest {

    private LineAndRectangleCommandValidator lineAndRectangleCommandValidator =
        new LineAndRectangleCommandValidator();

    private Canvas canvas;

    @Before
    public void init() {
        canvas = new Canvas(20, 4);
    }

    @Test
    public void validateArgument_expectThrowCanvasNotDrawnError_givenCanvasIsNull() {
        Assertions
            .assertThatThrownBy(
                () -> lineAndRectangleCommandValidator
                    .validateArgument(new String[]{"L", "10", "10", "10", "10"}, null))
            .isInstanceOf(CanvasDrawerException.class).hasMessage(CANVAS_NOT_DRAWN);
    }

    @Test
    public void validateArgument_expectThrowArgumentNotValidError_givenArgumentIsTooShort() {
        Assertions.assertThatThrownBy(() -> lineAndRectangleCommandValidator
            .validateArgument(new String[]{"L", "10", "10"}, canvas))
            .isInstanceOf(CanvasDrawerException.class).hasMessage(ARGUMENT_NOT_VALID);
    }

    @Test
    public void validateArgument_expectThrowArgumentNotValidError_givenArgumentIsTooLong() {
        Assertions.assertThatThrownBy(() -> lineAndRectangleCommandValidator
            .validateArgument(new String[]{"L", "10", "10", "10", "10", "5"}, canvas))
            .isInstanceOf(CanvasDrawerException.class).hasMessage(ARGUMENT_NOT_VALID);
    }

    @Test
    public void validateArgument_expectThrowArgumentNotValidError_givenXFromCoordinateOutOfBound() {
        String expectedMessage = String.format(INPUT_OUTSIDE_CANVAS_WIDTH, 21, canvas.getWidth());
        Assertions.assertThatThrownBy(() -> lineAndRectangleCommandValidator
            .validateArgument(new String[]{"L", "21", "4", "10", "4"}, canvas))
            .isInstanceOf(CanvasDrawerException.class).hasMessage(expectedMessage);
    }

    @Test
    public void validateArgument_expectThrowArgumentNotValidError_givenXToCoordinateOutOfBound() {
        String expectedMessage = String.format(INPUT_OUTSIDE_CANVAS_WIDTH, 21, canvas.getWidth());
        Assertions.assertThatThrownBy(() -> lineAndRectangleCommandValidator
            .validateArgument(new String[]{"L", "10", "4", "21", "4"}, canvas))
            .isInstanceOf(CanvasDrawerException.class).hasMessage(expectedMessage);
    }

    @Test
    public void validateArgument_expectThrowArgumentNotValidError_givenYFromCoordinateOutOfBound() {
        String expectedMessage = String.format(INPUT_OUTSIDE_CANVAS_HEIGHT, 5, canvas.getHeight());
        Assertions.assertThatThrownBy(() -> lineAndRectangleCommandValidator
            .validateArgument(new String[]{"L", "10", "5", "10", "4"}, canvas))
            .isInstanceOf(CanvasDrawerException.class).hasMessage(expectedMessage);
    }

    @Test
    public void validateArgument_expectThrowArgumentNotValidError_givenYToCoordinateOutOfBound() {
        String expectedMessage = String.format(INPUT_OUTSIDE_CANVAS_HEIGHT, -1, canvas.getHeight());
        Assertions.assertThatThrownBy(() -> lineAndRectangleCommandValidator
            .validateArgument(new String[]{"L", "10", "4", "10", "-1"}, canvas))
            .isInstanceOf(CanvasDrawerException.class).hasMessage(expectedMessage);
    }

    @Test
    public void validateArgument_expectNoExceptionThrown_givenArgumentsValid(){
        Assertions.assertThatCode(() -> lineAndRectangleCommandValidator
            .validateArgument(new String[]{"L", "10", "2", "10", "3"}, canvas))
            .doesNotThrowAnyException();
    }

}