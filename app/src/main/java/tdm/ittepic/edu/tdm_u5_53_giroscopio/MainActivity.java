package tdm.ittepic.edu.tdm_u5_53_giroscopio;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private Sensor mysensor;
    private SensorManager senman;
    TextView ejex, ejey, ejez;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        senman = (SensorManager) getSystemService(SENSOR_SERVICE);
        mysensor = senman.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        ejex = (TextView) findViewById(R.id.txtX);
        ejey = (TextView) findViewById(R.id.txtY);
        ejez = (TextView) findViewById(R.id.txtZ);
        senman.registerListener(this, mysensor, SensorManager.SENSOR_DELAY_GAME);
    }

    public void onSensorChanged(SensorEvent event) {
        ejex.setText("X:"+event.values[0]);
        ejey.setText("Y:"+event.values[1]);
        ejez.setText("Z:"+event.values[2]);

    }
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
// Hacer nada
    }

}
