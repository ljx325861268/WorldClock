package li.emily.worldtime.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class WorldTime {
    private String cityName;
    private int imageName;
    private Date time;
    private final SimpleDateFormat DATE_FORMAT_24 = new SimpleDateFormat("HH:mm:ss");


    public WorldTime(String cityName, int imageName, String location) {
        this.cityName = cityName;
        this.imageName = imageName;
        TimeZone timeZone = TimeZone.getTimeZone(location);
        DATE_FORMAT_24.setTimeZone(timeZone);
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
        return DATE_FORMAT_24.format(time);
    }

    public void updateTime() {
        this.time = new Date();
    }
}
