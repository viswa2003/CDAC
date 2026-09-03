#include <iostream>
using namespace std;

class LogBuffer {
    private:

    char* buffer;
    int capacity;
    int size;
    
    mutable int accessCount = 0;

    static int instanceCount;
    
    
    public:

    // Constructor
    LogBuffer(int capacity) {
        this->capacity = capacity;
        size = 0;
        buffer = new char[capacity];
        
        instanceCount++;

        cout << "[LogBuffer Created] capacity= " << capacity << endl;
    };


    // Deep copy
    LogBuffer(const LogBuffer& other) {
        size = other.size;
        capacity = other.capacity;

        char* bufferCopy = new char[capacity];

        for(int i = 0; i < size; i++) {
            bufferCopy[i] = other.buffer[i];
        }
        buffer = bufferCopy;
        
        instanceCount++;
    }


    // Copy Assignment
    LogBuffer& operator=(const LogBuffer& other) {
        
        if(this != &other) {
            cout << "[LogBuffer Assigned]" << endl;

            delete[] buffer;

            capacity = other.capacity;
            size = other.size;
            buffer = new char[capacity];

            for(int i = 0; i < size; i++) {
                buffer[i] = other.buffer[i];
            }
            
        }
        return *this;

    }


    // Destructor
    ~LogBuffer() {
        delete[] buffer;

        instanceCount--;
    }


    void append(const char* msg) {
        int i = size;
        int j = 0;

        while(i < capacity && msg[j] != '\0') {
            buffer[i] = msg[j];
            i++;
            j++;
        }

        size = i;
    } 

    void print() const {
        for(int i = 0; i < size; i++) {
            cout << buffer[i] ;
        }
        cout << endl;
        accessCount++;
    }


    void clear() {
        size = 0;
    }

    static int getInstanceCount() {
        return instanceCount;
    }

    int getAccessCount() const {
        return accessCount;
    }

};

int LogBuffer::instanceCount = 0;


int main() {

// Objective 1 : Basic usage

LogBuffer log1(256);

log1.append("Server started on port 8080");
log1.append(" | Request received from 192.168.1.10");
log1.print();


// Objective 2 : Deep copy via copy constructor

// copy constructor
LogBuffer log2 = log1;

log2.append(" | Cached response sent");

cout << "log1 : "; log1.print(); // must NOT contain log2's append
cout << "log2 : "; log2.print();

// Objective 3 : Copy assignment operator

LogBuffer log3(128);
log3 = log1;                     
log3.print();
log1.print();

// copy assignment
// Objective 4 : Self-assignment guard
log1 = log1;    

// Objective 5 : Static member
cout << "Live LogBuffer objects : " << LogBuffer::getInstanceCount() << endl;

const LogBuffer log5(10);
log5.print();
log5.print();
log5.print();

cout << "Access Count : " << log5.getAccessCount() << endl;

return 0;
}