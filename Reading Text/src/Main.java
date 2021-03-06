import java.io.*;

import java.util.ArrayList;

public class Main {
    static void searchingWord(String fileName, String keyWord) throws IOException {
        //Copy each sentence to the ArrayList
        ArrayList<String> sentences = new ArrayList<>();
        ArrayList<String> lines = new ArrayList<>();
        FileReader fr = new FileReader("ProgrammingHistory");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }
        int pos = 0;
        int posEG = 0;
        for (int i = 0; i < lines.size(); i++) {
            String l = lines.get(i);
            if (l.indexOf("e.g.") != -1) {
                posEG = l.indexOf("e.g.");
                for (int k = posEG + 4; k < l.length(); k++) {
                    if (l.substring(k, k + 1).equals(".")) {
                        sentences.add(l.substring(pos, k + 1));
                        pos = k + 1;
                    }
                }
            }
            else{
                for (int k = 0; k<l.length(); k++){
                    if (l.substring(k, k + 1).equals(".")) {
                        sentences.add(l.substring(pos,k + 1));
                        pos = k + 1;
                    }

                }
            }
            pos =0;
        }
        fr.close();
        br.close();
        //Looping through sentences in the ArrayList to search for "word" and return the index position of the sentence containing that word
        for (String s: sentences){
            if (s.contains(keyWord)){
                System.out.println("The word is in sentence number: "+ sentences.indexOf(s));
            }

            String[] words = s.split("\\s+|\\W+");
            for (int i =0; i<words.length;i++){
                if (words[i].equals(keyWord)){
                    System.out.println("Position of the word in the sentence: "+i);
                    System.out.println("--------------------------------------");
                }
            }

        }
    }



    public static void main(String[] args) throws IOException {
        searchingWord("ProgrammingHistory","However");
    }
}
