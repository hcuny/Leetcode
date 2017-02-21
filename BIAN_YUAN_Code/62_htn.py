#!/usr/bin/env python
# -*- coding: utf-8 -*-
def uniquePath(small, large):
    cur = [1 for x in range(0, small)]
    i = 1
    j = 1
    while i < large:
        while j < small:
            cur[j] += cur[j - 1]
            j += 1
        i += 1
        j = 1
    return cur[small - 1]


print uniquePath(3, 3)
