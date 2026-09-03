
#include<iostream>
#include <memory>
using namespace std;

class Texture{
    private:

    string name;
    int width;
    int height;


    public:

    Texture (string name, int width, int height) : name(name), width(width), height(height) {
        cout << "Texture Loaded..." << endl;
    }

    ~Texture() {
        cout << "Texture released..." << endl;
    }

    void display() const {
        cout << name << "  : " << width << " x " << height << endl;
    }
};




int main() {

//Part A

    auto tex1 = std::make_unique<Texture>("Player_sprite", 512, 512);
    tex1->display();

    // unique_ptr<Texture> tex2 = tex1;
    // auto tex2 = tex1;

    // tex1 is a unique pointer. Therefore there can only be one owner and cannot be copied.

    auto tex3 = std::move(tex1);

    cout << "Is tex1 null : " << (tex1 == NULL ? "YES" : "NO" )<< endl;

    
    return 0;
}