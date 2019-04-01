package com.example.pouch;

public class Table {

    int equips[][] = new int[10][10];

    public int insert(int shapeID, int wepID) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
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
}
