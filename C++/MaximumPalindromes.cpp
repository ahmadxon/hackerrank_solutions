#include <bits/stdc++.h>
#define int long long
using namespace std;
const int mod=1e9+7;
const int maxn=1e6+10;
void acc_ios()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
}
string s;
int sum[maxn][26];
int num[30];
int fac[maxn];
int fast_pow(int a,int b)
{
    int ans = 1;
    while(b)
    {
        if(b&1)
            ans = (ans*a)%mod;
        a=(a*a)%mod;
        b>>=1;
    }
    return ans;
}
signed main()
{
    acc_ios();
    cin>>s;
    fac[0]=1;
    for(int i=1; i<maxn; i++)
    {
        fac[i]=(fac[i-1]*i)%mod;
    }
    for(int i=0; i<s.size(); i++)
    {
        int w= s[i] -'a';
        sum[i+1][w]=1;
        for(int j=0; j<26; j++)
        {
            sum[i+1][j]+=sum[i][j];
        }
    }
    int q;
    cin>>q;
    while(q--)
    {
        int l,r;
        cin>>l>>r;
        for(int i=0; i<26; i++)
        {
            num[i] = sum[r][i]-sum[l-1][i];
        }
        int od=0,ev=0;
        int ano=1;
        for(int i=0; i<26; i++)
        {
            ev+=num[i]/2;
            od+=num[i]&1;
            if(num[i]/2>1)
                ano=(ano*fac[num[i]/2]%mod)%mod;
            ano%=mod;
        }
        ano=fast_pow(ano,mod-2);
        if(!od )
            od=1;
        cout<<(((fac[ev]*ano)%mod)*od%mod)%mod<<endl;
    }
    return 0;
}
 