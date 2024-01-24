import java.sql.SQLOutput;


 class downloadImages{
public synchronized  void downloadImage(String image, int size){
    for(int i=0;i<=size;i++){
        System.out.println("downloading cat image "+image+i+".jpg");
    }
}
}
class mythread extends  Thread {
    downloadImages dref;
    mythread(downloadImages dref){
        this.dref=dref;
    }
@Override
    public void run(){
       dref.downloadImage("cat",10);
}

}

class yourthread extends  Thread {
    downloadImages dref;
    yourthread(downloadImages dref){
        this.dref=dref;
    }
    @Override
    public void run(){
        dref.downloadImage("dog",10);
    }

}

public class ThreadExample {


    public static void main(String[] args) {
        System.out.println("application started");
        downloadImages dref=new downloadImages();
        mythread t1=new mythread(dref);
        yourthread t2=new yourthread(dref);
        t1.start();
//        try {
//          t1.join();
//        }
//        catch (Exception ee){ee.printStackTrace();}
        t2.start();

        System.out.println("application close");
    }
}
