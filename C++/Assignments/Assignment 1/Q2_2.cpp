
#include<iostream>
#include<cmath>

using namespace std;

double computeRMS(double *signal, int n) {
    double sum = 0;
    for(int i = 0; i < n; i++) {
        double val = *(signal + i);
            sum = sum + val * val;
    }
    return sqrt(sum / n);
}


void normalize(double* signal, int n){
    double max_value = 0;
    for(int i = 0; i < n; i++) {
        max_value = max(max_value, abs(*(signal + i))); 
    }
    // cout << "\nmax: " << max_value;

    for(int i = 0; i < n; i++) {
        *(signal + i) = *(signal + i) / max_value;
    }
}


int countZeroCrossings(double* signal, int n) {
    int count = 0;
    for(int i = 0; i < n; i++) {
        if(*(signal + i) < 0 && *(signal + i + 1) > 0){
            count ++;
        }
        else if(*(signal + i) > 0 && *(signal + i + 1) < 0){
            count ++;
        }
    }

    return count;
}


void applyGain(double* signal, int n, double gainFactor) {
    for(int i = 0; i < n; i++) {
        *(signal + i) *= gainFactor;
    }
}



int main(){

    double signal[100];
    // double signal[] = {0.5, -1.2, 0.8, -0.3, 1.0, -0.9, 0.1};
    int n, gain;
    cout << "Input signal count: " << endl;
    cin >> n;

    cout << "Input Gain factor: " << endl;
    cin >> gain ;

    // Enter input
    cout << "Enter signal : ";
    for (int i = 0; i < n; i++) {
        cin >> (signal[i]);
    }


    // Compute RMS
    double RMS = computeRMS(signal, n);
    cout << endl << "RMS\t: " << RMS << endl;
    
    
    // Before Normalise
    cout <<  "\nBefore normalize:" << endl;;
    for(int i = 0; i < n; i++){
        cout << signal[i] << "\t";
    }


    // Normalise
    normalize(signal, n);


    // After Normalize
    cout << endl << "\nAfter normalize:" << endl;;
    for(int i = 0; i < n; i++){
        cout << signal[i] << "\t";
    }

    
    // Zero Crossings
    int zeroCrossings = countZeroCrossings(signal, n);
    cout << "\n\nZero Crossings : " << zeroCrossings << endl;


    
    // Before Gain factor
    cout << endl << "\nBefore Gain factor:" << endl;;
    for(int i = 0; i < n; i++){
        cout << signal[i] << "\t";
    }
        
    // Gain factor
    applyGain(signal, n, gain);

    // after Gain factor
    cout << endl << "\nAfter Gain factor:" << endl;;
    for(int i = 0; i < n; i++){
        cout << signal[i] << "\t";
    }
    return 0;
}