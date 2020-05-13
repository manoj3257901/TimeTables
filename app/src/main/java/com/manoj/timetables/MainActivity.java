package com.manoj.timetables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView timeTableListView;
    public void generate(int timeTableNumber){
        ArrayList<String> timeTableContent = new ArrayList<String>();
        for ( int j = 1;j<=10 ; j++){
            timeTableContent.add(Integer.toString(timeTableNumber*j));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,timeTableContent);
        timeTableListView.setAdapter(arrayAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SeekBar timeTableSeekBar = findViewById(R.id.timeTableSeekBar);
        timeTableListView = findViewById(R.id.timeTableListView);
        int max = 20;
        int startPostion = 10 ;
        timeTableSeekBar.setMax(max);
        timeTableSeekBar.setProgress(startPostion);
        generate(startPostion);


        timeTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min =1;
                int timeTableNumber;
                if (progress < min ){
                    timeTableNumber = min;
                    timeTableSeekBar.setProgress(min);
                }else{
                    timeTableNumber = progress;

                }
                Log.i("tapped",Integer.toString(timeTableNumber));
                generate(timeTableNumber);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}
