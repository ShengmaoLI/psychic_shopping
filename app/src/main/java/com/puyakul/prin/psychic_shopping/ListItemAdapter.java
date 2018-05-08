//package com.puyakul.prin.psychic_shopping;
//
//import android.content.Context;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ListItemAdapter extends ArrayAdapter<String> {
//
//    private static final String TAG = "ListItemAdapter";
//
//    public ListItemAdapter(@NonNull Context context, int resource, @NonNull ArrayList<String> objects) {
//        super(context, resource, objects);
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//
//        if (convertView == null){
////            LayoutInflater inflater = LayoutInflater.from(getContext());
////            convertView = inflater.inflate(layout, parent, false);
//            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_item_detail_list, parent, false);
//        }
//
//        ViewHolder viewHolder = new ViewHolder();
//        viewHolder.listItem_Thumbnail = convertView.findViewById(R.id.img_thumbnail);
//        viewHolder.listItem_Name = convertView.findViewById(R.id.textView_listItemText);
//        viewHolder.listItem_Remove_btn = convertView.findViewById(R.id.btn_listItemRemove);
//        viewHolder.listItem_Name.setText(getItem(position));
//        convertView.setTag(viewHolder);
//        return convertView;
//    }
//
//    public class ViewHolder {
//        ImageView listItem_Thumbnail;
//        TextView listItem_Name;
//        Button listItem_Remove_btn;
//    }
//}
