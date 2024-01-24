package no.hvl.dat102.tidmaaling;

public class tidsmaaling {
    public static void main(String[] args) {
        Long k7 = 10_000_000L;
        Long k8 = 100_000_000L;
        Long k9 = 1_000_000_000L;
        long startTime = System.nanoTime();
        tid(k9);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println(duration/1000000 + " ms");
    }

    public static void tid(long n) {
        long k = 0;
        for (long i = 1; i <= n; i++) {
            k = k + 5;
        }
    }
}
