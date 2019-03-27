# tag: dp, two-pointer
# buttom-up fibonacci sequence

def fib1(n):
    assert n >= 0
    pre = 0
    cur = 1
    if(n==0 or n==1):
        return n
    for _ in range(1, n):
        res = pre + cur
        pre = cur
        cur = res
    return res

#print(fib1(12))

# dp with memo
def fib2(n):
    assert n >= 0
    res = []
    res.extend([0,1])
    for i in range(2, n+1):
        res.append(res[i-2]+res[i-1])
    return res[n]
print(fib2(8))
