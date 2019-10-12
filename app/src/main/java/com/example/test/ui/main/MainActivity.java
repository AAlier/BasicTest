package com.example.test.ui.main;

import android.os.Bundle;

import com.example.test.R;
import com.example.test.model.Answer;
import com.example.test.model.Question;
import com.example.test.util.ResourceManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity implements Listener {
    private ViewPager viewPager;
    private String FILENAME = "test.json";
    private HashMap<Integer, Integer> map = new HashMap<>();
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);
        adapter = new ViewPagerAdapter(getQuestions(), this);
        viewPager.setAdapter(adapter);
    }

    private List<Question> getQuestions() {
        String json = ResourceManager.readFromAssets(this, FILENAME);
        Type type = new TypeToken<List<Question>>() {
        }.getType();
        return new Gson().fromJson(json, type);
    }

    @Override
    public HashMap<Integer, Integer> getAnswers() {
        return map;
    }

    @Override
    public void onClickAnswer(int position, Answer answer) {
        map.put(position, answer.getId());
        adapter.notifyDataSetChanged();
    }
}
