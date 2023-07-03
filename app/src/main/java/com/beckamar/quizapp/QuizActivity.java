package com.beckamar.quizapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import org.w3c.dom.Text;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {

    TextView pregunta, questionCounter, tiempo;
    RadioButton radio0, radio1, radio2, radio3;
    RadioGroup radioGroup;
    ArrayList<String[]> datos = new ArrayList<>();
    int index = 0;
    CountDownTimer timer;
    int respCorrecta;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        inicializaComponentes();
        cargaDatos();
        cargaPregunta();
    }


    private void inicializaComponentes() {
        pregunta = (TextView) findViewById(R.id.pregunta);
        questionCounter = (TextView) findViewById(R.id.questionCounter);
        radio0 = (RadioButton) findViewById(R.id.radio0);
        radio1 = (RadioButton) findViewById(R.id.radio1);
        radio2 = (RadioButton) findViewById(R.id.radio2);
        radio3 = (RadioButton) findViewById(R.id.radio3);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        tiempo = (TextView) findViewById(R.id.tiempo);
    }

    private void cargaDatos() {
            SQLite auxSql = new SQLite(this, "bd.sqlite", null, 1);
        SQLiteDatabase db = auxSql.getReadableDatabase();
        String query = "select * from pregunta";

        Cursor c = db.rawQuery(query, null);

        if(c.moveToFirst()){
            do{
                String[] temp = new String[]{
                        c.getString(0), c.getString(1), c.getString(2),
                        c.getString(3), c.getString(4), c.getString(5),
                        c.getString(6)
                };
                datos.add(temp);
            }while(c.moveToNext());
        }
        auxSql.close();
    }

    private void cargaPregunta() {
        if(timer != null )timer.cancel();
        resetTimer();
        timer.start();

        this.questionCounter.setText(datos.get(index)[0] +" / " + datos.size());
        this.pregunta.setText(datos.get(index)[1]);
        this.radio0.setText(datos.get(index)[2]);
        this.radio1.setText(datos.get(index)[3]);
        this.radio2.setText(datos.get(index)[4]);
        this.radio3.setText(datos.get(index)[5]);


    }

    public void verificarRespuesta(RadioButton rbtnSeleccion) {
        String respSeleccionada = rbtnSeleccion.getText().toString();
        if(respSeleccionada.equals(datos.get(index)[6])){
            respCorrecta ++;
            rbtnSeleccion.setBackground(getResources().getDrawable(R.drawable.option_right));
        }else{
            mostrarRespuestaCorrecta();
            rbtnSeleccion.setBackground(getResources().getDrawable(R.drawable.option_wrong));
        }
    }

    public void mostrarRespuestaCorrecta() {
        String respuestaCorrecta = datos.get(index)[6];
        if (radio0.getText().toString().equals(respuestaCorrecta)) {
            radio0.setBackground(getResources().getDrawable(R.drawable.option_right));
        } else if (radio1.getText().toString().equals(respuestaCorrecta)) {
            radio1.setBackground(getResources().getDrawable(R.drawable.option_right));
        } else if (radio2.getText().toString().equals(respuestaCorrecta)) {
            radio2.setBackground(getResources().getDrawable(R.drawable.option_right));
        } else if (radio3.getText().toString().equals(respuestaCorrecta)) {
            radio3.setBackground(getResources().getDrawable(R.drawable.option_right));
        }
    }

    public void reset (){
        radio0.setBackground(getResources().getDrawable(R.drawable.textbox));
        radio1.setBackground(getResources().getDrawable(R.drawable.textbox));
        radio2.setBackground(getResources().getDrawable(R.drawable.textbox));
        radio3.setBackground(getResources().getDrawable(R.drawable.textbox));
    }

    void resetTimer(){
        timer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tiempo.setText(String.valueOf(millisUntilFinished/1000));
            }
            @Override
            public void onFinish() {

            }
        };
    }

    public void onClick(View view){
        switch(view.getId()){

            case R.id.radio0:
            case R.id.radio1:
            case R.id.radio2:
            case R.id.radio3:
                if(timer != null )timer.cancel();
                RadioButton rbtnSeleccionado = (RadioButton) view;
                verificarRespuesta(rbtnSeleccionado);
                break;

            case R.id.btnSiguiente:
                reset();
                index++;
                if (index < datos.size()) {
                    cargaPregunta();
                }
                else if(index == datos.size()){
                    Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                    intent.putExtra("correctas", respCorrecta);
                    intent.putExtra("total", datos.size());
                    startActivity(intent);
                }
                break;

        }


    }

}