public class GC{
    public static GC doStaff(){
        GC newGC = new GC();
        doStaff2(newGC);

         return newGC;
    }

    public static void main(String[] args){
        GC gc1;
        GC gc2 = new GC();
        GC gc3 = new GC();
        GC gc4 = gc3;
        gc1 = doStaff();
        gc2 = null;
    }

    public static void doStaff2(GC copyGC){
        GC localGC;
    }
}

