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
        
        WorldTime newyork = new WorldTime ("New York",R.drawable.newyork,"America/New_York");
        ClockViewHolder newyorkClock = new ClockViewHolder(this);
        newyorkClock.cityTextView.setText(newyork.getCityName());
        newyorkClock.timeTextView.setText(newyork.getTime());
        newyorkClock.imageView.setImageResource(newyork.getImageName());
        clocks.add(newyork);
        parent.addView(newyorkClock);

        WorldTime paris = new WorldTime("Paris",R.drawable.paris,"Europe/Paris");
        ClockViewHolder parisClock = new ClockViewHolder(this);
        parisClock.cityTextView.setText(paris.getCityName());
        parisClock.timeTextView.setText(paris.getTime());
        parisClock.imageView.setImageResource(paris.getImageName());
        clocks.add(paris);
        parent.addView(parisClock);

        WorldTime tokyo = new WorldTime("Tokyo",R.drawable.tokyo,"Asia/Tokyo");
        ClockViewHolder tokyoClock = new ClockViewHolder(this);
        tokyoClock.cityTextView.setText(tokyo.getCityName());
        tokyoClock.timeTextView.setText(tokyo.getTime());
        tokyoClock.imageView.setImageResource(tokyo.getImageName());
        clocks.add(tokyo);
        parent.addView(tokyoClock);
    }

    public void updateTime(){
        for(WorldTime clock : clocks) {
            clock.updateTime();
        }
    }
}
