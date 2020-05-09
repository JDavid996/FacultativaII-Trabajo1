package com.example.asignaturas_trabajo1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class AdaptadorLista extends BaseAdapter {
    private Context context;
    private int layout;
    private List<String> asignaturas;

    public AdaptadorLista(Context context, int layout, List<String> asignaturas) {
        this.context = context;
        this.layout = layout;
        this.asignaturas = asignaturas;
    }

    @Override
    public int getCount() {
        return asignaturas.size();
    }

    @Override
    public Object getItem(int position) {
        return asignaturas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null){
            LayoutInflater layoutInflater=LayoutInflater.from(this.context);
            convertView=layoutInflater.inflate(R.layout.item_list, null);
            holder=new ViewHolder();
            holder.textViewName=(TextView)convertView.findViewById(R.id.textViewLista);
            convertView.setTag(holder);
        }else {
            holder=(ViewHolder)convertView.getTag();
        }
        String current_Item=asignaturas.get(position);
        holder.textViewName.setText(current_Item);

        return convertView;
    }

    static class ViewHolder{
        private TextView textViewName;
    }


}
