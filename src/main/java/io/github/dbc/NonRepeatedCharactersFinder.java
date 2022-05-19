package io.github.dbc;

import java.util.Arrays;

public class NonRepeatedCharactersFinder {
    private static final int EXTENDED_ASCII_CODES = 256;

    /**
     * Finds the non-repeated character in a string.
     *
     * @param string String to find non-repeated characters in.
     * @return the first non-repeated character in the string.
     */
    public char findFirstNonRepeatedCharacter(String string) {
        if (string == null)
            throw new IllegalArgumentException();
        boolean[] visited = new boolean[EXTENDED_ASCII_CODES];
        int[] arr = new int[EXTENDED_ASCII_CODES];
        Arrays.fill(arr, Integer.MAX_VALUE);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < string.length(); i++) {
            if (!visited[string.charAt(i)]) {
                arr[string.charAt(i)] = i;
                visited[string.charAt(i)] = true;
            } else {
                arr[string.charAt(i)] = Integer.MAX_VALUE;
            }

        }
        for (int i = 0; i < EXTENDED_ASCII_CODES; i++) {
            if (arr[i] != Integer.MAX_VALUE)
                min = Math.min(min, arr[i]);
        }
        if (min == Integer.MAX_VALUE)
            return Character.MIN_VALUE;
        else
            return string.charAt(min);
    }
}
