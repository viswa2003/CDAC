
#include<iostream>
using namespace std;

int main() {

    struct Layout1 {
        char c1;        // 1 byte
        int i;          // 4 byte
        char c2;        //1 byte
    };
// 1 + 3 (padding) + 4 + 1 + 3 (padding) = 12byte
// Since int needs to start at an address divisible by 4, the compiler adds padding after the first char. 

    struct Layout2 {
        int i;          //4 byte
        char c1;        //1 byte
        char c2;        //1 byte
    };
// 4 + 1 + 1 + 2 (padding) = 8 byte
// since int is at beginning, padding is not needed before it.

    cout << sizeof(Layout1) << endl;    

    cout << sizeof(Layout2) << endl;

    return 0;
}