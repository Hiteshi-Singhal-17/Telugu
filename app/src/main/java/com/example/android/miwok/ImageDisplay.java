package com.example.android.miwok;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ImageDisplay extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_enlarged);

        ImageView imageView=findViewById(R.id.image_enlarged) ;
        Bundle bundle=getIntent().getExtras() ;
        if(bundle!= null){
            int imageId=bundle.getInt("Image id") ;
            imageView.setImageResource(imageId) ;
        }
    }
}
