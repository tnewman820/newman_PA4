import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


class DuplicateCounter
{
    private Map<String, Integer> wordCounter;

    void count(String dataFile)throws IOException{
        wordCounter = new HashMap<>();
        //create objects
        Scanner scnr = new Scanner(new File(dataFile));

        //loop through file and take in duplicates
        while(scnr.hasNext()) {
            String newWord = scnr.next();
            Integer count = wordCounter.get(newWord);
            if(count == null)
                count = 1;
            else
                count++;
            //place result into the hash map
            wordCounter.put(newWord, count);
        }
        //close the scanner object
        scnr.close();

    }

    void write(String outputFile)throws FileNotFoundException{
        //create objects
        PrintWriter writer = new PrintWriter(new File(outputFile));

        //loop through word counter and print results
        for(String temp : wordCounter.keySet()) {
            writer.println("Word: " + temp + " Count: " + wordCounter.get(temp));
        }

        //close the writer object
        writer.close();
    }
}