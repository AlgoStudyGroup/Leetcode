def pancake_sort(a)
    sorted_a = a.sort
    max = nil
    k = nil
    out = []
    while a != sorted_a 
      max = a.max
      if max != a.last
        max_index = a.index(max)
        if max_index != 0
          left = a[0..max_index]
          right = a[max_index+1..-1]
          left = left.reverse
          a = (left + right).reverse
          out << max_index+1
        else
          a = a.reverse
        end
        out << a.length

        a.pop
        sorted_a.pop
      else
        a.pop
        sorted_a.pop
      end
    end
    out
end