public class WordScrambler {

    private String[] scrambledWords;

    public WordScrambler(String[] wordArr) {

        scrambledWords = mixedWords(wordArr);

    }

    private String recombine(String word1, String word2) {
        int a = word1.length()/2;
        int b = word2.length()/2;
        String half1 = word1.substring(0,a);
        String half2 = word2.substring(b);
        String word = half1 + half2;
        return word;
    }

    private String[] mixedWords(String[] words) {
        if (words.length%2 != 0) {
            throw new IllegalArgumentException("Word Array must contain an even number of elements!");
        }
        String temp1;
        String temp2;
        for (int i = 0; i < words.length;i+=2) {
            if (words[i].indexOf(" ") > -1) {
                throw new IllegalArgumentException("Word Array must contain single words only! "+ words[i]+" contains more than one word!");
            } else if (words[i+1].indexOf(" ") > -1) {
                throw new IllegalArgumentException("Word Array must contain single words only! "+ words[i+1]+" contains more than one word!");

            }
            temp1 = recombine(words[i],words[i+1]);
            temp2 = recombine(words[i+1],words[i]);
            words[i] = temp1;
            words[i+1] = temp2;
        }
        return words;
    }
    public String[] getScrambledWords() {
        return scrambledWords;
    }
}