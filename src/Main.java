
import ArraysAndStringsChapter.*;
import LinkedListChapter.*;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String [] args){
        //IsUnique isUnique = new IsUnique();
        //System.out.println(isUnique.isAllLettersUnique(isUnique.evaluateString));

        //CheckPermutations checkPermutations = new CheckPermutations();
        //System.out.println(checkPermutations.compare("ABDC","AC BDs"));

        //URLify urLify = new URLify();
        //System.out.println(urLify.getUrlFied("Allen Jimenez Gonzalez"));

        //PalindromePermutation palindromePermutation = new PalindromePermutation();
        //System.out.println(palindromePermutation.checkPalindrome("atco cta"));

        //OneAway oneAway = new OneAway();
        //System.out.println(oneAway.detectChanges("pale","bake"));

        //StringCompression stringCompression = new StringCompression();
        //System.out.println(stringCompression.getCompressedString("aabcccccaaa"));

        //RotateMatrix rotateMatrix = new RotateMatrix();
        //int [][] m = {{1,2,3},{4,5,6},{7,8,9}};
        //rotateMatrix.printMatrix(m);
        //System.out.println("");
        //rotateMatrix.printMatrix(rotateMatrix.rotateMatrix(m));


        //ZeroMatrix zeroMatrix = new ZeroMatrix();
        //int [][] m1 = {{0,2,3},{4,5,6},{7,8,9}};
        //zeroMatrix.getZeroMatrix(m1);

        //StringRotation stringRotation = new StringRotation();
        //System.out.println(stringRotation.isSubString("waterbottle","erbottlewat"));

        //RemoveDups removeDups = new RemoveDups();
        //removeDups.getListRemovedDups().forEach(System.out::println);

        KthToLast kthToLast = new KthToLast();
        CustomLinkedList cl = new CustomLinkedList();
        cl.add(3);
        cl.add(5);
        cl.add(8);
        cl.add(5);
        cl.add(10);
        cl.add(2);
        cl.add(1);

        //cl.root = kthToLast.getSubList(cl.root,3);
        //cl.printList();

        //-------
        //cl.printList();
        //cl.getDeletedMiddleList();
        //cl.printList();

        cl.printList();
        cl.root= cl.partition(4);
        cl.printList();
    }
}
