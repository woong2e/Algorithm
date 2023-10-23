#include <iostream>

using namespace std;

string reverseString(string s, int start, int end);

int main(){
    int numTestCase;
    cin >> numTestCase;
    for(int i = 0; i < numTestCase; i++){
        string s;
        cin >> s;
        cout << reverseString(s, 0, s.length() -1) << endl;
    }
}

string reverseString(string s, int start, int end){
    if(start >= end){
        return s;
    }
    swap(s[start], s[end]);
    return reverseString(s, start+1, end-1);
}
