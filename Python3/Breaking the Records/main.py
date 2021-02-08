#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the breakingRecords function below.
def breakingRecords(score):
    
    count_best_score = 0
    count_worth_score = 0
    max = scores[0]
    min = scores[0]
    
    for i in score[1:]:
        if i > max:
            count_best_score = count_best_score + 1
            max = i
        if i < min:
            count_worth_score = count_worth_score + 1
            min = i
    return count_best_score, count_worth_score
        
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    scores = list(map(int, input().rstrip().split()))

    result = breakingRecords(scores)

    fptr.write(' '.join(map(str, result)))
    fptr.write('\n')

    fptr.close()
