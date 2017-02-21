#!/usr/bin/env python
# -*- coding: utf-8 -*-

'边界检测'
# def rangeCheck(length, fromIndex, toIndex):
#     if fromIndex > toIndex:
#         except ValueError, e:
#         print("fromIndex(" + fromIndex + ") > toIndex(" + toIndex + ")")
#     if fromIndex < 0:
#         except IndexError, e:
#         print('fromIndex < 0 ')
#     if toIndex > length:
#         except IndexError, e:
#         print('toIndex > %s ' % length)

'二分查找'


def binarySearch0(a, fromIndex, toIndex, key):
    low = fromIndex
    high = toIndex - 1
    while low <= high:
        mid = (low + high) >> 1
        midVal = a[mid]
        if key > midVal:
            low = mid + 1
        elif key < midVal:
            high = mid - 1
        else:
            return mid  # key found
    return -(low + 1)  # key not found


def binarySearch(bytes, fromIndex, toIndex, key):
    # rangeCheck(bytes.length, fromIndex, toIndex)
    return binarySearch0(bytes, fromIndex, toIndex, key)


def longestUpSub(nums):
    dp = [0 for x in nums]
    len = 0
    for x in nums:
        i = binarySearch(dp, 0, len, x)
        if i < 0:
            i = -(1 + i)
            dp[i] = x
            if len == i:
                len += 1
    return len


print longestUpSub([3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12])
