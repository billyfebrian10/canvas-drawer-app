package com.billyfebrian.validator;

import static com.billyfebrian.constant.CanvasDrawerConstant.Error.ARGUMENT_NOT_VALID;
import static com.billyfebrian.constant.CanvasDrawerConstant.Error.INPUT_NOT_VALID_NUMBER;

import com.billyfebrian.exception.CanvasDrawerException;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CanvasCommandValidatorTest {

    private CanvasCommandValidator canvasCommandValidator = new CanvasCommandValidator();

    @Test
    public void validateArgument_expectNotThrowError_givenCorrectArgument() throws CanvasDrawerException {
        Assertions.assertThatCode(() -> canvasCommandValidator.validateArgument(new String[]{"C",
            "20","4"}, null )).doesNotThrowAnyException();
    }

    @Test
    public void validateArgument_expectThrowArgumentNotValidError_givenArgumentLengthTooShort() throws CanvasDrawerException {

        Assertions
            .assertThatThrownBy(() -> canvasCommandValidator.validateArgument(new String[]{"C",
                "20"}, null))
            .isInstanceOf(CanvasDrawerException.class)
            .hasMessage(ARGUMENT_NOT_VALID);
    }

    @Test
    public void validateArgument_expectThrowArgumentNotValidError_givenArgumentLengthTooLong() throws CanvasDrawerException {
        Assertions
            .assertThatThrownBy(() -> canvasCommandValidator.validateArgument(new String[]{"C",
                "20", "4", "10"}, null))
            .isInstanceOf(CanvasDrawerException.class)
            .hasMessage(ARGUMENT_NOT_VALID);
    }

    @Test
    public void validateArgument_expectThrowArgumentNotValidError_givenSecondArgumentIsNotNumber() throws CanvasDrawerException {
        String expectedMessage = String.format(INPUT_NOT_VALID_NUMBER, "X");
        Assertions
            .assertThatCode(() -> canvasCommandValidator.validateArgument(new String[]{"C",
                "X", "4"}, null))
            .isInstanceOf(CanvasDrawerException.class)
            .hasMessage(expectedMessage);
    }

    @Test
    public void validateArgument_expectThrowArgumentNotValidError_givenThirdArgumentIsNotNumber() throws CanvasDrawerException {
        String expectedMessage = String.format(INPUT_NOT_VALID_NUMBER, "Y");
        Assertions
            .assertThatCode(() -> canvasCommandValidator.validateArgument(new String[]{"C",
                "20","Y"}, null ))
            .isInstanceOf(CanvasDrawerException.class)
            .hasMessage(expectedMessage);
    }
}