package com.hashtable;

public class HashTableRemove {
    static class myMapNode {
        //Define key value pair for hashtable
        String key;
        int value;
        myMapNode Next;

        //declaring parameterized constructor
        myMapNode(String key, int value) {
            this.key = key;
            this.value = value;
            this.Next = null;
        }
    }

    myMapNode head = null;
    myMapNode tail = null;

    //adding to hash table thr linked list
    public void addToHashTable(String data, int occurrence) {
        myMapNode newNode = new myMapNode(data, occurrence);
        if (head == null) {
            head = newNode;
        } else {
            tail.Next = newNode;
            newNode.Next = null;
        }
        tail = newNode;
    }

    public void printHashTable() {
        myMapNode current = head;
        if (head == null) {
            System.out.println("HashTable is empty");
        } else {
            System.out.println("Occurrence of word in sentence");
            System.out.println("Key && Occurrence");
            while (current != null) {
                System.out.println(current.key + " " + current.value);
                current = current.Next;
            }
        }
    }

    public void removeFromHashTable(String keyValue) {

        myMapNode current = head;
        if (head == null) {
            System.out.println("Hash Table is empty");
        } else {
            myMapNode previous =null;
            while (current != null && !current.key.equalsIgnoreCase(keyValue)) {
                //store the value of current in previous
                previous = current;
                current = current.Next;
            }
            if (current == null) {
                throw new RuntimeException("The key with the given value is not found!");
            }
            previous.Next = current.Next;
        }
    }

    public static void main(String[] args) {
        HashTableRemove hashTableRemove = new HashTableRemove();
        //declaring the sentence
        String paragraph = "Paranoids are not paranoid because they are paranoid \n" +
                "but because they keep putting themselves deliberately into avoidable situations";

        //create hashtable
       createHashTable (paragraph, hashTableRemove);
        System.out.println("\nPrinting the original Hash Table below:");

        //printing hashtable
        System.out.println("\nPrinting the Hash Table");
        hashTableRemove.printHashTable();
        System.out.println();

        //deleting from hashtable
        hashTableRemove.removeFromHashTable("avoidable");
        System.out.println("Printing the hash table after removing the avoidable word from phrase");
        System.out.println();
        hashTableRemove.printHashTable();
    }
        public static void createHashTable (String sentence, HashTableRemove  hashTableRemove){
            //creating  the string array
            String[] words = sentence.toLowerCase().split(" ");

            int[] temp = new int[words.length];
            int visited = -1;
            for (int i = 0; i < words.length; i++) {
                int occurrence = 1;
                for (int j = i + 1; j < words.length; j++) {
                    if (words[i].equals(words[j])) {
                        occurrence++;
                        temp[j] = visited;
                    }
                }
                if (temp[i] != visited)
                    temp[i] = occurrence;
            }
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] != visited) {
                    hashTableRemove.addToHashTable(words[i], temp[i]);
                }
            }
        }
    }
