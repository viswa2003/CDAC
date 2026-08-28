
#include <string>
#include <iostream>

using namespace std;

int main(int charc, char* argv[]) {
    if(charc < 4) {
        cout << "Usage  : ./sensor_monitor <warn_threshold> <critical_threshold> <num_readings>"<< endl;
        cout << "error  :  Missing arguments";
        return 1;
    }
    int warn = stoi(argv[1]);
    int crit = stoi(argv[2]);
    int num = stoi(argv[3]);

    int normal = 0, warning = 0, critical = 0, shutdown = 0;

    if(warn > crit) {
        cout << "<warning> should be less than <critical>"<< endl;
        return 1;
    }
    else if(num < 1 || num > 500) {
        cout << "Number of readings should be less than 500";
        return 1;
    }
    else{

    // int crit = stoi(argv[2]);
        cout << "config\t:  Warn = " << warn << " Critical : " << crit << " Readings = " << num<< endl;

        for(int i = 0; i < num; i++) {
            int simulate = rand() % 70;

            (simulate < warn) ? (normal ++) : (simulate < critical) ? (warning ++) : (simulate > critical && simulate < 60) ? (critical ++) : (shutdown++);
            
        }

        cout << "Result : Normal : " << normal << " warning : " << warning << " Critical : " << critical << " Shutdown : " << shutdown << endl;
    }
    return 0;
}