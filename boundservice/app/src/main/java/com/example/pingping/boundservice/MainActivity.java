package com.example.pingping.boundservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.pingping.boundservice.MyService.MyLocalBinder;

public class MainActivity extends AppCompatActivity {

    MyService pingsService;
    boolean isBound = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = new Intent(this, MyService.class);
        bindService(i,pingsConnection, Context.BIND_AUTO_CREATE);  // client uses this method to bind to service
        // bindService is a two-way communication service, while started started service is not.
    }

    public void showTime(View view) {
        String currentTime = pingsService.getCurrentTime();
        TextView pingsText = (TextView)findViewById(R.id.pingsText);
        pingsText.setText(currentTime);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private ServiceConnection pingsConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyLocalBinder binder = (MyLocalBinder) service;     //communication channel
            pingsService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };

}

// Articles explained Services: http://codetheory.in/understanding-android-started-bound-services/

