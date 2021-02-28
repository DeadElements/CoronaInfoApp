package com.example.coronainfoapp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.preference.PreferenceManager;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.switchmaterial.SwitchMaterial;

import static com.example.coronainfoapp.R.string.notificationTirol;


public class Settings extends AppCompatActivity {

    String channel = "1111";
    String derText = "Eine Nachricht";

    SwitchMaterial switchMaterialVO;
    SwitchMaterial switchMaterialTI;
    SwitchMaterial switchMaterialSA;
    SwitchMaterial switchMaterialOOE;
    SwitchMaterial switchMaterialNOE;
    SwitchMaterial switchMaterialWI;
    SwitchMaterial switchMaterialBU;
    SwitchMaterial switchMaterialST;
    SwitchMaterial switchMaterialKAE;



    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        // Vorarlberg  ------------------------------------------------------------
        switchMaterialVO = findViewById(R.id.switchMaterial_1);
        SharedPreferences settings = getSharedPreferences("Settings", 0);
        switchMaterialVO.setChecked(settings.getBoolean("Vorarlberg",false));
        voListener();

        // Tirol ------------------------------------------------------------------
        switchMaterialTI = findViewById(R.id.switchMaterial_2);
        switchMaterialTI.setChecked(settings.getBoolean("Tirol", false));
        tiListener();

        // Salzburg ---------------------------------------------------------------
        switchMaterialSA = findViewById(R.id.switchMaterial_3);
        switchMaterialSA.setChecked(settings.getBoolean("Salzburg", false));
        saListener();

        // Oberösterreich ---------------------------------------------------------
        switchMaterialOOE = findViewById(R.id.switchMaterial_4);
        switchMaterialOOE.setChecked(settings.getBoolean("Oberoesterreich", false));
        ooeListener();

        // Niederösterreich -------------------------------------------------------
        switchMaterialNOE = findViewById(R.id.switchMaterial_5);
        switchMaterialNOE.setChecked(settings.getBoolean("Niederoesterreich", false));
        noeListener();

        // Wien -------------------------------------------------------------------
        switchMaterialWI = findViewById(R.id.switchMaterial_6);
        switchMaterialWI.setChecked(settings.getBoolean("Wien", false));
        wiListener();

        // Burgenland -------------------------------------------------------------------
        switchMaterialBU = findViewById(R.id.switchMaterial_7);
        switchMaterialBU.setChecked(settings.getBoolean("Burgenland", false));
        buListener();

        // Steiermark -------------------------------------------------------------------
        switchMaterialST = findViewById(R.id.switchMaterial_8);
        switchMaterialST.setChecked(settings.getBoolean("Steiermark", false));
        stListener();

        // Kärnten -------------------------------------------------------------------
        switchMaterialKAE = findViewById(R.id.switchMaterial_9);
        switchMaterialKAE.setChecked(settings.getBoolean("Kärnten", false));
        kaeListener();




        FloatingActionButton fab = findViewById(R.id.floating_action_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });




    }

    private void voListener() {
        switchMaterialVO.setOnClickListener(v -> {
            SharedPreferences settings1 = getSharedPreferences("Settings", 0);
            SharedPreferences.Editor editor = settings1.edit();
            editor.putBoolean("Vorarlberg", switchMaterialVO.isChecked());
            editor.apply();


            NotificationManager notif=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
            Notification notify = new Notification.Builder
                    (getApplicationContext()).setContentTitle("Tirol").setContentText("Hallo").
                    setContentTitle("subject").setSmallIcon(R.drawable.ic_info_solid).build();

            notify.flags |= Notification.FLAG_AUTO_CANCEL;
            notif.notify(0, notify);
        });


    }
    private void tiListener() {
        switchMaterialTI.setOnClickListener(v -> {
            SharedPreferences settings1 = getSharedPreferences("Settings", 0);
            SharedPreferences.Editor editor = settings1.edit();
            editor.putBoolean("Tirol", switchMaterialTI.isChecked());
            editor.apply();
        });
    }
    private void saListener() {
        switchMaterialSA.setOnClickListener(v -> {
            SharedPreferences settings1 = getSharedPreferences("Settings", 0);
            SharedPreferences.Editor editor = settings1.edit();
            editor.putBoolean("Salzburg", switchMaterialSA.isChecked());
            editor.apply();
        });
    }
    private void ooeListener() {
        switchMaterialOOE.setOnClickListener(v -> {
            SharedPreferences settings1 = getSharedPreferences("Settings", 0);
            SharedPreferences.Editor editor = settings1.edit();
            editor.putBoolean("Oberoesterreich", switchMaterialOOE.isChecked());
            editor.apply();
        });
    }
    private void noeListener() {
        switchMaterialNOE.setOnClickListener(v -> {
            SharedPreferences settings1 = getSharedPreferences("Settings", 0);
            SharedPreferences.Editor editor = settings1.edit();
            editor.putBoolean("Niederoesterreich", switchMaterialNOE.isChecked());
            editor.apply();
        });
    }
    private void wiListener() {
        switchMaterialWI.setOnClickListener(v -> {
            SharedPreferences settings1 = getSharedPreferences("Settings", 0);
            SharedPreferences.Editor editor = settings1.edit();
            editor.putBoolean("Wien", switchMaterialWI.isChecked());
            editor.apply();
        });
    }
    private void buListener() {
        switchMaterialBU.setOnClickListener(v -> {
            SharedPreferences settings2 = getSharedPreferences("Settings", 0);
            SharedPreferences.Editor editor = settings2.edit();
            editor.putBoolean("Burgenland", switchMaterialBU.isChecked());
            editor.apply();
        });
    }
    private void stListener() {
        switchMaterialST.setOnClickListener(v -> {
            SharedPreferences settings3 = getSharedPreferences("Settings", 0);
            SharedPreferences.Editor editor = settings3.edit();
            editor.putBoolean("Steiermark", switchMaterialST.isChecked());
            editor.apply();
        });
    }
    private void kaeListener() {
        switchMaterialKAE.setOnClickListener(v -> {
            SharedPreferences settings1 = getSharedPreferences("Settings", 0);
            SharedPreferences.Editor editor = settings1.edit();
            editor.putBoolean("Kärnten", switchMaterialKAE.isChecked());
            editor.apply();
        });
    }


    private void addNotification() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channel)
                .setSmallIcon(R.drawable.ic_info_solid)
                .setContentTitle("Voralberg Notifications eingerichtet")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

// notificationId is a unique int for each notification that you must define
        notificationManager.notify(1, builder.build());

    }
}



