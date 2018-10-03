package actpracticarecepcion.app.com.services;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.widget.Toast;

public class HellowService extends Service {
    private Looper mServiceLooper;
    private ServiceHandler mServiceHandler;

    //Handler que recibe mensajes del thread
    private final class ServiceHandler extends Handler {
        public ServiceHandler(Looper looper) {
            super(looper);
        }
        @Override
        public void handleMessage(Message msg) {
            //Normalmente el trabajo se hace aquí como por ejemplo bajar un archivo.
            //En este ejemplo se pone un thread a dormir por 5 segundos
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            //Paramos el servicio usando el startId
            stopSelf(msg.arg1);
        }
    }
    @Override
    public void onCreate() {
        //Iniciar el hilo ejecutando el ervicio. Tenga  en cuenta que creamos un
        //hilo separado porque el servicio normalmente se ejecuta en el proceso
        //hilo principal, que no queremos bloquear.Nosotros tambien lo hacemos
        //prioridad de fondo para que el trabajo intensivo de CPU no interumpa nuestro intent
        HandlerThread thread =  new HandlerThread("ServiceStartArguments", Process.THREAD_PRIORITY_BACKGROUND);
        thread.start();

        //Get the HandlerThread's Looper and use it for ur Handler
        mServiceLooper = thread.getLooper();
        mServiceHandler = new ServiceHandler(mServiceLooper);
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show();


        Message msg = mServiceHandler.obtainMessage();
        mServiceHandler.sendMessage(msg);
        //Si nos matan, despues de regresar de aqui reinicie
        return START_STICKY;
    }
    @Override
    public IBinder onBind(Intent intent) {
        //We don't provide binding, so return null
        return null;
    }
    @Override
    public void onDestroy() {
        Toast.makeText(this, "service done", Toast.LENGTH_SHORT).show();
    }
}

