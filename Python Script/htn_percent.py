# coding: utf-8

import os
from collections import defaultdict

__author__ = 'tianning.htn'

'''analysis the language percent in file'''

file_count = 0.0
res = defaultdict()
for path, dir, files in os.walk('./'):
    file_count += len(files)
    for file in files:
        suf = os.path.splitext(file)[1]
        res[suf] = res.setdefault(suf, 0) + 1

for k, v in res.iteritems():
    print k, '%.2f%%' % (round(v / file_count, 4) * 100)
