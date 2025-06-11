package projectModule2.Island;

public class Island {
    private int width;
    private int height;
    private final Location[][] grid = new Location[height][width];

    public Island(){
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                grid[i][j] = new Location(i, j);
            }
        }
    }
    public Location getLocation(int x, int y){
        return grid[x][y];
    }

}
