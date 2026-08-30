
#include<iostream>
using namespace std;

class Product{
    private:

    int productId;
    int quantity;
    double price;
    string name;

    public:

    void acceptDetails(int productId, int quantity, double price, string name){
        this->productId = productId;
        this->quantity = quantity;
        this->price = price;
        this->name = name;
    }

    double totalValue() const{
        return this->quantity * this->price;
    }

    bool isLowOnStock(int threshold) const {
        return (quantity < threshold);
    }

    void displayDetails(int threshold) const {
        double value = this->totalValue();
        string low = "";

        if(isLowOnStock(threshold) == 1)
            low = " <- LOW STOCK";

        cout << this->productId << "    " << this->name << "    " << this->price << "   " << this->quantity << "    " << value << low << endl;
    }

    void highValueProduct(Product arr[]) {
        int index = 0;

        for(int i = 0; i < 5; i ++) {
            if(arr[i].totalValue() > arr[index].totalValue()) {
                index = i;
            }
        }

        cout << arr[index].name <<"   (Rs." << arr[index].totalValue() << ")";
    }

    void lowStock(Product arr[], int threshold) const {
        for(int i = 0; i < 5; i++) {
            if(arr[i].quantity < threshold) {
                cout << arr[i].name << "  ";
            }
        }
    }
    
};


int main() {

    int productId;
    string name;
    double price;
    int quantity;
    int threshold;

    Product arr[5];

    cout << "Enter Product ID, name, price, quantity"<< endl;

    for(int i = 0; i < 5; i++) {
        cin >> productId >> name >> price >> quantity;
        arr[i].acceptDetails(productId, quantity, price, name);
    }

    cout << "Enter threshold : " << endl;
    cin >> threshold;


    cout << "================ INVENTORY REPORT ================" << endl;
    cout << "prod ID\tname\tprice\tqnty\ttotal value" <<endl;
    for(int i = 0; i < 5; i++) {
        arr[i].displayDetails(threshold);
    }

    
    cout << "Highest Value Product : " ;
    arr[0].highValueProduct(arr); 

    cout << "\nLow Stock ( threshold : " << threshold << ") : ";
    arr[0].lowStock(arr, threshold);

    return 0;
}