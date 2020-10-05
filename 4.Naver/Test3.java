import java.util.*;
public class Test3 {

    public static String solution(String riddle) {


        char[] chs = riddle.toCharArray();

     
        for(int i = 0 ; i < chs.length ; i ++){
            // 첫 번째
            if(i == 0 &&  chs[i] == '?'){
                if(chs.length > 1 && chs[i+1] == '?'){
                    chs[i] = 'a';
                }else if (chs.length > 1 && chs[i+1] != '?'){
                    int tmp = 0;
                    if((char) (chs[i + 1] - 1) >=97){
                        chs[i] = (char) (chs[i + 1] - 1);
                    }else if ((char) (chs[i + 1] + 1) <=122){
                        chs[i] = (char) (chs[i + 1] + 1);
                    }
                  
                }
            }
            else if (i == chs.length-1 && chs[i] == '?'){
                System.out.println();
                if((char) (chs[i-1] - 1) >=97){
                    chs[i] = (char) (chs[i-1] - 1);
                }else if ((char) (chs[i-1] + 1) <=122){
                    chs[i] = (char) (chs[i-1] + 1);
                }

                
            }
            // 두번재 부터
            else if(chs[i] == '?'){
                // 앞만 물음표
                if(i+1<chs.length && chs[i+1] =='?'){
                   
                    if((char) (chs[i-1] - 1) >=97){
                        chs[i] = (char) (chs[i-1] - 1);
                    }else if ((char) (chs[i-1] + 1) <=122){
                        chs[i] = (char) (chs[i-1] + 1);
                    }
                }

                // 앞 뒤 비교 후 
                else if (i+1<chs.length && chs[i+1] !='?'){
                   int tmp =  (chs[i-1]) +  (chs[i+1]) /2;
                   chs[i] = (char) tmp;                    
                }

            }

           
        }

        String str = new String(chs);
        
        return str;
        
    }

    public static void main(String[] args) {
        System.out.println(solution("?????"));
    }
   

   
    
}
