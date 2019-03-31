def decode(data):
    # memo: 0-len(data) -> len+1
    memo = [-1] * (len(data)+1) 
    return dp(data, len(data), memo)

# k 指的是包括的长度 idx是该子数组的起始位置
def dp(data, k, memo):
    if k==0:
        return 1
    idx = len(data)-k
    if data[idx]==0:
        return 0
    if memo[k] != -1:
        return memo[k]
    res = dp(data, k-1, memo)
    # >=10 没必要 因为k必然是大于0
    if k>=2 and (data[idx]*10+data[idx+1]) <= 26:   
        res += dp(data, k-2, memo)
    memo[k]=res
    return res

if __name__ == "__main__":
    data = [1,2,3,1,5]
    
    print(f"There are {decode(data)} ways to decode data")