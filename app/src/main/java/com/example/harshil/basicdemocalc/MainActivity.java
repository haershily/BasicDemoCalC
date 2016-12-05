package com.example.harshil.basicdemocalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MainActivity extends AppCompatActivity {
    public static final String TAG="MainActivity";
    private EditText et1,et2;
    private Button bt1,bt2,bt3,bt4;
    private TextView tvReult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.et_vone);
        et2=(EditText)findViewById(R.id.et_vtwo);
        bt1=(Button)findViewById(R.id.ADD);
        bt2=(Button)findViewById(R.id.SUB);
        bt3=(Button)findViewById(R.id.MUL);
        bt4=(Button)findViewById(R.id.DIV);
        tvReult=(TextView)findViewById(R.id.Result);

        View.OnClickListener clickListener=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           try{ float a=et1.getText().toString().isEmpty()?0:Float.parseFloat(et1.getText().toString());
                float b=et2.getText().toString().isEmpty()?0:Float.parseFloat(et2.getText().toString());
            float c=0;
            switch(view.getId()){
                case R.id.ADD:c=a+b;break;
                case R.id.SUB:c=a-b;break;
                case R.id.MUL:c=a*b;break;
                case R.id.DIV:c=a/b;break;

            }
                tvReult.setText(String.valueOf(c));
            }catch (NumberFormatException e){
               Toast.makeText(MainActivity.this,"Numbers must be int",Toast.LENGTH_LONG);}
            catch (ArithmeticException e){
                Toast.makeText(MainActivity.this,"Cannot perform Operation",Toast.LENGTH_LONG);
            }
            }

        };
        bt1.setOnClickListener(clickListener);
        bt2.setOnClickListener(clickListener);
        bt3.setOnClickListener(clickListener);
        bt4.setOnClickListener(clickListener);
    }
}