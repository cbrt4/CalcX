package com.alex.calcx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    ExpressionCalculator calculator = new ExpressionCalculator();

    TextView expression;
    TextView answer;

    Button zero;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button dot;
    Button plus;
    Button minus;
    Button multiple;
    Button divide;
    Button mod;
    Button sin;
    Button cos;
    Button tan;
    Button cot;
    Button ln;
    Button lg;
    Button log;
    Button exp;
    Button abs;
    Button factorial;
    Button power;
    Button sqrt;
    Button cbrt;
    Button root;
    Button e;
    Button pi;
    Button openBr;
    Button closeBr;
    Button clear;
    Button backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

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

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.digit0:
                expression.append("0");
                break;
            case R.id.digit1:
                expression.append("1");
                break;
            case R.id.digit2:
                expression.append("2");
                break;
            case R.id.digit3:
                expression.append("3");
                break;
            case R.id.digit4:
                expression.append("4");
                break;
            case R.id.digit5:
                expression.append("5");
                break;
            case R.id.digit6:
                expression.append("6");
                break;
            case R.id.digit7:
                expression.append("7");
                break;
            case R.id.digit8:
                expression.append("8");
                break;
            case R.id.digit9:
                expression.append("9");
                break;
            case R.id.dot:
                expression.append(".");
                break;
            case R.id.plus:
                expression.append("+");
                break;
            case R.id.minus:
                expression.append("-");
                break;
            case R.id.multiple:
                expression.append("*");
                break;
            case R.id.divide:
                expression.append("/");
                break;
            case R.id.mod:
                expression.append("%");
                break;
            case R.id.sin:
                expression.append("sin");
                break;
            case R.id.cos:
                expression.append("cos");
                break;
            case R.id.tan:
                expression.append("tan");
                break;
            case R.id.cot:
                expression.append("cot");
                break;
            case R.id.ln:
                expression.append("ln");
                break;
            case R.id.lg:
                expression.append("lg");
                break;
            case R.id.log:
                expression.append("log");
                break;
            case R.id.exp:
                expression.append("exp");
                break;
            case R.id.abs:
                expression.append("abs");
                break;
            case R.id.factorial:
                expression.append("!");
                break;
            case R.id.power:
                expression.append("^");
                break;
            case R.id.sqrt:
                expression.append("sqrt");
                break;
            case R.id.cbrt:
                expression.append("cbrt");
                break;
            case R.id.root:
                expression.append("root");
                break;
            case R.id.e:
                expression.append("e");
                break;
            case R.id.pi:
                expression.append("pi");
                break;
            case R.id.openBr:
                expression.append("(");
                break;
            case R.id.closeBr:
                expression.append(")");
                break;
            case R.id.clear:
                expression.setText("");
                break;
            case R.id.backspace:
                if (expression.getText().length() > 0)
                    expression.setText(expression.getText().subSequence(0, expression.getText().length()-1));
                break;
        }
        answer.setText(expression.getText().length() > 0 ?
                " = " + calculator.calculate(expression.getText().toString()) : "");
    }
}
