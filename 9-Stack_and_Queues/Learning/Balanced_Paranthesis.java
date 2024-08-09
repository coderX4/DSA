package Learning;
import java.util.*;
public class Balanced_Paranthesis {
    public static boolean Balanced(String inputstr){
        char[] c = inputstr.toCharArray();
        Stack1 st = new Stack1();
        for(char i = 0; i< c.length;i++){
            char curr = c[i];
            if(curr == '(' || curr == '{' || curr == '['){
                st.Push(curr);
            }
            else{
                if(st.Size() == 0){
                    return false;
                }
                char c1 = st.Pop();
                if((c1 == '(' && curr == ')') ||(c1 == '{' && curr == '}')
                ||(c1 == '[' && curr == ']')){
                    continue;
                }
                return false;
            }
        }
        if(st.Size() == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "{[({})]";
        boolean res = Balanced(s);
        if(res){
            System.out.println("Balanced");
        }
        else{
            System.out.println("Not Balanced");
        }

    }
}

class Stack1{

    public char[] arr = new char[1000];
    public int top = -1;
    public void Push(char data){
        top = top + 1;
        arr[top] = data;
    }

    public char Pop(){
        char x = arr[top];
        top = top - 1;
        return x;
    }

    public char Peek(){
        if(top != -1){
            return arr[top];
        }
        return arr[top];
    }

    public int Size(){
        return top + 1;
    }
}
