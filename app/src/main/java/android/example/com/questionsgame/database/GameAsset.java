package android.example.com.questionsgame.database;

import java.util.Date;

/**
 * Created by Lenovo on 4/15/2018.
 */

public class GameAsset {

    private String app_id; //gameStat.setApp_id("a");
    private String exercise_id; //gameStat.setExercise_id("a");
    private String level_id;  //gameStat.setLevel_id("a");
    private int successful_attempts; //gameStat.setSuccessful_attempts("a");
    private int failed_attempts;  //gameStat.setFailed_attempts("a");
    private String Device = "UnownAndroidDevice";
    private Date updated_At;
    private Date created_At;
    private double min_time_succeed_sec ;
    private double avg_time_succeed_sec ;
    private double longitude;

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    private double latitude;

    public double getMin_time_succeed_sec() {
        return min_time_succeed_sec;
    }

    public void setMin_time_succeed_sec(double min_time_succeed_sec) {
        this.min_time_succeed_sec = min_time_succeed_sec;
    }

    public double getAvg_time_succeed_sec() {
        return avg_time_succeed_sec;
    }

    public void setAvg_time_succeed_sec(double avg_time_succeed_sec) {
        this.avg_time_succeed_sec = avg_time_succeed_sec;
    }

    public GameAsset(String app_id, String exercise_id, String level_id, Date created_at, int successful_attempts, int failed_attempts, String device) {
        this.app_id = app_id;
        this.exercise_id = exercise_id;
        this.level_id = level_id;
        this.created_At = created_at;
        this.successful_attempts = successful_attempts;
        this.failed_attempts = failed_attempts;
        Device = device;
    }

    public GameAsset(String app_id, String exercise_id, Date created_at, double longitude, double latitude) {
        this.app_id = app_id;
        this.exercise_id = exercise_id;
        this.created_At = created_at;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getExercise_id() {
        return exercise_id;
    }

    public void setExercise_id(String exercise_id) {
        this.exercise_id = exercise_id;
    }

    public String getLevel_id() {
        return level_id;
    }

    public void setLevel_id(String level_id) {
        this.level_id = level_id;
    }

    public Date getUpdated_At() {
        return updated_At;
    }

    public void setUpdated_At(Date updated_At) {
        this.updated_At = updated_At;
    }

    public Date getCreated_At() {
        return created_At;
    }

    public void setCreated_At(Date created_At) {
        this.created_At = created_At;
    }

    public int getSuccessful_attempts() {
        return successful_attempts;
    }

    public void setSuccessful_attempts(int successful_attempts) {
        this.successful_attempts = successful_attempts;
    }

    public int getFailed_attempts() {
        return failed_attempts;
    }

    public void setFailed_attempts(int failed_attempts) {
        this.failed_attempts = failed_attempts;
    }

    public String getDevice() {
        return Device;
    }

    public void setDevice(String device) {
        Device = device;
    }

    public void initializeGameAsset(){
        setFailed_attempts(0);
        setSuccessful_attempts(0);
        setMin_time_succeed_sec(0);
        setAvg_time_succeed_sec(0);
    }
}