package com.example.zad_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SensorDetailsActivity extends AppCompatActivity implements SensorEventListener {
    static final String EXTRA_SENSOR_TYPE_PARAMETER = "EXTRA_SENSOR_TYPE";
    private SensorManager sensorManager;
    private Sensor sensor;
    private TextView sensorNameTextView;
    private TextView sensorValueTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_details);
        Log.d("APP_LIFECYCLE_TAG", "Sensor created");

        sensorNameTextView = findViewById(R.id.sensor_name);
        sensorValueTextView = findViewById(R.id.sensor_value);

        int type = getIntent().getIntExtra(EXTRA_SENSOR_TYPE_PARAMETER, Sensor.TYPE_ACCELEROMETER);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(type);

        if(sensor == null){
            sensorNameTextView.setText(R.string.missing_sensor);
        }
        else{
            sensorNameTextView.setText(sensor.getName());
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("APP_LIFECYCLE_TAG", "Sensor start");

        if (sensor != null) {
            sensorManager.registerListener(this, sensor, sensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("APP_LIFECYCLE_TAG", "Sensor stop");

        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Log.d("APP_LIFECYCLE_TAG", "Sensor changed");

        switch(sensorEvent.sensor.getType()){
            case Sensor.TYPE_LIGHT:
                sensorValueTextView.setText(getResources().getString(R.string.sensor_label_value_2, sensorEvent.values[0]));
                break;
            case Sensor.TYPE_PROXIMITY:
                sensorValueTextView.setText(getResources().getString(R.string.sensor_label_value_2, sensorEvent.values[0]));
                break;
            case Sensor.TYPE_ACCELEROMETER:
                sensorValueTextView.setText(getResources().getString(R.string.sensor_label_value_1, sensorEvent.values[0], sensorEvent.values[1], sensorEvent.values[2]));
                break;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        Log.d("APP_LIFECYCLE_TAG", "Sensor accuracy changed");
    }
}