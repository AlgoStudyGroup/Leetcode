def partition_labels(s)
    last_indices = Array.new(26)
    s.each_char.with_index do |val, index|
       last_indices[val.ord - "a".ord] = index 
    end
    last_indices
    start = 0
    finish = 0
    out = []

    p last_indices
    0.upto((s.length)-1) do |n|
        val = s[n]
        finish = [finish, last_indices[val.ord - "a".ord]].max 
        if finish == n

          out << finish-start + 1
          start = finish  + 1
        end
    end
    out
end