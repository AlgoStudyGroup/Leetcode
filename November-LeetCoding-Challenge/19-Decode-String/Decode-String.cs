using System.Collections.Generic;
using System;
using System.Text;

namespace _394_Decode_String
{
    public class Solution
    {
        public string DecodeString(string s)
        {
            var numStack = new Stack<int>();
            var resStack = new Stack<string>();
            resStack.Push("");

            var len = s.Length;

            for (int i = 0; i < len; i++)
            {
                var c = s[i];
                if (c >= '0' && c <= '9')
                {
                    int start = i;
                    while (s[i + 1] >= '0' && s[i + 1] <= '9') i++;
                    numStack.Push(int.Parse(s.Substring(start, i - start + 1)));
                }
                else if (c == '[')
                {
                    resStack.Push("");
                }
                else if (c == ']')
                {
                    string str = resStack.Pop();
                    var sb = new StringBuilder();
                    var times = numStack.Pop();
                    for (int b = 0; b < times; b++)
                    {
                        sb.Append (str);
                    }
                    resStack.Push(resStack.Pop() + sb.ToString());
                }
                else
                {
                    var curr = resStack.Pop();
                    resStack.Push(curr + c);
                }
            }
            return resStack.Pop();
        }
    }
}
