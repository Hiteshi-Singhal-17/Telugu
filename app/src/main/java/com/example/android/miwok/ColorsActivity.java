package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        ArrayList<Word> colors=new ArrayList<>() ;
        colors.add(new Word("Red","Erupu",R.drawable.color_red));
        colors.add(new Word("Green","Ākupacca",R.drawable.color_green));
        colors.add(new Word("Mustard Yellow","Āvālu pasupu",R.drawable.color_mustard_yellow));
        colors.add(new Word("Dusty Yellow","Muriki pasupu",R.drawable.color_dusty_yellow));
        colors.add(new Word("Brown","Gōdhuma raṅgu",R.drawable.color_brown));
        colors.add(new Word("Gray","Būḍida raṅgu",R.drawable.color_gray));
        colors.add(new Word("Black","Nalupu",R.drawable.color_black));
        colors.add(new Word("White","Telupu",R.drawable.color_white));

        WordAdapter colorsAdapter=new WordAdapter(this,colors,R.color.category_colors) ;
        ListView colorView=findViewById(R.id.list) ;
        colorView.setAdapter(colorsAdapter);


        colorView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                long viewId = view.getId();
                Intent i;
                if (viewId == R.id.words_text_view) {
                    //To pass the text
                    i = new Intent(ColorsActivity.this, TextDisplay.class);
                    String englishWord = colors.get(position).getDefaultTranslation();
                    String teluguWord = colors.get(position).getTeluguTranslation();
                    Bundle bundle = new Bundle();
                    bundle.putString("English Translation", englishWord);
                    bundle.putString("Telugu Translation", teluguWord);
                    i.putExtras(bundle);

                } else {
                    //To pass the image
                    i = new Intent(ColorsActivity.this, ImageDisplay.class);
                    int imageId = colors.get(position).getImageId();
                    i.putExtra("Image id", imageId);
                }
                startActivity(i);
            }
        });
    }
}