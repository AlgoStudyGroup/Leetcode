def compare_version(version1, version2)
    arr1 = version1.split(".")
    arr2 = version2.split(".")
    
    len = [arr1.length-1, arr2.length-1].max

    0.upto(len) do |n|
      if arr1[n].nil? && arr2[n].nil?
        return 0
      else
        a = arr1[n] || "0"
        b = arr2[n] || "0"
        if a.to_i > b.to_i
          return 1
        elsif a.to_i < b.to_i
          return -1
        else
          next
        end
      end
    end

end