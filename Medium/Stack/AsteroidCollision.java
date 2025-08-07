package Medium.Stack;

import java.util.Stack;
import java.util.Arrays; // Add this import

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] asteroids = {5,10,-5};
        System.out.println(Arrays.toString(asteroidCollision(asteroids))); // Fix output
    }
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            boolean alive = true;

            while (alive && asteroids[i] < 0 && !st.isEmpty() && st.peek() > 0) {
                int top = st.peek();

                if (Math.abs(top) < Math.abs(asteroids[i])) {
                    st.pop();
                } else if (Math.abs(top) == Math.abs(asteroids[i])) {
                    st.pop();
                    alive = false;
                } else {
                    alive = false;
                }
            }

            if (alive) {
                st.push(asteroids[i]);
            }
        }

        int[] res = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            res[i] = st.pop();
        }
        return res;
    }
}
