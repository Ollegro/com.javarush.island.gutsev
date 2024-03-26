package model.Island;

import config.IslandConfig;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Island {
    private final List<List<Cell>> island;
    private final int x;
    private final int y;

    public Island() {
        IslandConfig islandConfig = new IslandConfig();
        this.x = islandConfig.getIslandSizeByX();
        this.y = islandConfig.getIslandSizeByY();
        island = new ArrayList<>(x);
        for (int i = 0; i < x; i++) {
            island.add(new ArrayList<>(y));
        }

    }

}
