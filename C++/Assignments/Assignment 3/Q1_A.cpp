

#include<iostream>
using namespace std;

enum class HttpStatus {
    Ok = 200, Created = 201, BadRequest = 400, Unauthorized = 401, NotFound = 404, ServerError = 500 
};

void handleResponse(HttpStatus status, const string& endpoint) {

    int result = static_cast<int>(status);
    switch (result) {
        case 200 : cout << "[ " << endpoint << " ]      -> " << result << " OK            : Request Successful" <<endl; 
                    break;
        case 201 : cout << "[ " << endpoint << " ]      -> " << result << " Created       : Created Successfully"<<endl; 
                    break;
        case 400 : cout << "[ " << endpoint << " ]      -> " << result << " Bad request   : Check again" <<endl; 
                    break;
        case 401 : cout << "[ " << endpoint << " ]      -> " << result << " Unauthorized  : Authentication Required"<<endl; 
                    break;
        case 404 : cout << "[ " << endpoint << " ]      -> " << result << " Not Found     : Endpoint doesnot exist" <<endl; 
                    break;
        default : cout <<  "[ " << endpoint << " ]      ->" << result << "  Server Error  : Internal server error - retry later" <<endl;
    }
}

int main() {
    int status1 = static_cast<int>(HttpStatus::Ok);
    int status2 = static_cast<int>(HttpStatus::Created);
    int status3 = static_cast<int>(HttpStatus::BadRequest);
    int status4 = static_cast<int>(HttpStatus::Unauthorized);
    int status5 = static_cast<int>(HttpStatus::NotFound);
    int status6 = static_cast<int>(HttpStatus::ServerError);

    handleResponse(HttpStatus::Ok, "GET /api/users");
    handleResponse(HttpStatus::Created, "POST /api/products/add_products");
    handleResponse(HttpStatus::BadRequest, "GET /api/get/users");
    handleResponse(HttpStatus::Unauthorized, "POST /api/login");
    handleResponse(HttpStatus::NotFound, "GET /api/products/99");
    handleResponse(HttpStatus::ServerError, "POST /api/order");

    return 0;

}