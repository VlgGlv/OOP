class MixFor5 {
    public static void main(String [] args) {
        int x = 0;
        int y = 30;
        for(int outer = 0; outer < 3; outer++) {
            for(int inner = 4; inner > 1; inner--) {
                // NONE
                y = y - 2;
                if (x == 6) {
                    x = x + 0;
                    break;
                }
                x = x + 3;
            }
            y = y -2;
        }
        System.out.println(x + " " + y);
    }
}


/*
x = x + 3
[27 6]

x = x + 6
[30 6]

x = x + 2
[26 6]

x++
[25 6]

x--
[23 6]

x = x + 0
[6 14]
*/
