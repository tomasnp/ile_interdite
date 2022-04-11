package Modele;
/**
import models.Zone;

import java.util.ArrayList;


 // Ile

public class Ile {

    private ArrayList<ArrayList<Zone>> grid;

    public Ile(int size) {
        grid = new ArrayList<ArrayList<Zone>>();
        for (int j = 0; j < size; j++) {
            ArrayList<Zone> line = new ArrayList<Zone>();
            for (int i = 0; i < size; i++) {
                if (Math.abs(i - (size - 1) / 2.) +
                        Math.abs(j - (size - 1) / 2.) <= size / 2.) {
                    line.add(new Zone(i, j));
                } else {
                    line.add(null);
                }
            }
            grid.add(line);
        }
    }

    public Zone getZone(int x, int y) {
        return grid.get(y).get(x);
    }

    public int getGridSize() {
        return grid.size();
    }

    public ArrayList<Integer> getCoordLine(int y) {
        ArrayList<Integer> s = new ArrayList<Integer>();
        for (int index = 0; index < grid.size(); index++) {
            if (grid.get(y).get(index) != null) {
                s.add(index);
            }
        }
        return s;
    }
}
*/