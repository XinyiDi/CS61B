package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE

        // Create needed lists to store results
        AList Ns = new AList();
        AList times = new AList();

        // add all Ns to Ns
        for (int i = 1000; i <= 128000; i = i * 2) {
            Ns.addLast(i);
        }

        for (int i = 0; i < Ns.size(); i += 1){
            // time the implementation
            Stopwatch sw = new Stopwatch();
            // addLast to construct an Alist
            AList L = new AList();
            int N = (int) Ns.get(i);
            for (int j = 0; j < N; j += 1) {
            L.addLast(j);
            }
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);

        }
        AList opCounts = Ns;
        printTimingTable(Ns, times, opCounts);

    }
}
