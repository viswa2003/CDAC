
#include <iostream>
using namespace std;

class Entity{
    private:
    string name;
    int health;
    int level;
    string type;

    public:
    // Setters
    Entity& setName(const string& name) {
        this->name = name;
        return *this;
    }

    Entity& setHealth(int health) {
        this->health = health;
        return *this;
    }

    Entity& setLevel(int level) {
        this->level = level;
        return *this; 
    }

    Entity& setType(const string& type) {
        this->type = type;
        return *this;
    }


    // Getters
    string getName() const {
        return name;
    }

    int getHealth() const {
        return health;
    }

    int getLevel() const {
        return level;
    }

    string getType() const {
        return type;
    }

    void displayInfo() const {
        cout << "====== Entity Info ======" << endl;
        cout << "Name         : " << name << endl;
        cout << "Health       : " << health << endl;
        cout << "Level        : " << level << endl;
        cout << "Type         : " << type << endl << endl;

    }

};

// Namespace Physics
namespace Physics {
    
    double clamp(double val, double min, double max) {
        if(val < min)
            return min;
        else if (val > max) 
            return max;
        else 
            return val;
    }

    double lerp(double a, double b, double t) {
        return a + (b - a) * t;
    }
}

// Namespace Game Math
namespace GameMath {

    int clamp(int val, int min, int max) {
        if(val < min)
            return min;
        else if (val > max) 
            return max;
        else 
            return val;
    }
    
    double lerp(double a, double b, double t) {
        return a + (b - a) * t;
    }

}


int main() {
    Entity player;
    Entity enemy;
    Entity item;

    player.setName("Aragorn").setHealth(100).setLevel(10).setType("Player");
    enemy.setName("Orc").setHealth(60).setLevel(5).setType("Enemy");
    item.setName("Health Potion").setHealth(0).setLevel(1).setType("Item");

    player.displayInfo();
    enemy.displayInfo();
    item.displayInfo();


// Part B

    cout << "Physics clamp : " << Physics::clamp(10, 50, 100)<< endl;
    cout << "Game Math clamp : " << GameMath::clamp(120, 10, 100) << endl;

    cout << "Physics lerp : " << Physics::lerp(5, 10, 15) << endl;
    cout << "Game Math lerp : " << GameMath::lerp(5, 10, 15) << endl;

    {
        using namespace Physics;
        
        cout << "Physics namespace clamp : " << clamp(10, 50, 100)<< endl;
        cout << "Physics  namespace lerp : " << lerp(10, 50, 0.5)<< endl;

    }

    return 0;
}