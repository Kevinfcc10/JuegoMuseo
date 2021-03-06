package com.example.kevin.juegomuseo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Kevin on 12/2/2018.
 */

public class CustomGrid2 extends BaseAdapter {

    private Context mContext;
    private  int[] Imageid;
    private  String[] tags;

    public CustomGrid2(Context c,int[] Imageid,String[] tags ){
        mContext = c;
        this.Imageid = Imageid;
        this.tags=tags;
    }

    @Override
    public int getCount() {

        return Imageid.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.activity_grid_single2, null);
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image1);
            imageView.setImageResource(Imageid[position]);
            imageView.setTag(tags[position]);
        } else {
            grid = (View) convertView;
        }

        return grid;
    }

}
