//============================================================================
// Name        : Q3.cpp
// Author      : Viswa
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <vector>
#include<climits>
#include <cctype>

using namespace std;

class DataProcessor {
public:
	virtual void loadData(const string& source) = 0;

	virtual void processData() = 0;

	virtual void exportResult(const string& destination) = 0;

	virtual string processorType() const = 0;

	virtual int recordCount() const = 0;


	virtual void printSummary() const {}


	virtual ~DataProcessor() {}
};

class CSVProcessor : public DataProcessor {
public:
	vector<string> records;

	void loadData(const string& source) {

		records.push_back("Viswa");
		records.push_back("Abharnna");
		records.push_back("Anu");
		records.push_back("Aditya");
		records.push_back("Abhi");
	}

	void processData() {
		for(auto& record : records) {
			for(char& ch : record) {
				ch = toupper(ch);
			}
		}
	}

	void exportResult(const string& destination) {
		cout << "[CSV EXPORT -> " << destination << "]" << endl;

		for(auto record : records) {
			cout << record << endl;
		}
	}

	string processorType() const {
		return "CSV Processor";
	}

	int recordCount() const {
		return records.size();
	}

	virtual void printSummary() const {
		cout << processorType() << endl;
		cout << recordCount() << endl;
	}
};

class SensorStreamProcessor : public DataProcessor {
public:
	vector<double> readings;

	void loadData(const string& source) {
		readings.push_back(10.6);
		readings.push_back(55.3);
		readings.push_back(34.06);
		readings.push_back(22.88);
		readings.push_back(20.4);
	}

	void processData() {
		double min = INT_MAX, max = INT_MIN;
		double sum = 0;

		for(auto& read : readings) {
			if(read < min) {
				min = read;
			}
			if(read > max) {
				max = read;
			}
			sum += read;
		}
		double mean = sum / readings.size();

		cout << "Minimum : " << min << "  Maximum : " << max << " Mean: " << mean << endl;
	}

	void exportResult(const string& destination) {
		cout << "[CSV EXPORT -> " << destination << "]" << endl;

	}
	string processorType() const {
			return "Sensor Stream Processing";
		}

	int recordCount() const {
		return readings.size();
	}

	double getMean() {
		double sum = 0;
		for(auto& read : readings) {
			sum += read;
		}
		return sum / readings.size();
	}

};

int main() {
	vector<DataProcessor*> pipeline;

	pipeline.push_back(new CSVProcessor());
	pipeline.push_back(new SensorStreamProcessor());

	for (auto* p : pipeline) {
		p->loadData("source_data");
		p->processData();
		p->printSummary();
		p->exportResult("output_dir");

		cout << "---" << endl;
	}

	for (auto* p : pipeline) {
		if (auto* csv = dynamic_cast<CSVProcessor*>(p)) {
			cout << "Found CSV Processor with " << csv->recordCount() << " records."
			<< endl;
		} else if (auto* sensor = dynamic_cast<SensorStreamProcessor*>(p)) {
			cout << "Found Sensor Processor — Mean: " << sensor->getMean() << endl;
		}
	}

	return 0;
}
