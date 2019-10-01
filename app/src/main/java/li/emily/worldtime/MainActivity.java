package li.emily.worldtime;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import android.os.Bundle;

import java.util.ArrayList;

import li.emily.worldtime.model.WorldTime;
import li.emily.worldtime.view.ClockViewHolder;


public class MainActivity extends AppCompatActivity {
    private LinearLayout parent;
    private ArrayList<WorldTime> clocks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parent = (LinearLayout) findViewById(R.id.parentScroll);

        clocks = new ArrayList<>();
        addData();
    }

    public void addData(){
        WorldTime sydney = new WorldTime("Sydney", R.drawable.sydney, "Australia/Sydney");
        ClockViewHolder sydneyClock = new ClockViewHolder(this);
        sydneyClock.cityTextView.setText(sydney.getCityName());
        sydneyClock.timeTextView.setText(sydney.getTime());
        sydneyClock.imageView.setImageResource(sydney.getImageName());
        clocks.add(sydney);
        parent.addView(sydneyClock);

        WorldTime beijing = new WorldTime("Beijing", R.drawable.beijing, "Asia/Hong_Kong");
        ClockViewHolder beijingClock = new ClockViewHolder(this);
        beijingClock.cityTextView.setText(beijing.getCityName());
        beijingClock.timeTextView.setText(beijing.getTime());
        beijingClock.imageView.setImageResource(beijing.getImageName());
        clocks.add(beijing);
        parent.addView(beijingClock);
    }

    public void updateTime(){
        for(WorldTime clock : clocks) {
            clock.updateTime();
        }
    }
}
