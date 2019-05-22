package edu.gatech.seclass.capitalize;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyMainTest {

/*
Place all  of your tests in this class, optionally using MainTest.java as an example.
*/

    private ByteArrayOutputStream outStream;
    private ByteArrayOutputStream errStream;
    private PrintStream outOrig;
    private PrintStream errOrig;
    private Charset charset = StandardCharsets.UTF_8;

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Before
    public void setUp() throws Exception {
        outStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outStream);
        errStream = new ByteArrayOutputStream();
        PrintStream err = new PrintStream(errStream);
        outOrig = System.out;
        errOrig = System.err;
        System.setOut(out);
        System.setErr(err);
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(outOrig);
        System.setErr(errOrig);
    }

    // Some utilities

    private File createTmpFile() throws IOException {
        File tmpfile = temporaryFolder.newFile();
        tmpfile.deleteOnExit();
        return tmpfile;
    }


    private File createInputFile1() throws Exception{
        File file1=createTmpFile();
        return file1;
    }

    private File createInputFile2() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);
        fileWriter.write("Howdy Billy,\n" +
                "This is a test file for the capitalize utility.\n" +
                "let's make sure it has at least a few lines,\n" +
                "so that we can create some \n"
                + "interesting test cases...And let's say \"howdy\" to Bill again!\n"+
                 "is this OK for you?");
        fileWriter.close();
        return file1;
    }

    private File createInputFile3() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);
        fileWriter.write("the wheels on the bus go round and round,\n"+
        "round and round, round and round.");
        fileWriter.close();
        return file1;
    }

    private File createInputFile4() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);
        fileWriter.write("here is a test, just a test!\n"+" It is not fun.");
        fileWriter.close();
        return file1;
    }

    private File createInputFile5() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);
        fileWriter.write("this is an apple");
        fileWriter.close();
        return file1;
    }
    private File createInputFile6() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);
        fileWriter.write("This is an apple.\n"+"I like it! Do you like apples?");
        fileWriter.close();
        return file1;
    }
    private File createInputFile7() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);
        fileWriter.write("Howdy Billy,\n" +
                "This is a test file for the capitalize utility.\n" +
                "let's make sure it has at least a few lines,\n" +
                "so that we can create some \n"
                + "interesting test cases...And let's say \"howdy\" to Bill again!");
        fileWriter.close();
        return file1;
    }

    private File createInputFile8() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);
        fileWriter.write("Bill is,\n" +
                "in my opinion,\n" +
                "an easier name to spell than William.\n" +
                "Bill is shorter,\n" +
                "and Bill is\n" +
                "first alphabetically.");
        fileWriter.close();
        return file1;
    }

    private File createInputFile9() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);
        fileWriter.write("Howdy Bill, have you learned your abc and 123?\r\n" +
                "I know My Abc's.\r" +
                "It is important to know your abc's and 123's,\n" +
                "so repeat with me: abc! 123! Abc and 123!");
        fileWriter.close();
        return file1;
    }

    private File createInputFile10() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);
        fileWriter.write("AppleBananaCarrot.\r" +
                "DogElephantHorse.\r" +
                "Icecream. Jello");
        fileWriter.close();
        return file1;
    }

    private File createInputFile11() throws Exception {
        File file = createTmpFile();
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("");
        fileWriter.close();
        return file;
    }

    private File createInputFile12() throws Exception {
        File file = createTmpFile();
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("this is a very simple string" + System.lineSeparator() +
                "with a few lines" + System.lineSeparator() +
                "and not much else");
        fileWriter.close();
        return file;
    }

    private File createInputFile13() throws Exception {
        File file = createTmpFile();
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("-- -- -- --");
        fileWriter.close();
        return file;
    }

    private File createInputFile14() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);
        fileWriter.write("Mary had a csv,csv,csv\n" +
                "Mary had a csv,commas, in a csv.\n" +
                "csv,csv,csv");
        fileWriter.close();
        return file1;
    }

    private File createInputFile15() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);
        fileWriter.write("oneword");
        fileWriter.close();
        return file1;
    }

    private File createInputFile16() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);
        fileWriter.write("lol.rofl.roflmho");
        fileWriter.close();
        return file1;
    }
    private File createInputFile17() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);
        fileWriter.write("");
        fileWriter.close();
        return file1;
    }
    private File createInputFile18() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);
        fileWriter.write("this is a-n apple!");
        fileWriter.close();
        return file1;
    }

    private File createInputFile19() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);
        fileWriter.write("#@#$#@#$@#$%#@#$#@$#");
        fileWriter.close();
        return file1;
    }

    private File createInputFile20() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);
        fileWriter.write("Here is an apple!");
        fileWriter.close();
        return file1;
    }

    private String getFileContent(String filename) {
        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get(filename)), charset);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

     // test cases from MainTest
     // Purpose: To provide an example of a test case format
     // Frame #: Instructor example 1 from assignment directions
     @Test
     public void mainTest1() throws Exception {

         File inputFile1 = createInputFile7();

         String args[] = {inputFile1.getPath()};
         Main.main(args);
         String expected1 = "Howdy Billy,\n" +
                 "This Is A Test File For The Capitalize Utility.\n" +
                 "Let's Make Sure It Has At Least A Few Lines,\n" +
                 "So That We Can Create Some \n"
                 + "Interesting Test Cases...And Let's Say \"howdy\" To Bill Again!";
         String actual1 = getFileContent(inputFile1.getPath());
         assertEquals("The files differ!", expected1, actual1);
     }

    // Purpose: To provide an example of a test case format
    // Frame #: Instructor example 2 from assignment directions
    @Test
    public void mainTest2() throws Exception {
        File inputFile1 = createInputFile7();
        String args[] = {"-l", inputFile1.getPath()};
        Main.main(args);
        String expected1 = "Howdy Billy,\n" +
                "This is a test file for the capitalize utility.\n" +
                "Let's make sure it has at least a few lines,\n" +
                "So that we can create some \n"
                + "Interesting test cases...And let's say \"howdy\" to Bill again!";
        String actual1 = getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1, actual1);
    }

    // Purpose: To provide an example of a test case format
    // Frame #: Instructor example 3 from assignment directions
    @Test
    public void mainTest3() throws Exception {
        File inputFile1 = createInputFile7();

        String args[] = {"-e", "-s", inputFile1.getPath()};
        Main.main(args);
        String expected2 = "Howdy Billy,\n" +
                "This is a test file for the capitalize utility.\n" +
                "Let's make sure it has at least a few lines,\n" +
                "so that we can create some \n"
                + "interesting test cases...AND LET'S SAY \"HOWDY\" TO BILL AGAIN!";
        String actual2 = getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected2, actual2);
    }

    // Purpose: To provide an example of a test case format
    // Frame #: Instructor example 4 from assignment directions
    @Test
    public void mainTest4() throws Exception {
        File inputFile1 = createInputFile7();
        String args[] = {"-s", ",", "-x", inputFile1.getPath()};
        Main.main(args);
        String expected3 = "Howdy billy,\n" +
                "This is a test file for the capitalize utility.\n" +
                "let's make sure it has at least a few lines,\n" +
                "So that we can create some \n"
                + "interesting test cases...and let's say \"howdy\" to bill again!";
        String actual3 = getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected3, actual3);
    }


    // Purpose: To provide an example of a test case format
    // Frame #: Instructor error example

    //Part of mainTest5 was modified to assertEquals("Usage: Capitalize  [-l] [-e] [-s] [string] [-x] [-c] [boolean] <filename>", errStream.toString().trim());.
    @Test
    public void mainTest5() {
        String args[] = null; //invalid argument
        Main.main(args);
        assertEquals("Usage: Capitalize  [-l] [-e] [-s] [string] [-x] [-c] [boolean] <filename>", errStream.toString().trim());
    }

    // Additional Test for Deliverable 2
    @Test
    public void mainTest6() {
        String args[] = {"nofile.txt"};
        Main.main(args);
        assertEquals("File Not Found", errStream.toString().trim());
    }

    // Additional Test for Deliverable 2
    @Test
    public void mainTest7() throws Exception {
        File inputFile1 = createInputFile7();
        String args[] = {"-s", ",", "-x", "-c", inputFile1.getPath()};
        Main.main(args);
        assertEquals("Usage: Capitalize  [-l] [-e] [-s] [string] [-x] [-c] [boolean] <filename>", errStream.toString().trim());
    }

    // Additional Test for Deliverable 2
    @Test
    public void mainTest8() throws Exception {
        File inputFile = createInputFile8();
        String args[] = {"-s", ",.?!", "-x", inputFile.getPath()};
        Main.main(args);
        String expected = "Bill is,\n" +
                "In my opinion,\n" +
                "An easier name to spell than william.\n" +
                "Bill is shorter,\n" +
                "And bill is\n" +
                "first alphabetically.";
        String actual = getFileContent(inputFile.getPath());
        assertEquals("The files differ!", expected, actual);
    }

    // Additional Test for Deliverable 2
    @Test
    public void mainTest9() throws Exception {
        File inputFile = createInputFile8();
        String args[] = {"-s", ",.?!", "-e", "-x", "-c", "true", inputFile.getPath()};
        Main.main(args);
        String expected = "BillIs,\n" +
                "InMyOpinion,\n" +
                "AnEasierNameToSpellThanWilliam.\n" +
                "BillIsShorter,\n" +
                "AndBillIsFirstAlphabetically.";
        String actual = getFileContent(inputFile.getPath());
        assertEquals("The files differ!", expected, actual);
    }

    // Additional Test for Deliverable 2
    @Test
    public void mainTest10() throws Exception {
        File inputFile = createInputFile10();
        String args[] = {"-s", "-c", "false", inputFile.getPath()};
        Main.main(args);
        String expected = "Apple banana carrot.\r" +
                "Dog elephant horse.\r" +
                "Icecream. Jello";
        String actual = getFileContent(inputFile.getPath());
        assertEquals("The files differ!", expected, actual);
    }

    // Additional Test for Deliverable 2
    @Test
    public void mainTest11() throws Exception {
        File inputFile = createInputFile10();
        String args[] = {"-s", inputFile.getPath()};
        Main.main(args);
        String expected = "AppleBananaCarrot.\r" +
                "DogElephantHorse.\r" +
                "Icecream. Jello";
        String actual = getFileContent(inputFile.getPath());
        assertEquals("The files differ!", expected, actual);
    }

    // Additional Test for Deliverable 2
    @Test
    public void mainTest12() throws Exception {
        File inputFile = createInputFile9();
        String args[] = {"-e", inputFile.getPath()};
        Main.main(args);
        String expected = "Howdy Bill, have you learned your abc and 123?\r\n" +
                "I know My Abc's.\r" +
                "IT IS IMPORTANT TO KNOW YOUR ABC'S AND 123'S,\n" +
                "SO REPEAT WITH ME: ABC! 123! ABC AND 123!";
        String actual = getFileContent(inputFile.getPath());
        assertEquals("The files differ!", expected, actual);
    }

    // Additional Test for Deliverable 2
    @Test
    public void mainTest13() throws Exception {
        File inputFile = createInputFile9();
        String args[] = {"-e", "-c", "true", inputFile.getPath()};
        Main.main(args);
        String expected = "HowdyBill,HaveYouLearnedYourAbcAnd123?\r\n" +
                "IKnowMyAbc's.\r" +
                "ITISIMPORTANTTOKNOWYOURABC'SAND123'S,SOREPEATWITHME:ABC! 123! ABCAND123!";
        String actual = getFileContent(inputFile.getPath());
        assertEquals("The files differ!", expected, actual);
    }

    // Additional Test for Deliverable 2
    @Test
    public void mainTest14() throws Exception {
        File inputFile = createInputFile11();
        String args[] = {"-s", "-x", inputFile.getPath()};
        Main.main(args);
        String expected = "";
        String actual = getFileContent(inputFile.getPath());
        assertEquals("The files differ!", expected, actual);
    }

    // Additional Test for Deliverable 2
    @Test
    public void mainTest15() throws Exception {
        File inputFile = createInputFile16();
        String args[] = {"-s", inputFile.getPath()};
        Main.main(args);
        String expected = "Lol.Rofl.Roflmho";
        String actual = getFileContent(inputFile.getPath());
        assertEquals("The files differ!", expected, actual);
    }

    // Additional Test for Deliverable 2
    @Test
    public void mainTest16() throws Exception {
        File inputFile = createInputFile12();
        String args[] = {"-l", inputFile.getPath()};
        Main.main(args);
        String expected = "This is a very simple string" + System.lineSeparator() +
                "With a few lines" + System.lineSeparator()+
                "And not much else";
        String actual = getFileContent(inputFile.getPath());
        assertEquals("The files differ!", expected, actual);
    }

    // Additional Test for Deliverable 2
    @Test
    public void mainTest17() throws Exception {
        File inputFile = createInputFile12();
        String args[] = {"-s", "i", inputFile.getPath()};
        Main.main(args);
        String expected = "ThiS iS a very siMple striNg" + System.lineSeparator() +
                "wiTh a few liNes" + System.lineSeparator() +
                "and not much else";
        String actual = getFileContent(inputFile.getPath());
        assertEquals("The files differ!", expected, actual);
    }

    // Additional Test for Deliverable 2
    @Test
    public void mainTest18() throws Exception {
        File inputFile = createInputFile13();
        String args[] = {"-l", "-x", inputFile.getPath()};
        Main.main(args);
        String expected = "-- -- -- --";
        String actual = getFileContent(inputFile.getPath());
        assertEquals("The files differ!", expected, actual);
    }

    // Additional Test for Deliverable 2
    @Test
    public void mainTest19() throws Exception {
        File inputFile = createInputFile13();
        String args[] = {"-s", "-", inputFile.getPath()};
        Main.main(args);
        String expected = "-- -- -- --";
        String actual = getFileContent(inputFile.getPath());
        assertEquals("The files differ!", expected, actual);
    }

    // Additional Test for Deliverable 2
    @Test
    public void mainTest20() throws Exception {
        File inputFile = createInputFile14();
        String args[] = {"-s", ",.", inputFile.getPath()};
        Main.main(args);
        String expected = "Mary had a csv,Csv,Csv\n" +
                "Mary had a csv,Commas, In a csv.\n" +
                "Csv,Csv,Csv";
        String actual = getFileContent(inputFile.getPath());
        assertEquals("The files differ!", expected, actual);
    }

    // Additional Test for Deliverable 2
    @Test
    public void mainTest21() throws Exception {
        File inputFile = createInputFile14();
        String args[] = {"-s", "c", "-x", inputFile.getPath()};
        Main.main(args);
        String expected = "Mary had a cSv,cSv,cSv\n" +
                "mary had a cSv,cOmmas, in a cSv.\n" +
                "cSv,cSv,cSv";
        String actual = getFileContent(inputFile.getPath());
        assertEquals("The files differ!", expected, actual);
    }

    // Additional Test for Deliverable 2
    @Test
    public void mainTest22() throws Exception {
        File inputFile = createInputFile15();
        String args[] = {"-x", inputFile.getPath()};
        Main.main(args);
        String expected = "Oneword";
        String actual = getFileContent(inputFile.getPath());
        assertEquals("The files differ!", expected, actual);
    }

    // Additional Test for Deliverable 2
    @Test
    public void mainTest23() throws Exception {
        File inputFile = createInputFile15();
        String args[] = {"-c", "false", inputFile.getPath()};
        Main.main(args);
        String expected = "Oneword";
        String actual = getFileContent(inputFile.getPath());
        assertEquals("The files differ!", expected, actual);
    }

    // Additional Test for Deliverable 2
    @Test
    public void mainTest24() throws Exception {
        File inputFile = createInputFile16();

        String args[] = {"-x", "-x", "-x", inputFile.getPath()};
        Main.main(args);
        String expected = "Lol.rofl.roflmho";
        String actual = getFileContent(inputFile.getPath());
        assertEquals("The files differ!", expected, actual);
    }

    // Additional Test for Deliverable 2
    @Test
    public void mainTest25() throws Exception {
        File inputFile = createInputFile16();
        String args[] = {"-s", "l", "-c", "true", inputFile.getPath()};
        Main.main(args);
        String expected = "lOl.rofl.roflMho";
        String actual = getFileContent(inputFile.getPath());
        assertEquals("The files differ!", expected, actual);
    }


    // Additional Test for Deliverable 2
    @Test
    public void mainTest26() throws Exception {
        File inputFile = createInputFile16();
        String expected = getFileContent(inputFile.getPath());
        String args[] = {"-l", "-k", "true", inputFile.getPath()};
        Main.main(args);
        String actual = getFileContent(inputFile.getPath());
        assertEquals("The files differ!", expected, actual);
        assertEquals("Usage: Capitalize  [-l] [-e] [-s] [string] [-x] [-c] [boolean] <filename>", errStream.toString().trim());
    }

    // Purpose: To test if the file is empty
    // Frame #: Test Case 2
    @Test
    public void capitalizeTest1() throws Exception {
        File inputFile1=createInputFile1();
        String args[]={"-e", inputFile1.getPath()};
        Main.main(args);
        String expected1="";
        String actual1=getFileContent(inputFile1.getPath());
        assertEquals("The files differ!",expected1,actual1);
    }

    //Purpose: The option is -l, -e, -x and -s, default delimiters, the presence of lines is one or more, the presence of exclamatory sentence is none, the presence for capital letters that do not meet the specified capitalization rules is none, and the occurrence of delimiter is true.
    //Frame #: Test Case 8
    @Test
    public void capitalizeTest2() throws Exception {
        File inputFile1=createInputFile3();
        String args[]={"-l", "-e", "-s", "-x", inputFile1.getPath()};
        Main.main(args);
        String expected1="The wheels on the bus go round and round,\n"+
                "Round and round, round and round.";
        String actual1=getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1,actual1);
    }

    //Purpose: The option is -l, -e, -x and -s, default delimiters, the presence of lines is one or more, the presence of exclamatory sentence is none, the presence for capital letters that do not meet the specified capitalization rules is none, and the occurrence of delimiter is true.
    //Frame #: Test Case 8
    @Test
    public void capitalizeTest16() throws Exception {
        File inputFile1=createInputFile4();
        String args[]={"-l", "-e", "-s", "-x", inputFile1.getPath()};
        Main.main(args);
        String expected1="HERE IS A TEST, JUST A TEST!\n"+" It is not fun.";
        String actual1=getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1,actual1);
    }

    //Purpose: The option is -l, -e, -x and -s, default delimiters, the presence of lines is one or more, the presence of exclamatory sentence is one or more, the presence for capital letters that do not meet the specified capitalization rules is one or more, and the occurrence of delimiter is true.
    //Frame #: Test Case 20
    @Test
    public void capitalizeTest3() throws Exception {
        File inputFile1=createInputFile2();
        String args[]={"-l", "-e", "-x", "-s", inputFile1.getPath()};
        Main.main(args);
        String expected1="Howdy billy,\n" +
                "This is a test file for the capitalize utility.\n" +
                "Let's make sure it has at least a few lines,\n" +
                "So that we can create some \n"
                + "Interesting test cases...AND LET'S SAY \"HOWDY\" TO BILL AGAIN!\n"+
                "Is this ok for you?";
        String actual1=getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1,actual1);
    }

    //Purpose: The option is -l, -e, -x and -s, default delimiters, the presence of lines is one or more, the presence of exclamatory sentence is one or more, the presence for capital letters that do not meet the specified capitalization rules is one or more, and the occurrence of delimiter is true.
    //Frame #: Test Case 20
    @Test
    public void capitalizeTest17() throws Exception {

        File inputFile1=createInputFile4();
        String args[]={"-l", "-e", "-s", "-x", inputFile1.getPath()};
        Main.main(args);
        String expected1="HERE IS A TEST, JUST A TEST!\n"+" It is not fun.";
        String actual1=getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1,actual1);
    }

    //Purpose: The option is -l, -e, -x and -s, specified delimiters, the presence of lines is one or more, the presence of exclamatory sentence is one or more, the presence for capital letters that do not meet the specified capitalization rules is one or more, and the occurrence of delimiter is false.
    //Frame #: Test Case 23
    // Type b
    @Test
    public void capitalizeTest4() throws Exception {
        File inputFile1=createInputFile2();
        String args[]={"-l", "-e", "-x", "-s", "$", inputFile1.getPath()};
        Main.main(args);
        String expected1="HOWDY BILLY,\n" +
                "THIS IS A TEST FILE FOR THE CAPITALIZE UTILITY.\n" +
                "LET'S MAKE SURE IT HAS AT LEAST A FEW LINES,\n" +
                "SO THAT WE CAN CREATE SOME \n"
                + "INTERESTING TEST CASES...AND LET'S SAY \"HOWDY\" TO BILL AGAIN!\n"+
                "Is this ok for you?";
        String actual1=getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1,actual1);
    }

    //Purpose: The option is -l, -e, -x and -s, specified delimiters, the presence of lines is one or more, the presence of exclamatory sentence is one or more, the presence for capital letters that do not meet the specified capitalization rules is one or more, and the occurrence of delimiter is false.
    //Frame #: Test Case 23
    @Test
    public void capitalizeTest18() throws Exception {
        File inputFile1=createInputFile4();
        String args[]={"-l", "-e", "-x", "-s", "$", inputFile1.getPath()};
        String expected1="here is a test, just a test!\n"+" It is not fun.";
        String actual1=getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1,actual1);
    }

    //Purpose: The option is -l, -e and -s, specified string of delimiters, the presence of lines is one or more, the presence of exclamatory sentence is none, and the occurrence of delimiter is true.
    //Frame #: Test Case 25
    @Test
    public void capitalizeTest5() throws Exception {
        File inputFile1=createInputFile3();
        String args[]={"-l", "-e", "-s", ",", inputFile1.getPath()};
        Main.main(args);
        String expected1="The wheels on the bus go round and round,\n"+
                "Round and round, Round and round.";
        String actual1=getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1,actual1);
    }
    //Purpose: The option is -l, -e and -s, specified string of delimiters, the presence of lines is one or more, the presence of exclamatory sentence is none, and the occurrence of delimiter is true.
    //Frame #: Test Case 25
    @Test
    public void capitalizeTest19() throws Exception {
        File inputFile1=createInputFile4();
        String args[]={"-l", "-e",  "-s", ",", inputFile1.getPath()};
        String expected1="here is a test, just a test!\n"+" It is not fun.";
        String actual1=getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1,actual1);
    }
    //Purpose: The option is -l, -x and -e, the presence of lines is one or more, the presence for capital letters that do not meet the specified capitalization rules is none, and the presence of exclamatory sentence is none.
    //Frame #: Test Case 32
    @Test
    public void capitalizeTest6() throws Exception {
        File inputFile1=createInputFile3();
        String args[]={"-l", "-x", "-e", inputFile1.getPath()};
        Main.main(args);
        String expected1="The wheels on the bus go round and round,\n"+
                "Round and round, round and round.";
        String actual1=getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1,actual1);
    }

    //Purpose: The option is -l, -x and -s, specified string of delimiter, the presence of lines is one or more, the presence for capital letters that do not meet the specified capitalization rules is one or more, and the occurrence of delimiter is true.
    //Frame #: Test Case 43
    @Test
    public void capitalizeTest7() throws Exception {
        File inputFile1=createInputFile2();
        String args[]={"-l", "-s", ",", "-x", inputFile1.getPath()};
        Main.main(args);
        String expected1="Howdy billy,\n" +
                "This is a test file for the capitalize utility.\n" +
                "Let's make sure it has at least a few lines,\n" +
                "So that we can create some \n"
                + "Interesting test cases...and let's say \"howdy\" to bill again!\n"+
                "Is this ok for you?";
        String actual1=getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1,actual1);
    }

    //Purpose: The option is -l and -s, specified string of delimiter, the presence of lines is one or more, and the occurrence of delimiter is false.
    //Frame #: Test Case 49
    @Test
    public void capitalizeTest8() throws Exception {
        File inputFile1=createInputFile2();
        String args[]={"-l", "-s", "%", inputFile1.getPath()};
        Main.main(args);
        String expected1="Howdy Billy,\n" +
                "This is a test file for the capitalize utility.\n" +
                "Let's make sure it has at least a few lines,\n" +
                "So that we can create some \n"
                + "Interesting test cases...And let's say \"howdy\" to Bill again!\n"+
                "Is this OK for you?";
        String actual1=getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1,actual1);
    }

    //Purpose: The option is -l and -x, the presence of lines is one or more, and the presence for capital letters that do not meet the specified capitalization rules is one or more.
    //Frame #: Test Case 51
    @Test
    public void capitalizeTest9() throws Exception {
        File inputFile1=createInputFile2();
        String args[]={"-l", "-x", inputFile1.getPath()};
        Main.main(args);
        String expected1="Howdy billy,\n" +
                "This is a test file for the capitalize utility.\n" +
                "Let's make sure it has at least a few lines,\n" +
                "So that we can create some \n"
                + "Interesting test cases...and let's say \"howdy\" to bill again!\n"+
                "Is this ok for you?";
        String actual1=getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1,actual1);
    }

    //Purpose: The option is -e, -s and -x, specified string of delimiter, the presence of exclamatory sentence is one or more, the presence of specified delimiter is one or more, and the presence for capital letters that do not meet the specified capitalization rules is one or more.
    //Frame #: Test Case 66
    // Type b
    @Test
    public void capitalizeTest10() throws Exception {
        File inputFile1=createInputFile2();
        String args[]={"-e", "-x", "-s", ",", inputFile1.getPath()};
        Main.main(args);
        String expected1="Howdy billy,\n" +
                "This is a test file for the capitalize utility.\n" +
                "let's make sure it has at least a few lines,\n" +
                "SO THAT WE CAN CREATE SOME \n"
                + "INTERESTING TEST CASES...AND LET'S SAY \"HOWDY\" TO BILL AGAIN!\n"+
                "is this ok for you?";
        String actual1=getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1,actual1);
    }

    //Purpose: The option is -e and -s, specified string of delimiter, the presence of exclamatory sentence is one or more, the presence of specified delimiter is one or more.
    //Frame #: Test Case 74
    // Type b
    @Test
    public void capitalizeTest11() throws Exception {
        File inputFile1=createInputFile2();
        String args[]={"-e", "-s", ",", inputFile1.getPath()};
        Main.main(args);
        String expected1="Howdy Billy,\n" +
                "This is a test file for the capitalize utility.\n" +
                "let's make sure it has at least a few lines,\n" +
                "SO THAT WE CAN CREATE SOME \n"
                + "INTERESTING TEST CASES...AND LET'S SAY \"HOWDY\" TO BILL AGAIN!\n"+
                "is this OK for you?";
        String actual1=getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1,actual1);
    }

    //Purpose: The option is -e and -x, the presence of exclamatory sentence in File one or more, the presence of capital letters that do not meet the specified capitalization rules is one or more.
    //Frame #: Test Case 80
    // Type b
    @Test
    public void capitalizeTest12() throws Exception {
        File inputFile1=createInputFile2();
        String args[]={"-e", "-x", inputFile1.getPath()};
        Main.main(args);
        String expected1="howdy billy,\n" +
                "this is a test file for the capitalize utility.\n" +
                "let's make sure it has at least a few lines,\n" +
                "so that we can create some \n"
                + "interesting test cases...AND LET'S SAY \"HOWDY\" TO BILL AGAIN!\n"+
                "is this ok for you?";
        String actual1=getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1,actual1);
    }

    //Purpose: The option is -e only,  and the presence of exclamatory sentence in File is one or more.
    //Frame #: Test Case 82
    @Test
    public void capitalizeTest13() throws Exception {
        File inputFile1=createInputFile2();
        String args[]={"-e", inputFile1.getPath()};
        Main.main(args);
        String expected1="Howdy Billy,\n" +
                "This is a test file for the capitalize utility.\n" +
                "let's make sure it has at least a few lines,\n" +
                "so that we can create some \n"
                + "interesting test cases...AND LET'S SAY \"HOWDY\" TO BILL AGAIN!\n"+
                "is this OK for you?";
        String actual1=getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1,actual1);
    }

    //Purpose: The option is -s only, no string of delimiters, and the presence of default delimiters is one or more.
    //Frame #: Test Case 91
    @Test
    public void capitalizeTest14() throws Exception {
        File inputFile1=createInputFile2();
        String args[]={"-s", inputFile1.getPath()};
        Main.main(args);
        String expected1="Howdy Billy,\n" +
                "This is a test file for the capitalize utility.\n" +
                "Let's make sure it has at least a few lines,\n" +
                "so that we can create some \n"
                + "interesting test cases...And let's say \"howdy\" to Bill again!\n"+
                "Is this OK for you?";
        String actual1=getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1,actual1);
    }

    //Purpose: The option is -x only, and the occurrence of capital letters do not meet the specified capitalization rules is one or more.
    //Frame #: Test Case 96
    @Test
    public void capitalizeTest15() throws Exception {
        File inputFile1=createInputFile2();
        String args[]={"-x", inputFile1.getPath()};
        Main.main(args);
        String expected1="Howdy Billy,\n" +
                "This Is A Test File For The Capitalize Utility.\n" +
                "Let's Make Sure It Has At Least A Few Lines,\n" +
                "So That We Can Create Some \n"
                + "Interesting Test Cases...and Let's Say \"howdy\" To Bill Again!\n"+
                "Is This Ok For You?";
        String actual1=getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1,actual1);
    }
    //Purpose: There is no option and there are whitespaces in file.
    //Frame #: Test Case 98
    @Test
    public void capitalizeTest20() throws Exception {
        File inputFile1=createInputFile5();
        String args[]={inputFile1.getPath()};
        Main.main(args);
        String expected1="This Is An Apple";
        String actual1=getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1,actual1);
    }

    //Purpose: The option is -x only,  and there are no capital letters in file.
    //Frame #: Test Case 94
    @Test
    public void capitalizeTest21() throws Exception {
        File inputFile1=createInputFile5();
        String args[]={"-x",inputFile1.getPath()};
        Main.main(args);
        String expected1="This Is An Apple";
        String actual1=getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1,actual1);
    }

    //Purpose: The option is -s only,  specified string of delimiter, and the presence of delimiters is zero.
    //Frame #: Test Case 94
    // Type b
    @Test
    public void capitalizeTest22() throws Exception {
        File inputFile1=createInputFile5();
        String args[]={"-s", "z",inputFile1.getPath()};
        Main.main(args);
        String expected1="This is an apple";
        String actual1=getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1,actual1);
    }

    //Purpose: The option is -s only,  default delimiter, and the presence of delimiters is zero.
    //Frame #: Test Case 93
    // Type b
    @Test
    public void capitalizeTest23() throws Exception {
        File inputFile1=createInputFile5();
        String args[]={"-s", inputFile1.getPath()};
        Main.main(args);
        String expected1="This is an apple";
        String actual1=getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1,actual1);
    }

    //Purpose: The option is -s only,  specified string of delimiter, and the presence of delimiters is one or more.
    //Frame #: Test Case 92

    @Test
    public void capitalizeTest24() throws Exception {
        File inputFile1=createInputFile5();
        String args[]={"-s","s", inputFile1.getPath()};
        Main.main(args);
        String expected1="This Is An apple";
        String actual1=getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1,actual1);
    }
    //Purpose: The option is -s and -x,  specified string of delimiter, the presence of delimiters is zero, and the capital letter is one or more.
    //Frame #: Test Case 90
    @Test
    public void capitalizeTest25() throws Exception {
        File inputFile1=createInputFile6();
        String args[]={"-s","z","-x", inputFile1.getPath()};
        Main.main(args);
        String expected1="This is an apple.\n"+"i like it! do you like apples?";
        String actual1=getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1,actual1);
    }

    //Purpose: The option is -s and -x,  specified string of delimiter, the presence of delimiters is one or more, and the capital letter is one or more.
    //Frame #: Test Case 88
    @Test
    public void capitalizeTest26() throws Exception {
        File inputFile1=createInputFile6();
        String args[]={"-s","n","-x", inputFile1.getPath()};
        Main.main(args);
        String expected1="This is an Apple.\n"+"i like it! do you like apples?";
        String actual1=getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1,actual1);
    }

    //Purpose: The option is -s and -x,  default delimiter, the presence of delimiters is one or more, and the capital letter is one or more.
    //Frame #: Test Case 87
    @Test
    public void capitalizeTest27() throws Exception {
        File inputFile1=createInputFile6();
        String args[]={"-s","-x", inputFile1.getPath()};
        Main.main(args);
        String expected1="This is an apple.\n"+"I like it! Do you like apples?";
        String actual1=getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1,actual1);
    }

    //Purpose: The option is -s and -e,  default delimiter, the presence of delimiters is one or more, and exclamatory sentence is one or more.
    //Frame #: Test Case 73
    @Test
    public void capitalizeTest28() throws Exception {
        File inputFile1=createInputFile6();
        String args[]={"-s","-e", inputFile1.getPath()};
        Main.main(args);
        String expected1="This is an apple.\n"+"I LIKE IT! Do you like apples?";
        String actual1=getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1,actual1);
    }

    //Purpose: The option is -l only,  and there is one or more lines in file.
    //Frame #: Test Case 52
    @Test
    public void capitalizeTest29() throws Exception {
        File inputFile1=createInputFile6();
        String args[]={"-l",inputFile1.getPath()};
        Main.main(args);
        String expected1="This is an apple.\n"+"I like it! Do you like apples?";
        String actual1=getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1,actual1);
    }

    //Purpose: The option is -l and -e, one or more lines in file and one or more exclamatory sentence in file.
    //Frame #: Test Case 37
    @Test
    public void capitalizeTest30() throws Exception {
        File inputFile1=createInputFile6();
        String args[]={"-l","-e",inputFile1.getPath()};
        Main.main(args);
        String expected1="This is an apple.\n"+"I LIKE IT! Do you like apples?";
        String actual1=getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1,actual1);
    }



    //// help to reach 97%

    @Test
    public void capitalizeTest31() throws Exception {
        File inputFile1=createInputFile2();
        String args[]={""};
        String expected = getFileContent(inputFile1.getPath());
        Main.main(args);
        String actual = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected, actual);
        //assertEquals("The files differ!", expected, actual);
        assertEquals("Usage: Capitalize  [-l] [-e] [-s] [string] [-x] [-c] [boolean] <filename>", errStream.toString().trim());
    }

    //98%

    @Test
    public void capitalizeTest32() throws Exception {
        File inputFile1=createInputFile4();
        String args[]={"-l","-e","-x","-s","-c","false",inputFile1.getPath()};
        Main.main(args);
        String expected1="HERE IS A TEST, JUST A TEST!\n" +
                " It is not fun.";
        String actual1=getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1,actual1);
    }
    //99%

    @Test
    public void capitalizeTest33() throws Exception {
        File inputFile1=createInputFile4();
        String args[]={"-l","-e","-x","-s","a","-c","false",inputFile1.getPath()};
        Main.main(args);
        String expected1="Here is a Test, just a TEST!\n" +
                " it is not fun.";
        String actual1=getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1,actual1);
    }

    //Type d: capitalize fails when delimiter is specified as "\n", probably due to this type (such as whitespace) of delimiters were not taken into consideration.
    @Test
    public void capitalizeTes34() throws Exception {
        File inputFile = createInputFile4();
        String args[] = {"-s","\n", inputFile.getPath()};
        Main.main(args);
        String expected = "Here is a test, just a test!\n"+" It is not fun.";
        String actual = getFileContent(inputFile.getPath());
        assertEquals("The files differ!", expected, actual);
    }
    //Type d: capitalize fails when delimiter is specified as " ", probably due to this type (such as whitespace) of delimiters were not taken into consideration.
    @Test
    public void capitalizeTes35() throws Exception {
        File inputFile = createInputFile4();
        String args[] = {"-s"," ", inputFile.getPath()};
        Main.main(args);
        String expected = "Here Is A Test, Just A Test!\n"+" It Is Not Fun.";
        String actual = getFileContent(inputFile.getPath());
        assertEquals("The files differ!", expected, actual);
    }

    //Type d: capitalize fails when has duplicate options (even occurrence), propbaly due to the lack of capitalize operation for this case.
    @Test
    public void capitalizeTes36() throws Exception {
        File inputFile = createInputFile4();
        String args[] = {"-e","-e",inputFile.getPath()};
        Main.main(args);
        String expected = "HERE IS A TEST, JUST A TEST!\n"+" It is not fun.";
        String actual = getFileContent(inputFile.getPath());
        assertEquals("The files differ!", expected, actual);
    }

    //Type d: capitalize falis when the delimiter is capital letters, probably due to the wrong operation order or the lack of capitalize operation for capital letters as delimiter.
    @Test
    public void capitalizeTest37() throws Exception {
        File inputFile = createInputFile4();
        String args[] = {"-s","I","-x",inputFile.getPath()};
        Main.main(args);
        String expected = "Here is a test, just a test!\n" +
                " iT is not fun.";
        String actual = getFileContent(inputFile.getPath());
        assertEquals("The files differ!", expected, actual);
    }

    //Type d: capitalize fails when delimiter is specified as "\r", probably due to this type (such as whitespace) of delimiters were not taken into consideration.
    @Test
    public void mainTest27() throws Exception {
        File inputFile = createInputFile10();
        String args[] = {"-s","\r", inputFile.getPath()};
        Main.main(args);
        String expected = "AppleBananaCarrot.\r" +
                "DogElephantHorse.\r" +
                "Icecream. Jello";
        String actual = getFileContent(inputFile.getPath());
        assertEquals("The files differ!", expected, actual);
    }

    @Test
    public void capitalizeTest38() throws Exception {
        File inputFile = createInputFile4();
        String args[] = {"-s","i","-x",inputFile.getPath()};
        Main.main(args);
        String expected = "Here iS a test, just a test!\n" +
                " iT iS not fun.";
        String actual = getFileContent(inputFile.getPath());
        assertEquals("The files differ!", expected, actual);
    }
}
