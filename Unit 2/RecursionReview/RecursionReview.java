public class RecursionReview {
    public static void main(String[] args){
        RecursionReview r = new RecursionReview();
        System.out.println(r.reverseWords("Hello World"));
        System.out.println(r.elfish("elfin"));
        System.out.println(r.xIsh("elf", "elfin"));
        System.out.println(r.multiply(5, 3));
    }

    public int multiply(int a, int b){
        if(b==0){
            return 0;
        }
        return a + multiply(a, b-1);
    }

    public String reverseWords(String str){
        int space = str.indexOf(" ");
        if(space == -1){
            return str;
        }
        String firstWord = str.substring(0, space);
        String rest = str.substring(space+1);
        return reverseWords(rest) + " " + firstWord;
    }
    
    public boolean elfish(String word){
        if(word.length() == 0){
            return false;
        }
        if(word.indexOf("e") != -1 && word.indexOf("l") != -1 && word.indexOf("f") != -1){
            return true;
        }
        return elfish(word.substring(1));
    }

    public boolean xIsh(String first, String second){
        if(first.length() == 0){
            return true;
        }
        char letter = first.charAt(0);
        if(second.indexOf(letter)==-1){
            return false;
        }
        return xIsh(first.substring(1), second);
    }
}
