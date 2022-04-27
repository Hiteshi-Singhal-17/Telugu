package com.example.android.miwok;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TextDisplay extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_enlarged);

        Bundle bundle=getIntent().getExtras() ;
        //getIntent() -> Return the intent that started this activity.
        //It is the method of Activity class

        if(bundle!=null){
            TextView englishWord=findViewById(R.id.english_word_text_view) ;
            TextView teluguWord=findViewById(R.id.telugu_word_text_view) ;
            englishWord.setText(bundle.getString(Constants.ENGLISH_TRANSLATION));
            teluguWord.setText(bundle.getString(Constants.TELUGU_TRANSLATION));
        }
    }
}
