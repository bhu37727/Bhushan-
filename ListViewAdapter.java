package com.android.veggitech.growapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.veggitech.growapp.R;
import com.android.veggitech.growapp.model.TipModel;
import com.mindorks.placeholderview.ViewHolder;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;

    private ArrayList<TipModel> dataModelArrayList = new ArrayList<TipModel>();

    public ListViewAdapter(Context context, ArrayList<TipModel> dataModelArrayList) {
        /*this.context = context;
        this.tipTitle = tipTitle;
        this.tipDescription = tipDescription;*/
        //inflater = (LayoutInflater.from(applicationContext));
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        this.context = context;
        this.dataModelArrayList = dataModelArrayList;
    }

    @Override
    public int getCount() {
        return dataModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {


            view = inflater.inflate(R.layout.listview_tips, null);
        }

        final TextView textViewTitle = (TextView) view.findViewById(R.id.textViewHeading);
        final TextView textViewDes = (TextView) view.findViewById(R.id.textViewDescription);

        textViewTitle.setText(dataModelArrayList.get(position).getTitle().toString());
        textViewDes.setText(dataModelArrayList.get(position).getDescription().toString());


        return view;
       /* ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_tips, null, true);

           // holder.iv = (ImageView) convertView.findViewById(R.id.iv);
            holder.tipTitle = (TextView) convertView.findViewById(R.id.textViewHeading);
            holder.tipDescription = (TextView) convertView.findViewById(R.id.textViewDescription);


            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }

        //Picasso.get().load(dataModelArrayList.get(position).getImgURL()).into(holder.iv);
        holder.tipTitle.setText(dataModelArrayList.get(position).getTitle());
        holder.tipDescription.setText(dataModelArrayList.get(position).getDescription());

        return convertView;*/
    }

    private class ViewHolder {

        protected TextView tipTitle, tipDescription;
        //protected ImageView iv;
    }
}
