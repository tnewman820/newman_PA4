import java.io.IOException;
//application used for testing DuplicateRemover class
public class Application {
    public static void main(String[] args) throws IOException {
        //create new instance of DuplicateRemover
        DuplicateRemover duplicateRemover = new DuplicateRemover();
        //output unique words of problem1.txt to unique_words.txt
        duplicateRemover.remove("problem1.txt");
        duplicateRemover.write("unique_words.txt");
    }

}
