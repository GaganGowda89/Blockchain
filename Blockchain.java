
package com.deere.democlient.Hyservapis;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author gowda
 */
public class Blockchain {

    private int previousHash;
    private String[] transactions;
    
    private int blockhash;
    
        public Blockchain(int previousHash, String[] transactions) {
            this.previousHash = previousHash;
            this.transactions = transactions;
        
            Object[] contentTransaction = {Arrays.hashCode(transactions), previousHash};
            this.blockhash = Arrays.hashCode(contentTransaction);
    }
    
    public int getPreviousHash() {
        return previousHash;
    }

    public String[] getTransactions() {
        return transactions;
    }

    public int getBlockhash() {
        return blockhash;
    }    
        
    public static void main(String args[]){
        
        ArrayList<Blockchain> block = new ArrayList<>();
        
        //Create the first block 
        String[] firstBlockTransaction = {"Sending Money to Alex","Bitcoin: 5 "};
        Blockchain firstBlock = new Blockchain(0,firstBlockTransaction);
        
        //Create the Second block 
        String[] secondBlockTransaction = {"Sending Money to Ben","Bitcoin: 10 "};
        Blockchain secondBlock = new Blockchain(firstBlock.getBlockhash(),secondBlockTransaction);
        

        System.out.println("The first block Hash is: "+firstBlock.blockhash);
        System.out.println("The second block Hash is: "+secondBlock.blockhash);

        //Note initially when we had 2 blocks the hash codes were as follows:
        //1. The first block Hash is: -1080507538
        //2.The second block Hash is: -1234376355
        
        //Let's see adding the third block changes the has value
        //Create the Third block 
        String[] thirdBlockTransaction = {"Received Money from Alex and Ben" ,"Bitcoin: 15"};
        Blockchain thirdBlock = new Blockchain(secondBlock.getBlockhash(),thirdBlockTransaction);
        
        System.out.println("The third block Hash is: "+thirdBlock.blockhash);
        
        //Note that the value didnt change much:
        //The first block Hash is: -1080507538
        //The second block Hash is: -1234376355
        //The third block Hash is: 158962124
        
        // Let's see changing the transaction value of first block will it change the other transaction value (Changed Bitcoin to 55 )
        // The first block Hash is: -927972127
        // The second block Hash is: -1081840944
        // The third block Hash is: 311497535
        
        // The main point was to showcase changing any string characters in the transaction will lead to new digital signature. This hashing algorithm is very difficult to crack and 
        // more the blocks it is harder to crack 
        
    }
}
