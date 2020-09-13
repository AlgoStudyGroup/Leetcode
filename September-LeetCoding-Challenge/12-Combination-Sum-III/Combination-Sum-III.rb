def combination_sum3(k, n)
    path = []
    res = []
    bt(k, n, 1, path, res)
    res
    
end

def bt(k, n, s, path, res)
    if k == 0
        if n == 0
            res << path.clone
            return
        end
    end
    
    s.upto(9) do |i|
        return if i > n
        path << i
        bt(k-1, n-i, i+1, path, res)
        path.pop
    end
end