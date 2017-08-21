package com.alex.calcx;

import java.util.*;

public class ExpressionCalculator {

    private final List<String> FUNCTIONS, OPERATORS, BRACKETS;
    private final HashMap<String, Double> CONSTANTS;
    private final String UNARY = "un";
    private Stack<String> stack, out;

    public ExpressionCalculator() {
        FUNCTIONS = new ArrayList<>();
        Collections.addAll(FUNCTIONS, "sin", "cos", "tan", "cot", "!", "^", "%", "ln", "lg", "abs", "sqrt", "cbrt");

        OPERATORS = new ArrayList<>();
        Collections.addAll(OPERATORS, "-", "+", "/", "*", UNARY);

        BRACKETS = new ArrayList<>();
        Collections.addAll(BRACKETS, "(", ")");

        CONSTANTS = new HashMap<>();
        CONSTANTS.put("pi", Math.PI);
        CONSTANTS.put("e", Math.E);
    }

    private List<String> getTokens(String expression) {

        expression = expression
                .toLowerCase()
                .replace(",", ".")
                .replaceAll("['`]", "");

        for (String function : FUNCTIONS) {
            expression = expression.replace(function, " " + function + " ");
        }

        for (String operator : OPERATORS) {
            expression = expression.replace(operator, " " + operator + " ");
        }

        for (String bracket : BRACKETS) {
            expression = expression.replace(bracket, " " + bracket + " ");
        }

        for (Map.Entry<String, Double> entry : CONSTANTS.entrySet()) {
            expression = expression.replace(entry.getKey(), " " + entry.getValue() + " ");
        }

        List<String> tokens = new ArrayList<>();
        String previous = "";

        for (String token : expression.split("[ ]+")) {
            if ((isNumber(previous) || isCloseBracket(previous) || previous.matches("[!]")) &&
                    (isOpenBracket(token) || isNumber(token) || isFunction(token) && !token.matches("[!%^]"))) {
                tokens.add("*");
                tokens.add(token);
            } else if (token.equals("-") && !isNumber(previous) && !isCloseBracket(previous) && !previous.matches("[!]")) {
                tokens.add("-1");
                tokens.add(UNARY);
            } else if (token.equals("+") && !isNumber(previous) && !isCloseBracket(previous) && !previous.matches("[!]")) {
                tokens.add("1");
                tokens.add(UNARY);
            } else tokens.add(token);
            previous = token;
        }
        return tokens;
    }

    /**
     * Алгоритм toRPN:
     * <p>
     * Пока есть ещё символы для чтения:
     * <p>
     * Читаем очередной символ.
     * <p>
     * Если символ является числом, добавляем его к выходной строке.
     * <p>
     * Если символ является символом функции, помещаем его в стек.
     * <p>
     * Если символ является открывающей скобкой, помещаем его в стек.
     * <p>
     * Если символ является закрывающей скобкой:
     * До тех пор, пока верхним элементом стека не станет открывающая скобка,
     * выталкиваем элементы из стека в выходную строку. При этом открывающая
     * скобка удаляется из стека, но в выходную строку не добавляется. Если
     * стек закончился раньше, чем мы встретили открывающую скобку, это означает,
     * что в выражении либо неверно поставлен разделитель, либо не согласованы скобки.
     * <p>
     * Если символ является оператором о1, тогда:
     * 1) пока…
     * … (если оператор o1 право-ассоциированный) приоритет o1 меньше приоритета
     * оператора, находящегося на вершине стека…
     * … (если оператор o1 ассоциированный, либо лево-ассоциированный) приоритет
     * o1 меньше либо равен приоритету оператора, находящегося на вершине стека…
     * … выталкиваем верхний элемент стека в выходную строку;
     * 2) помещаем оператор o1 в стек.
     * <p>
     * Когда входная строка закончилась, выталкиваем все символы из стека в
     * выходную строку. В стеке должны были остаться только символы операторов;
     * если это не так, значит в выражении не согласованы скобки.
     */
    private void toRPN(String expression) {

        for (String token : getTokens(expression)) {
            if (isNumber(token)) out.push(token);
            if (isFunction(token)) stack.push(token);
            if (isOpenBracket(token)) stack.push(token);
            if (isCloseBracket(token)) {
                while (!stack.empty() && !isOpenBracket(stack.peek())) {
                    out.push(stack.pop());
                }
                if (!stack.empty() && isOpenBracket(stack.peek())) stack.pop();
            }
            if (isOperator(token)) {
                while (!stack.empty() && operationPriority(token) <= operationPriority(stack.peek())) {
                    out.push(stack.pop());
                }
                stack.push(token);
            }
        }
        while (!stack.empty()) out.push(stack.pop());
    }

