class TapeDeckTestDrive{ //move up main class
    public static void main(String[] args){
        TapeDeck t = new TapeDeck(); //add new object
        t.canRecord = true;
        t.playTape();
        if (t.canRecord == true){
            t.recordTape();
        }
    }
}


class TapeDeck{

    boolean canRecord = false;

    void playTape(){
        System.out.println("пленка проигрывактся");
    }

    void recordTape(){
        System.out.println("идет запись на пленку");
    }
}


