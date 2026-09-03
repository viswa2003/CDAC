
#include<iostream>
#include<memory>
using namespace std;


class Shader{
    private:

    string name;
    string type;

    public:
    
    Shader(string name, string type) : name(name), type(type) {
        cout << "Shader compiled..." << endl;
    } 

    ~Shader() {
        cout << "Shader destroyed..." << endl;
    }

    // int getReferenceCount() {
    //     return use_count();
    // }
};

int main() {
 
    auto shader = std::make_shared<Shader>("main_vert", "vertex");
    cout << "Ref count : " << shader.use_count() << endl;
    
    {
        auto rendererRef = shader;
        cout << "Ref count : " << shader.use_count() << endl;

        auto editorRef = shader;
        cout << "Ref count : " << shader.use_count() << endl;
    }

    cout << "Ref count : " << shader.use_count() << endl;


    return 0;
}