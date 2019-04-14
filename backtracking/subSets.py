# bit manipulation ver
# time complexity: O(n*2^n)

def subSets(nums):
    n = len(nums)
    size = 1 << n
    res = set()
    for i in range(size):
        res.add(tuple(num for j, num in enumerate(nums) if i & 1 << j))
    return res

if __name__ == "__main__":
    print(subSets([1, 2, 2]))