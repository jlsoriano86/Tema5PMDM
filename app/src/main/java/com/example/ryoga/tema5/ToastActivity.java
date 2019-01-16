package com.example.ryoga.tema5;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.view.View;

public class ToastActivity extends AppCompatActivity {
    EditText txtTextoToast;
    EditText txtHorizontal;
    EditText txtVertical;
    RadioGroup aliHorizontal;
    RadioGroup aliVertical;
    int aliHorizontalGravity;
    int aliVerticalGravity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
    }

    public void mostrar(View view) {
        txtTextoToast = (EditText) findViewById(R.id.txtTextoToast);
        txtHorizontal = (EditText) findViewById(R.id.txtHorizontal);
        txtVertical = (EditText) findViewById(R.id.txtVertical);
        aliHorizontal = (RadioGroup) findViewById(R.id.aliHorizontal);
        int index = aliHorizontal.indexOfChild(findViewById(aliHorizontal.getCheckedRadioButtonId()));
        RadioButton r = (RadioButton) aliHorizontal.getChildAt(index);
        String selectedtext1 = r.getText().toString();
        aliVertical = (RadioGroup) findViewById(R.id.aliVertical);
        index = aliVertical.indexOfChild(findViewById(aliVertical.getCheckedRadioButtonId()));
        r = (RadioButton) aliVertical.getChildAt(index);
        String selectedtext2 = r.getText().toString();


        if(selectedtext1.equals("Izquierda"))
        {
            aliHorizontalGravity = 3;
        }
        else if(selectedtext1.equals("Derecha"))
        {
            aliHorizontalGravity = 5;
        }
        else
        {
            aliHorizontalGravity = 1;
        }

        if(selectedtext2.equals("Arriba"))
        {
            aliVerticalGravity = 48;
        }
        else if(selectedtext2.equals("Centro"))
        {
            aliVerticalGravity = 16;
        }
        else
        {
            aliVerticalGravity = 80;
        }


        Toast toast = Toast.makeText(this, txtTextoToast.getText(), Toast.LENGTH_LONG);
        toast.setGravity(aliVerticalGravity|aliHorizontalGravity,(Integer.parseInt(txtHorizontal.getText().toString())), (Integer.parseInt(txtVertical.getText().toString())));
        toast.show();

    }
}
