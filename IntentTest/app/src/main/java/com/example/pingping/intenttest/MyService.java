package com.example.pingping.intenttest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private static final String TAG = "pingping.intenttest";

    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"onStartCommand() is called");


        Runnable r = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<5; i++) {
                    long futureTime = System.currentTimeMillis() + 5000;
                    while(System.currentTimeMillis() < futureTime) {
                        synchronized (this) {
                            try{
                                wait(futureTime - System.currentTimeMillis());
                                Log.i(TAG, "Service is doing something");
                            }catch(Exception e) {
                            }
                        }
                    }
                }
            }
        };

        Thread pingsThread = new Thread(r);
        pingsThread.start();
        //return Service.START_STICKY;
        return Service.START_NOT_STICKY;
    }

    // not guaranteed to be called by the system
    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy() is called");
    }

    // Service must implement the onBind() method.
    // Since Started Services do not support binding, we can have a minor implementation of returning null
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
