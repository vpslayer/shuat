def gen_Parenthesis(n):
    def dfs(res, s, left, right):
        if left == 0 and right == 0:
            res.append(s)
        if left > 0:
            dfs(res, s+"(", left-1, right)
        # left == right => 每次加入的左右括号数相等
        if right > 0 and left < right:
            dfs(res, s+")", left, right-1)
    
    res = []
    dfs(res, "", n, n)
    return res

if __name__ == "__main__":
    print(gen_Parenthesis(3))