#include <iostream>
#include <string>
#include <algorithm>

int main() {
    std::string name;
    std::cout << "Enter your name: ";
    std::getline(std::cin, name);

    // Reverse the input string
    std::reverse(name.begin(), name.end());

    std::cout << "Your name backwards is: " << name << "!\n";

    return 0;
}
