#include <bits/stdc++.h>
using namespace std;

int main() {
    int T,n;
    cin >> T;
    for(int t = 0; t < T; t++){
        cin >> n;
        int ar[n],sum = 0;
        for(int i = 0; i < n; i++)cin >> ar[i];
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++)if(ar[j] < ar[i])sum += 1; 
        }
        (sum%2 == 0) ? cout << "YES" << endl : cout << "NO" << endl;
    }
    return 0;
}