package com.example.a2stevm21.mapping;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

public class HelloMap extends Activity implements View.OnClickListener {
    MapView mv;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(this);

        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));
        mv =(MapView)findViewById(R.id.map1);
        mv.setBuiltInZoomControls(true);
        mv.getController().setZoom(14);
        mv.getController().setCenter(new GeoPoint(40.1, 22.5));

    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_hello_map, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.choosemap){

            Intent intent = new Intent(this,MapChooseActivity.class);
            startActivityForResult(intent, 0);
            return true;
        }
        return false;
    }
    protected void onActivityResult(int requestCode,int resultCode,Intent intent)
    {

        if(requestCode==0) //id of activity launching new activity
        {

            if (resultCode==RESULT_OK) //code send back to main activity from the second activity
            {
                Bundle extras=intent.getExtras();
                boolean cyclemap = extras.getBoolean("com.example.cyclemap");
                if(cyclemap==true)
                {
                    mv.setTileSource(TileSourceFactory.CYCLEMAP);
                }
                else
                {
                    mv.setTileSource(TileSourceFactory.MAPNIK);
                }
            }
        }
    }

    @Override
    public void onClick(View view) {
        EditText latitudeEditText = (EditText) findViewById(R.id.latitudeInput);
        double latitude = Double.parseDouble(latitudeEditText.getText().toString());

        EditText longitudeEditText = (EditText) findViewById(R.id.longitudeInput);
        double longitude = Double.parseDouble(longitudeEditText.getText().toString());

        mv.getController().setCenter(new GeoPoint(latitude, longitude));
    }
}
