package com.example.lab11_ngotruongvu;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void cau12(View view){
        Toast.makeText(getApplicationContext(), "cau12", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, VeButton.class);
        startActivity(intent);
    }
    public void caudanhsachnhanvien(View view){
        Toast.makeText(getApplicationContext(), "caudanhsachnhanvien", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, Danhsachnhanvien.class);
        startActivity(intent);
    }
}