package li.emily.worldtime.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import li.emily.worldtime.R;

public class ClockViewHolder extends LinearLayout {
    public TextView cityTextView;
    public ImageView imageView;
    public TextView timeTextView;

    public ClockViewHolder(Context context){
        super(context);
        inflate(context, R.layout.view_clock, this);
        cityTextView = (TextView) findViewById(R.id.cityName);
        timeTextView = (TextView) findViewById(R.id.cityTime);
        imageView = (ImageView) findViewById(R.id.cityImage);
    }
}