package com.alex.calcx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    ExpressionCalculator calculator;

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
    Button solve;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculator = new ExpressionCalculator();

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
        solve = (Button) findViewById(R.id.solve);

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
        solve.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.digit0:
                answer.append("0");
                break;
            case R.id.digit1:
                answer.append("1");
                break;
            case R.id.digit2:
                answer.append("2");
                break;
            case R.id.digit3:
                answer.append("3");
                break;
            case R.id.digit4:
                answer.append("4");
                break;
            case R.id.digit5:
                answer.append("5");
                break;
            case R.id.digit6:
                answer.append("6");
                break;
            case R.id.digit7:
                answer.append("7");
                break;
            case R.id.digit8:
                answer.append("8");
                break;
            case R.id.digit9:
                answer.append("9");
                break;
            case R.id.dot:
                answer.append(".");
                break;
            case R.id.plus:
                answer.append("+");
                break;
            case R.id.minus:
                answer.append("-");
                break;
            case R.id.multiple:
                answer.append("*");
                break;
            case R.id.divide:
                answer.append("/");
                break;
            case R.id.mod:
                answer.append("%");
                break;
            case R.id.sin:
                answer.append("sin");
                break;
            case R.id.cos:
                answer.append("cos");
                break;
            case R.id.tan:
                answer.append("tan");
                break;
            case R.id.cot:
                answer.append("cot");
                break;
            case R.id.ln:
                answer.append("ln");
                break;
            case R.id.lg:
                answer.append("lg");
                break;
            case R.id.log:
                answer.append("log");
                break;
            case R.id.exp:
                answer.append("exp");
                break;
            case R.id.abs:
                answer.append("abs");
                break;
            case R.id.factorial:
                answer.append("!");
                break;
            case R.id.power:
                answer.append("^");
                break;
            case R.id.sqrt:
                answer.append("sqrt");
                break;
            case R.id.cbrt:
                answer.append("cbrt");
                break;
            case R.id.root:
                answer.append("root");
                break;
            case R.id.e:
                answer.append("e");
                break;
            case R.id.pi:
                answer.append("pi");
                break;
            case R.id.openBr:
                answer.append("(");
                break;
            case R.id.closeBr:
                answer.append(")");
                break;
            case R.id.clear:
                answer.setText("");
                break;
            case R.id.backspace:
                if (answer.getText().length() > 0) answer.setText(answer.getText().subSequence(0, answer.getText().length()-1));
                break;
            case R.id.solve:
                answer.append("\n = " + calculator.calculate(answer.getText().toString()) + "\n");
                break;
        }
    }
}
