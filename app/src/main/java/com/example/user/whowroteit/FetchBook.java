package com.example.user.whowroteit;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

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
        try{
            JSONObject jsonObject = new JSONObject(s);
            JSONArray itemsArray = jsonObject.getJSONArray("items");
            //Iterate through the results
            for(int i = 0; i<itemsArray.length(); i++){
                JSONObject book = itemsArray.getJSONObject(i); //Get the current item
                String titleText=null;
                String authors=null;
                JSONObject volumeInfo = book.getJSONObject("volumeInfo");

                try {
                    titleText = volumeInfo.getString("title");
                    authors = volumeInfo.getString("authors");
                } catch (Exception e){
                    e.printStackTrace();
                }

                //If both a title and author exist, update the TextViews and return
                if (title != null && authors != null){
                    title.setText(titleText);
                    author.setText(authors);
                    return;
                }
                title.setText("No Results Found");
                author.setText("");
            }
        }
        catch(Exception e){
            title.setText("No Results Found");
            author.setText("");
            e.printStackTrace();
        }
    }

    @Override
    protected String doInBackground(String... strings) {
        return NetworkUtils.getBookInfo(strings[0]);
    }
}
