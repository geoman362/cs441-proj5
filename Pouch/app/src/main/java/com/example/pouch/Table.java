package com.example.pouch;

public class Table {

    private int equips[][];
    private int xdim;
    private int ydim;
    public Table(int x, int y) {
        equips = new int[x][y];
        xdim = x;
        ydim = y;
    }
    public int insert(int shapeID, int wepID) {
        for (int i = 0; i < xdim; i++) {
            for (int j = 0; j < ydim; j++) {
                if (equips[i][j] == 0) {
                    if (shapeID == 0) { //Square shapes
                        if (equips[i + 1][j] == 0 && equips[i + 1][j + 1] == 0 && equips[i][j + 1] == 0) {
                            equips[i][j] = wepID;
                            equips[i + 1][j] = wepID;
                            equips[i + 1][j + 1] = wepID;
                            equips[i][j + 1] = wepID;
                            return 1;
                        }
                    } else if (shapeID == 1) { //4-long shapes
                        if (equips[i + 1][j] == 0 && equips[i + 2][j] == 0 && equips[i + 3][j] == 0) {
                            equips[i][j] = wepID;
                            equips[i + 1][j] = wepID;
                            equips[i + 2][j] = wepID;
                            equips[i + 3][j] = wepID;
                            return 1;
                        }
                    } else if (shapeID == 1) { //3-long shapes
                        if (equips[i + 1][j] == 0 && equips[i + 2][j] == 0) {
                            equips[i][j] = wepID;
                            equips[i + 1][j] = wepID;
                            equips[i + 2][j] = wepID;
                            return 1;
                        }
                    } else if (shapeID == 1) { //2-long shapes
                        if (equips[i + 1][j] == 0) {
                            equips[i][j] = wepID;
                            equips[i + 1][j] = wepID;
                            return 1;
                        }
                    }
                }
            }
        }
        return 0;
    }
    public int insert(int shapeID, int wepID, int i, int j) {
                if (equips[i][j] == 0) {
                    if (shapeID == 0) { //Square shapes
                        if (equips[i + 1][j] == 0 && equips[i + 1][j + 1] == 0 && equips[i][j + 1] == 0) {
                            equips[i][j] = wepID;
                            equips[i + 1][j] = wepID;
                            equips[i + 1][j + 1] = wepID;
                            equips[i][j + 1] = wepID;
                            return 1;
                        }
                    } else if (shapeID == 1) { //4-long shapes
                        if (equips[i + 1][j] == 0 && equips[i + 2][j] == 0 && equips[i + 3][j] == 0) {
                            equips[i][j] = wepID;
                            equips[i + 1][j] = wepID;
                            equips[i + 2][j] = wepID;
                            equips[i + 3][j] = wepID;
                            return 1;
                        }
                    } else if (shapeID == 1) { //3-long shapes
                        if (equips[i + 1][j] == 0 && equips[i + 2][j] == 0) {
                            equips[i][j] = wepID;
                            equips[i + 1][j] = wepID;
                            equips[i + 2][j] = wepID;
                            return 1;
                        }
                    } else if (shapeID == 1) { //2-long shapes
                        if (equips[i + 1][j] == 0) {
                            equips[i][j] = wepID;
                            equips[i + 1][j] = wepID;
                            return 1;
                        }
                    }
                }
        return 0;
    }
    public int remove(int wepID) {
        int succ = 0;
        for(int i = 0;i<xdim;i++){
            for(int j = 0;j<ydim;j++){
                if(equips[i][j] == wepID){
                    equips[i][j] = 0;
                    succ = 1;
                }
            }
        }
        return succ;
    }
}
