# 624. Remove Substrings [LintCode]

Given a stringsand a set of nsubstrings. You are supposed to remove every instance of those n substrings from s so that s is of the minimum length and output this minimum length.

Example

Given s =ccdaabcdbb, substrs =["ab", "cd"]

Return2

Explanation:

ccdaabcdbb->ccdacdbb->cabb->cb(length = 2)

宽度优先搜索Queue + HashSet去重，对于每一层（放进queue的每一个长度的）的String，用尽dictionary中的每一个substring；对于每一个substring，从当前String中的每一个可能的start index中尽可能搜索到。查找当前String中是否存在substring的方法：

str.indexOf(String sub, int fromIndex)
