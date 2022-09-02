package com.company;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String sentence = "KNVKOFJGKIGKMVZMKSKOAMXVTAVGKARIQFNAIGEFHXLKRIVFRXOFFRIMP\n" +
                          "CUIVFLRFANFGVKTAEFPKVIMVKAQKMEFHNAVIKMXKUGKMVZMKSJUQTNAIG\n" +
                          "VTFGUQTFNNAMGVTAVNAOAQVARIQFGIGMKVAVARRRIZFVTFVKMFKOVTINH\n" +
                          "FJAHZAMGVTKUPTVIVSKURGDFANSFRRVKIMVHKGUQFNKJFKVTFHNUDYFQV\n" +
                          "KOQKMEFHNAVIKMSTIRFNTFSANVHXIMPVKOIWKMKMFVTFQKKZVKKZVTFQA\n" +
                          "URGHKMKONKULKOOVTFOIHFAMGAVKMQFNFVVKSKHZVTHKSIMPFEFHXVTIM\n" +
                          "PSIVTIMTFHHFAQTAVVTFGUQTFNNAMGVTFDADXVTFOIHFIHKMNQAJFOIHN\n" +
                          "VVTFMOKRRKSFGANTKSFHKONAUQFLAMNLRAVFNAMGGINTFNVTFGUQTFNNV\n" +
                          "KKZMKMKVIQFKOVTFJFEFMSTFMVTFXTIVTFHAMGVTFDADXSANTKSRIMPNK\n" +
                          "JUQTARHFAGXVTAVIVSANCUIVFIJLKNNIDRFVKNAXSTFVTFHVTFDRKSNTU\n" +
                          "HVIVKHMKVKTLRFANFJIMGSTAVXKUHFGKIMPQHIFGARIQFYUJLIMPULAMG\n" +
                          "GKSMIMAMAPKMXKOVFHHK";
        
        Cal_Sentence(sentence);
        replaceWord(sentence);

    }
    public static void replaceWord(String sentence){
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        String new_sentence=null;
        String from;
        String to;
        System.out.println(sentence);
        while (flag) {
            System.out.print("\n" + "change char from: ");
            from= sc.nextLine();
            System.out.print("              to: ");
            to = sc.nextLine();
            new_sentence = sentence.replace(from,to);
            sentence = new_sentence;
            System.out.println(new_sentence);
        }
    }
    public static String Cal_Sentence(String sentence){

        //Make a map of all the characters you want to track.
        String indexes = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        //Initialize an array to the size of the possible matches.
        int[] count = new int[indexes.length()];

        //Loop through the sentence looking for matches.
        for (int i = 0; i < sentence.length(); i++) {
            //This will get the index in the array, if it's a character we are tracking
            int index = indexes.indexOf(sentence.charAt(i));

            //If it's not a character we are tracking, indexOf returns -1, so skip those.
            if (index < 0)
                continue;

            count[index]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] < 1)
                continue;

            System.out.println(String.format("%s (%d) %s",
                    indexes.charAt(i),
                    count[i],
                    //This little bit of magic creates a string of null bytes, then replaces it with asterisks.
                    new String(new char[count[i]]).replace('\0', '*')));
        }

        return indexes;
    }
}
