
package pm;

import java.util.Iterator;
import java.util.TreeSet;

public class Ex6_Lotto2 {
    public Ex6_Lotto2() {
    }

    public void printLotto() {
        TreeSet ts = new TreeSet();

        do {
            int ran = (int)(Math.random() * 45.0D + 1.0D);
            ts.add(ran);
        } while(ts.size() < 6);

        Iterator it = ts.iterator();

        while(it.hasNext()) {
            int n = (Integer)it.next();
            System.out.printf("%-3d", n);
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Ex6_Lotto2 l = new Ex6_Lotto2();
        
        for(int i = 0; i < 5; ++i) {
            l.printLotto();
        }

    }
}
