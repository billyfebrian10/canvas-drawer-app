package com.billyfebrian.object;

public class Canvas {

    private int width;
    private int height;
    private char[][] coordinates;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        coordinates = new char[height][width];
        for (int i = 0; i<this.width; i++) {
            for(int j = 0; j<this.height; j++) {
                coordinates[j][i] = ' ';
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public char[][] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(char[][] coordinates) {
        this.coordinates = coordinates;
    }
}
