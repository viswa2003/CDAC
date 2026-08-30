
#include <iostream>
using namespace std;

void tileCount(int **arr, int row, int col) {
    int grass = 0, water = 0, mountain = 0, forest = 0, dungeon = 0;

    for(int i = 0; i < row; i++){
        for(int j = 0; j < col; j++) {
            int num = arr[i][j];

            (num == 0) ? grass++ : (num == 1) ? water++ : (num == 2) ? mountain++ : (num == 3) ? forest++ : dungeon++;
        }
    }

    cout << "   Grass           : " << grass << endl;
    cout << "   Water           : " << water << endl;
    cout << "   Mountain        : " << mountain << endl;
    cout << "   Forest          : " << forest << endl;
    cout << "   Dungeon         : " << dungeon << endl;
}


int level = 1; //Global 

namespace Engine {
    namespace Audio {
        void playSound(string name) {
            cout << "Playing : " << name << endl;
        }
    }
}


int main() {

    int level = 1; //local

    int row, col;

    cout << "Enter row and column size : " << endl;
    cin >> row >> col;

    int** arr = new int*[row];
    for(int i = 0; i < row; i++){
        arr[i] = new int[col];
    }
    

    // cout << "Enter values for grid : " << endl ;

    for(int i = 0; i < row; i++) {
        for(int j = 0; j < col; j++) {
            // cin >> arr[i][j];

            arr[i][j] = (rand() % 5);
        }
    }

    cout << "==== GAME MAP (" << row << "x" << col << ") ====="<< endl;
    for(int i = 0; i < row; i++) {
        for(int j = 0; j < col; j++) {
            // cin >> arr[i][j];

            cout << arr[i][j] << "   ";
        }
        cout << endl;
    }

    cout << "\nLegend: 0=Grass  1=Water  2=Mountain  3=Forest  4=Dungeon\n" << endl;
    
    cout << "Tile count: " << endl;
    
    tileCount(arr, row, col);

    cout << endl;
     
    cout << "Global level : " << ::level << endl;
    cout << "Local level : " << level << endl;

    Engine::Audio::playSound("Sword_clash");

    for(int i = 0; i < row; i++) {
        delete[] arr[i];
    }

    delete[] arr;

    return 0;

}