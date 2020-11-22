package com.example.konkor.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.konkor.R;
import com.example.konkor.adapter.ViewPageAdapter;
import com.example.konkor.fragment.AnswerFragment;
import com.example.konkor.fragment.CommentsFragment;
import com.google.android.material.tabs.TabLayout;

public class SingleAnswerActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ViewPageAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_answer);
        adapter = new ViewPageAdapter(getSupportFragmentManager(),0);
        adapter.addFragment(new CommentsFragment(), "نظرات و راه‌حل‌ها");
        adapter.addFragment(new AnswerFragment(), "مشاهده جواب");

        tabLayout = findViewById(R.id.tab_layout_answer);
        viewPager = findViewById(R.id.view_pager_answers);

        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(adapter.getCount());
        tabLayout.setupWithViewPager(viewPager);
    }
}