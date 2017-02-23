package com.example.a2stevm21.mapping;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MapViewListActivity extends ListActivity {


    String[] maps, details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        maps = new String[]{"Regular Map", "Cycle Map"};
        details = new String[]{"A general purpose map", "A map designed for cycling"};
        MyAdapter adapter = new MyAdapter();
        setListAdapter(adapter);
    }
        public void onListItemClick(ListView listview, View view, int index, long id){

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


    public class MyAdapter extends ArrayAdapter<String>
    {
        public MyAdapter()
        // We have to use ExampleListActivity.this to refer to the outer class (the activity)
        {
            super(MapViewListActivity.this, android.R.layout.simple_list_item_1, maps);
        }

        public View getView(int index, View convertView, ViewGroup parent)
        {
            LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.activity_map_view_list, parent, false);
            TextView maptype = (TextView)view.findViewById(R.id.maptype);
            TextView description = (TextView)view.findViewById(R.id.description);
            maptype.setText(maps[index]);
            description.setText(details[index]);
            return view;
        }
    }
}
