package com.alex.calcx;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private final static String EXPRESSION = "expression";
    private ExpressionCalculator calculator;
    private StringBuilder expressionBuilder;
    private SharedPreferences sharedPrefs;
    private TextView expression;
    private TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        init();
    }

    @Override
    public void onStart() {
        super.onStart();
        loadExpression();
        expression.setText(expressionBuilder);
        answer.setText(expression.getText().length() > 0 ?
                " = " + calculator.calculate(expression.getText().toString()) : "");
    }

    @Override
    protected void onStop() {
        super.onStop();
        saveExpression();
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
        // Save the user's current game state
        savedInstanceState.putString(EXPRESSION, expressionBuilder.toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);
        // Restore state members from saved instance
        expressionBuilder = new StringBuilder().append(savedInstanceState.getString(EXPRESSION));
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

        Button zero = (Button) findViewById(R.id.digit0);
        Button one = (Button) findViewById(R.id.digit1);
        Button two = (Button) findViewById(R.id.digit2);
        Button three = (Button) findViewById(R.id.digit3);
        Button four = (Button) findViewById(R.id.digit4);
        Button five = (Button) findViewById(R.id.digit5);
        Button six = (Button) findViewById(R.id.digit6);
        Button seven = (Button) findViewById(R.id.digit7);
        Button eight = (Button) findViewById(R.id.digit8);
        Button nine = (Button) findViewById(R.id.digit9);
        Button dot = (Button) findViewById(R.id.dot);
        Button plus = (Button) findViewById(R.id.plus);
        Button minus = (Button) findViewById(R.id.minus);
        Button multiple = (Button) findViewById(R.id.multiple);
        Button divide = (Button) findViewById(R.id.divide);
        Button mod = (Button) findViewById(R.id.mod);
        Button sin = (Button) findViewById(R.id.sin);
        Button cos = (Button) findViewById(R.id.cos);
        Button tan = (Button) findViewById(R.id.tan);
        Button cot = (Button) findViewById(R.id.cot);
        Button ln = (Button) findViewById(R.id.ln);
        Button lg = (Button) findViewById(R.id.lg);
        Button log = (Button) findViewById(R.id.log);
        Button exp = (Button) findViewById(R.id.exp);
        Button abs = (Button) findViewById(R.id.abs);
        Button factorial = (Button) findViewById(R.id.factorial);
        Button power = (Button) findViewById(R.id.power);
        Button sqrt = (Button) findViewById(R.id.sqrt);
        Button cbrt = (Button) findViewById(R.id.cbrt);
        Button root = (Button) findViewById(R.id.root);
        Button e = (Button) findViewById(R.id.e);
        Button pi = (Button) findViewById(R.id.pi);
        Button openBr = (Button) findViewById(R.id.openBr);
        Button closeBr = (Button) findViewById(R.id.closeBr);
        Button clear = (Button) findViewById(R.id.clear);
        Button backspace = (Button) findViewById(R.id.backspace);

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

    private void saveExpression() {
        sharedPrefs = getSharedPreferences("CalcMain", MODE_PRIVATE);
        Editor editor = sharedPrefs.edit();
        editor.putString(EXPRESSION, expressionBuilder.toString()).apply();
        //Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
    }

    private void loadExpression() {
        sharedPrefs = getSharedPreferences("CalcMain", MODE_PRIVATE);
        expressionBuilder = new StringBuilder().append(sharedPrefs.getString(EXPRESSION, ""));
        //Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();
    }
}
