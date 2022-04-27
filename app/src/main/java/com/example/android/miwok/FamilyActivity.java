package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        ArrayList<Word> family=new ArrayList<>() ;
        family.add(new Word("Father","Taṇḍri",R.drawable.family_father)) ;
        family.add(new Word("Mother","Talli",R.drawable.family_mother)) ;
        family.add(new Word("Son","Koḍuku",R.drawable.family_son)) ;
        family.add(new Word("Daughter","Kūturu",R.drawable.family_daughter)) ;
        family.add(new Word("Older Brother","Peddannayya",R.drawable.family_older_brother)) ;
        family.add(new Word("Younger Brother","Tam'muḍu",R.drawable.family_younger_brother)) ;
        family.add(new Word("Older Sister","Akka",R.drawable.family_older_sister)) ;
        family.add(new Word("Younger Sister","Cinna celli",R.drawable.family_younger_sister)) ;
        family.add(new Word("Grandmother","Am'mam'ma",R.drawable.family_grandmother)) ;
        family.add(new Word("Grandfather","Tātayya",R.drawable.family_grandfather)) ;

        WordAdapter familyAdapter=new WordAdapter(this,family,R.color.category_family) ;
        ListView familyView=findViewById(R.id.list) ;
        familyView.setAdapter(familyAdapter);
        familyView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                long viewId=view.getId();
                Intent i;
                if(viewId==R.id.words_text_view){
                    i=new Intent(FamilyActivity.this,TextDisplay.class);
                    String teluguWord=family.get(position).getTeluguTranslation();
                    String englishWord=family.get(position).getDefaultTranslation() ;
                    Bundle bundle=new Bundle() ;
                    bundle.putString("Telugu Translation",teluguWord);
                    bundle.putString("English Translation",englishWord);
                    i.putExtras(bundle);
                }else{
                    i=new Intent(FamilyActivity.this,ImageDisplay.class) ;
                    int imageId=family.get(position).getImageId() ;
                    i.putExtra("Image id",imageId) ;
                 }
                startActivity(i);
            }
        });

    }
}