def comb_sum(candidates, target):
    def dfs(nums, target, idx, path, result):
        if target < 0:
            return
        if target == 0:
            result.append(path)
        for i in range(idx, len(nums)):
            dfs(nums, target - nums[i], i, path + [nums[i]], result)

    res = []
    candidates.sort()
    dfs(candidates, target, 0, [], res)
    return res

if __name__ == "__main__":
    can = [2, 3, 6, 7]
    target = 8
    print(comb_sum(can, target))