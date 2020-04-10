package com.example.module_story.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.module_story.R;
import com.example.module_story.databases.DatabaseUtils;
import com.example.module_story.models.ItemModel;

import java.util.List;

public class StoryAdapter extends BaseAdapter {
    private List<ItemModel> itemModels;
    private Context context;
    private int layout;

    public StoryAdapter(List<ItemModel> itemModels, Context context, int layout) {
        this.itemModels = itemModels;
        this.context = context;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return itemModels.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.list_story, null);
        TextView tvTitle = convertView.findViewById(R.id.tv_title);
        TextView tvAuthor=convertView.findViewById(R.id.tv_author);
        ImageView ivImage= convertView.findViewById(R.id.iv_story);
        ItemModel itemModel = itemModels.get(position);
        tvTitle.setText(itemModel.getTitle());
        tvAuthor.setText(itemModel.getAuthor());
        Glide.with(parent.getContext()).load(DatabaseUtils.getInstance(parent.getContext()).getListModel().get(position).getImage()).into(ivImage);
        return convertView;
    }
}
