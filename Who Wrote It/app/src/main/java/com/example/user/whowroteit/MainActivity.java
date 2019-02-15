package com.example.user.whowroteit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText bookInput;
    private TextView author;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bookInput = (EditText) findViewById(R.id.bookInput);
        title = (TextView) findViewById(R.id.titleText);
        author = (TextView) findViewById(R.id.authorText);
    }
    public void searchBooks (View view){
        String queryString = bookInput.getText().toString();
        new FetchBook(title, author).execute(queryString);
    }
}
