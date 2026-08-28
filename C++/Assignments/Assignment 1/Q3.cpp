#include <iostream>
#include<string>
using namespace std;

class Employee{
    private:
        int empId;
        static int employeeCount;
        string name;
        string department;
        char grade;
        double basic_salary;
        bool isActive;

    
    public: 
        Employee(){
            employeeCount ++;
            empId = 1000 + employeeCount;

            isActive = true;
        }

    // public setters
        void setName(const string &n){
            if(n != "") {
                name = n;
            }
            else
                cout << "Invalid name" << endl;
        };

        void setDepartment(const string &dept){
            if(dept == "Engineering" || dept == "HR" || dept == "Finance" || dept == "Operations") {
                department = dept;
            }
            else
                cout << "ERROR: 'Marketing' is not a registered department."  << endl;
        };

        void setGrade(char g){
            if(g == 'A' || g == 'B' || g == 'C' || g == 'D'){
                grade = g;
            }
            else
                cout << "ERROR: Invalid grade 'X'. Accepted values: A, B, C, D." << endl;
        };

        void setBasicSalary(double salary){
            if(salary > 10000 && salary < 5000000) {
                basic_salary = salary;
            }
        };

        void deactivate(){
            if(isActive == true) {
                isActive = false;
            }
        };

    // public getters
        
        int getEmpId() const{
            return empId;
        };

        string getName() const {
            return name;
        };

        string getDepartment() const {
            return department;
        };

        char getGrade() const {
            return grade;
        }

        double getBasicSalary() const {
            return basic_salary;
        };

        bool getIsActive() const {
            return isActive;
        };

    
    // Member Functions

        double computeAllowances() const{
            if(grade == 'A'){
                return basic_salary * 0.4;
            }
            else if(grade == 'B'){
                return basic_salary * 0.3;
            }
            else if(grade == 'C'){
                return basic_salary * 0.2;
            }
            else 
                return basic_salary * 0.1;
        }

        double computeGrossSalary() const{
            return basic_salary + computeAllowances();
        }

        double computeTax() const {
            if(computeGrossSalary() <= 50000) {
                return 0.0;
            }else if(computeGrossSalary() <= 100000) {
                return (computeGrossSalary() - 50000) * 0.1;
            }
            else 
                return ((computeGrossSalary() - 100000)* 0.2) + 5000;
        }

        double computeNetSalary() const{
            return computeGrossSalary() - computeTax();
        }

        void printPaySlip() const {
            int allowance;
            string status;

            if(getIsActive() == 1){
                status = "Active";
            }else  
                status = "Not Active";

            if(getGrade() == 'A') {
                allowance = 40;
            }else if(getGrade() == 'B') {
                allowance = 30;
            }else if(getGrade() == 'C') {
                allowance = 20;
            } else if(getGrade() == 'D') {
                allowance = 10;
            }

            cout << "=================================="<< endl;
            cout << "   EMPLOYEE PAYSLIP - AUG 2026 "<< endl;
            cout << "=================================="<< endl;
            cout << "Emp ID     : " << getEmpId() << endl;
            cout << "Name       : " << getName() << endl;
            cout << "Department : " << getDepartment() << endl;
            cout << "Grade      : " << getGrade() << endl;
            cout << "Status     : " << status << endl;
            cout << "---------------------------------" << endl;
            cout << "Basic Salary       :  Rs. " << getBasicSalary() << endl;
            cout << "Allowance (" << allowance << "%)    :  Rs. " << computeAllowances()<< endl;
            cout << "Gross Salary       :  Rs. " << computeGrossSalary() <<endl;
            cout << "---------------------------------" << endl;
            cout << "Tax Deduction      :  Rs. " << computeTax() << endl;
            cout << "Net Salary         :  Rs. " << computeNetSalary() << endl;

        }

        static int getEmployeeCount() {
            return employeeCount;
        };


        // Read Input
        void acceptDetails() {
            string n;
            string dept;
            char g;
            double salary;

            cout << "Enter name :" << endl;
            cin >> n;
            setName(n);

            cout << "Enter department :" << endl;
            cin >> dept;
            setDepartment(dept);

            cout << "Enter grade :" << endl;
            cin >> g;
            setGrade(g);

            cout << "Enter salary :" << endl;
            cin >> salary;
            setBasicSalary(salary);
            
        }

};

int Employee::employeeCount = 0;

int main() {
    Employee e1;
    Employee *e2 = new Employee();
    Employee *e3 = new Employee();

    e1.acceptDetails();
    e2->acceptDetails();
    e3->acceptDetails();


    e1.printPaySlip();
    e2->printPaySlip();
    e3->printPaySlip();

    e3->deactivate();
    if(!e3->getIsActive()){
        cout << endl << e3->getName() <<" is no longer active. Payroll skipped." << endl;
    }

    cout << "Total employee  : " << Employee::getEmployeeCount() << endl;

    delete e2;
    delete e3;

    return 0;

}
