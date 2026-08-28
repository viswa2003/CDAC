
#include<iostream>

using namespace std;



void displayValid(double arr[], int n, int &valid, int &skipped, int &normal,int &warning,int &critical,int &shutdown) {
     for(int i = 0; i < n; i++) {
        if (arr[i] == 0) {
            skipped += 1;
            continue;
        }
        double temp = arr[i];

        (temp >= 60) ? shutdown++ :(temp >= 45) ? critical++ : (temp >= 30) ? warning++ : normal++;

        cout << " " << arr[i];
        valid += 1;
    }
}


void firstCritical(double arr[], int n) {
    for(int i = 0; i < n; i++) {
        if(arr[i] >= 45){
            cout << "First Critical   : " << i  << " -> " << arr[i] << endl;
            break;
        }
    }
}


void minMax(double arr[],int n, double &minimum, double &maximum, double &total){
    for(int i = 0; i < n; i++) {
        if(arr[i] == 0) {
            continue;
        }
        minimum = min(minimum, arr[i]); 
        maximum = max(maximum, arr[i]);
        total += arr[i];
    }
}





int main() {
    int n;
    int valid = 0; 
    int skipped = 0;
    int normal = 0, warning = 0, critical = 0, shutdown = 0;

    double arr[100];

    double minimum = INT_MAX;
    double maximum = 0;
    double total = 0;



    cout << "No of Readings : ";
    cin >> n;

    cout << "Enter readings : ";
    for( int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    cout << "Readings entered: " << n;
    
    cout << "\nValid readings : ";

    displayValid(arr, n, valid, skipped, normal, warning, critical, shutdown);

    cout << "\nSkipped (errors) : " << skipped << endl;

    firstCritical(arr, n);

    minMax(arr, n, minimum, maximum, total);

    double average = total / valid;

    cout << "Min : " << minimum << " Max : " << maximum << " Avg : " << average;

    cout << "\nNormal : " << normal << " Warnings : " << warning << " Critical : " << critical << " Shutdown : " << shutdown;
    
    return 0;

}