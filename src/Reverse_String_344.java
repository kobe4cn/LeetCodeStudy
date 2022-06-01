//344. 反转字符串
public class Reverse_String_344 {
    public void reverseString(char[] s) {

        int length = s.length;
        if(length%2==0){
            int left=0;
            int right=length-1;
            while(left<right){
                char temp=s[left];
                s[left]=s[right];
                s[right]=temp;
                left++;
                right--;
            }
        }else{
            int left=0;
            int right=length-1;
            while(left!=right){
                char temp=s[left];
                s[left]=s[right];
                s[right]=temp;
                left++;
                right--;
            }
        }
    }


    public static void main(String[] args) {
        char[] s={'H','a','n','e','a','h'};
        new Reverse_String_344().reverseString(s);
    }

}
