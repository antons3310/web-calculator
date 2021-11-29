package ru.ashebalkin.skypro.course2.lesson2.webcalculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public String calcPlus(String num1, String num2) {

        StringBuilder result = checkAll(num1, num2);

        if (result.toString().equals("")) {
            int num3 = makeDigits(num1) + makeDigits(num2);
            return num1 + " + " + num2 + " = " + num3;
        }

        return result.toString();
    }

    @Override
    public String calcMinus(String num1, String num2) {

        StringBuilder result = checkAll(num1, num2);

        if (result.toString().equals("")) {
            int num3 = makeDigits(num1) - makeDigits(num2);
            return num1 + " - " + num2 + " = " + num3;
        }

        return result.toString();
    }

    @Override
    public String calcMultiply(String num1, String num2) {

        StringBuilder result = checkAll(num1, num2);

        if (result.toString().equals("")) {
            int num3 = makeDigits(num1) * makeDigits(num2);
            return num1 + " * " + num2 + " = " + num3;
        }

        return result.toString();
    }

    @Override
    public String calcDivide(String num1, String num2) {

        StringBuilder result = checkAll(num1, num2);
        result.append(divideCheck(num2));

        if (result.toString().equals("")) {
            int num3 = makeDigits(num1) / makeDigits(num2);
            return num1 + " / " + num2 + " = " + num3;
        }

        return result.toString();

    }

    private StringBuilder checkAll(String num1, String num2){
        StringBuilder result = new StringBuilder();

        result.append(checkExistParamams(num1, num2));

        if (result.toString().equals("")) {
            result.append(cheskDigits(num1));
        }

        if (result.toString().equals("")) {
            result.append(cheskDigits(num2));
        }

        return result;
    }

    private String checkExistParamams(String num1, String num2) {
        if ((num1.trim().length() == 0 && num2.trim().length() == 0)) {
            return "<b>Не указан ни один из параметров для вычисления выражения. Вычисление не возможно</b>";
        } else {
            if (num1.trim().length() == 0 || num2.trim().length() == 0) {
                return "<b>Не указан один из параметров для вычисления выражения. Вычисление не возможно</b>";
            }
        }
        return "";
    }

    private String cheskDigits(String num) {
        try {
            Integer.parseInt(num.trim());
        } catch (NumberFormatException nfe) {
            return "Ошибка переданного формата данных: " + nfe.getMessage();
        }
        return "";
    }

    private int makeDigits(String num) {
        return Integer.parseInt(num.trim());
    }

    private String divideCheck(String num2) {
        if (makeDigits(num2) == 0) {
            return "<b>Деление на 0 запрещено. Вычисление не возможно</b>";
        } else return "";
    }
}
