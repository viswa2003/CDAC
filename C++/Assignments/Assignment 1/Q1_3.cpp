
#include<iostream>
using namespace std;

void display(double arr[][3], int row, int col) {
    cout << "\t\tRoom1\tRoom2\tRoom3 \n";

    for(int i =0; i < row; i++) {
        cout << "Floor " << i + 1 <<" : " ;

        for(int j = 0; j < col; j++) {
            cout <<"\t" << arr[i][j];    
        }
        cout << endl;
    }
}

void hottestRoom(double arr[][3], int row, int col) {
    double hottest = 0;
    int floor;
    int room;

    for(int i = 0; i < row; i++) {
        for(int j = 0; j < col; j++) {
            if(arr[i][j] > hottest){
                floor = i;
                room = j;
                hottest = arr[i][j];
            }
        }
    }
    cout << "Hottest Room  :  Floor " << floor + 1 << ", Room " << room + 1 <<" -> " << hottest << " C" << endl; 
}

void hottestFloor(double arr[][3], int row, int col) {
    double floorTemp;
    double hottestTemp;
    int hotFloor;

    for(int i = 0; i < row; i ++) {
        
        floorTemp = 0;
        for (int j = 0; j < col; j++) {
            floorTemp += arr[i][j];
        }
        if(floorTemp > hottestTemp){
            hottestTemp = floorTemp;
            hotFloor = i;
        }
    }

    double avg = hottestTemp / 3;

    cout << "Hottest Floor  :  Floor " << hotFloor <<"  (avg " << avg << " C)" << endl;
}


void warningRooms(double arr[][3], int row, int col) {
    int warningCount = 0;

    for(int i = 0; i < row; i++) {
        for(int j = 0; j < col; j ++) {
            if(arr[i][j] >= 30) {
                warningCount ++;
            }
        }
    }

    cout << "Rooms at WARNING or above : " << warningCount << endl;
}


int main() {
    double arr[3][3];

    int row = 3, col = 3;

    cout << "Enter temperatures of 9 rooms: ";

    for(int i = 0; i < row; i++) {
        for(int j = 0; j < col; j++) {
            cin >> arr[i][j];
        }
    }

    display(arr, row, col);

    hottestRoom(arr, row, col);

    hottestFloor(arr, row, col);

    warningRooms(arr, row, col);

    
}