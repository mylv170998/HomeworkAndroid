package com.example.module_story.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.module_story.R;
import com.example.module_story.adapters.StoryAdapter;
import com.example.module_story.databases.DatabaseUtils;
import com.example.module_story.models.ItemModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private StoryAdapter storyAdapter;
    private ArrayList<ItemModel> listStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView =findViewById(R.id.lv_story);
        listStory = (ArrayList<ItemModel>) DatabaseUtils.getInstance(this).getListModel();
        storyAdapter =  new StoryAdapter(listStory, MainActivity.this, R.layout.list_story);
        listView.setAdapter(storyAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ReadStoryActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("author",listStory.get(position).getAuthor());
                bundle.putString("title",listStory.get(position).getTitle());
                bundle.putString("description", listStory.get(position).getDescription());
                bundle.putString("imageUrl",listStory.get(position).getImage());
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
    }


}
