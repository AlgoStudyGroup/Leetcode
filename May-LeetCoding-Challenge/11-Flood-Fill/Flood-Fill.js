/**
 * @param {number[][]} image
 * @param {number} sr
 * @param {number} sc
 * @param {number} newColor
 * @return {number[][]}
 */
var floodFill = function(image, sr, sc, newColor) {
    if(newColor==image[sr][sc]){return image;}
    var color = image[sr][sc];
    dfs(image,new Array(sr,sc),color,newColor);
    return image;
};


var dfs = function(image,pos,color,newColor){
    var q = new Array(1);
    q[0] = pos;
    var m = pos[0];
    var n = pos[1];
    while(q.length>0){
        let p = q.shift();
        let a = p[0];
        let b = p[1];
        image[a][b]=newColor;
        if(a+1<image.length){
            if(image[a+1][b]==color){
                image[a+1][b]=newColor;
                q.push(new Array(a+1,b));
            }            
        }
        if(a-1>=0){
            if(image[a-1][b]==color){
                image[a-1][b]=newColor;
                q.push(new Array(a-1,b));
            }            
        }
        if(b+1<image[0].length){
            if(image[a][b+1]==color){
                image[a][b+1]=newColor;
                q.push(new Array(a,b+1));
            }            
        }
        if(b-1>=0){
            if(image[a][b-1]==color){
                image[a][b-1]=newColor;
                q.push(new Array(a,b-1));
            }            
        }
    }
};

