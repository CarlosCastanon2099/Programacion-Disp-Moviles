package com.example.tarea3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }

    public void changeImage10(View view) {
        ImageView imageView = (ImageView) findViewById(R.id.image_view10);
        imageView.setImageResource(R.drawable.imagen11);
    }

    public void changeImage20(View view) {
        ImageView imageView = (ImageView) findViewById(R.id.image_view20);
        imageView.setImageResource(R.drawable.imagen21);
    }

    public void changeImage30(View view) {
        ImageView imageView = (ImageView) findViewById(R.id.image_view30);
        imageView.setImageResource(R.drawable.imagen31);
    }

    public void changeImage50(View view) {
        ImageView imageView = (ImageView) findViewById(R.id.image_view50);
        imageView.setImageResource(R.drawable.imagen51);
    }

    public void changeImage70(View view) {
        ImageView imageView = (ImageView) findViewById(R.id.image_view70);
        imageView.setImageResource(R.drawable.imagen71);
    }

    public void changeImage80(View view) {
        ImageView imageView = (ImageView) findViewById(R.id.image_view80);
        imageView.setImageResource(R.drawable.imagen81);
    }


}