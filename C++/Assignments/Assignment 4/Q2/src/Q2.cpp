//============================================================================
// Name        : Q2.cpp
// Author      : Viswa
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <stack>
#include <vector>
#include <iomanip>
#include <string>
#include <climits>
using namespace std;

class Vehicle {
protected:
	string registrationNo;
	string ownerName;
	int yearOfManufacture;
	double kmDriven;

public:

	Vehicle(const string& reg, const string& owner, int year, double km) : registrationNo(reg), ownerName(owner), yearOfManufacture(year), kmDriven(km) {
		cout << "[Vehicle constructor] " << reg << " : " << owner << endl;
	}

	virtual double fuelCost(double kmToTravel) const = 0;

	virtual void describe() const {
		cout << "Reg no : " << registrationNo << "Owner : " << ownerName << "year of manufacture : " << yearOfManufacture << "KM Driven : " << kmDriven << endl;
	}

	virtual string vehicleType() = 0;

	virtual ~Vehicle() {
		cout << "Vehicle destructor" << endl;
	}

	double getKmDriven() const {
		return kmDriven;
	}

	string getRegNo() {
		return registrationNo;
	}

	string getRegNo() const {
		return registrationNo;
	}

	string getOwner() const {
		return ownerName;
	}

	double getKm() const {
		return kmDriven;
	}

};

class Car : public Vehicle {
public:
	string fuelType;
	double mileageKmpl;

	Car(const string& reg, const string& owner, int year, double km, string fuelType, double mileageKmpl) : Vehicle(reg, owner, year, km), fuelType(fuelType), mileageKmpl(mileageKmpl) {

	}

	double fuelCost(double km) const override {
		double cost;
		double petrolCost = 106.00;
		double dieselCost = 93.00;

		if(fuelType == "Petrol") {
			cost = (km / mileageKmpl) * petrolCost;
		}
		else {
			cost = (km / mileageKmpl) * dieselCost;
		}
		return cost;
	}

	string vehicleType() {
		return "Car";
	}

	void describe() const override {
		Vehicle::describe();
		cout << "Fuel Type : " << fuelType << "Mileage" << mileageKmpl << endl;
	}

	~Car() {
		cout << "car destructor.." << endl;

	}
};

class Truck : public Vehicle {
public:
	double payLoadCapacityTons;
	double fuelEfficiencyKmpl;

	Truck(const string& reg, const string& owner, int year, double km, double payLoadCapacityTons, double fuelEfficiencyKmpl) : Vehicle(reg, owner, year, km), payLoadCapacityTons(payLoadCapacityTons), fuelEfficiencyKmpl(fuelEfficiencyKmpl) {
		cout << "[Truck Constructor]"<< reg << " : " << owner << endl;;
	}

	double fuelCost(double km) const override {
		double dieselPrice = 93.00;
		double efficiencyDrop = payLoadCapacityTons * 0.10;
		double cost = (km / fuelEfficiencyKmpl) * dieselPrice;

		return cost - efficiencyDrop;
	}

	string vehicleType() {
		return "Truck";
	}

	~Truck() {
		cout << "Truck Destructor" << endl;
	}

};

class ElectricTruck : public Truck {
public:
	double batteryCapacityKWh;
	double rangePerChargeKm;

	ElectricTruck(const string& reg, const string& owner, int year, double km, double payLoadCapacityTons, double fuelEfficiencyKmpl, double batteryCapacityKWh, double rangePerChargeKm) : Truck(reg, owner, year, km, payLoadCapacityTons, fuelEfficiencyKmpl), batteryCapacityKWh(batteryCapacityKWh), rangePerChargeKm(rangePerChargeKm) {
		cout << "[Electric truck constructor]" << reg << " : " << owner << endl;;
	}

	double fuelCost(double km) const override {
		double electricityCostPerUnit = 9.50;
		return (km / rangePerChargeKm) * batteryCapacityKWh * electricityCostPerUnit;

	}

