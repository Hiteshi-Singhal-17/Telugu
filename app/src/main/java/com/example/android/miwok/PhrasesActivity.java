package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        ArrayList<Word> phrases=new ArrayList<>() ;
        phrases.add(new Word("Where are you going?","Mīru ekkaḍiki veḷutunnāru?"));
        phrases.add(new Word("What is your name?", "Nī pēru ēmiṭi?"));
        phrases.add(new Word("My name is...", "Nā pēru"));
        phrases.add(new Word("How are you feeling?", "Nī anubhūti elā undi"));
        phrases.add(new Word("I’m feeling good.", "Nēnu bāgā nē unnānu"));
        phrases.add(new Word("Are you coming?", "Mīru vastunnārā?"));
        phrases.add(new Word("Yes, I’m coming", "Avunu, nēnu vastunnānu"));
        phrases.add(new Word("How are you doing?", "Nuvvu elā unnāvu"));
        phrases.add(new Word("Let’s go.", "Veḷdāṁ"));
        phrases.add(new Word("Come here.", "Ikkaḍiki raṇḍi"));

        WordAdapter phrasesAdapter=new WordAdapter(this,phrases,R.color.category_phrases) ;
        ListView phrasesView=findViewById(R.id.list) ;
        phrasesView.setAdapter(phrasesAdapter);
        phrasesView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //To pass the text
                Intent i = new Intent(PhrasesActivity.this, TextDisplay.class);
                String englishWord = phrases.get(position).getDefaultTranslation();
                String teluguWord = phrases.get(position).getTeluguTranslation();
                Bundle bundle = new Bundle();
                bundle.putString("English Translation", englishWord);
                bundle.putString("Telugu Translation", teluguWord);
                i.putExtras(bundle);
                /* It adds all the key/value pairs from the provided bundle to the intent.
                In this case the content of the bundle will be added to the intent,
                not the bundle itself.*/
                startActivity(i);}
            });
        }
    }
