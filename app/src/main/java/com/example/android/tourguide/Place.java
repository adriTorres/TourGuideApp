package com.example.android.tourguide;

/**
 * {@link Place} represents a location
 * It contains a location's title name, a related image, its short information, its summary, an its real location.
 */

public class Place {
    //Place image
    private int image;
    //Place title
    private String title;
    //Place info
    private String info;
    //Place summary
    private String summary;
    //Place location
    private String location;

    /**
     * Create a new Place object.
     *
     * @param image    category picture
     * @param title    title name of the location
     * @param info     short info about the location
     * @param summary  summary about the location
     * @param location real location of the place
     */
    public Place(int image, String title, String info, String summary, String location) {
        this.image = image;
        this.title = title;
        this.info = info;
        this.summary = summary;
        this.location = location;
    }

    //Getters
    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getInfo() {
        return info;
    }

    public String getSummary() {
        return summary;
    }

    public String getLocation() {
        return location;
    }
}
