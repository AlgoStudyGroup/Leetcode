def get_hint(secret, guess)
   new_guess = []
    new_secret = []
    count_a = 0
    count_b = 0
    
    guess.chars.to_a.each_with_index do |val, index|
        if val == secret[index]
            count_a += 1
        else
            new_guess << val
            new_secret << secret[index]
        end
    end
    
    new_guess.sort!
    new_secret.sort!
    while new_guess != [] && new_secret != []
        s = new_secret.pop
        g = new_guess.pop
        if s == g
            count_b += 1
        elsif s.to_i > g.to_i
            new_guess << g
        elsif s.to_i < g.to_i
            new_secret <<s
        end
    end
    count_a.to_s + "A" +  count_b.to_s + "B"
end