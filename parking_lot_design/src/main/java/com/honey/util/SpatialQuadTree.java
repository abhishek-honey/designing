package com.honey.util;
import java.util.ArrayList;
import java.util.List;

public class SpatialQuadTree {
    private static final int MAX_POINTS = 3;
    private SpatialRegion area;
    private List<SpatialPoint> points = new ArrayList<>();
    private List<SpatialQuadTree> quadTrees = new ArrayList<>();
    private StringBuilder searchTraversePath;

    public SpatialQuadTree(SpatialRegion area) {
        this.area = area;
    }

    public boolean addPoint(SpatialPoint point) {
        if (this.area.containsPoint(point)) {
            if (this.points.size() < MAX_POINTS) {
                this.points.add(point);
                return true;
            } else {
                if (this.quadTrees.size() == 0) {
                    createQuadrants();
                }
                return addPointToOneQuadrant(point);
            }
        }
        return false;
    }

    private boolean addPointToOneQuadrant(SpatialPoint point) {
        boolean isPointAdded;
        for (int i = 0; i < 4; i++) {
            isPointAdded = this.quadTrees.get(i)
                .addPoint(point);
            if (isPointAdded)
                return true;
        }
        return false;
    }

    private void createQuadrants() {
        SpatialRegion region;
        for (int i = 0; i < 4; i++) {
            region = this.area.getQuadrant(i);
            quadTrees.add(new SpatialQuadTree(region));
        }
    }

    public List<SpatialPoint> search(SpatialRegion searchRegion, List<SpatialPoint> matches, String depthIndicator) {
        searchTraversePath = new StringBuilder();
        if (matches == null) {
            matches = new ArrayList<SpatialPoint>();
            searchTraversePath.append(depthIndicator)
                .append("Search Boundary =")
                .append(searchRegion)
                .append("\n");
        }
        if (!this.area.doesOverlap(searchRegion)) {
            return matches;
        } else {
            for (SpatialPoint point : points) {
                if (searchRegion.containsPoint(point)) {
                    searchTraversePath.append(depthIndicator)
                    .append("Found match " + point)
                    .append("\n");
                    matches.add(point);
                }
            }
            if (this.quadTrees.size() > 0) {
                for (int i = 0; i < 4; i++) {
                    searchTraversePath.append(depthIndicator)
                        .append("Q")
                        .append(i)
                        .append("-->")
                        .append(quadTrees.get(i).area)
                        .append("\n");
                    quadTrees.get(i)
                        .search(searchRegion, matches, depthIndicator + "\t");
                    this.searchTraversePath.append(quadTrees.get(i)
                        .printSearchTraversePath());
                }
            }
        }
        return matches;
    }

    public String printTree(String depthIndicator) {
        String str = "";
        if (depthIndicator == "") {
            str += "Root-->" + area.toString() + "\n";
        }

        for (SpatialPoint point : points) {
            str += depthIndicator + point.toString() + "\n";
        }
        for (int i = 0; i < quadTrees.size(); i++) {
            str += depthIndicator + "Q" + String.valueOf(i) + "-->" + quadTrees.get(i).area.toString() + "\n";
            str += quadTrees.get(i)
                .printTree(depthIndicator + "\t");
        }
        return str;
    }

    public String printSearchTraversePath() {
        return searchTraversePath.toString();
    }
}