package ru.ashebalkin.skypro.course2.lesson2.webcalculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ashebalkin.skypro.course2.lesson2.webcalculator.service.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String showHellowMessage() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String getCalcPlus(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        return num1 + " + " + num2 + " = " + calculatorService.calcPlus(num1, num2);
    }

    @GetMapping("/minus")
    public String getCalcMinus(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        return num1 + " - " + num2 + " = " + calculatorService.calcMinus(num1, num2);
    }

    @GetMapping("/multiply")
    public String getCalcMultipy(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        return num1 + " * " + num2 + " = " +  calculatorService.calcMultiply(num1, num2);
    }

    @GetMapping("/divide")
    public String getCalcDivide(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {

        String result = calculatorService.divideCheck(num2);

        if (result.equals("")) {
            return num1 + " / " + num2 + " = " +  calculatorService.calcDivide(num1, num2);
        } else return result;

    }

}
