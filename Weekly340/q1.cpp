#include <algorithm>
#include <stdio.h>
#include <vector>
#include <cmath>
#include <iostream>


//int main() {
//    std::cout << "Hello world" << std::endl;
//}
//
//class Solution {
//public:
//
//
//    int diagonalPrime(std::vector<std::vector<int>>& nums) {
//        int max = 0;
//        for (int i = 0; i < nums.size(); i++) {
//            if (is_prime(nums[i][i])) {
//                max = std::max(nums[i][i], max);
//            } else if (is_prime(nums[i][nums.size()-1-i])) {
//                max = std::max(nums[i][nums.size()-1-i], max);
//            }
//        }
//        return max;
//    }
//
//    bool is_prime(int n) {
//        if (n == 1 || n == 0) return false;
//        for (int i = 2; i < sqrt(n); i++) {
//            if (n % i == 0) return false;
//        }
//        return true;
//    }
//};