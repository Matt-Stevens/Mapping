package com.example.a2stevm21.mapping;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MapChooseActivity extends Activity implements View.OnClickListener {
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mca);

        Button btnRegular = (Button) findViewById(R.id.btnRegular);
        btnRegular.setOnClickListener(this);
        Button btnCycleMap = (Button) findViewById(R.id.btnCycleMap);
        btnCycleMap.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        boolean cyclemap = false;
        if (view.getId() == R.id.btnCycleMap){
            cyclemap = true;
        }
        bundle.putBoolean("com.example.cyclemap", cyclemap);
        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        finish();
    }
}
