
#include<iostream>
using namespace std;

int main() {
    
    int statusReg  = 0b10110001;   
    int controlReg = 0b00000000;   
    int dataReg    = 0b11001010; 

    const int *regPtr1 = &statusReg;
    int *const regPtr2 = &controlReg;
    const int* const regPtr3 = &statusReg;

    cout << "Status reg :  "<< *regPtr1 << endl;

    // *regPtr1 = 10;
    // Write is not possible.


    // repointing regPtr1 to dataReg
    regPtr1 = & dataReg;
    //Repointing is possible. 
    cout << "After repointing : " << *regPtr1;


    // regPtr2
    cout << "Control reg : "<< *regPtr2 << endl;

    *regPtr2 = 10;
    // writing is possible. 

    // regPtr2 = &dataReg;
    // cannot repoint.


    // regPtr3
    cout << "Status reg regPtr3: " << *regPtr3 << endl;

    // *regPtr3 = 20
    // Cannot modify

    // regPtr3 = &dataReg;
    // cannot repoint

    return 0;
}