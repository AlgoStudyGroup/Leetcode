def largest_time_from_digits(a)
    out = a.permutation.to_a.map {|e| e.join("").to_i}.sort.select{|elt| elt < 2359 && elt.to_s[-2..-1] .to_i < 60}.last

    return "" if out == nil
    out.to_s.rjust(4, '0').insert(2, ":")
end