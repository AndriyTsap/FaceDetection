package com.eleks.data_platform.facedetection;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.util.LruCache;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.eleks.data_platform.facedetection.cache.ImageStore;

public class ImageActivity extends AppCompatActivity {

    private LruCache<String, Bitmap> mMemoryCache;
    ImageStore store = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_activty);

        store = new ImageStore();

        Intent intent = getIntent();
        Bitmap bitmap = store.getBitmapByItsPath(intent.getStringExtra("BitmapKey"));

        ImageView img = (ImageView) findViewById(R.id.imageView1);
        img.setImageBitmap(bitmap);
    }

}
