
#include<iostream>
#include<utility>
#include<vector>
using namespace std;

using Header = pair<string, string>;
using HeaderList = vector<Header>;
using Port = unsigned int;
using IPAddress = string;

typedef unsigned long long RequestID;


void printHeaders(const HeaderList& headers) {
    for(Header val : headers) {
        cout << "   "<< val.first << " " << val.second << endl;
    }
}


int main() {

    Port servicePort = 8080;
    RequestID request = 1748293847;

    cout << "Request ID     :" << request << endl;
    cout << "Server Port    :" << servicePort << endl << endl;


    Header h1 = {"Content-Type      :", "application/json"};
    Header h2 = {"Authorization     :", "Bearer eyJhbGci..."};
    Header h3 = {"Accept-Language   :", "application/json"};
    
    cout << "Headers : " << endl;
    HeaderList headerArray = {h1, h2, h3};

    printHeaders(headerArray);

    return 0;
}
