package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        //Numbers to store translation in english and telugu
        ArrayList<Word> numbers = new ArrayList<>();
        numbers.add(new Word("One", "Okaṭi", R.drawable.number_one));
        numbers.add(new Word("Two", "Reṇḍu", R.drawable.number_two));
        numbers.add(new Word("Three", "Mūḍu", R.drawable.number_three));
        numbers.add(new Word("Four", "Nālugu", R.drawable.number_four));
        numbers.add(new Word("Five", "Ayidu", R.drawable.number_five));
        numbers.add(new Word("Six", "Āru", R.drawable.number_six));
        numbers.add(new Word("Seven", "Ēḍu", R.drawable.number_seven));
        numbers.add(new Word("Eight", "Enimidi", R.drawable.number_eight));
        numbers.add(new Word("Nine", "Tommidi", R.drawable.number_nine));
        numbers.add(new Word("Ten", "Padi", R.drawable.number_ten));


        WordAdapter numberAdapter = new WordAdapter(this, numbers, R.color.category_numbers);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(numberAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                long viewId = view.getId();
                Intent i;
                if (viewId == R.id.words_text_view) {
                    //To pass the text
                    i = new Intent(NumbersActivity.this, TextDisplay.class);
                    String englishWord = numbers.get(position).getDefaultTranslation();
                    String teluguWord = numbers.get(position).getTeluguTranslation();
                    Bundle bundle = new Bundle();
                    bundle.putString(Constants.ENGLISH_TRANSLATION, englishWord);
                    bundle.putString(Constants.TELUGU_TRANSLATION, teluguWord);
                    i.putExtras(bundle);

                } else {
                    //To pass the image
                    i = new Intent(NumbersActivity.this, ImageDisplay.class);
                    int imageId = numbers.get(position).getImageId();
                    i.putExtra("Image id", imageId);
                }
                startActivity(i);
            }
        });
    }
}