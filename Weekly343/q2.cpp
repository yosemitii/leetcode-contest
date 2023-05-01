//
// Created by Lubin Sun on 4/29/23.
//

#include <algorithm>
#include <stdio.h>
#include <vector>
#include <cmath>
#include <iostream>
#include <map>

using namespace std;

class Solution {
public:
    int firstCompleteIndex(vector<int>& arr, vector<vector<int>>& mat) {
        // map<int, int[]> map;
        // vector<vector<bool>> res;
        // for (int v = 0; v < arr.size(); v++){
        //     for (int i = 0; i < mat.size(); i++) {
        //         for (int j = 0; j < mat[0].size(); j++) {
        //             // for (auto v: arr) {
        //             //     if (j == )
        //             // }
        //             if (arr[v] == mat[i][j]) {
        //                 // res[i][j] = true;
        //                 mat[i][j] = -1;
        //             }
        //             if (v < mat[i].size()-1 && v < mat.size()-1) {
        //                 continue;
        //             }
        //             bool row_painted = true;
        //             for (int x = 0; x < mat[i].size(); x++) {
        //                 // if (mat[i][x] != -1) continue;
        //                 row_painted = row_painted && (mat[i][x] == -1);
        //             }
        //             if (row_painted) return v;
        //             bool col_painted = true;
        //             for (int y = 0; y < mat.size(); y++) {
        //                 // if (mat[y][j] != -1) continue;
        //                 col_painted = col_painted && (mat[y][j] == -1);
        //             }
        //             if (col_painted) return v;
        //         }
        //     }
        // }
        // return arr.size()-1;

        // map<int, vector<int>> int_to_col;
        // map<int, vector<int>> int_to_row;
        // vector<vector<int>> mat_t(mat[0].size(), std::vector<int>(mat.size(), 0));
        vector<int> col_cnt(mat[0].size(), mat.size());
        vector<int> row_cnt(mat.size(), mat[0].size());
        map<int, int> int_col_map;
        map<int, int> int_row_map;

        for (int i = 0; i < mat.size(); i++) {
            for (int j = 0; j < mat[0].size(); j++) {
                // if (mat_t[j] == NULL) {
                //     mat_t[
                // }

                int value = mat[i][j];
                // mat_t[j][i] = value;
                // int_to_col =
                int_row_map[value] = i;
                int_col_map[value] = j;
            }
        }

        int c = -1;
        int r = -1;
        for (int idx = 0; idx < arr.size(); idx++) {
            c = int_col_map[arr[idx]];
            r = int_row_map[arr[idx]];

            col_cnt[c]--;
            if (col_cnt[c] == 0) return idx;
            row_cnt[r]--;
            if (row_cnt[c] == 0) return idx;
            // mat[i].remove(mat[i].begin()+c);
            // if (mat[i].empty()) return idx;
            // mat_t[j].remove(mat[j].begin()+r);
            // if (mat_t[j].empty()) return idx;
        }

        return arr.size()-1;
    }
};

int main() {
    vector<int> arr = {6,2,3,1,4,5};
    vector<vector<int>> mat = {{5,1},{2,4},{6,3}};
    Solution s;
    int x = s.firstCompleteIndex(arr, mat);
    printf("%d", x);
}