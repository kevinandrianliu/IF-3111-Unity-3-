package com.example.user.whowroteit;

import android.os.AsyncTask;
import android.widget.TextView;

public class FetchBook extends AsyncTask<String, Void, String> {
    private TextView title;
    private TextView author;

    public FetchBook(TextView title, TextView author) {
        this.title = title;
        this.author = author;
    }
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

    @Override
    protected String doInBackground(String... strings) {
        return NetworkUtils.getBookInfo(strings[0]);
    }
}
