package li.emily.worldtime.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class WorldTime {
    private String cityName;
    private int imageName;
    private Date time;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat();
    public static final String DATE_FORMAT_12 = "h:mm:ss a";
    public static final String DATE_FORMAT_24 = "HH:mm:ss";
    public enum TimeFormat {
        TWELVE, TWENTYFOUR
    }


    public WorldTime(String cityName, int imageName, String location, String format) {
        this.cityName = cityName;
        this.imageName = imageName;
        TimeZone timeZone = TimeZone.getTimeZone(location);
        dateFormat.setTimeZone(timeZone);
        dateFormat.applyPattern(format);
        this.time = new Date();
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getImageName() {
        return imageName;
    }

    public void setImageName(int imageName) {
        this.imageName = imageName;
    }

    public String getTime() {
        return dateFormat.format(time);
    }

    public void updateTime() {
        this.time = new Date();
    }

    public void setDateFormat(String format){
        dateFormat.applyPattern(format);
    }
}