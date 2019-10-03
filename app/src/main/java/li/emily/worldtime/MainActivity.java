package li.emily.worldtime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import li.emily.worldtime.model.WorldTime;
import li.emily.worldtime.view.ClockAdapter;
import li.emily.worldtime.view.ClockViewHolder;


public class MainActivity extends AppCompatActivity {
    private LinearLayout parent;
    private ArrayList<WorldTime> clocks;
    private Timer timer = new Timer();
    private ClockAdapter clockAdapter;
    private String CURRENT_TIME_FORMAT;

    private Button button12;
    private Button button24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parent = (LinearLayout) findViewById(R.id.parentScroll);
        button12 = (Button) findViewById(R.id.id_button12);
        button24 = (Button) findViewById(R.id.id_button24);
        CURRENT_TIME_FORMAT = WorldTime.DATE_FORMAT_12;
        button12.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                CURRENT_TIME_FORMAT = WorldTime.DATE_FORMAT_12;
            }
        });

        button24.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                CURRENT_TIME_FORMAT = WorldTime.DATE_FORMAT_24;
            }
        });

        clocks = new ArrayList<>();
        addData(CURRENT_TIME_FORMAT);

        clockAdapter = new ClockAdapter(this, clocks);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        addData(CURRENT_TIME_FORMAT);

                    }
                });
            }
        }, 0, 1000);
    }

    public void addData(String format){
        parent.removeAllViews();

        WorldTime sydney = new WorldTime("Sydney", R.drawable.sydney, "Australia/Sydney", format);
        ClockViewHolder sydneyClock = new ClockViewHolder(this);
        sydneyClock.cityTextView.setText(sydney.getCityName());
        sydneyClock.timeTextView.setText(sydney.getTime());
        sydneyClock.imageView.setImageResource(sydney.getImageName());

        parent.addView(sydneyClock);

        WorldTime beijing = new WorldTime("Bei Jing", R.drawable.beijing, "Asia/Hong_Kong",format);
        ClockViewHolder beijingClock = new ClockViewHolder(this);
        beijingClock.cityTextView.setText(beijing.getCityName());
        beijingClock.timeTextView.setText(beijing.getTime());
        beijingClock.imageView.setImageResource(beijing.getImageName());

        parent.addView(beijingClock);


        WorldTime newyork = new WorldTime ("New York",R.drawable.newyork,"America/New_York", format);
        ClockViewHolder newyorkClock = new ClockViewHolder(this);
        newyorkClock.cityTextView.setText(newyork.getCityName());
        newyorkClock.timeTextView.setText(newyork.getTime());
        newyorkClock.imageView.setImageResource(newyork.getImageName());

        parent.addView(newyorkClock);

        WorldTime paris = new WorldTime("Paris",R.drawable.paris,"Europe/Paris", format);
        ClockViewHolder parisClock = new ClockViewHolder(this);
        parisClock.cityTextView.setText(paris.getCityName());
        parisClock.timeTextView.setText(paris.getTime());
        parisClock.imageView.setImageResource(paris.getImageName());

        parent.addView(parisClock);

        WorldTime tokyo = new WorldTime("Tokyo",R.drawable.tokyo,"Asia/Tokyo", format);
        ClockViewHolder tokyoClock = new ClockViewHolder(this);
        tokyoClock.cityTextView.setText(tokyo.getCityName());
        tokyoClock.timeTextView.setText(tokyo.getTime());
        tokyoClock.imageView.setImageResource(tokyo.getImageName());

        parent.addView(tokyoClock);

    }

    public void updateTime(){
        for(WorldTime clock : clocks) {
            clock.updateTime();
        }
    }

    public void onFormatTimeClick(){
        Intent intent = new Intent();
    }
}