import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int r = 0;
        int j = 0;
        for(int i =0 ; i < g.length; i++) {
            while(s[j] < g[i]) {
                j++;
            }
            r++;
            j++;
        }
        return r;
    }
}
