class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        counts = {}

        for i in nums:
            counts[i] = counts.get(i, 0) + 1
        
        return max(counts, key = counts.get)

        