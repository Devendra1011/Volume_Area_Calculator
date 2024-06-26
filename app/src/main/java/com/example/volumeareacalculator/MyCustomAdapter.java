package com.example.volumeareacalculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<Shape> {

    private ArrayList<Shape> shapesArrayList;

    Context context;

    public MyCustomAdapter(ArrayList<Shape> shapesArrayList, Context context) {
        super(context, R.layout.grid_item_layout, shapesArrayList);
        this.shapesArrayList = shapesArrayList;
        this.context = context;
    }


    private static class MyViewHolder {
        TextView shapeName;
        ImageView shapeImage;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        // Get the shape object for the current position
        Shape shapes = getItem(position);


        // Inflating layout

        MyViewHolder myViewHolder;


        if (convertView == null) {
            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.grid_item_layout, parent, false);

            // finding the views
            myViewHolder.shapeImage = (ImageView) convertView.findViewById(R.id.image_view);
            myViewHolder.shapeName = (TextView) convertView.findViewById(R.id.text_shape);


            convertView.setTag(myViewHolder);


        } else {

            // a view went off-screen
            myViewHolder = (MyViewHolder) convertView.getTag();


        }

        myViewHolder.shapeName.setText(shapes.getShapeName());
        myViewHolder.shapeImage.setImageResource(shapes.getShapeImg());
        return convertView;


    }
}
