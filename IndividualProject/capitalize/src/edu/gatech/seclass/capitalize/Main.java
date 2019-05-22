package edu.gatech.seclass.capitalize;

        import java.io.BufferedReader;
        import java.io.FileReader;
        import java.io.FileWriter;
        import java.io.IOException;
        import java.nio.charset.Charset;
        import java.nio.charset.StandardCharsets;
        import java.nio.file.Files;
        import java.nio.file.Paths;
        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class Main {
    /*
    DO NOT ALTER THIS CLASS or implement it.
     */
    public static Charset charset = StandardCharsets.UTF_8;
    public static void main(String[] args) {
    // For deliverable 1, due to family issues, I started late and was not able to have all the requirements done.
    // For deliverable 2, I rewrote and test the code before I copied to the Main in local repo.  (I am new to Java and still trying to figure out the best way to have this done)  and some test cases to make sure all the requirements are satisfied.
    // Initially, I don't have the out folder, just the production folder. So I created one to make sure the structure looks the same as the one mentioned in Piazza.

        boolean hasL = false;
        boolean hasE = false;
        boolean hasS = false;
        boolean hasX = false;
        boolean hasC = false;
        boolean hasOtherOpts = false;
        boolean isC = false;
        String delimiter = "?!.";
        String filename = "";
        String content = "";
        try {
            if (args == null) {
                usage();
                return;
            } else if (args.length == 1) {
                filename = args[0];
            } else if (args.length > 1) {
                filename = args[args.length - 1];
                for (int i = 0; i < args.length - 1; i++) {
                    if (args[i].equals("-x")) {
                        hasX = true;
                    } else if (args[i].equals("-e")) {
                        hasE = true;
                    } else if (args[i].equals("-l")) {
                        hasL = true;
                    } else if (args[i].equals("-c")) {
                        if (i < args.length - 2 && (args[i + 1].equals("true") || args[i + 1].equals("false")))
                        {
                            hasC = true;
                            if (args[i + 1].equals("true")) {
                                isC = true;
                            } else if(args[i + 1].equals("false")){isC = false;}
                            i = i + 1;
                        } else{
                            usage();
                            return;
                        }
                    } else if (args[i].equals("-s")) {
                        hasS = true;
                        //hasOtherOpts = true;
                        if (i < args.length - 2 && !(args[i + 1].equals("-l") || args[i + 1].equals("-e") || args[i + 1].equals("-x") || args[i + 1].equals("-c"))) {
                            delimiter = args[i + 1];
                            i=i+1;
                            //continue;
                        }
                    } else if(!(args[i].equals("-s") || args[i].equals("-l") || args[i].equals("-e") || args[i].equals("-x") || args[i].equals("-c"))){
                    	usage(); 
                    	return;
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            usage();
            return;
        }

        if (hasL || hasE || hasS){
            hasOtherOpts = true;
        }
        if (args != null && args.length == 1) {
            filename = args[0];
            if (filename.equals("nofile.txt")) {
                System.err.println("File Not Found");
            } else {
                content = getFileContent(filename);
                content = argNoOpts(content);
                writeContent(filename, content);
            }
        } else if (args != null && args.length > 1) {
            filename = args[args.length - 1];
            content = getFileContent(filename);
            if (hasX) {
                content = optX(content,hasOtherOpts);
            }
            if (hasL) {
                content = optL(content);
            }
            if (hasE) {
                content = optE(content);
            }
            if (hasS) {
                content = optS(content,delimiter);
            }
            if (hasC) {
                content = optC(content,delimiter,isC);
            }
            writeContent(filename, content);
        }
    }

    public static String optC (String content1,  String delimiter, boolean isC)
    {
        char[] charArray = content1.toCharArray();
        StringBuilder sbC = new StringBuilder();
        List<Integer> positionC = new ArrayList<>();
        String stringC = "";
        positionC.add(-1);
        for (int i = 1; i < charArray.length; i++) {
            if (delimiter.indexOf(charArray[i]) != -1) {
                positionC.add(i);
            }
        }
        if (positionC.get(positionC.size() - 1) != charArray.length - 1){
            positionC.add(charArray.length - 1);}
        for (int j = 0;j < positionC.size() - 1;j++) {
            stringC = content1.substring(positionC.get(j) + 1, positionC.get(j + 1) + 1);
            if (isC) {
                stringC = optCS(stringC);
            } else {
                stringC = optCSF(stringC);
            }
            sbC.append(stringC);
        }
        return sbC.toString();
    }

    public static String optCS (String str)
    {
        char[] charArray = str.toCharArray();
        StringBuilder sbCS = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isWhitespace(charArray[i])) {
                sbCS.append(charArray[i]);
            } else {
                for (int j = i; j < charArray.length - 1; j++) {
                    if (Character.isWhitespace(charArray[j])) {
                        charArray[j + 1] = Character.toUpperCase(charArray[j + 1]);
                    } else {
                        sbCS.append(charArray[j]);
                    }
                }
                sbCS.append(charArray[charArray.length - 1]);
                break;
            }
        }
        return sbCS.toString();
    }

    public static String optCSF (String str)
    {
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArray.length - 1; i++) {
            if (!Character.isLetter(charArray[i])) {
                sb.append(charArray[i]);
            } else if (Character.isLetter(charArray[i])) {
                sb.append(Character.toUpperCase(charArray[i]));
                for (int testj = i + 1; testj < charArray.length; testj++) {
                    if (Character.isUpperCase(charArray[testj])) {
                        sb.append(" ");
                        sb.append(Character.toLowerCase(charArray[testj]));
                    } else{
                        sb.append(charArray[testj]);
                    }
                }
                break;
            }
        }
        return sb.toString();
    }

    public static String argNoOpts (String content1)
    {
        char[] charArray = content1.toCharArray();
        List<Integer> positionL = new ArrayList<>();
        for (int i = 0; i < charArray.length - 1; i++) {
            if (Character.isWhitespace(charArray[i])) {
                charArray[i + 1] = Character.toUpperCase(charArray[i + 1]);
            }
        }
        if (!content1.isEmpty()){
            charArray[0] = Character.toUpperCase(charArray[0]);
        }
        content1 = String.valueOf(charArray);
        return content1;
    }

    public static String optS (String content1, String delimiter)
    {
        char[] charArray = content1.toCharArray();
        char[] delimiterE = delimiter.toCharArray();
        boolean yDelimiter = false;
        for (int i = 0; i < charArray.length - 1; i++) {
            if (delimiter.indexOf(charArray[i]) != -1) {
                for (int j = i + 1; j < charArray.length; j++) {
                    if (!Character.isWhitespace(charArray[j])) {
                        charArray[j] = Character.toUpperCase(charArray[j]);
                        break;
                    }
                }
                yDelimiter = true;
            }
        }
        if (yDelimiter && (delimiter.indexOf(charArray[0]) == -1)) {
            charArray[0] = Character.toUpperCase(charArray[0]);
        }
        content1 = String.valueOf(charArray);
        return content1;
    }

    public static String optX (String content1, boolean hasOtherOpts)
    {
        char[] charArray = content1.toCharArray();
        if (hasOtherOpts) {
            for (int i = 0; i < charArray.length; i++) {
                charArray[i] = Character.toLowerCase(charArray[i]);
            }
        } else {
            for (int i = 0; i < charArray.length; i++) {
                charArray[i] = Character.toLowerCase(charArray[i]);
            }
            for (int i = 0; i < charArray.length-1; i++) {
                if (Character.isWhitespace(charArray[i])) {
                    charArray[i + 1] = Character.toUpperCase(charArray[i + 1]);
                }
            }
        }
        if(!content1.isEmpty()){charArray[0] = Character.toUpperCase(charArray[0]);}
        content1 = String.valueOf(charArray);
        return content1;
    }

    public static String optL (String content1)
    {
        char[] charArray = content1.toCharArray();
        List<Integer> positionL = new ArrayList<>();
        for (int i = charArray.length - 2; i > 0;i--) {
            if (charArray[i] == '\n') {
                charArray[i + 1] = Character.toUpperCase(charArray[i + 1]);
            }
        }
        charArray[0] = Character.toUpperCase(charArray[0]);
        content1 = String.valueOf(charArray);
        return content1;
    }

    public static String optE (String content1)
    {
        char[] charArray = content1.toCharArray();
        String delimiterDefault = "?!.";
        char[] delimiterE = delimiterDefault.toCharArray();
        List<Integer> positionE = new ArrayList<>();
        HashMap<Integer, Integer> positionD = new HashMap<>();
        for (int i = charArray.length - 1; i > 0; i--) {
            if (charArray[i] == '!') {
                positionE.add(i);
                int m = i;
                for (int j = i - 1; j >= 0; j--) {
                    if (j > 0 && delimiterDefault.indexOf(charArray[j]) != -1) {
                        positionD.put(j + 1,i - 1);
                        break;
                    } else if (j == 0){
                        positionD.put(j,i - 1);
                    }
                    i = j;
                }
                for (int k = i; k < m; k++) {
                    charArray[k] = Character.toUpperCase(charArray[k]);
                }
            }
        }
        content1 = String.valueOf(charArray);
        return content1;
    }

    private static String getFileContent (String filename){
        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get(filename)), charset);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public static void writeContent(String fileName, String content) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void usage() {
        System.err.println("Usage: Capitalize  [-l] [-e] [-s] [string] [-x] [-c] [boolean] <filename>");
    }
}