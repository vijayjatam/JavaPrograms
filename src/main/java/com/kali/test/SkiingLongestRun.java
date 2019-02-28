package com.kali.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SkiingLongestRun {
    private static Map<String, String> hashMap = new HashMap<String, String>();

    // Find the longest run for a grid.
// Traverse all index and find the longest run..
    private void findLogestRun(Integer[][] grid) {
        String maxRunList = "";
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                String returnList = findLogestRun(grid, i, j);
                if (returnList.length() > maxRunList.length())
                    maxRunList = returnList;
            }
        }
        System.out.println(maxRunList.toString() + " (" + (maxRunList.split(" ").length - 1) + ")");
        hashMap.clear();
    }

    // Check the left, right, upper and down longest run and return the max of them.
    private String findLogestRun(Integer[][] grid, int row, int col) {
        String maxRun = getLeftRun(grid, row, col);
        String rightRun = getRightRun(grid, row, col);
        if (rightRun.length() > maxRun.length())
            maxRun = rightRun;

        String upperRun = getUpperRun(grid, row, col);

        if (upperRun.length() > maxRun.length())

            maxRun = upperRun;

        String downRun = getDownRun(grid, row, col);

        if (downRun.length() > maxRun.length())

            maxRun = downRun;

        maxRun += " " + grid[row][col];

        String key = row + " " + col;

        hashMap.put(key, maxRun);

        return maxRun;

    }
// Find the longest run for left index.

    private String getLeftRun(Integer[][] grid, int row, int col) {

        String leftRun = "";

        int left = col - 1;
// check if left exist and its value is less than current index.

        if (left >= 0 && grid[row][left] < grid[row][col]) {

            String leftKey = row + " " + left;
// If index already processed then No need to process again get it from the map.

            if (hashMap.containsKey(leftKey)) {

                leftRun = hashMap.get(leftKey);

            } else

                leftRun = findLogestRun(grid, row, left);

        }

        return leftRun;

    }
// Find the longest run for right index.

    private String getRightRun(Integer[][] grid, int row, int col) {

        String rightRun = "";

        int rig = col + 1;
// check if right exist and its value is less than current index.

        if (rig < grid[0].length && grid[row][rig] < grid[row][col]) {

            String rightKey = row + " " + rig;
// If index already processed then No need to process again get it from the map.

            if (hashMap.containsKey(rightKey))

                rightRun = hashMap.get(rightKey);

            else

                rightRun = findLogestRun(grid, row, rig);

        }

        return rightRun;
    }

    private String getUpperRun(Integer[][] grid, int row, int col) {

        String upperRun = "";

        int up = row - 1;
// check if upper index exist and its value is less than current index.

        if (up >= 0 && grid[up][col] < grid[row][col]) {

            String upperKey = up + " " + col;
// If index already processed then No need to process again get it from the map.

            if (hashMap.containsKey(upperKey))

                upperRun = hashMap.get(upperKey);

            else

                upperRun = findLogestRun(grid, up, col);

        }

        return upperRun;

    }

    // Find the longest run for down index.
    private String getDownRun(Integer[][] grid, int row, int col) {

        String downRun = "";

        int down = row + 1;
// check if down index exist and its value is less than current index.

        if (down < grid.length && grid[down][col] < grid[row][col]) {

            String downKey = down + " " + col;
// If index already processed then No need to process again get it from the map.

            if (hashMap.containsKey(downKey))

                downRun = hashMap.get(downKey);

            else

                downRun = findLogestRun(grid, down, col);

        }

        return downRun;
    }

    // Check if the new problem started.
    private boolean tokenStartWithString(String[] tokens) {

        try {

            Integer.valueOf(tokens[0]);

            return false;

        } catch (NumberFormatException nfe) {

            return true;

        }
    }

    // Main method to start execution.
// Save the problem(grid) in file and provide the path in main method, in variable filePath.
    public static void main(String arg[]) {

        System.out.println("Logest Run Outputs :- \n");

        BufferedReader br = null;

        String filePath = "src/main/java/com/kali/test/input1.txt";

        SkiingLongestRun longestRun = new SkiingLongestRun();
// Try to read file and create 2D array for each problem.

        try {

            Integer[][] grid = null;

            String sCurrentLine = null;

            int count = 0;

            br = new BufferedReader(new FileReader(filePath));

            sCurrentLine = br.readLine();

            sCurrentLine = br.readLine();

            while (sCurrentLine != null) {

                String[] tokens = sCurrentLine.split(" ");

                if (longestRun.tokenStartWithString(tokens)) {

                    if (grid != null) {

                        longestRun.findLogestRun(grid);

                        grid = null;

                    }

                    System.out.print(tokens[0] + " = ");

                    count = 0;

                    Integer row = Integer.valueOf(tokens[1]);

                    Integer col = Integer.valueOf(tokens[2]);

                    grid = new Integer[row][col];

                } else {

                    for (int i = 0; i < tokens.length; i++) {

                        grid[count][i] = Integer.valueOf(tokens[i]);

                    }

                    count++;

                }

                sCurrentLine = br.readLine();

            }

            if (grid != null) {

                longestRun.findLogestRun(grid);

            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null) br.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }

    }

}