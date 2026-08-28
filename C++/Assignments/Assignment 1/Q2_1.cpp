
#include<iostream>
using namespace std;


void resetSensorPairV1(int reading1, int reading2) {

    int temp = reading1;
    reading1 = reading2;
    reading2 = temp;

}

void resetSensorPairV2(int &reading1, int &reading2) {

    int temp = reading1;
    reading1 = reading2;
    reading2 = temp;

}

void resetSensorPairV3(int *reading1, int *reading2) {

    int temp = *reading1;
    *reading1 = *reading2;
    *reading2 = temp;

}

int main() {

    int reading1, reading2;
    cout << "Enter 2 readings: " << endl;
    cin >> reading1 >>reading2;

    cout << "--- V1: Call By Value --- " << endl ;

    cout << "Before  :  A = " << reading1 << " B = " << reading2 <<endl;

    resetSensorPairV1(reading1, reading2);

    cout << "After   :  A = " << reading1 << " B = " << reading2 <<  "\t<- values unchanged"<<endl;

    // In Call-By-Value, a copy of the variables reading1 and reading2 are passed to the function resetSensorPairingV1. 
    // The copies of the variables are swapped inside the function but the original values in the memory remains the same.

    

    cout << "--- V2: Call By Reference --- " << endl ;

    cout << "Before  :  A = " << reading1 << " B = " << reading2 <<endl;

    resetSensorPairV2(reading1, reading2);

    cout << "After   :  A = " << reading1 << " B = " << reading2 <<  "\t<- values swapped"<<endl;

    // In Call-By-Reference, instead of a copy, a referance to the original variable in the main() is passed to the function resetSensorReadingV2(). 
    // When the reference variable is modified, the original variables are modified.


    cout << "--- V3: Call By Pointer --- " << endl ;

    cout << "Before  :  A = " << reading1 << " B = " << reading2 <<endl;
    
    resetSensorPairV3(&reading1, &reading2);
    
    cout << "After   :  A = " << reading1 << " B = " << reading2 <<  "\t<- values swapped back"<<endl;

    // In Call-By-Pointer, the addresses of the original variables are passed as arguments to the function.
    // The pointer parameters store the address and by dereferencing the pointers, the function can access and modify the original value
    return 0;
}