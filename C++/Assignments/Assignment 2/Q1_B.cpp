
#include<iostream>
using namespace std;


double reorderCost(int qty, double unitPrice) {
    return qty * unitPrice;
}        


double reorderCost(double qty, double unitPrice) {
    return qty * unitPrice;
}

double reorderCost(int qty, double unitPrice, double taxRate) {
    return (qty * unitPrice) + (qty * unitPrice) * taxRate;
}

double applyDiscount(double price, double discountPercent = 10.0) {
    return price - (price * discountPercent/100);
}

int main () {
    int quantity;
    double price;
    double taxRate;

    cout << "Enter integer quantity : "<< endl;
    cin >> quantity;
 
    double doubleQuantity;
    cout << "Enter fractional quantity : " << endl;
    cin >> doubleQuantity;
    
    cout << "Enter price : " << endl;
    cin >> price;

    cout << "Enter tax rate : " << endl;
    cin >> taxRate;
    
    cout <<"Cost : " << reorderCost(quantity, price) << endl;

    cout << "Cost : " << reorderCost(doubleQuantity, price)<< endl;

    cout << "Cost : "<< reorderCost(quantity, price, taxRate)<< endl;

    cout << "Discount : " << applyDiscount(price);

    return 0;

    
}