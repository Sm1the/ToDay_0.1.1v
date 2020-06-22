package ru.anypixelstudio.com.today;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.content.Intent;

public class MenuActivity extends AppCompatActivity {

    /* ===== Лист переменнхы. ===== */
    private static long back_pressed;
    String getLocalText_BackPress = null;
    /*String getLocalText_Add = "Добавить";
    String getLocalText_Edit = null;
    String getLocalText_View = null;
    String getLocalText_Setting = null;
    String getLocalText_About = null;*/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }


    public void addButton(View v){
        switch (v.getId()) {
            case R.id.Add_button:
                Intent in = new Intent(this, AddActivity.class);
                startActivity(in);
                break;
            default:
                break;
        }
    }

    public void viewButton(View v){

    }

    public void openCalendar(View v){
        switch (v.getId()) {
            case R.id.Calendar_button:
                Intent in = new Intent(this, OpenCalendar.class);
                startActivity(in);
                break;
            default:
                break;
        }
    }

    public void openAlarm(View v){
        switch (v.getId()) {
            case R.id.Alarm_button:
                Intent in = new Intent(this, OpenAlarm.class);
                startActivity(in);
                break;
            default:
                break;
        }
    }

    public void settingButton(View v){

    }

    public void aboutButton(View v){

    }

    /* Закрытие приложения по двойному клику кнопки "Назад" */
    @Override
    public void onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
        } else {
            Toast.makeText(getBaseContext(), getLocalText_BackPress , Toast.LENGTH_SHORT).show();
        }
        back_pressed = System.currentTimeMillis();
    }
}
