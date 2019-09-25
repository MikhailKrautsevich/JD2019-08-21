package by.it.zavadski.jd01_15;

import java.io.*;

public class TaskB {
    public static StringBuilder toPrint=new StringBuilder();
    //1st one line comment for main method
    public static void main(String[] args) {
        String inputFile = TaskA.getClassPath(TaskB.class).concat("TaskB.java");
        String outputFile = TaskA.getClassPath(TaskB.class).concat("TaskB.txt");
        removeComments(inputFile);
        printer(outputFile);
        readFile(outputFile);
    }
/*
* 2lined comment to be removed
*/
private static void removeComments(String inputFile) {
        try(BufferedReader bufferedReader=new BufferedReader(new FileReader(inputFile))
        ){
            String line;
            while((line=bufferedReader.readLine())!=null){
                StringBuilder cleanString=new StringBuilder(line).append("\n");
                if(line.contains("*/")&&!line.contains("contains"))
                    cleanString.delete(line.indexOf("*"),line.length());
                if(line.contains("/*")&&!line.contains("contains"))
                    cleanString.delete(line.indexOf("*"),line.length());
                if(line.contains("/")&&!line.contains("contains")&&!line.contains("indexOf"))
                    cleanString.delete(line.indexOf("/"),line.length());
                else if(line.contains("*") &&!line.contains("contains")&&!line.contains("indexOf")&&!line.contains(".*"))
                    cleanString.delete(line.indexOf("*"),line.length());
                toPrint.append(cleanString.toString());
            }
        }
/*
* removed
*/
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Java doc example
     * @param outputFile
     */
//printer method for print result
    private static void printer(String outputFile) {
        try(PrintWriter writer=new PrintWriter(new FileWriter(outputFile))){
            writer.print(toPrint.toString());
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    private static void readFile(String fileToRead){
        try(BufferedReader reader=new BufferedReader(new FileReader(fileToRead))
        ){
            while (reader.ready()){
                System.out.println(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
