class DVDPlayerTestDrive{// move up
    public static void main(String[] args){

        DVDPlayer d = new DVDPlayer();
        d.canRecord = true;
        d.playDVD();

        if (d.canRecord = true){
            d.recordDVD();
        }
    }
}


class DVDPlayer{

    boolean canRecord = false;

    void recordDVD(){
        System.out.println("идет запись DVD");
    }
    void playDVD(){//add method
        System.out.println("DVD проигрывается");
    }
}