    /**
     * Автоматизация вычисления выражений в обратной польской нотации
     * основана на использовании стека.
     * <p>
     * Алгоритм вычисления для стековой машины:
     * <p>
     * 1.Обработка входного символа
     * * Если на вход подан операнд, он помещается на вершину стека.
     * * Если на вход подан знак операции, то соответствующая операция
     * выполняется над требуемым количеством значений, извлечённых из
     * стека, взятых в порядке добавления. Результат выполненной операции
     * кладётся на вершину стека.
     * <p>
     * 2.Если входной набор символов обработан не полностью, перейти к шагу 1.
     * <p>
     * 3.После полной обработки входного набора символов результат вычисления
     * выражения лежит на вершине стека.
     */
    public double calculate(String expression) {
        stack = new Stack<>();
        out = new Stack<>();
        toRPN(expression);

        for (String token : out) {
            if (isNumber(token)) stack.push(token);
            if (isOperator(token)) calculateOperation(token);
            if (isFunction(token)) calculateFunction(token);
        }
        return stack.size() == 1 && isNumber(stack.peek()) ?
                Double.parseDouble(stack.pop()) : .0 / .0;
    }

    /**
     * Оптимизация выражений
     * Если вы пишете интерпретатор, то выходная строка, полученная после
     * преобразования исходного выражения в обратную польскую нотацию, может
     * храниться вместо исходного выражения для последующей интерпретации.
     * Обратная польская нотация также позволяет компьютеру упрощать выражения.
     * Пример алгоритма упрощения выражения
     * Рассмотрим алгоритм, который осуществляет предвычисление констант в выражении.
     * Дано выражение в ОПН. Нам понадобится стек для хранения смешанных данных (чисел и операторов).
     * Алгоритм подобен тому, который применяется для вычисления выражений.
     * Мы просматриваем выражение слева направо.
     * <p>
     * Пока есть символы для чтения:
     * <p>
     * Читаем очередной символ.
     * <p>
     * Если символ является числом, помещаем его в стек.
     * <p>
     * Если символ является переменной, считая что переменная имеет значение null, помещаем символ в стек.
     * <p>
     * Если символ является оператором:
     * 1) (если все аргументы оператора, лежащие в стеке, имеют значение, отличное от null)
     * выталкиваем аргументы оператора из стека и помещаем в стек результат операции;
     * 2) (если хотя бы один из аргументов имеет значение null)
     * считая что результат операции null, кладём символ оператора в стек.
     * <p>
     * После того, как всё выражение просмотрено, то, что осталось в стеке, является оптимизированым
     * выражением (операторы выражения лежат в стеке в обратном порядке).
     */
    private void optimize() {
    }

    private void calculateOperation(String token) {
        try {
            double arg2 = Double.parseDouble(stack.pop()),
                    arg1 = Double.parseDouble(stack.pop());
            switch (token) {
                case "-":
                    stack.push(String.valueOf(arg1 - arg2));
                    break;
                case "+":
                    stack.push(String.valueOf(arg1 + arg2));
                    break;
                case "/":
                    stack.push(String.valueOf(arg1 / arg2));
                    break;
                case "*":
                    stack.push(String.valueOf(arg1 * arg2));
                    break;
                case UNARY:
                    stack.push(String.valueOf(arg1 * arg2));
                    break;
            }
        } catch (EmptyStackException e) {
            stack.push(String.valueOf(.0 / .0));
        }
    }

    private void calculateFunction(String token) {
        try {
            double arg1, arg2 = Double.parseDouble(stack.pop());
            switch (token) {
                case "sin":
                    stack.push(String.valueOf(Math.sin(arg2)));
                    break;
                case "cos":
                    stack.push(String.valueOf(Math.cos(arg2)));
                    break;
                case "tan":
                    stack.push(String.valueOf(Math.sin(arg2) / Math.cos(arg2)));
                    break;
                case "cot":
                    stack.push(String.valueOf(Math.cos(arg2) / Math.sin(arg2)));
                    break;
                case "!":
                    stack.push(String.valueOf(factorial(arg2)));
                    break;
                case "^":
                    arg1 = Double.parseDouble(stack.pop());
                    stack.push(String.valueOf(Math.pow(arg1, arg2)));
                    break;
                case "%":
                    arg1 = Double.parseDouble(stack.pop());
                    stack.push(String.valueOf(arg1 % arg2));
                    break;
                case "ln":
                    stack.push(String.valueOf(Math.log(arg2)));
                    break;
                case "lg":
                    stack.push(String.valueOf(Math.log10(arg2)));
                    break;
                case "abs":
                    stack.push(String.valueOf(Math.abs(arg2)));
                    break;
                case "sqrt":
                    stack.push(String.valueOf(Math.sqrt(arg2)));
                    break;
                case "cbrt":
                    stack.push(String.valueOf(Math.cbrt(arg2)));
                    break;
            }
        } catch (EmptyStackException e) {
            stack.push(String.valueOf(.0 / .0));
        }
    }

    private double factorial(double arg) {
        if ((arg % 1 != 0) || arg < 0) return .0 / .0;
        double result = 1;
        for (int i = (int) arg; i > 1; i--) result *= i;
        return result;
    }

    private boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isFunction(String token) {
        return FUNCTIONS.contains(token);
    }

    private boolean isOpenBracket(String token) {
        return token.equals("(");
    }

    private boolean isCloseBracket(String token) {
        return token.equals(")");
    }

    private boolean isOperator(String token) {
        return OPERATORS.contains(token);
    }

    private byte operationPriority(String token) {
        byte priority = -1;
        if (token.matches("[-+]")) priority = 0;
        if (token.matches("[*/]")) priority = 1;
        if (isFunction(token)) priority = 2;
        if (token.equals(UNARY)) priority = 3;
        return priority;
    }
}