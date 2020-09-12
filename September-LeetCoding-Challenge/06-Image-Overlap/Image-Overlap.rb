def largest_overlap(a, b)

    # c'est une solution que je n'ai pas tout comprise
    # pk [max_overlaps, shift_count(x, y, a, b)].max  et [max_overlaps, shift_count(x, y, b, a)].max suffisent ??
    max_overlaps = 0
    
    len = a.length
    
    0.upto(len-1) do |y|
        0.upto(len-1) do |x|
            max_overlaps = [max_overlaps, shift_count(x, y, a, b)].max
            max_overlaps = [max_overlaps, shift_count(x, y, b, a)].max
        end
    end
    max_overlaps
    
end
        
        
        
def shift_count(x, y, m, r)
   len = m.length
   count = 0
   r_row = 0
    
    y.upto(len - 1) do |m_row|
       r_col = 0
        
            x.upto(len - 1) do |m_col|
                count += 1 if m[m_row][m_col] == 1 &&  m[m_row][m_col] == r[r_row][r_col]
                r_col += 1
            end
        
        r_row +=1
    end
    count
end