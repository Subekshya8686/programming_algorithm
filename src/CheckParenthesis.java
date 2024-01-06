public class CheckParenthesis {
    boolean checkBraces(String exp){
        String openbraces="[{(";
        String closebraces="]})";

        Stacks stk=new Stacks(exp.length());
        for(int i=0;i<exp.length();i++){
            char bracket=exp.charAt(i);
            if(openbraces.indexOf(bracket)>=0){
              //true for opening bracket
              stk.push(bracket);
            }
            else{
                //closing bracket
                int closingbrcktindx=closebraces.indexOf(bracket);
                char crossopenbracket=openbraces.charAt(closingbrcktindx);

                if(stk.pop()!=crossopenbracket){
                    return  false;
                }
            }
        }
        if(!stk.isEmpty()){
            return  false;
        }
        return true;
    }

    public static void main(String[] args) {
        CheckParenthesis c=new CheckParenthesis();
        System.out.println(c.checkBraces("{()"));
    }
}