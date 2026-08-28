
#include<iostream>
#include<cmath>
#include<numbers>


using namespace std;



inline double distanceBetween(double x1, double y1, double x2, double y2){
    return sqrt((pow((x2 - x1), 2) + pow((y2 - y1), 2)));
}

inline double toRadians(double degrees) {
    const double PI = 3.1415;
    return degrees * (PI / 180);
}

inline double clamp(double value, double minVal, double maxVal) {
    if(value < minVal) {
        return minVal;
    }
    else if(value > maxVal) {
        return maxVal;
    }
    else
        return value; 
}

inline bool isInSafeZone(double x, double y, double cx, double cy, double radius) {
    if(distanceBetween(x, y, cx, cy) > radius) {
        return false;
    }
    else    
        return true;
}

int main() {
    double homeX = 0.0;
    double homeY = 0.0;
    double radius = 50;

    int waypoint1_X,waypoint1_y;

    cout << "Enter waypoints: " << endl << "Enter X and Y: " << endl;
    cin >> waypoint1_X >> waypoint1_y;

    cout << "Distance from home : " << distanceBetween(waypoint1_X, waypoint1_y, homeX, homeY) << endl;

    cout << "In safe zone : " << isInSafeZone(waypoint1_X, waypoint1_y, homeX, homeY, radius);


    return 0;
}