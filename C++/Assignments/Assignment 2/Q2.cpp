
#include <iostream>
using namespace std;

class Patient {
    private:
    int patientId;
    string name;
    int age;
    string ward;
    const string bloodGroup;

    public:
    // Default constructor
    Patient() : patientId(0), name("Unknown"), age(0), ward("General"), bloodGroup("O+") {
        cout << "Default patient registered." << endl ;
    }

    // Constructor 2
    Patient(int id, const string& name) : patientId(id), name(name), bloodGroup("O+"){
        cout << "Emergency: " << name << endl;
    }
    
    // Constructor 3
    Patient(int id, const string& name, int age, const string& ward, const string& bg) : patientId(id), name(name), age(age), ward(ward), bloodGroup(bg) {
        cout << "Full admission: " << name << endl;
    }
    
    // Destructor
    ~Patient(){
        cout << "Patient " << name << " discharged" << endl;
    }

    void displayRecord() const {
        cout << "========== Patient Record ========== " << endl;
        cout << "ID              : " << patientId << endl;
        cout << "Name            : " << name << endl;
        cout << "Age             : " << age << endl;
        cout << "Ward            : " << ward << endl;
        cout << "Blood Group     : " << bloodGroup << endl << endl;

    };

    void transferWard(const string& newWard) {
        ward = newWard;
        cout << "Ward Transfer " << name << " -> " << newWard << endl;;  
    };

};


int main() {
    Patient p1;
    Patient p2(101, "Viswa");
    Patient p3(102, "Rajesh", 2, "Cardio", "A+");

    Patient* patient = new Patient[4];

    
    for(int i = 0; i < 4; i++) {
        patient[i].displayRecord();
    }

    p3.transferWard("Physio");

    delete[] patient;

    return 0;
}

