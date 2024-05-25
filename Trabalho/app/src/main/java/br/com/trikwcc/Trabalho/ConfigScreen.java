package br.com.trikwcc.Trabalho;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.method.Touch;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ConfigScreen extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private RadioGroup speedGroup, geograficGroup, controlMapGroup;
    private RadioGroup controlTypeMap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config_screen);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        speedGroup = findViewById(R.id.control_speed);
        controlTypeMap = findViewById(R.id.control_mapType);
        geograficGroup = findViewById(R.id.control_geographic);
        controlMapGroup = findViewById(R.id.control_map);

        int checkedGeografic = sharedPreferences.getInt("geografic", -1);
        if (checkedGeografic != -1){
            RadioButton radionButton = findViewById(checkedGeografic);
            radionButton.setChecked(true);
        }

        int checkedTypeMap = sharedPreferences.getInt("controlTypeMap", -1);
        if (checkedTypeMap != -1){
            RadioButton radionButton = findViewById(checkedTypeMap);
            radionButton.setChecked(true);
        }


        int checkedRadioButtonId = sharedPreferences.getInt("speed", -1);
        if (checkedRadioButtonId != -1){
            RadioButton radionButton = findViewById(checkedRadioButtonId);
            radionButton.setChecked(true);
        }

        int checkedControlMap = sharedPreferences.getInt("controlMap", -1);
        if (checkedControlMap != -1){
            RadioButton radionButton = findViewById(checkedControlMap);
            radionButton.setChecked(true);
        }

        controlTypeMap.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("controlTypeMap", checkedId);
                editor.apply();
            }
        });

        geograficGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("geografic", checkedId);
                editor.apply();
            }
        });

        controlMapGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("controlMap", checkedId);
                editor.apply();
            }
        });

        speedGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("speed", checkedId);
                editor.apply();
            }
        });



    }

}