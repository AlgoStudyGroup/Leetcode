public class Solution {
    public int CompareVersion(string version1, string version2) {       
        var v1parts = version1.Split(".").ToList();
        var v2parts = version2.Split(".").ToList();
        
        if(v1parts.Count != v2parts.Count){
            while(v1parts.Count < v2parts.Count)
            {
                v1parts.Add("0");
            }
            while(v1parts.Count > v2parts.Count)
            {
                v2parts.Add("0");
            }
        }
        
        for(int i=0; i<v1parts.Count; i++){
            var v1 = int.Parse(v1parts[i]);
            var v2 = int.Parse(v2parts[i]);
            if(v1 > v2){
                return 1;
            }else if(v1 == v2){
                continue;
            }else if(v1 < v2){
                return -1;
            }
        }
        
        return 0;
    }
}