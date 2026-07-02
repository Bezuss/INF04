package com.example.szcionka;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity { // Это база
    String[] teksty = {"Dzień dobry", "Good morning", "Buenos dias"}; //Teksty pojawiające się w polu napisu cytatu są zdefiniowane w kodzie jako tablica 3-elementowa.
    SeekBar suwak; // Дефинируем переменную suwak
    TextView cytat; // Дефинируем переменную cytat
    TextView rozmiar; // Дефинируем переменную rozmiar
    int ktoryTekst = 0;

    Button guzik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Включается Андроид
        EdgeToEdge.enable(this);// Тулза для телефонов новее, пускай будет(можно убрать
        setContentView(R.layout.activity_main); // Cвязывает вид и логику проекта
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> { // Можно убирать
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars()); // Можно убрать()
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);// Можно убрат
            return insets;
        });

        suwak = findViewById(R.id.suwak); // Присваиваем переменной suwak элемент
        cytat = findViewById(R.id.cytat); // Присваиваем переменной cytat элемент
        rozmiar = findViewById(R.id.textView2); // Присваиваем переменной rozmiar элемент
        guzik = findViewById(R.id.button);

        suwak.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // После ввода new SeekBar появляется эта конструкция
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                rozmiar.setText("Rozmiar: " + suwak.getProgress());
                cytat.setTextSize(suwak.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        guzik.setOnClickListener(new View.OnClickListener() { // Вызов функции button
            @Override
            public void onClick(View v) {
                ktoryTekst++;
                if(ktoryTekst==3){
                    ktoryTekst=0;
                }
                cytat.setText(teksty[ktoryTekst]);
            }
        });




    }


}