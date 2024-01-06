public class FindPermutation {

    void printPermutation(String str,String perm){
        if(perm.length()>1 && perm.charAt(1)!='B'){
            return;
        }
        if(str.isEmpty()){
            System.out.println(perm);
            return;
        }
        for(int i=0;i<str.length();i++){
            String newstr=str.substring(0,i)+str.substring(i+1);
            printPermutation(newstr,perm+str.charAt(i));
        }
    }

    public static void main(String[] args) {
        String s1="ABC";
        FindPermutation f=new FindPermutation();
        f.printPermutation(s1,"");
    }

}
