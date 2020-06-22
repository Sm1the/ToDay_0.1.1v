package ru.anypixelstudio.com.today;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class OpenAlarm extends AppCompatActivity {

    private NotificationManager nm;
    private final int NOTIFICATION_ID = 1;
    PendingIntent pendingIntent;

    Button alarm_buttonOnOf;
    TimePicker _Alarm;
    AlarmManager alarmManager;
    Calendar calendar;
    Boolean alarm_OnOf = true;
    String timeAlarm;
    EditText editText;
    String getEditText;
    String hour_string;
    String minute_string;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_alarm);

        editText = (EditText)findViewById(R.id.editText);
        alarm_buttonOnOf = (Button)findViewById(R.id.Alarm_buttonOnOf);
        _Alarm = (TimePicker)findViewById(R.id.timePicker);
        alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        calendar = Calendar.getInstance();

        nm = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        intent = new Intent(getApplicationContext(), OpenAlarm.class);



    }

    @TargetApi(Build.VERSION_CODES.M)
    public void Start_Alarm(View v){
        calendar.set(Calendar.HOUR_OF_DAY,_Alarm.getHour());
        calendar.set(Calendar.MINUTE,_Alarm.getMinute());
        int hour = _Alarm.getHour();
        int minute = _Alarm.getMinute();
        hour_string = (String.valueOf(hour));
        minute_string = (String.valueOf(minute));

        if(hour > 12){
            //Для преобразования часов
            hour_string = String.valueOf(hour - 12);
        }

        if (minute < 10){
            //Для преобразования минут
            minute_string = "0" + String.valueOf(minute);
        }

        timeAlarm = "Будильник прозвенит в "+hour_string+":"+minute_string;
        if (alarm_OnOf == true){
            alarm_buttonOnOf.setText("Остановить");
            Toast.makeText(getBaseContext(), timeAlarm , Toast.LENGTH_SHORT).show();
            alarm_OnOf = false;
            pendingIntent = PendingIntent.getActivity(OpenAlarm.this, 0 , intent, PendingIntent.FLAG_UPDATE_CURRENT);
            alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),pendingIntent);
            Notification.Builder builder = new Notification.Builder(getApplicationContext());
            getEditText = String.valueOf(editText.getText());
            builder
                    .setContentIntent(pendingIntent)
                    .setSmallIcon(R.drawable.ic_notification)
                    .setLargeIcon(BitmapFactory.decodeResource(getApplication().getResources(),R.drawable.ic_notification))
                    .setTicker("Новое уведомление")
                    .setAutoCancel(true)
                    .setContentTitle(hour_string+":"+minute_string)
                    .setContentText(getEditText);

            Notification notification = builder.build();
            nm.notify(NOTIFICATION_ID,notification);
        }else{
            alarm_buttonOnOf.setText("Запустить");
            Toast.makeText(getBaseContext(), "Будильник остановлен!" , Toast.LENGTH_SHORT).show();
            alarm_OnOf = true;
        }
    }
}
