package com.example.konkor.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.konkor.R;
import com.example.konkor.adapter.RVBooksListAdapter;
import com.example.konkor.models.Book;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {
    private RVBooksListAdapter adapter;
    private RecyclerView rvBookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        rvBookList = findViewById(R.id.rv_books_list);
        List<Book> books;
        books = setDummyBooks();
        adapter = new RVBooksListAdapter(getApplicationContext(),books  );
        rvBookList.setAdapter(adapter);
        rvBookList.setLayoutManager(new GridLayoutManager(this,2));

    }

    private List<Book> setDummyBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1,"عنوان نمونه یک", "محمد نجفی", 3));
        books.add(new Book(1,"عنوان نمونه یک", "محمد نجفی", 3));
        books.add(new Book(1,"عنوان نمونه یک", "محمد نجفی", 3));
        books.add(new Book(1,"عنوان نمونه یک", "محمد نجفی", 3));
        books.add(new Book(1,"عنوان نمونه یک", "محمد نجفی", 3));
        books.add(new Book(1,"عنوان نمونه یک", "محمد نجفی", 3));
        books.add(new Book(1,"عنوان نمونه یک", "محمد نجفی", 3));
        books.add(new Book(1,"عنوان نمونه یک", "محمد نجفی", 3));
        books.add(new Book(1,"عنوان نمونه یک", "محمد نجفی", 3));
        books.add(new Book(1,"عنوان نمونه یک", "محمد نجفی", 3));
        return books;
    }
}