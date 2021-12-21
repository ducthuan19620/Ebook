package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.Model.Book;
import com.example.myapplication.Model.Chapter;
import com.example.myapplication.R;
import com.example.myapplication.Ultils.ChapterAdapter;

import java.util.Objects;

public class DetailBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_book);
        //getSupportFragmentManager().beginTransaction().replace(R.id.list_chapter, new ChapterFragment()).commit();
        //getSupportFragmentManager().beginTransaction().replace(R.id.book_content, new BookContentFragment()).commit();

        if (findViewById(R.id.bookDetail_layout) != null){
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .show((Objects.requireNonNull(manager.findFragmentById(R.id.list_chapter))))
                    .hide((Objects.requireNonNull(manager.findFragmentById(R.id.book_content))))
                    .addToBackStack(ChapterFragment.class.getName())
                    .commit();
        }

        if (findViewById(R.id.bookDetail_land) != null){
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .show((Objects.requireNonNull(manager.findFragmentById(R.id.list_chapter))))
                    .show((Objects.requireNonNull(manager.findFragmentById(R.id.book_content))))
                    .commit();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
    }
}