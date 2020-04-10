package com.example.module_story.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.module_story.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReadStoryActivity extends AppCompatActivity {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title_read)
    TextView tvTitleRead;
    @BindView(R.id.tv_author_read)
    TextView tvAuthorRead;
    @BindView(R.id.tv_description_rd)
    TextView tvDescriptionRd;
    @BindView(R.id.iv_story_read)
    ImageView ivStoryRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_story);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        Bundle bundle= intent.getExtras();
        tvTitleRead.setText(bundle.getString("title"));
        tvAuthorRead.setText(bundle.getString("author"));
        tvDescriptionRd.setText(bundle.getString("description"));
        Glide.with(this).load(bundle.getString("imageUrl")).into(ivStoryRead);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
