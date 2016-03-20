package com.example.pingping.sqlitesample;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    EditText buckysInput;
    TextView buckysText;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buckysInput = (EditText)findViewById(R.id.buckysInput);
        buckysText = (TextView) findViewById(R.id.buckysText);
        dbHandler = new MyDBHandler(this, null, null, 1);
        //
        new printDB().execute();

    }

    // Add a product to the database
    public void addButtonClicked(View view){
        Products product = new Products(buckysInput.getText().toString());
        dbHandler.addProduct(product);
        //
        new printDB().execute();
    }

    // Delete Items
    public void deleteButtonClicked(View view) {
        String inputText = buckysInput.getText().toString();
        dbHandler.deleteProduct(inputText);
        //
        new printDB().execute();
    }

    private class printDB extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... voids) {
            String dbString = dbHandler.databaseToString();
            return dbString;
        }

        @Override
        protected void onPostExecute(String dbString) {
            buckysText.setText(dbString);
            buckysInput.setText("");
        }
    }
}
