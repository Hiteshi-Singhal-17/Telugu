/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
// import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Open numbersActivity when numbers in clicked on in MainActivity
        TextView numbersText=findViewById(R.id.numbers) ;
        numbersText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent numbersIntent=new Intent(MainActivity.this,NumbersActivity.class) ;
                startActivity(numbersIntent);
                // For example, via the startActivity() method you can define
                // that the intent should be used to start an activity.
            }
        });

        //Open FamilyActivity when family members clicked in MainActivity
        TextView familyText=findViewById(R.id.family) ;
        familyText.setOnClickListener(v -> {
            Intent familyIntent=new Intent(MainActivity.this,FamilyActivity.class) ;
            startActivity(familyIntent);
        });

        //Open ColorsActivity when Colors clicked in MainActivity
        TextView colorsText=findViewById(R.id.colors) ;
        colorsText.setOnClickListener(v -> {
            Intent colorsIntent=new Intent(MainActivity.this,ColorsActivity.class) ;
            startActivity(colorsIntent);
        });

        //Open PhrasesActivity when Phrases clicked in MainActivity
        TextView phrasesText=findViewById(R.id.phrases) ;
        phrasesText.setOnClickListener(v -> {
            Intent phrasesIntent=new Intent(getApplicationContext(),PhrasesActivity.class) ;
            startActivity(phrasesIntent);
        });

    }
}
