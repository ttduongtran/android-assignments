package com.example.basiccalculator;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView input, signbox;

    String sign, value1, value2;
    Double num1, num2, result;

    boolean hasDot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (TextView)findViewById(R.id.input);
        signbox = (TextView)findViewById(R.id.sign);
    }

    //    Buttons
    public void handleClick_0(View view) {
        input.setText(input.getText() + "0");
    }
    public void handleClick_1(View view) {
        input.setText(input.getText() + "1");
    }
    public void handleClick_2(View view) {
        input.setText(input.getText() + "2");
    }
    public void handleClick_3(View view) {
        input.setText(input.getText() + "3");
    }
    public void handleClick_4(View view) {
        input.setText(input.getText() + "4");
    }
    public void handleClick_5(View view) {
        input.setText(input.getText() + "5");
    }
    public void handleClick_6(View view) {
        input.setText(input.getText() + "6");
    }
    public void handleClick_7(View view) {
        input.setText(input.getText() + "7");
    }
    public void handleClick_8(View view) {
        input.setText(input.getText() + "8");
    }
    public void handleClick_9(View view) {
        input.setText(input.getText() + "9");
    }

    // Functionals
    public void handleClick_dot(View view) {
        if (!hasDot) {
            if (input.getText().equals("")) {

                input.setText("0.");
            } else {

                input.setText(input.getText() + ".");
            }

            hasDot = true;
        }
    }

    public void handleClick_add(View view) {
        sign = "+";
        value1 = input.getText().toString();
        input.setText(null);
        signbox.setText(value1 + " +");
        hasDot = false;
    }

    public void handleClick_subtract(View view) {
        sign = "-";
        value1 = input.getText().toString();
        input.setText(null);
        signbox.setText(value1 + " -");
        hasDot = false;
    }

    public void handleClick_multiply(View view) {
        sign = "*";
        value1 = input.getText().toString();
        input.setText(null);
        signbox.setText(value1 + " *");
        hasDot = false;
    }

    public void handleClick_divide(View view) {
        sign = "/";
        value1 = input.getText().toString();
        input.setText(null);
        signbox.setText(value1 + " /");
        hasDot = false;
    }

    public void handleClick_log(View view) {
        sign = "log";
        value1 = input.getText().toString();
        input.setText(null);
        signbox.setText("log");
        hasDot = false;
    }

    public void handleClick_convert(View view) {
        sign = "convert";
        value1 = input.getText().toString();
        input.setText(null);
        signbox.setText("+/-");
        hasDot = false;
    }

    public void handleClick_power(View view) {
        sign = "power";
        value1 = input.getText().toString();
        input.setText(null);
        signbox.setText("xⁿ");
        hasDot = false;
    }

    public void handleClick_factorial(View view) {
        sign = "factorial";
        input.setText(null);
        signbox.setText("!");
        hasDot = false;
    }

    public void handleClick_sin(View view) {
        sign = "sin";
        input.setText(null);
        signbox.setText("sin");
        hasDot = false;
    }

    public void handleClick_cos(View view) {
        sign = "cos";
        input.setText(null);
        signbox.setText("cos");
        hasDot = false;
    }

    public void handleClick_tan(View view) {
        sign = "tan";
        input.setText(null);
        signbox.setText("tan");
        hasDot = false;
    }
    public void handleClick_root(View view) {
        sign = "root";
        input.setText(null);
        signbox.setText("√");
        hasDot = false;
    }
    public void handleClick_modulo(View view) {
        sign = "modulo";
        value1 = input.getText().toString();
        input.setText(null);
        signbox.setText(value1 + " %");
        hasDot = false;
    }
    public void handleClick_delete(View view) {
        if (input.getText().equals("")) {
            input.setText(null);
        } else {
            int len = input.getText().length();
            String s = input.getText().toString();
            if (s.charAt(len - 1) == '.') {
                hasDot = false;
                input.setText(input.getText().subSequence(0, input.getText().length() - 1));

            } else {
                input.setText(input.getText().subSequence(0, input.getText().length() - 1));
            }
        }
    }
    public void handleClick_clear(View view) {
        input.setText(null);
        signbox.setText(null);
        value1 = null;
        value2 = null;
        sign = null;
        hasDot = false;
    }
    public void handleClick_equal(View view) {
        if((sign == null
                || input.getText().equals("")
                    || ((sign.equals("+")
                                || sign.equals("-")
                                || sign.equals("*")
                                || sign.equals("/"))
                                && value1.equals("")))
                && (sign!="convert")) {
            signbox.setText("Error!!");
        } else {
            switch (sign) {
                case "+":
                    value2 = input.getText().toString();
                    num1 = Double.parseDouble(value1);
                    num2 = Double.parseDouble(value2);
                    result = num1 + num2;
                    input.setText(result + "");
                    sign = null;
                    signbox.setText(null);
                    break;
                case "-":
                    value2 = input.getText().toString();
                    num1 = Double.parseDouble(value1);
                    num2 = Double.parseDouble(value2);
                    result = num1 - num2;
                    input.setText(result + "");
                    sign = null;
                    signbox.setText(null);
                    break;
                case "*":
                    value2 = input.getText().toString();
                    num1 = Double.parseDouble(value1);
                    num2 = Double.parseDouble(value2);
                    result = num1 * num2;
                    input.setText(result + "");
                    sign = null;
                    signbox.setText(null);
                    break;
                case "/":
                    value2 = input.getText().toString();
                    num2 = Double.parseDouble(value2);
                    if (num2 == 0) {
                        signbox.setText("Error!!");
                    } else {
                        num1 = Double.parseDouble(value1);
                        result = num1 / num2;
                        input.setText(result + "");
                        sign=null;
                        signbox.setText(null);
                    }
                    break;
                case "modulo":
                    value2 = input.getText().toString();
                    num1 = Double.parseDouble(value1);
                    num2 = Double.parseDouble(value2);
                    result =  num1 % num2;
                    input.setText(result + "");
                    sign = null;
                    signbox.setText(null);
                    break;
                case "convert":
                    num1 = Double.parseDouble(value1);
                    num2 = -1.0;
                    result = num1*num2;
                    input.setText(result + "");
                    sign = null;
                    signbox.setText(null);
                    break;
                case "log":
                    value1 = input.getText().toString();
                    num1 = Double.parseDouble(value1);
                    input.setText(Math.log10(num1) + "");
                    sign = null;
                    signbox.setText(null);
                    break;
                case "power":
                    num1 = Double.parseDouble((value1));
                    value2 = input.getText().toString();
                    num2 = Double.parseDouble(value2);
                    input.setText(Math.pow(num1, num2) + "");
                    sign = null;
                    signbox.setText(null);
                    break;
                case "root":
                    value1 = input.getText().toString();
                    num1 = Double.parseDouble((value1));
                    input.setText(Math.sqrt(num1) + "");
                    sign = null;
                    signbox.setText(null);
                    break;
                case "factorial":
                    value1 = input.getText().toString();
                    num1 = Double.parseDouble((value1));
                    int i = Integer.parseInt(value1) - 1;

                    while (i > 0) {
                        num1 = num1 * i;
                        i--;
                    }

                    input.setText(num1 + "");
                    sign = null;
                    signbox.setText(null);
                    break;

                default:
                    break;
            }
        }
    }

//    private void calc(String sign, String val1, String val2) {
//        num1 = Double.parseDouble(val1);
//        num2 = Double.parseDouble(val2);
//        return num1 - num2;
//    }
}