package com.beckamar.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

import me.ibrahimsn.lib.OnItemSelectedListener;

public class MainActivity extends AppCompatActivity {

    CardView cardView1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cardView1 = findViewById(R.id.cardView1);
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                startActivity(intent);
            }
        });

    }

//    public void bottomBar(){
//
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(me.ibrahimsn.lib.R.id.fragment_container_view_tag, new Fragment());
//        transaction.commit();
//
//        setSupportActionBar(binding.toolbar);
//        binding.bottomBar.setOnItemSelectedListener(new OnItemSelectedListener() {
//            @Override
//            public boolean onItemSelect(int i) {
//
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                switch (i){
//                    case 0:
//                        //Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
//                        transaction.replace(me.ibrahimsn.lib.R.id.fragment_container_view_tag, new Fragment());
//                        transaction.commit();
//                        break;
//
//                    case 1:
//                        Toast.makeText(MainActivity.this, "Resultados", Toast.LENGTH_SHORT).show();
//                        break;
//                    case 2:
//                        Toast.makeText(MainActivity.this, "Perfil", Toast.LENGTH_SHORT).show();
//                        break;
//
//                }
//                return false;
//            }
//        });
//
//
//
//
//    }


}