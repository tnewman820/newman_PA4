import java.io.IOException;
//application used for testing DuplicateRemover class
public class Application {
    public static void main(String[] args) throws IOException {
        //create new instance of DuplicateCounter
        DuplicateCounter duplicateCounter = new DuplicateCounter();
        //output unique words of problem2.txt to unique_word_counts.txt
        duplicateCounter.count("problem2.txt");
        duplicateCounter.write("unique_word_counts.txt");
    }

}
