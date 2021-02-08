#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the almostSorted function below.
def almostSorted(arr):
    is_sorted = True
     
    low_idx = 0
    high_idx = len(arr)-1
     
    while (low_idx < high_idx and arr[low_idx] < arr[low_idx+1]):
        low_idx += 1
    
    if low_idx == high_idx:
        print("yes")
        return
 
    while (high_idx > 0 and arr[high_idx] > arr[high_idx-1]):
        high_idx -= 1
     
    if low_idx == 0 or arr[high_idx] > arr[low_idx -1]:
        if arr[high_idx] < arr[low_idx +1] or low_idx+1 == high_idx:
            if high_idx == len(arr)-1 or arr[low_idx] < arr[high_idx+1]:
                if arr[low_idx] > arr[high_idx -1] or low_idx == high_idx-1:
                    low_idx_runner = low_idx+1
                    while (low_idx_runner < high_idx and arr[low_idx_runner] < arr[low_idx_runner+1]):
                        low_idx_runner += 1
                    if low_idx_runner == high_idx-1 or low_idx == high_idx-1:   
                        print("yes")
                        print("swap", low_idx+1, high_idx+1)
                        return
     
    low_idx_runner = low_idx+1
    while (low_idx_runner < high_idx and arr[low_idx_runner] > arr[low_idx_runner+1]):
        low_idx_runner += 1
     
    if low_idx_runner == high_idx:
        if low_idx == 0 or arr[high_idx] > arr[low_idx -1]:
            if high_idx == len(arr)-1 or arr[low_idx] < arr[high_idx+1]:
                print("yes")
                print("reverse", low_idx+1, high_idx+1)
                return
     
    print("no")

if __name__ == '__main__':
    n = int(input())

    arr = list(map(int, input().rstrip().split()))

    almostSorted(arr)
