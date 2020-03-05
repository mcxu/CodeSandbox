'''
Longest Increasing Subsequence

Given array of ints, find the longest subsequence that has all values in increasing order.

Examples:
Input  : arr[] = {3, 10, 2, 1, 20}
Output : Length of LIS = 3
The longest increasing subsequence is 3, 10, 20

Input  : arr[] = {3, 2}
Output : Length of LIS = 1
The longest increasing subsequences are {3} and {2}

Input : arr[] = {50, 3, 10, 7, 40, 80}
Output : Length of LIS = 4
The longest increasing subsequence is {3, 7, 40, 80}

https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
'''

class Prob:
    '''
    n: number of values in array
    Time complexity: O(n^2), since there is a nested for loop going from [0,i] of the outer for loop.
    Space complexity: O(n) since longestUpToVal stores at most n elements.
    '''
    @staticmethod
    def longestIncreasingSubsequence(array):
        # stores the length of the longest increasing subsequence up to a val corresponding to index.
        # Init to all 1 because the longest increasing subsequence of a val by itself is 1.
        longestUpToVal = [1 for _ in array] 
        
        for i in range(len(array)):
            iVal = array[i]
            
            for j in range(0, i):
                jVal = array[j]
                
                if jVal < iVal:
                    longestUpToVal[i] = max(longestUpToVal[j]+1, longestUpToVal[i])
                    print("longestUpToVal: ", longestUpToVal)
        
        return max(longestUpToVal)
    
    @staticmethod
    def test1():
        array = [3, 10, 2, 1, 20]
        #array = [3,2]
        #array = [50, 3, 10, 7, 40, 80]
        #array = [10, 22, 9, 33, 21, 50, 41, 60, 80]
        ans = Prob.longestIncreasingSubsequence(array)
        print("ans: ", ans)
        
Prob.test1()
                