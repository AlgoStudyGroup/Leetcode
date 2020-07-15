public class Solution
{
    //Pointer solution
    public string ReverseWords(string s)
    {
        var arr = s.ToCharArray();
        var start = 0;
        var end = arr.Length;
        reverse(arr, start, end - 1);

        reverseWords(arr, start, end);

        return cleanSpaces(arr, end);
    }

    private void reverse(char[] arr, int start, int end)
    {
        while (start < end)
        {
            var temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            end--;
            start++;
        }
    }

    private void reverseWords(char[] arr, int start, int end)
    {
        int b = 0, e = 0;
        while (b < end)
        {
            while (b < e || (b < end && arr[b] == ' ')) b++; //skip spaces
            while (e < b || (e < end && arr[e] != ' ')) e++; //skip non spaces
            reverse(arr, b, e - 1); //reverse the word
        }
    }

    private string cleanSpaces(char[] arr, int n)
    {
        int b = 0, e = 0;
        while (e < n)
        {
            while (e < n && arr[e] == ' ') e++;
            while (e < n && arr[e] != ' ') arr[b++] = arr[e++];
            while (e < n && arr[e] == ' ') e++;
            if (e < n) arr[b++] = ' ';
        }
        return new string(arr).Substring(0, b);
    }

    //Stack solution
    public string ReverseWords(string s)
    {
        var v = System.Text.RegularExpressions.Regex.Replace(s, " {2,}", " ");
        var arr = v.Trim().Split(" ").ToArray();
        var sb = new StringBuilder();
        var stack = new Stack<string>();
        for (int i = 0; i < arr.Length; i++)
        {
            stack.Push(arr[i]);
        }
        while (stack.Count > 0)
        {
            sb.Append(stack.Pop() + " ");
        }
        return sb.ToString().Trim();
    }
}