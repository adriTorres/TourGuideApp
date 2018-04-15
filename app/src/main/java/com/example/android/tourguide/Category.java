package com.example.android.tourguide;

/**
 * {@link Category} represents a category for multiple locations {@link Place}
 * It contains a category's name and an image related.
 */
public class Category {
    //Category Image
    private int image;
    //Category name
    private String name;

    /**
     * Create a new Category object.
     *
     * @param name  category name
     * @param image category picture
     */
    public Category(int image, String name) {
        this.image = image;
        this.name = name;
    }

    //Getters
    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

}
