package com.example.relativecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView outputText;
    Button butC,butPlus,butMinus,butPercent,butMult,butSplit,butEqual,butPlusMinus;
    double tempDigit;
    short optionSelected=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init(){
        outputText=findViewById(R.id.outputView);
        butC=findViewById(R.id.butC);
        butPlus=findViewById(R.id.butPlus);
        butMinus=findViewById(R.id.butMinus);
        butMult=findViewById(R.id.butMultiplex);
        butSplit=findViewById(R.id.butSplit);
        butEqual=findViewById(R.id.butEqual);
        butPercent=findViewById(R.id.butPercent);
        butPlusMinus=findViewById(R.id.butPlusMinus);

        butPlusMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outputText.setText(String.valueOf((
                        -1*Double.valueOf(outputText.getText().toString()))));
            }
        });

        butPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempDigit=Double.valueOf(outputText.getText().toString());
                outputText.setText("");
                optionSelected=0;
            }
        });

        butMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempDigit=Double.valueOf(outputText.getText().toString());
                outputText.setText("");
                optionSelected=1;
            }
        });

        butPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempDigit=Double.valueOf(outputText.getText().toString());
                outputText.setText("");
                optionSelected=2;
            }
        });

        butMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempDigit=Double.valueOf(outputText.getText().toString());
                outputText.setText("");
                optionSelected=3;
            }
        });

        butSplit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempDigit=Double.valueOf(outputText.getText().toString());
                outputText.setText("");
                optionSelected=4;
            }
        });

        butEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(optionSelected!=-1) {
                    double secondDigit = Double.valueOf(outputText.getText().toString());
                    switch (optionSelected) {
                        case 0: {
                            outputText.setText(String.valueOf(tempDigit +secondDigit));
                            break;
                        }
                        case 1: {
                            outputText.setText(String.valueOf(tempDigit -secondDigit));
                            break;
                        }
                        case 2: {
                            outputText.setText(String.valueOf(tempDigit / 100 *secondDigit));
                            break;
                        }
                        case 3: {
                            outputText.setText(String.valueOf(tempDigit * secondDigit));
                            break;
                        }
                        case 4: {
                            outputText.setText(String.valueOf(tempDigit / secondDigit));
                            break;
                        }
                    }
                }
            }
        });
        butC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optionSelected=-1;
                outputText.setText("");
            }
        });

    }

    public void btnPress(View view) {
        Button btn = (Button) view;
        outputText.append(btn.getText());
    }

}
