def repeated_substring_pattern(s)
    out = false
    length = s.length / 2 
    0.upto(length) do |n|
        out =  is_repeated_sub?(s[0..n], s)
        return out if out == true
    end
    out
    
end

def is_repeated_sub?(sub, string)
    modulo = string.length % sub.length
    return false if modulo != 0
    multiplicator = string.length / sub.length 
    return false if multiplicator <= 1
    return (sub * multiplicator) == string
end