#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the sherlockAndAnagrams function below.
def sherlockAndAnagrams(s):
    n = len(s)
    res = 0
    for l in range(1, n):
        cnt = {}
        for i in range(n - l + 1):
            subs = list(s[i:i + l])
            subs.sort()
            subs = ''.join(subs)
            if subs in cnt:
                cnt[subs] += 1
            else:
                cnt[subs] = 1
            res += cnt[subs] - 1
    return res

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    q = int(input())

    for q_itr in range(q):
        s = input()

        result = sherlockAndAnagrams(s)

        fptr.write(str(result) + '\n')

    fptr.close()
