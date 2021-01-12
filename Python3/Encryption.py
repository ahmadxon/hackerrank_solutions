#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the encryption function below.
def encryption(s):
    length = len(s)
    rows = int(math.floor(length**(0.5)))
    columns = int(math.ceil(length**(0.5)))
    result = ""
    for i in range(columns):
        k = i
        for j in range(k,length,columns):
            result+=s[j]
        result+=" "
    return result

    
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    result = encryption(s)

    fptr.write(result + '\n')

    fptr.close()