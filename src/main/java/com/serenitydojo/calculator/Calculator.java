package com.serenitydojo.calculator;

import org.apache.maven.shared.utils.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {
    public int evaluate(String expression) throws IllegalMathsOperatorException {

        Integer total = 0;
        String operator = "+";

        if (expression.isEmpty()) {
            return 0;
        } else {

            List<String> tokens = Arrays.stream(expression.split("\\s"))
                    .filter(element -> !element.isEmpty())
                    .collect(Collectors.toList());


            for (String token : tokens) {
                if (!StringUtils.isNumeric(token)) {

                    operator = token;
                }
                else{
                        switch (operator) {
                            case "+":
                                total = total  + Integer.parseInt(token);
                                break;
                            case "-":
                                total = total - Integer.parseInt(token);
                                break;
                            case "*":
                                 total = total * Integer.parseInt(token);
                                 break;
                            case "/":
                                total = total / Integer.parseInt(token);
                                break;
                            default:
                                throw new IllegalMathsOperatorException("Incorrect Operator Used " + token);
                        }
                    }

                }
                return total;
            }

        //return total;
    }
}




