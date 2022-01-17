package ru.ashebalkin.skypro.course2.lesson2.webcalculator.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.ashebalkin.skypro.course2.lesson2.webcalculator.constants.CalculatorServiceTestConstants.*;

class CalculatorServiceImplParameterizedTest {

    private final CalculatorServiceImpl out = new CalculatorServiceImpl();

    int result;

    public static Stream<Arguments> prepareDataForPlusCalcTest() {
        return Stream.of(
                Arguments.of(POSITIVE_NUMBER_NUM1, POSITIVE_NUMBER_NUM2, POS_NUM1_PLUS_POS_NUM2),
                Arguments.of(POSITIVE_NUMBER_NUM1, NEGATIVE_NUMBER_NUM1, POS_NUM1_PLUS_NEG_NUM1),
                Arguments.of(NEGATIVE_NUMBER_NUM1, NEGATIVE_NUMBER_NUM2, NEG_NUM1_PLUS_NEG_NUM2)
        );
    }

    @ParameterizedTest
    @MethodSource("prepareDataForPlusCalcTest")
    void calcPlusTest(int num1, int num2, int expected) {
        result = out.calcPlus(num1, num2);
        assertEquals(expected, result);
    }

    public static Stream<Arguments> prepareDataForMinusCalcTest() {
        return Stream.of(
                Arguments.of(POSITIVE_NUMBER_NUM1, POSITIVE_NUMBER_NUM2, POS_NUM1_MINUS_POS_NUM2),
                Arguments.of(POSITIVE_NUMBER_NUM1, NEGATIVE_NUMBER_NUM1, POS_NUM1_MINUS_NEG_NUM1),
                Arguments.of(NEGATIVE_NUMBER_NUM1, NEGATIVE_NUMBER_NUM2, NEG_NUM1_MINUS_NEG_NUM2)
        );
    }

    @ParameterizedTest
    @MethodSource("prepareDataForMinusCalcTest")
    void calcMinusTest(int num1, int num2, int expected) {
        result = out.calcMinus(num1, num2);
        assertEquals(expected, result);
    }

    public static Stream<Arguments> prepareDataForMultiplyCalcTest() {
        return Stream.of(
                Arguments.of(POSITIVE_NUMBER_NUM1, POSITIVE_NUMBER_NUM2, POS_NUM1_MULTIPLY_POS_NUM2),
                Arguments.of(POSITIVE_NUMBER_NUM1, NEGATIVE_NUMBER_NUM1, POS_NUM1_MULTIPLY_NEG_NUM1),
                Arguments.of(NEGATIVE_NUMBER_NUM1, NEGATIVE_NUMBER_NUM2, NEG_NUM1_MULTIPLY_NEG_NUM2)
        );
    }

    @ParameterizedTest
    @MethodSource("prepareDataForMultiplyCalcTest")
    void calcMultiplyTest(int num1, int num2, int expected) {
        result = out.calcMultiply(num1, num2);
        assertEquals(expected, result);
    }

    public static Stream<Arguments> prepareDataForDivideCalcTest() {
        return Stream.of(
                Arguments.of(POSITIVE_NUMBER_NUM1, POSITIVE_NUMBER_NUM2, POS_NUM1_DIVIDE_POS_NUM2),
                Arguments.of(POSITIVE_NUMBER_NUM1, NEGATIVE_NUMBER_NUM1, POS_NUM1_DIVIDE_NEG_NUM1),
                Arguments.of(NEGATIVE_NUMBER_NUM1, NEGATIVE_NUMBER_NUM2, NEG_NUM1_DIVIDE_NEG_NUM2)
        );
    }

    @ParameterizedTest
    @MethodSource("prepareDataForDivideCalcTest")
    void calcDivideTest(int num1, int num2, int expected) {
        result = out.calcDivide(num1, num2);
        assertEquals(expected, result);
    }

}