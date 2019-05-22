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


    private String getFileContent(String filename) {
        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get(filename)), charset);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

     // test cases

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
    @Test
    public void capitalizeTest4() throws Exception {
        File inputFile1=createInputFile2();
        String args[]={"-l", "-e", "-x", "-s", "$", inputFile1.getPath()};
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
    @Test
    public void capitalizeTest10() throws Exception {
        File inputFile1=createInputFile2();
        String args[]={"-e", "-x", "-s", ",", inputFile1.getPath()};
        Main.main(args);
        String expected1="Howdy billy,\n" +
                "This is a test file for the capitalize utility.\n" +
                "let's make sure it has at least a few lines,\n" +
                "So that we can create some \n"
                + "interesting test cases...AND LET'S SAY \"HOWDY\" TO BILL AGAIN!\n"+
                "is this ok for you?";
        String actual1=getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1,actual1);
    }

    //Purpose: The option is -e and -s, specified string of delimiter, the presence of exclamatory sentence is one or more, the presence of specified delimiter is one or more.
    //Frame #: Test Case 74
    @Test
    public void capitalizeTest11() throws Exception {
        File inputFile1=createInputFile2();
        String args[]={"-e", "-s", ",", inputFile1.getPath()};
        Main.main(args);
        String expected1="Howdy Billy,\n" +
                "This is a test file for the capitalize utility.\n" +
                "let's make sure it has at least a few lines,\n" +
                "So that we can create some \n"
                + "interesting test cases...AND LET'S SAY \"HOWDY\" TO BILL AGAIN!\n"+
                "is this OK for you?";
        String actual1=getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1,actual1);
    }

    //Purpose: The option is -e and -x, the presence of exclamatory sentence in File one or more, the presence of capital letters that do not meet the specified capitalization rules is one or more.
    //Frame #: Test Case 80
    @Test
    public void capitalizeTest12() throws Exception {
        File inputFile1=createInputFile2();
        String args[]={"-e", "-x", inputFile1.getPath()};
        Main.main(args);
        String expected1="Howdy billy,\n" +
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
    @Test
    public void capitalizeTest22() throws Exception {
        File inputFile1=createInputFile5();
        String args[]={"-s", "z",inputFile1.getPath()};
        Main.main(args);
        String expected1="this is an apple";
        String actual1=getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected1,actual1);
    }

    //Purpose: The option is -s only,  default delimiter, and the presence of delimiters is zero.
    //Frame #: Test Case 93
    @Test
    public void capitalizeTest23() throws Exception {
        File inputFile1=createInputFile5();
        String args[]={"-s", inputFile1.getPath()};
        Main.main(args);
        String expected1="this is an apple";
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


}
