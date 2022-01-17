package ru.ashebalkin.skypro.course2.lesson2.webcalculator.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.ashebalkin.skypro.course2.lesson2.webcalculator.constants.CalculatorServiceTestConstants.*;

class CalculatorServiceImplTest {

    private final CalculatorServiceImpl out = new CalculatorServiceImpl();

    int result;

    @Test
    void calcPlusTest() {
        result = out.calcPlus(POSITIVE_NUMBER_NUM1, POSITIVE_NUMBER_NUM2);
        assertEquals(POS_NUM1_PLUS_POS_NUM2, result);

        result = out.calcPlus(POSITIVE_NUMBER_NUM1, NEGATIVE_NUMBER_NUM1);
        assertEquals(POS_NUM1_PLUS_NEG_NUM1, result);

        result = out.calcPlus(NEGATIVE_NUMBER_NUM1, NEGATIVE_NUMBER_NUM2);
        assertEquals(NEG_NUM1_PLUS_NEG_NUM2, result);
    }

    @Test
    void calcMinusTest() {
        result = out.calcMinus(POSITIVE_NUMBER_NUM1, POSITIVE_NUMBER_NUM2);
        assertEquals(POS_NUM1_MINUS_POS_NUM2, result);

        result = out.calcMinus(POSITIVE_NUMBER_NUM1, NEGATIVE_NUMBER_NUM1);
        assertEquals(POS_NUM1_MINUS_NEG_NUM1, result);

        result = out.calcMinus(NEGATIVE_NUMBER_NUM1, NEGATIVE_NUMBER_NUM2);
        assertEquals(NEG_NUM1_MINUS_NEG_NUM2, result);
    }

    @Test
    void calcMultiplyTest() {
        result = out.calcMultiply(POSITIVE_NUMBER_NUM1, POSITIVE_NUMBER_NUM2);
        assertEquals(POS_NUM1_MULTIPLY_POS_NUM2, result);

        result = out.calcMultiply(POSITIVE_NUMBER_NUM1, NEGATIVE_NUMBER_NUM1);
        assertEquals(POS_NUM1_MULTIPLY_NEG_NUM1, result);

        result = out.calcMultiply(NEGATIVE_NUMBER_NUM1, NEGATIVE_NUMBER_NUM2);
        assertEquals(NEG_NUM1_MULTIPLY_NEG_NUM2, result);
    }

    @Test
    void calcDivideTest() {
        result = out.calcDivide(POSITIVE_NUMBER_NUM1, POSITIVE_NUMBER_NUM2);
        assertEquals(POS_NUM1_DIVIDE_POS_NUM2, result);

        result = out.calcDivide(POSITIVE_NUMBER_NUM1, NEGATIVE_NUMBER_NUM1);
        assertEquals(POS_NUM1_DIVIDE_NEG_NUM1, result);

        result = out.calcDivide(NEGATIVE_NUMBER_NUM1, NEGATIVE_NUMBER_NUM2);
        assertEquals(NEG_NUM1_DIVIDE_NEG_NUM2, result);
    }

    @Test
    void calcDivideZeroExceptionTest() {
        assertThrows(IllegalArgumentException.class,
                () -> out.calcDivide(POSITIVE_NUMBER_NUM1, ZERO_NUMBER)
        );

        assertThrows(IllegalArgumentException.class,
                () -> out.calcDivide(NEGATIVE_NUMBER_NUM1, ZERO_NUMBER)
        );

        assertThrows(IllegalArgumentException.class,
                () -> out.calcDivide(ZERO_NUMBER, ZERO_NUMBER)
        );
    }
}