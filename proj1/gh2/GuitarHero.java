package gh2;
import deque.ArrayDeque;
import deque.Deque;
import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

public class GuitarHero {
    //public static final double CONCERT_A = 440.0;
    //public static final double CONCERT_C = CONCERT_A * Math.pow(2, 3.0 / 12.0);

    public static void main(String[] args) {
        /* create two guitar strings, for concert A and C */

        Deque<GuitarString> stringDeque = new ArrayDeque<>();
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

        // fill stringDeque with the correct GuitarStrings
        for (int i = 0; i<keyboard.length(); i ++){
            Double freq = 440 * Math.pow(2, (i - 24)/12);
            GuitarString gs = new GuitarString(freq);
            stringDeque.addLast(gs);
        }

        while (true) {
            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                if (keyboard.contains(String.valueOf(key))) {
                    int key_idx = keyboard.indexOf(key);
                    GuitarString string = stringDeque.get(key_idx);
                    string.pluck();
                }

            double sample = 0;
            for (int i = 0; i < stringDeque.size(); i++) {
                GuitarString sub = stringDeque.get(i);
                sample += sub.sample();
            }
            /* play the sample on standard audio */
            StdAudio.play(sample);

            for (int i = 0; i < stringDeque.size(); i++) {
                GuitarString sub = stringDeque.get(i);
                sub.tic();

            }



    }}}}

