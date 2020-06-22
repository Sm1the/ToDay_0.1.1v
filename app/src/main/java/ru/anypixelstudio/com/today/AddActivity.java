package ru.anypixelstudio.com.today;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {
    //Перменные для заполнение файла
    EditText edit_Shapka;
    EditText edit_Opisanie;

    //
    String _Shapka = null;
    String _Opisanie = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        //Определение по Id
        edit_Shapka = (EditText)findViewById(R.id.Edit_Shapka);
        edit_Opisanie = (EditText)findViewById(R.id.Edit_Opisanie);
        //


    }

    public void Button_Clear(View v){
        edit_Shapka.setText(null);
        edit_Opisanie.setText(null);
    }

    public void Button_Complite(View v){
        _Shapka = (String.valueOf(edit_Shapka.getText()));
        _Opisanie = (String.valueOf(edit_Opisanie.getText()));
    }



   /* public void clickToBack(View v){
        if(Layout1.getVisibility() == View.VISIBLE){
            Toast.makeText(getBaseContext(), "Вы и так на первой форме." , Toast.LENGTH_SHORT).show();
        }else{Layout1.setVisibility(View.VISIBLE); Button_Ok.setText("Вперед");}


    }

    public void clickToNext(View v){
        Layout1.setVisibility(View.GONE);
        if (Layout1.getVisibility() == View.GONE) {
            Button_Ok.setText("Завершить");

        }

    }*/
}
