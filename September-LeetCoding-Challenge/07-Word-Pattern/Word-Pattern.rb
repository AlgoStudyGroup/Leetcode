def word_pattern(pattern, str)
    arr = str.split
    return false if pattern.length != arr.length
    l = pattern.length
    h = {}
    out = true
    0.upto(l-1) do |n|

        if h.key?(pattern[n])
            return out = false if h[pattern[n]] != arr[n]
        else
            return false if h.values.include?(arr[n])
            h.merge!(pattern[n] => arr[n])
        end
    end
    out
end