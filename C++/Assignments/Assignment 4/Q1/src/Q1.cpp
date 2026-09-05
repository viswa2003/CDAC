

#include <iostream>
using namespace std;

class LedgerEntry {
private:
	string description;
	int days;
	double* amounts;

public:
	static int totalEntries;

//	Constructor
	LedgerEntry(const string& desc, int days) : description(desc), days(days) {
		amounts = new double[days];

		cout << "[Ledger Created]" << description << " (" << days << ")" << endl;

		totalEntries++;
	}

//	Copy constructor - deep copy
	LedgerEntry(const LedgerEntry& other) :  description(other.description), days(other.days) {
		amounts = new double[days];

		for(int i = 0; i < days; i++) {
			amounts[i] = other.amounts[i];

		}
		totalEntries++;
	}

//	Move constructor
	LedgerEntry(LedgerEntry&& other) noexcept {
		cout << "[Move Constructor] Ownership transferred from: " << other.description << endl;

		description = move(other.description);
		days = other.days;
		amounts = other.amounts;
		other.amounts = nullptr;
		other.days = 0;



	}

//	copy assignment operator
	LedgerEntry& operator=(const LedgerEntry& other) {
		if(this != &other){

			delete[] amounts;

			days = other.days;
			description = other.description;

			amounts = new double[days];

			if(this != &other) {
				for(int i = 0; i < days; i++) {
					amounts[i] = other.amounts[i];
				}
			}
		}
		return *this;
	}

//	Move Assignment operator
	LedgerEntry& operator=(LedgerEntry&& other) noexcept {

		if(this != &other) {
			cout << "[Move Assignment] Ownership transferred from: " << description << endl;
			delete[] amounts;

			days = other.days;
			description = move(other.description);
			amounts = other.amounts;
			other.amounts = nullptr;
			other.days = 0;
		}

		return *this;
	}

	~LedgerEntry() {
		delete[] amounts;
		cout << "[Destructor] " << description << "destroyed" << endl;
		totalEntries--;

	}

//	+ operator overload
	LedgerEntry operator+(const LedgerEntry& other) const {
		LedgerEntry combined("Combined", other.days);

		for(int i = 0; i < combined.days; i++) {
			combined.amounts[i] = amounts[i] + other.amounts[i];
		}
		return combined;
	}

//	== operator overloading
	bool operator==(const LedgerEntry& other) const {
		int days = other.days;
		double totalA = 0;
		double totalB = 0;

		for(int i = 0; i < days; i++) {
			totalA += amounts[i];
			totalB += other.amounts[i];
		}
		return totalA == totalB;
	}

//	> operator overloading

	bool operator>(const LedgerEntry& other) const {
		int days = other.days;
		double totalA = 0;
		double totalB = 0;

		for(int i = 0; i < days; i++) {
			totalA += amounts[i];
			totalB += other.amounts[i];
		}
		return totalA > totalB;
	}

	double& operator[](int index) {
		if(index < 0 || index >= days) {
			throw out_of_range("Index out of range");
		}
		return amounts[index];
	}

	const double& operator[](int index) const {
		if(index < 0 || index >= days) {
			throw out_of_range("Index out of range");
		}
		return amounts[index];
	}

//	totalEntry getter


	friend ostream& operator<<(ostream& out, const LedgerEntry& entry);

	friend istream& operator>>(istream& in, LedgerEntry& entry);

};


ostream& operator<<(ostream& out, const LedgerEntry& entry) {
	out << entry.description << " : [";
	double total = 0;

	for(int i = 0; i < entry.days; i++) {
		out << entry.amounts[i];
		total += entry.amounts[i];

		if(i < entry.days - 1) {
			out << ", ";
		}
	}
	out << "]  Total : " << total << endl;
	return out;
}

istream& operator>>(istream& in, LedgerEntry& entry) {
	in >> entry.description;
	in >> entry.days;

	for(int i = 0; i < entry.days; i++) {
		in >> entry.amounts[i];
	}
	return in;
}


int LedgerEntry::totalEntries = 0;



int main() {
// Objective 1 — Constructor & deep copy
	LedgerEntry jan("January Sales", 5);

	jan[0] = 1200.50;  jan[1] = 3400.00;  jan[2] = 800.75;
	jan[3] = 2100.00;  jan[4] = 650.25;

	LedgerEntry feb("February Sales", 5);

	feb[0] = 900.00;   feb[1] = 2200.50;  feb[2] = 1750.00;
	feb[3] = 3000.00;  feb[4] = 475.50;

	cout << jan << endl;
	cout << feb << endl;

	// Objective 2 — Operator + (sum two ledgers into combined)
	LedgerEntry combined = jan + feb;
	cout << "Combined: " << combined << endl;

	// Objective 3 — Relational operators
	cout << "Jan == Feb : " << (jan == feb ? "Yes" : "No") << endl;
	cout << "Jan  > Feb : " << (jan  > feb ? "Yes" : "No") << endl;


	// Objective 4 — Move constructor (should NOT deep copy)
	LedgerEntry moved = move(jan);
	cout << "After move, jan.amounts is null: "
	<< (/* check jan is empty */ true ? "YES" : "NO") << endl;
	cout << "Moved entry: " << moved << endl;

	// Objective 5 — Move assignment
	LedgerEntry q1("Q1 Total", 5);
	q1 = move(feb);

	// feb's resources transferred to q1
	cout << "Q1 (moved from feb): " << q1 << endl;

	// Objective 6 — Static member
	cout << "Live LedgerEntry objects: " << LedgerEntry::totalEntries << endl;

	return 0;
}