	string vehicleType() {
		return "Electric Truck";
	}

	void describe () const {
		cout << "Range : " << rangePerChargeKm << " \nBattery Capacity : " << batteryCapacityKWh  << endl;
	}

};

class Van : public Vehicle {
public:
	int seatingCapacity;
	double mileagePerKmpl;

	Van(const string& reg, const string& owner, int year, double km, int seatingCapacity, double mileagePerKmpl) : Vehicle(reg, owner, year, km), seatingCapacity(seatingCapacity), mileagePerKmpl(mileagePerKmpl) {
		cout << "Van Constructor" << endl;
	}

	double fuelCost(double km) const override {
		double petrolCost = 106.00;
		return (km / mileagePerKmpl) * petrolCost;
	}

	string vehicleType() {
		return "Van";
	}

	~Van() {
		cout << "Van destructor";
	}
};


void printFleetReport(const vector<Vehicle*> &fleet, double tripKm) {
	cout << endl;
	cout << endl;
	cout << setw(5) << "========= FLEET REPORT - Trip Distance : " << tripKm << " km =========="  << setw(5) << endl;
	cout << setw(10) << "Reg " << setw(15) << "Type " << setw(15) << "Owner" << setw(15) << "KM Driven" << endl;

	for(int i = 0; i < fleet.size(); i++) {
		cout << setw(10) << fleet[i]->getRegNo() << setw(15) << fleet[i]->vehicleType() << setw(15) << fleet[i]->getOwner() << setw(10) << fleet[i]->getKm() << endl;
	}

	cout << "===== FUEL / CHARGE COST ESTIMATE ======" << endl;

	double minimum = INT_MAX;
	string efficient;

	for(int i = 0; i < fleet.size(); i++) {
		double current_fuel_cost = fleet[i]->fuelCost(tripKm);
		string fuelType = " ";
		string charge = " "

		Car* car = dynamic_cast<Car*>(fleet[i]);
		ElectricTruck* truck = dynamic_cast<ElectricTruck*>(fleet[i]);

		if(car != nullptr) {
			fuelType += car->fuelType;
		}

		cout << fleet[i]->getRegNo() << " (" << fleet[i]->vehicleType() << ")" << setw(20) << " : Rs. " << current_fuel_cost << fuelType << endl;

		if(current_fuel_cost < minimum) {
			efficient = "Most Efficient Vehicle : " + fleet[i]->getRegNo() + " (" + fleet[i]->vehicleType() + ") - Rs. " + to_string(current_fuel_cost)+ " for " + to_string(tripKm) + " km";
			minimum = current_fuel_cost;
		}
	}
	cout << efficient << endl;
}


int main() {

	stack<ElectricTruck> stk;
	{
		ElectricTruck truck("TN01AB1234", "Viswa", 2024, 45000, 10.0, 5.0, 300.0, 400.0);
		stk.push(truck);

		cout << "Scope ends" << endl;

	}

	vector<Vehicle*> fleet;

	Vehicle* car = new Car("KL 55 V 1234", "Viswa", 2023, 20000, "Petrol", 20);
	Vehicle* truck = new Truck("TN 01 AB 1234", "Rahul", 2022, 35000, 10.0, 5.0);
	Vehicle* electricTruck = new ElectricTruck("KA 01 EV 5678", "Arun", 2024, 15000, 8.0, 4.0, 300.0, 400.0);
	Vehicle* van = new Van("MH 12 CD 9012", "Priya", 2021, 50000, 8, 15);
	Vehicle* car2 = new Car("DL 03 EF 3456", "Kiran", 2020, 60000, "Diesel", 18);

	fleet.push_back(car);
	fleet.push_back(truck);
	fleet.push_back(electricTruck);
	fleet.push_back(van);
	fleet.push_back(car2);

	printFleetReport(fleet, 500);

	return 0;
}
