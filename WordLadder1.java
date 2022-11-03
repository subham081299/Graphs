package Graphs;
//https://practice.geeksforgeeks.org/problems/word-ladder/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=word-ladder
/* QUESTION:
Given two distinct words startWord and targetWord, and a list denoting wordList of unique words of equal lengths. Find the length of the shortest transformation sequence from startWord to targetWord.
Keep the following conditions in mind:

A word can only consist of lowercase characters.
Only one letter can be changed in each transformation.
Each transformed word must exist in the wordList including the targetWord.
startWord may or may not be part of the wordList
The second part of this problem can be found here.

Note: If no possible way to transform sequence from startWord to targetWord return 0
 */
//SOLUTION:
import java.util.*;
public class WordLadder1 {
    public static void main(String[] args) {
        String[] wordList = {"des","der","dfr","dgt","dfs"};
        String startWord = "der", targetWord= "dfs";

        int number_of_ways =  wordLadderLength(startWord,targetWord,wordList);
        System.out.println(number_of_ways);
    }


    public static int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        Queue<Word_Step> q = new LinkedList<>();
        q.add(new Word_Step(startWord,1));
        Set<String> set = new HashSet<>();

        for (String word:wordList)
        {
            set.add(word);     //{"des","der","dfr","dgt","dfs"} gets added
        }
        set.remove(startWord); // "der" is removed

        while (!q.isEmpty())
        {
             String word = q.peek().word;//"der"
             int steps = q.poll().steps;//1

             if(word.equals(targetWord))return steps; // return when the word is equal to "dfs"
             for (int i = 0 ; i <word.length() ; i++)
             {
                 for (char c = 'a' ; c<='z' ; c++) //"aer" ..... "dfr"...
                 {
                     char newWord[] = word.toCharArray();
                     newWord[i] = c;
                     String replaced = new String(newWord);
                     if(set.contains(replaced)) // contains "dfr"
                     {
                         q.add(new Word_Step(replaced,steps+1)); // add "dfr" ,++steps
                         set.remove(replaced);//remove it
                     }

                 }
             }

        }
        return 0;
    }

}
class Word_Step
{
    String word ;
    int steps;
    public Word_Step(String word , int steps)
    {
        this.word = word;
        this.steps = steps;
    }
}
