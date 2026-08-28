
#include <iostream>
using namespace std;


int statusCode(double x) {

    if (x < 0) {
        return  -1;
    }
    else if (x < 30) {
        return 0;
    } 
    else if(x < 45) {
        return 1;
    }
    else if (x < 60) {
        return 2;
    }
    else {
        return 3;
    }
}

void label(int status) {
    switch(status){
        case -1 : cout << "Status     : SENSOR_ERROR";
                  break;

        case 0 : cout << "Status      : NORMAL";
                  break;

        case 1 : cout << "Status      : WARNING";
                  break;

        case 2 : cout << "Status      : CRITICAL";
                  break;

        default : cout << "Status      : SHUTDOWN";
                  break;
    }
}

double temperature(double x) {
    return ((x * 9) / 5) + 32;
}

string action(int status) {
    if (status == -1) {
        return "Sensor fault - check wiring";
    }
    else if(status == 0) {
        return "No action required";
    }
    else if (status == 1) {
        return "Alert to supervisor";
    }
    else if(status == 2) {
        return "Cooling system triggered";
    }
    else
        return "Emergency shutdouwn initiated";

}





int main() {
    double temp;
    cout << "input: ";
    cin >> temp;

    int status = statusCode(temp);
    double fahren = temperature(temp);
    

    cout <<endl <<  "Temperature : " << temp << " C " << " / " << fahren << " F" << endl;
    
    label(status);

    cout << endl << "Action      : " << action(status) << endl;

    cout << "reading     : ";
    (temp < 25) ? (cout << "Below Average" ) : cout << "Above Average"; 
    
    
}