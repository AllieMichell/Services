package actpracticarecepcion.app.com.services;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void iniciarIntentService(View view) {
        Log.wtf("zzz", "iniciarIntentService");
        Intent intent = new Intent(this, MyIntentService.class);
        startService(intent);
    }
    public void pararIntentService(View view) {
        Log.wtf("zzz", "pararIntentService");
        Intent intent = new Intent(this, MyIntentService.class);
        stopService(intent);
    }
    public void iniciarService(View view) {
        Log.wtf("zzz", "iniciarService");
        Intent intent = new Intent(this, MyIntentService.class);
        startService(intent);
    }
}
