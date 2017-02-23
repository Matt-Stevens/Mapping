package com.example.a2stevm21.mapping;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SetLocation extends Activity implements View.OnClickListener {
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_location);

        Button submitButton= (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        EditText setLatitude = (EditText) findViewById(R.id.setLatitude);
        double latitude = Double.parseDouble(setLatitude.getText().toString());
        EditText setLongitude = (EditText) findViewById(R.id.setLongitude);
        double longitude = Double.parseDouble(setLongitude.getText().toString());
        bundle.putDouble("com.example.setLat", latitude);
        bundle.putDouble("com.example.setLong", longitude);
        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);

        finish();

    }
}
