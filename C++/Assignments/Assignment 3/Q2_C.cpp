#include <iostream>
#include <memory>
using namespace std;

class AudioClip {
    private:

    string name;
    double sound;

    public:
    AudioClip(string name, double sound) : name(name), sound(sound) {

    }

    string getName() {
        return name;
    }
};


int main() {
    auto audio = make_shared<AudioClip>("Explosion", 3.5);

    weak_ptr<AudioClip> observer = audio;
    
    auto clip  = observer.lock();

    if(clip) {
        cout << "Clip alive : " << clip->getName() << endl;
    }

    audio.reset();

    if(observer.expired()) { // False : Since clip is a shared_ptr
        cout << "Clip already unloaded" << endl;
    }

    return 0;
}