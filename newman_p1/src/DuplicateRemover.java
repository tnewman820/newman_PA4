import java.io.File;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.io.IOException;
import java.util.HashSet;
import java.io.FileNotFoundException;
import java.io.FileWriter;

class DuplicateRemover {
    private Set<String> uniqueWords;

    //remove method. saves unique words to instance variable
    void remove(String dataFile) throws FileNotFoundException//error handler for no file
    {
        //create objects
        String nextWord;//temp string
        Scanner scnr = new Scanner(new File(dataFile));
        uniqueWords = new HashSet<String>();
        //while loop to capture each UNIQUE word with add method
        while(scnr.hasNext())
        {
            //temp saves file input to nextWord and then adds(as long as it doesnt already exist) it to the uniqueWords list
            nextWord = scnr.next();
            uniqueWords.add(nextWord);
        }
        //close the scanner object
        scnr.close();
    }

    //write method, outputs the unique words
    void write(String outputFile) throws IOException //error handler for i/o
    {
        //create objects
        File file = new File(outputFile);
        FileWriter fileWrite = new FileWriter(file);
        Iterator iterator = uniqueWords.iterator();

        //if there is already a file overwrite it
        if(file.exists()) {
            //loop through and write to the file while there is unique words left
            while(iterator.hasNext())
            {
                String string = (String)iterator.next();
                //print each string on new line
                fileWrite.write(string + "\n");
            }
        }
        //if there is no file make one
        else
        {
            boolean success = file.createNewFile();
            //stop if file creation fails
            if(!success){
                System.out.println("Failure to create new file!");
                return;
            }
            //loop through and write to the file while there is unique words left
            while(iterator.hasNext())
            {
                String string = (String)iterator.next();
                //print each string on new line
                fileWrite.write(string + "\n");
            }
        }
        //clean up file writer
        fileWrite.close();
        //if we make it to this point then everything worked, print success message so user knows files are ready
        System.out.println("Success!");
    }

}