package com.example.android.miwok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    private int mColorResourceId;

    public WordAdapter(@NonNull Context context, ArrayList<Word> words, int colorResourceId) {
        super(context, 0, words);
        mColorResourceId=colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        convertView.findViewById(R.id.words_text_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((ListView) parent).performItemClick(v, position, 0);
            }
        });

        // Get the Word object located at this position
        Word currentWord = getItem(position) ;

        //Get the color passed in constructor
        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        // Find the TextView in the list_item.xml layout with the ID telugu_text_view
        TextView teluguTextView = convertView.findViewById(R.id.telugu_text_view);
        // Get the telugu translation from the current Word object and
        // set this text on the telugu Text View
        teluguTextView.setText(currentWord.getTeluguTranslation());
        //Set the background color of Telugu textview
        teluguTextView.setBackgroundColor(color);


        //Find the TextView in the list_item.xml layout with the ID english_text_view
        TextView englishTextView = convertView.findViewById(R.id.english_text_view) ;
        // Get the english translation from the current word object and
        // set this text on the english text view
        englishTextView.setText(currentWord.getDefaultTranslation());
        //Set the background color of  english textview
        englishTextView.setBackgroundColor(color);


        //Find the imageView in the list_item.xml layout with the ID image
        ImageView imageView = convertView.findViewById(R.id.image);
        if(currentWord.hasImage()) {
            //Get the image and set to imageView
            imageView.setImageResource(currentWord.getImageId());

            //Make sure image is visible
            imageView.setVisibility(View.VISIBLE);
        }
        else{
            //If the image is not available, set the visibility as Gone
            imageView.setVisibility(View.GONE);
        }
        return convertView ;
    }
}





















