#include<iostream>
#include<climits>
using namespace std;



bool parsePacket(const int* rawData, int size, int** outMin, int** outMax){
    if (size <= 0) {
        return false;
    }
    int minimum = INT_MAX;
    int maximum = INT_MIN;

    for(int i = 0; i < size; i++) {
        if(*(rawData + i) <= minimum) {
            minimum = *(rawData + i);
            *outMin = const_cast<int*>(rawData + i);
        }
    }
    
    for(int i = 0; i < size; i++) {
        if(*(rawData + i) >= maximum) {
            maximum = *(rawData + i);
            *outMax = const_cast<int*>(rawData + i);
        }
        
    }
    return true;

}


int main() {
    int packet[] = {45, 12, 67, 8, 55, 31};
    int* minPtr = nullptr;
    int* maxPtr = nullptr;

    if (parsePacket(packet, 6, &minPtr, &maxPtr)) {
        cout << "Calibration Min : " << *minPtr << endl;
        cout << "Calibration Max : " << *maxPtr << endl;
    }
}