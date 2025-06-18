package projectModule2.Island;

public class Island {
    private int width;
    private int height;
    private final Location[][] locations;

    public Island(int width, int height){
        this.width = width;
        this.height = height;
        locations = new Location[height][width];
        initializeLocations();
    }

    private void initializeLocations(){
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                locations[y][x] = new Location(x, y);
            }
        }
    }

    public Location getLocation(int x, int y){
        if (x >= 0 && x < width && y >= 0 && y < height) {
            return locations[y][x];
        }
        return null;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
