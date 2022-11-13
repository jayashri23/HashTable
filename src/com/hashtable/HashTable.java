package com.hashtable;

public class HashTable {

    static class myMapNode {
        //Define key value pair for hashtable
        String key;
        int value;
        FrequencyOfWords.myMapNode Next;

        //declaring parameterized constructor
        myMapNode(String key, int value) {
            this.key = key;
            this.value = value;
            this.Next = null;
        }
    }

    FrequencyOfWords.myMapNode head = null;
    FrequencyOfWords.myMapNode tail = null;

    //adding to hash table thr linked list
    public void addToHashTable(String data, int occurrence) {
        FrequencyOfWords.myMapNode newNode = new FrequencyOfWords.myMapNode(data, occurrence);
        if (head == null) {
            head = newNode;
        } else {
            tail.Next = newNode;
            newNode.Next = null;
        }
        tail = newNode;
    }

    //print hashtable
    public void printHashTable() {
        FrequencyOfWords.myMapNode current = head;
        if (head == null) {
            System.out.println("HashTable is empty");
            return;
        } else {
            System.out.println("Occurrence of word in sentence");
            System.out.println("Key && Occurrence");
            while (current != null) {
                System.out.println(current.key + " " + current.value);
                current = current.Next;
            }
        }
    }

    public static void main(String[] args) {
        FrequencyOfWords hashTable = new FrequencyOfWords();

        //declaring the sentence
        String paragraph = "Paranoids are not paranoid because they are paranoid \n" +
                "but because they keep putting themselves deliberately into avoidable situations";

        //create hashtable
        createHashTable(paragraph,hashTable);

        //printing hashtable
        System.out.println("\nPrinting the Hash Table");
        hashTable.printHashTable();
    }
    public static void createHashTable(String sentence ,FrequencyOfWords hashTable){
        //creating  the string array
        String [] words = sentence.toLowerCase().split(" ");

        int [] temp = new int [words.length];
        int visited =-1;
        for (int i =0; i< words.length ;i++){
            int occurrence =1;
            for (int j=i+1; j<words.length;j++){
                if(words[i].equals(words[j])){
                    occurrence++;
                    temp[j] =visited;
                }
            }
            if(temp[i] !=visited)
                temp[i] =occurrence;
        }
        for (int i=0;i<temp.length;i++){
            if(temp[i] !=visited){
                hashTable.addToHashTable(words[i],temp[i]);
            }
        }
    }
}

