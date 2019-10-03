package li.emily.worldtime.view;

import android.content.Context;

import java.time.Clock;
import java.util.ArrayList;
import android.widget.LinearLayout;


import li.emily.worldtime.R;
import li.emily.worldtime.model.WorldTime;


public class ClockAdapter extends ClockViewHolder{
    private Context context;
    private ArrayList<WorldTime> worldTimes;
    private WorldTime.TimeFormat format;

    public ClockAdapter(Context context, ArrayList<WorldTime> worldTimes){
        super(context);
        this.worldTimes = worldTimes;
        this.context = context;
        this.format = WorldTime.TimeFormat.TWELVE;
    }


    public void switchFormat(){
        if(this.format == WorldTime.TimeFormat.TWELVE){
            this.format = WorldTime.TimeFormat.TWENTYFOUR;
        } else {
            this.format = WorldTime.TimeFormat.TWELVE;
        }
    }

    public WorldTime.TimeFormat getFormat() {
        return format;
    }

}
