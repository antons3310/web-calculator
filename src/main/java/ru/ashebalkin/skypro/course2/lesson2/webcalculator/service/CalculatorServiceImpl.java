package ru.ashebalkin.skypro.course2.lesson2.webcalculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public int calcPlus(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public int calcMinus(int num1, int num2) {
        return num1 - num2;
    }

    @Override
    public int calcMultiply(int num1, int num2) {
        return num1 * num2;
    }

    @Override
    public int calcDivide(int num1, int num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Деление не 0 не запрещено, оно просто не имеет результата");
        }
        return num1 / num2;
    }

}
