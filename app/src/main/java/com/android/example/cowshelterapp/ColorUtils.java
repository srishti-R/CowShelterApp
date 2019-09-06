package com.android.example.cowshelterapp;

public class ColorUtils {


    static int[][] colorsArray = new int[][]{
            new int[]{R.color.red1, R.color.red2, R.color.red3, R.color.red4},
            new int[]{R.color.blue1, R.color.blue2, R.color.blue3, R.color.blue4},
            new int[]{R.color.green1, R.color.green2, R.color.green3, R.color.green4},
            new int[]{R.color.yellow1, R.color.yellow2, R.color.yellow3, R.color.yellow4},
            new int[]{R.color.orange1, R.color.orange2, R.color.orange3, R.color.orange4},
            new int[]{R.color.brown1, R.color.brown2, R.color.brown3, R.color.brown4},
            new int[]{R.color.grey1, R.color.grey2, R.color.grey3, R.color.grey4}
    };

    /*List<List<int[]>> colors=new ArrayList<List<int[]>>();

    public List convertArrayToList(Integer[][] colorsArray){
        for (Integer[] array: colorsArray) {
            //This will add int[] object into the list, and not the int values.
            colors.add(Arrays.asList(array));
        }
    }

    int iLength = colorsArray.length;
    List<List<Integer>> listOfLists = new ArrayList<>(iLength);
    for (int i = 0; i < iLength; i++) {
        int jLength = colorsArray[0].length;
        listOfLists.add(new ArrayList(jLength));
        for (int j = 0; j < jLength; ++j) {
            listOfLists.get(i).add(colorsArray[i][j]);
        }
    }*/

}
