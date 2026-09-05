//============================================================================
// Name        : Q3_B.cpp
// Author      : Viswa
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <stdexcept>
using namespace std;


template <typename T>
class DataBuffer {
private:
	T* data;
	int capacity;
	int head;
	int tail;
	int count;

public:

	DataBuffer(int capacity) : capacity(capacity), head(0), tail(0), count(0) {
		data = new T[capacity];
	}

	~DataBuffer() {
		delete[] data;
	}

	void push(const T& value) {
		data[tail] = value;
		tail = (tail + 1) % capacity;

		if(count == capacity) {
			head = (head + 1) % capacity;
		}
		else{
			count ++;
		}
	}

	T pop() {
		if(count != 0) {
			T popped = data[head];
			head = (head + 1) % capacity;
			count--;
			return popped;
		}
		else
		{
			throw underflow_error("Buffer Empty");
		}

	}

	T peek() const {
		if (count == 0) {
			throw underflow_error("Buffer Empty");
		}
		else
		{
			return data[head];
		}
	}

	bool isEmpty() const {
		return count == 0;
	}

	bool isFull() const {
		return capacity == count;
	}

	int size() const {
		return count;
	}

//	template <typename U>
	friend ostream& operator<<(ostream& out, const DataBuffer<T>& buf) {
		int index = buf.head;
		cout << "[ ";
		for(int i = 0; i < buf.count; i++) {
			out << buf.data[index] << " " ;
			index = (index + 1) % buf.capacity;
		}
		cout << "]";
		return out;
	}
};




int main() {

	// Integer buffer — simulate sensor tick IDs
	DataBuffer<int> tickBuffer(5);

	for (int i = 1; i <= 7; i++) tickBuffer.push(i * 10);  // Should overwrite oldest
	cout << "Tick Buffer: " << tickBuffer << endl;

	// Double buffer — simulate temperature readings
	DataBuffer<double> tempBuffer(4);

	tempBuffer.push(36.6); tempBuffer.push(37.1);
	tempBuffer.push(38.2); tempBuffer.push(36.9);

	cout << "Before pop: " << tempBuffer << endl;
	cout << "Popped: " << tempBuffer.pop() << endl;
	cout << "After pop:  " << tempBuffer << endl;

	// String buffer — simulate log message queue
	DataBuffer<string> logBuffer(3);

	logBuffer.push("INFO: Server started");
	logBuffer.push("WARN: High memory usage");
	logBuffer.push("ERROR: DB connection timeout");
	logBuffer.push("INFO: Retry successful");

	// Overwrites oldest
	cout << "Log Buffer: " << logBuffer << endl;

	return 0;
}
