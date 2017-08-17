package com.alex.calcx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    ExpressionCalculator calculator;
    StringBuilder expressionBuilder;

    TextView expression;
    TextView answer;

    Button zero, one, two, three, four, five, six, seven, eight, nine, dot, plus, minus, multiple, divide, mod, sin, cos, tan, cot, ln, lg, log, exp, abs, factorial, power, sqrt, cbrt, root, e, pi, openBr, closeBr, clear, backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        init();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);

        // Save the user's current game state
        savedInstanceState.putString("expression", expressionBuilder.toString());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);

        // Restore state members from saved instance
        expressionBuilder = new StringBuilder().append(savedInstanceState.getString("expression"));
        expression.setText(expressionBuilder);
        answer.setText(expression.getText().length() > 0 ?
                " = " + calculator.calculate(expression.getText().toString()) : "");
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.digit0:
                expressionBuilder.append("0");
                break;
            case R.id.digit1:
                expressionBuilder.append("1");
                break;
            case R.id.digit2:
                expressionBuilder.append("2");
                break;
            case R.id.digit3:
                expressionBuilder.append("3");
                break;
            case R.id.digit4:
                expressionBuilder.append("4");
                break;
            case R.id.digit5:
                expressionBuilder.append("5");
                break;
            case R.id.digit6:
                expressionBuilder.append("6");
                break;
            case R.id.digit7:
                expressionBuilder.append("7");
                break;
            case R.id.digit8:
                expressionBuilder.append("8");
                break;
            case R.id.digit9:
                expressionBuilder.append("9");
                break;
            case R.id.dot:
                expressionBuilder.append(".");
                break;
            case R.id.plus:
                expressionBuilder.append("+");
                break;
            case R.id.minus:
                expressionBuilder.append("-");
                break;
            case R.id.multiple:
                expressionBuilder.append("*");
                break;
            case R.id.divide:
                expressionBuilder.append("/");
                break;
            case R.id.mod:
                expressionBuilder.append("%");
                break;
            case R.id.sin:
                expressionBuilder.append("sin");
                break;
            case R.id.cos:
                expressionBuilder.append("cos");
                break;
            case R.id.tan:
                expressionBuilder.append("tan");
                break;
            case R.id.cot:
                expressionBuilder.append("cot");
                break;
            case R.id.ln:
                expressionBuilder.append("ln");
                break;
            case R.id.lg:
                expressionBuilder.append("lg");
                break;
            case R.id.log:
                expressionBuilder.append("log");
                break;
            case R.id.exp:
                expressionBuilder.append("exp");
                break;
            case R.id.abs:
                expressionBuilder.append("abs");
                break;
            case R.id.factorial:
                expressionBuilder.append("!");
                break;
            case R.id.power:
                expressionBuilder.append("^");
                break;
            case R.id.sqrt:
                expressionBuilder.append("sqrt");
                break;
            case R.id.cbrt:
                expressionBuilder.append("cbrt");
                break;
            case R.id.root:
                expressionBuilder.append("root");
                break;
            case R.id.e:
                expressionBuilder.append("e");
                break;
            case R.id.pi:
                expressionBuilder.append("pi");
                break;
            case R.id.openBr:
                expressionBuilder.append("(");
                break;
            case R.id.closeBr:
                expressionBuilder.append(")");
                break;
            case R.id.clear:
                expressionBuilder = new StringBuilder().append("");
                break;
            case R.id.backspace:
                if (expressionBuilder.length() > 0)
                    expressionBuilder.deleteCharAt(expressionBuilder.length() - 1);
                break;
        }
        expression.setText(expressionBuilder);
        answer.setText(expression.getText().length() > 0 ?
                " = " + calculator.calculate(expression.getText().toString()) : "");
    }

    private void init() {
        calculator = new ExpressionCalculator();
        expressionBuilder = new StringBuilder().append("");

        expression = (TextView) findViewById(R.id.expression);
        answer = (TextView) findViewById(R.id.answer);

        zero = (Button) findViewById(R.id.digit0);
        one = (Button) findViewById(R.id.digit1);
        two = (Button) findViewById(R.id.digit2);
        three = (Button) findViewById(R.id.digit3);
        four = (Button) findViewById(R.id.digit4);
        five = (Button) findViewById(R.id.digit5);
        six = (Button) findViewById(R.id.digit6);
        seven = (Button) findViewById(R.id.digit7);
        eight = (Button) findViewById(R.id.digit8);
        nine = (Button) findViewById(R.id.digit9);
        dot = (Button) findViewById(R.id.dot);
        plus = (Button) findViewById(R.id.plus);
        minus = (Button) findViewById(R.id.minus);
        multiple = (Button) findViewById(R.id.multiple);
        divide = (Button) findViewById(R.id.divide);
        mod = (Button) findViewById(R.id.mod);
        sin = (Button) findViewById(R.id.sin);
        cos = (Button) findViewById(R.id.cos);
        tan = (Button) findViewById(R.id.tan);
        cot = (Button) findViewById(R.id.cot);
        ln = (Button) findViewById(R.id.ln);
        lg = (Button) findViewById(R.id.lg);
        log = (Button) findViewById(R.id.log);
        exp = (Button) findViewById(R.id.exp);
        abs = (Button) findViewById(R.id.abs);
        factorial = (Button) findViewById(R.id.factorial);
        power = (Button) findViewById(R.id.power);
        sqrt = (Button) findViewById(R.id.sqrt);
        cbrt = (Button) findViewById(R.id.cbrt);
        root = (Button) findViewById(R.id.root);
        e = (Button) findViewById(R.id.e);
        pi = (Button) findViewById(R.id.pi);
        openBr = (Button) findViewById(R.id.openBr);
        closeBr = (Button) findViewById(R.id.closeBr);
        clear = (Button) findViewById(R.id.clear);
        backspace = (Button) findViewById(R.id.backspace);

        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        dot.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        multiple.setOnClickListener(this);
        divide.setOnClickListener(this);
        mod.setOnClickListener(this);
        sin.setOnClickListener(this);
        cos.setOnClickListener(this);
        tan.setOnClickListener(this);
        cot.setOnClickListener(this);
        ln.setOnClickListener(this);
        lg.setOnClickListener(this);
        log.setOnClickListener(this);
        exp.setOnClickListener(this);
        abs.setOnClickListener(this);
        factorial.setOnClickListener(this);
        power.setOnClickListener(this);
        sqrt.setOnClickListener(this);
        cbrt.setOnClickListener(this);
        root.setOnClickListener(this);
        e.setOnClickListener(this);
        pi.setOnClickListener(this);
        openBr.setOnClickListener(this);
        closeBr.setOnClickListener(this);
        clear.setOnClickListener(this);
        backspace.setOnClickListener(this);
    }
}
