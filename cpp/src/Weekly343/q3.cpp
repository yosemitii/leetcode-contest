//
// Created by Lubin Sun on 4/30/23.
//
#include <algorithm>
#include <stdio.h>
#include <cmath>
#include <iostream>
#include <vector>
#include <set>
#include <map>
#include <queue>
#include <unordered_set>
using namespace std;
class Solution {
public:
    int minimumCost(vector<int>& start, vector<int>& target, vector<vector<int>>& specialRoads) {
        map<int, vector<int>> indexMap;

        set<vector<int>> vertices;
        set<vector<int>> starts;
        set<vector<int>> targets;

        class Edge {
        public:
            vector<int> start;
            vector<int> target;
            int weight;
            Edge(vector<int>& v1, vector<int>& v2, int w) {
                this->start = v1;
                this->target = v2;
                this->weight = w;
            }
        };

        //
        struct EdgeCompare {
            bool operator()(const Edge& e1, const Edge& e2) const {
                return e1.weight > e2.weight;
            }
        };

        struct PairCompare {
            bool operator()(const pair<vector<int>, int>& e1, const pair<vector<int>, int>& e2) const {
                return e1.second > e2.second;
            }
        };

        priority_queue<Edge, vector<Edge>, EdgeCompare> fringe;

        priority_queue<pair<vector<int>, int>, vector<pair<vector<int>, int>>, PairCompare> pq;

        map<vector<int>, vector<Edge>> edges;
        vertices.insert(start);
        vertices.insert(target);

        for (auto arr: specialRoads) {
            if (abs(arr[2]-arr[0]) + abs(arr[3]-arr[1]) <= arr[4]) continue;
            vector<int> v1 = {arr[0], arr[1]};
            vector<int> v2 = {arr[2], arr[3]};
            vertices.insert(v1);
            vertices.insert(v2);
            Edge e(v1, v2, arr[4]);
            edges[v1].emplace_back(v1, v2, arr[4]);
            edges[start].emplace_back(start, v1, mahanttanDistance(start, v1));
            edges[v2].emplace_back(v2, target, mahanttanDistance(v2, target));
            starts.insert(v1);
            targets.insert(v2);
//            edges[v2].emplace_back(v2, v1, arr[4]);
        }

//        for (auto v1: vertices) {
//            for (auto v2 : vertices) {
//                if (v1 == v2) continue;
//                edges[v1].emplace_back(v1, v2, abs(v2[0]-v1[0])+abs(v2[1]-v1[1]));
//            }
//        }
        for (auto v1: targets) {
            for (auto v2: starts) {
                edges[v1].emplace_back(v1, v2, mahanttanDistance(v1, v2));
            }
        }

        /* Display edges and vertices */
//        for (auto v: edges) {
//            printf("%d, %d\n", v.first[0], v.first[1]);
//            for (auto e: v.second) {
//                printf("[%d,%d] -> [%d,%d]: %d\n", e.start[0], e.start[1], e.target[0], e.target[1], e.weight);
//            }
//        }
//        for (auto v: vertices) {
//            printf("[%d,%d]", v[0], v[1]);
//        }



        map<vector<int>, bool> visited;
        map<vector<int>, int> distanceTable;
        for (auto v: vertices) {
            distanceTable[v] = mahanttanDistance(target, start);
            visited[v] = false;
        }

        for (auto e: edges[start]) {
            fringe.push(e);
            pq.emplace(e.target, e.weight);
            distanceTable[e.target] = e.weight;
        }
        cout << endl;
//        for (auto d: distanceTable) {
//            printf("%d\t", d.second);
//        }

//        printf("\nstart Dijkstra\n");
        while (!pq.empty()) {
            auto p = pq.top();
//            printf("[%d,%d]d:%d\n", p.first[0], p.first[1], p.second);
            if (visited[p.first]) {
                pq.pop();
                continue;
            }
            for (auto e: edges[p.first]) {
                distanceTable[e.target] = min(distanceTable[p.first] + e.weight, distanceTable[e.target]);
                if (!visited[e.target]) {
//                    printf("new dis: %d, old dis: %d\n", distanceTable[p.first] + e.weight, distanceTable[e.target]);
                    pq.emplace(e.target, distanceTable[e.target]);
                }

            }
            visited[p.first] = true;
            pq.pop();
//            printf("pq size: %d", pq.size());
        }

        return distanceTable[target];
    }

    int mahanttanDistance(vector<int> v1, vector<int>v2) {
        return abs(v2[0]-v1[0])+abs(v2[1]-v1[1]);
    }

};

int main() {
    vector<int> start = {1,1};
    vector<int> target = {10,8};
    vector<vector<int>> sr = {{6,4,9,7,1},{5,2,2,1,3},{3,2,5,5,2}};
    Solution s;
    int x = s.minimumCost(start, target,sr);
    cout << x;
}
