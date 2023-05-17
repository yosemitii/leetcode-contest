package javasrc.contest.weekly336;

import java.util.HashSet;

/*
 * @Created 05/17/2023
 * @Author sun
 * @Info: 6315. Count the Number of Vowel Strings in Range
 * https://leetcode.com/contest/weekly-contest-336/problems/count-the-number-of-vowel-strings-in-range/
 */
public class NumberVowelStrings {



    HashSet<Character> v = new HashSet<>();
    public int vowelStrings(String[] words, int left, int right) {
        v.add('a');
        v.add('e');
        v.add('i');
        v.add('o');
        v.add('u');
        int cnt = 0;
        for (int i = left; i <= right; i++) {
            if (v.contains(words[i].charAt(0)) && v.contains(words[i].charAt(words[i].length()-1))){
                cnt++;
            }
        }
        return cnt;
    }


}
