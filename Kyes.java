import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Keys {
    public static void main(String[] args) {

        int[] ikeys = new int[]{

        KeyEvent.VK_D,
        KeyEvent.VK_E,
        KeyEvent.VK_B,
        KeyEvent.VK_U,
        KeyEvent.VK_G,
        KeyEvent.VK_ENTER,

        KeyEvent.VK_A,
        KeyEvent.VK_SPACE,
        KeyEvent.VK_1,
        KeyEvent.VK_0,
        KeyEvent.VK_0,
        KeyEvent.VK_ENTER,
        KeyEvent.VK_M,
        KeyEvent.VK_O,
        KeyEvent.VK_V,
        KeyEvent.VK_SPACE,
        KeyEvent.VK_A,
        KeyEvent.VK_H,
        KeyEvent.VK_COMMA,
        KeyEvent.VK_9,
        KeyEvent.VK_ENTER,

        KeyEvent.VK_M,
        KeyEvent.VK_O,
        KeyEvent.VK_V,
        KeyEvent.VK_SPACE,
        KeyEvent.VK_D,
        KeyEvent.VK_X,
        KeyEvent.VK_COMMA,
        KeyEvent.VK_1,
        KeyEvent.VK_0,
        KeyEvent.VK_D,
        KeyEvent.VK_ENTER,


        KeyEvent.VK_I,
        KeyEvent.VK_N,
        KeyEvent.VK_T,
        KeyEvent.VK_SPACE,
        KeyEvent.VK_2,
        KeyEvent.VK_1,
        KeyEvent.VK_ENTER,

        KeyEvent.VK_M,
        KeyEvent.VK_O,
        KeyEvent.VK_V,
        KeyEvent.VK_SPACE,
        KeyEvent.VK_A,
        KeyEvent.VK_H,
        KeyEvent.VK_COMMA,
        KeyEvent.VK_4,
        KeyEvent.VK_C,
        KeyEvent.VK_ENTER,


        KeyEvent.VK_M,
        KeyEvent.VK_O,
        KeyEvent.VK_V,
        KeyEvent.VK_SPACE,
        KeyEvent.VK_A,
        KeyEvent.VK_L,
        KeyEvent.VK_COMMA,
        KeyEvent.VK_0,
        KeyEvent.VK_ENTER,

        KeyEvent.VK_I,
        KeyEvent.VK_N,
        KeyEvent.VK_T,
        KeyEvent.VK_SPACE,
        KeyEvent.VK_2,
        KeyEvent.VK_1,
        KeyEvent.VK_ENTER,

        KeyEvent.VK_ENTER,


        KeyEvent.VK_E,
        KeyEvent.VK_SPACE,
        KeyEvent.VK_1,
        KeyEvent.VK_0,
        KeyEvent.VK_D,
        KeyEvent.VK_SPACE,

        KeyEvent.VK_SHIFT,
        KeyEvent.VK_QUOTE,
        KeyEvent.VK_H,
        KeyEvent.VK_E,
        KeyEvent.VK_L,
        KeyEvent.VK_L,
        KeyEvent.VK_O,
        KeyEvent.VK_SPACE,
        KeyEvent.VK_W,
        KeyEvent.VK_O,
        KeyEvent.VK_R,
        KeyEvent.VK_L,
        KeyEvent.VK_D,

        KeyEvent.VK_SHIFT,
        KeyEvent.VK_1,

        KeyEvent.VK_SHIFT,
        KeyEvent.VK_4,

        KeyEvent.VK_SHIFT,
        KeyEvent.VK_QUOTE,
        KeyEvent.VK_ENTER,


        KeyEvent.VK_R,
        KeyEvent.VK_SPACE,
        KeyEvent.VK_B,
        KeyEvent.VK_X,
        KeyEvent.VK_ENTER,
        KeyEvent.VK_0,
        KeyEvent.VK_ENTER,
        KeyEvent.VK_R,
        KeyEvent.VK_SPACE,
        KeyEvent.VK_C,
        KeyEvent.VK_X,
        KeyEvent.VK_ENTER,
        KeyEvent.VK_2,
        KeyEvent.VK_4,
        KeyEvent.VK_ENTER,


        KeyEvent.VK_N,
        KeyEvent.VK_SPACE,
        KeyEvent.VK_H,
        KeyEvent.VK_W,
        KeyEvent.VK_PERIOD ,
        KeyEvent.VK_C,
        KeyEvent.VK_O,
        KeyEvent.VK_M,
        KeyEvent.VK_ENTER,
        KeyEvent.VK_W,
        KeyEvent.VK_ENTER,
        KeyEvent.VK_Q,
        KeyEvent.VK_ENTER,
        KeyEvent.VK_H,
        KeyEvent.VK_W,
        KeyEvent.VK_PERIOD ,
        KeyEvent.VK_C,
        KeyEvent.VK_O,
        KeyEvent.VK_M,
        KeyEvent.VK_ENTER,
        };
        Robot r;
        try {
            r = new Robot();

            Thread.sleep(2000);


            for (int i = 0; i < ikeys.length; i++) {

                r.keyPress(ikeys[i]);
                if(ikeys[i]==KeyEvent.VK_SHIFT){
                    r.keyPress(ikeys[++i]);
                    r.keyRelease(KeyEvent.VK_SHIFT);
                }
                r.keyRelease(ikeys[i]);
                if (ikeys[i] == KeyEvent.VK_ENTER) {
                    Thread.sleep(500);
                } else {
                    Thread.sleep((int)(Math.random()*10)+100);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

