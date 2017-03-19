package com.yifeng.BinarySearch;
/*
Example
Given "abcdefg".

offset=0 => "abcdefg"
offset=1 => "gabcdef"
offset=2 => "fgabcde"
offset=3 => "efgabcd"

三步翻转法;
*/
public class RotateString {
	public void reverse(char[] str,int start,int end){
        for(int i = start,j = end; i < j; i++,j--){
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            String s = "";
            
        }
    }
        
    public void rotateString(char[] str, int offset) {
        if(str == null || str.length == 0){
            return;
        }
        
        if(offset > str.length){
            offset = offset % str.length;
        }
        
        for(int i = 0; i < str.length - 1; i++){
            reverse(str,0,str.length - 1);
            reverse(str,0,offset - 1);
            reverse(str,offset,str.length - 1);
            return;
        }
    }
}
