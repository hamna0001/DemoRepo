package com.example.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView  tvOutput;
    Button btnOne , btnTwo, btnThree ,btnFour , btnFive , btnSix, btnSeven , btnEight ,  btnNine ,btnZero ,btnDoubleZero;
    Button btnAC ,btnClear ,btnModulus , btnDivide , btnMultiply ,btnPlus ,btnMinus ,btnEqual ,btnDot;

    Calculator calculator = new Calculator();
    boolean isClear = false;
    String  input ;
    View.OnClickListener btnDigitClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                if(isClear){
                    calculator.setFirstOperand(Double.parseDouble(tvOutput.getText().toString()));
                    tvOutput.setText("");
                    isClear = false;
                }
                Button btn =(Button)v;
                tvOutput.append(btn.getText().toString());
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    };
    View.OnClickListener btnOperatorsClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            isClear = true;
            calculator.setOperator(((Button)v).getText().toString().charAt(0));
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvOutput =findViewById(R.id.tvOutput);
        btnOne =findViewById(R.id.btnOne);
        btnTwo =findViewById(R.id.btnTwo);
        btnThree =findViewById(R.id.btnThree);
        btnFour =findViewById(R.id.btnFour);
        btnFive =findViewById(R.id.btnFive);
        btnSix =findViewById(R.id.btnSix);
        btnSeven =findViewById(R.id.btnSeven);
        btnEight =findViewById(R.id.btnEight);
        btnNine =findViewById(R.id.btnNine);
        btnZero =findViewById(R.id.btnZero);
        btnDoubleZero =findViewById(R.id.btnDoubleZero);
        btnAC =findViewById(R.id.btnAc);
        btnClear =findViewById(R.id.btnClear);
        btnModulus =findViewById(R.id.btnModulus);
        btnDivide =findViewById(R.id.btnDivision);
        btnMultiply =findViewById(R.id.btnMultiply);
        btnPlus =findViewById(R.id.btnPlus);
        btnMinus =findViewById(R.id.btnMinus);
        btnEqual =findViewById(R.id.btnEqual);
        btnDot =findViewById(R.id.btnDot);

        btnOne.setOnClickListener(btnDigitClickListener);
        btnTwo.setOnClickListener(btnDigitClickListener);
        btnThree.setOnClickListener(btnDigitClickListener);
        btnFour.setOnClickListener(btnDigitClickListener);
        btnFive.setOnClickListener(btnDigitClickListener);
        btnSix.setOnClickListener(btnDigitClickListener);
        btnSeven.setOnClickListener(btnDigitClickListener);
        btnEight.setOnClickListener(btnDigitClickListener);
        btnNine.setOnClickListener(btnDigitClickListener);
        btnZero.setOnClickListener(btnDigitClickListener);
        btnDoubleZero.setOnClickListener(btnDigitClickListener);

        btnModulus.setOnClickListener(btnOperatorsClickListener);
        btnPlus.setOnClickListener(btnOperatorsClickListener);
        btnMinus.setOnClickListener(btnOperatorsClickListener);
        btnMultiply.setOnClickListener(btnOperatorsClickListener);
        btnDivide.setOnClickListener(btnOperatorsClickListener);

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String  secondOperand = tvOutput.getText().toString();
                if(isClear){
                    Toast.makeText(MainActivity.this, "second operand is null", Toast.LENGTH_SHORT).show();
                    calculator.setSecondOperand(0);
                    calculator.setFirstOperand(Double.parseDouble(secondOperand));
                    Toast.makeText(MainActivity.this, "So second operand is set to zero", Toast.LENGTH_SHORT).show();
                    isClear=false;
                }else {
                    calculator.setSecondOperand(Double.parseDouble(tvOutput.getText().toString()));
                }

                tvOutput.setText(Double.toString(calculator.calculate()));
                Toast.makeText(MainActivity.this,"Result",Toast.LENGTH_SHORT).show();
            }
        });
        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isClear = false;
                tvOutput.setText(null);

            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isClear = false;
                String input = tvOutput.getText().toString();
                String result = "";
                if (input.length()>0){
                    result = input.substring(0,input.length()-1);
                }
                tvOutput.setText(result);
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isClear = false;
                String  result = tvOutput.getText().toString();
                if(!result.contains(".")){
                    tvOutput.setText(result + ".");
                }
            }
        });
    }
}