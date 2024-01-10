// import javax.security.auth.callback.CallbackHandler;
import java.util.Stack;

public class InfixToPostfix {
    int perecedence(char ch){
        if(ch=='^'){
            return 3;
        }
        if(ch=='*' || ch=='/'){
            return 2;
        }
        if(ch=='+' || ch=='-'){
            return 1;
        }
       return -1;
    }

    String infixToPostfix(String exp){
    String result="";
        Stack<Character> stk=new Stack<>();
        for(int i=0;i<exp.length();i++){
            char ch=exp.charAt(i);
            if(perecedence(ch)>0){
                //operator
                while(!stk.isEmpty() && perecedence(ch)<=perecedence(stk.peek())){
                result=result+stk.pop();
                }

                    stk.push(ch);

            }

            else if(ch=='('){
                stk.push(ch);
            }
            else if(ch==')'){
              char x=stk.pop();
              while(x!='('){
                  result=result+x;
                  x=stk.pop();
              }
            }
            else{//ophrends
                result=result+ch;
                 }

        }
        while(!stk.isEmpty()){
            result=result+stk.pop();
        }
        return  result;
    }

    public static void main(String[] args) {
        InfixToPostfix o=new InfixToPostfix();
        System.out.println(o.infixToPostfix("5+(3*2)"));
    }
}
