package tools;

import java.io.*;

public class ReadFile {
    public void readContentFromFile(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader("/Users/fring/IdeaProjects/Algorithm_practice/src/main/resources/dataset.txt"));
            reader.readLine();
        }catch (Exception ex){
            System.out.println("can't find file");
        }
    }
}
