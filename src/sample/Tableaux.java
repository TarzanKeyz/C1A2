package sample;

/**
 * @author France Beaudoin
 */

public class Tableaux {
    private static void permute(int[] tab, int i1, int i2) {
        int transit = tab[i1];
        tab[i1] = tab[i2];
        tab[i2] = transit;
    }

    private static void permute(String[] tab, int i1, int i2) {
        String transit = tab[i1];
        tab[i1] = tab[i2];
        tab[i2] = transit;
    }

    public static void trierCroissantSSS(int[] tab) {
        int imin;
        for (int i = 0; i < tab.length - 1; i++) {
            imin = i;
            for (int j = i + 1; j < tab.length; j++) {
                if (tab[j] < tab[imin])
                    imin = j;
            }
            if (imin != i)
                permute(tab, i, imin);
        }
    }

    public static void trierCroissantSSS(String[] tab) {
        int imin;
        for (int i = 0; i < tab.length - 1; i++) {
            imin = i;
            for (int j = i + 1; j < tab.length; j++) {
                if (Integer.parseInt(tab[j]) < Integer.parseInt(tab[imin]))
                    imin = j;
            }
            if (imin != i)
                permute(tab, i, imin);
        }
    }

    public static void trierDecroissantSSS(String[] tab) {
        int imax;
        for (int i = 0; i < tab.length - 1; i++) {
            imax = i;
            for (int j = i + 1; j < tab.length; j++) {
                if (Integer.parseInt(tab[j]) > Integer.parseInt(tab[imax]))
                    imax = j;
            }
            if (imax != i)
                permute(tab, i, imax);
        }
    }


    public static void trierDecroissant(int[] tab) {
        int imax;
        for (int i = 0; i < tab.length - 1; i++) {
            imax = i;
            for (int j = i + 1; j < tab.length; j++) {
                if (tab[j] > tab[imax])
                    imax = j;
            }
            if (imax != i) {
                permute(tab, i, imax);
            }
        }
    }

    public static void print(int[] tab) {
        for (int i = 0; i < tab.length; i++) {
            System.out.println(tab[i]);
        }
    }

    public static void print(String[] tab) {
        for (int i = 0; i < tab.length; i++) {
            System.out.println(tab[i]);
        }
    }

    public static int maximum(int[] tab) {
        int max = tab[0];
        for (int i = 0; i < tab.length - 1; i++) {
            if (tab[i] > max)
                max = tab[i];
        }
        return max;
    }

    public static int minimum(int[] tab) {
        int min = tab[0];
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] < min)
                min = tab[i];
        }
        return min;
    }

    public static double moyenne(double[] tab) {
        double total = 0.0;
        double moyenne;

        for (int i = 0; i < tab.length; i++) {
            total = total + tab[i];
        }
        moyenne = total / tab.length;
        return moyenne;
    }

    public static int fouilleSeq(int[] tab, int cherche) {
        boolean trouve = false;
        int parcours = 0;

        while (parcours < tab.length && !trouve) {
            if (tab[parcours] == cherche)
                trouve = true;
            else
                parcours++;
        }
        if (trouve)
            return parcours;
        else
            return -1;

    }

    public static int maximum (String [] tabStr){
        int max = Integer.parseInt(tabStr[0]);

        for (int i=0; i<tabStr.length; i++){
            if (max < Integer.parseInt(tabStr[i]))
                max = Integer.parseInt(tabStr[i]);
        }
        return max;
    }

    public static int minimum (String [] tab){
        int min =  Integer.parseInt(tab[0]);

        for (int i=0; i<tab.length; i++){
            if (min > Integer.parseInt(tab [i]))
                min = Integer.parseInt(tab [i]);
        }
        return min;
    }

    public static double moyenne (String [] tab){
        double total = 0;
        double moyenne;

        for (int i=0; i<tab.length; i++){
            total += Double.parseDouble(tab[i]);
        }

        return moyenne = total / tab.length;
    }

    public static int fouilleSeq (String [] tab, String cherche){
        boolean trouve = false;
        int parcours = 0;

        while (parcours < tab.length && !trouve){
            if (tab [parcours].equals(cherche))
                trouve = true;
            else
                parcours ++;
        }
        if (trouve)
            return parcours;
        else
            return -1;
    }
}
