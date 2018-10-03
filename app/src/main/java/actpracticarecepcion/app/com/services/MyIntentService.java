package actpracticarecepcion.app.com.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class MyIntentService extends IntentService {
    public MyIntentService(String name) {super(name);}
    public MyIntentService() {super("MyIntentService");}

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        //Normally we would do some work here, like download a file.
        //For our sample, we just sleep for 5 seconds.
        Toast.makeText(this, "onHandleIntent", Toast.LENGTH_SHORT).show();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            //Restore interrupt status
            Thread.currentThread().interrupt();
        }
    }
    
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "intent service starting", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy(){
        Toast.makeText(this, "intent service done", Toast.LENGTH_SHORT).show();
    }
}
