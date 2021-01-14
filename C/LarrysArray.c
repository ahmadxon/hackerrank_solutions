#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {
    int t;
    scanf("%d",&t);
    while(t--){
        int n,count=0;
        scanf("%d",&n);
        int a[n],i,j,k;
        for(i=0;i<n;i++){
            scanf("%d",&a[i]);
        }
        for(i=0;i+1<n;i++){
            for(j=i+1;j<n;j++){
                if(a[i]>a[j])
                    count++;
            }
        }
        if(count&1)
            printf("NO\n");
        else
            printf("YES\n");
    }
    return 0;
}