package easy; /**
 ***The Goal
 * MIME types are used in numerous internet protocols to associate a media type (html, image, video ...) with the content sent.
 * The MIME type is generally inferred from the extension of the file to be sent.
 *
 * You have to write a program that makes it possible to detect the MIME type of a file based on its name.
 *
 ***Rules
 *
 * You are provided with a table which associates MIME types to file extensions.
 * You are also given a list of names of files to be transferred and for each one of these files, you must find the MIME type to be used.
 *
 * The extension of a file is defined as the substring which follows the last occurrence, if any, of the dot character within the file name.
 * If the extension for a given file can be found in the association table (case insensitive, e.g. TXT is treated the same way as txt), then print the corresponding MIME type.
 * If it is not possible to find the MIME type corresponding to a file, or if the file doesn’t have an extension, print UNKNOWN.
 *
 ***Game Input
 *
 * Line 1: Number N of elements which make up the association table.
 * Line 2: Number Q of file names to be analyzed.
 * N following lines: One file extension per line and the corresponding MIME type (separated by a blank space).
 * Q following lines: One file name per line.
 *
 ***Output
 *
 * For each of the Q filenames, display on a line the corresponding MIME type.
 * If there is no corresponding type, then display UNKNOWN.
 *
 ***Constraints
 *
 * 0 < N < 10000
 * 0 < Q < 10000
 * File extensions are composed of a maximum of 10 alphanumerical ASCII characters.
 * MIME types are composed of a maximum 50 alphanumerical and punctuation ASCII characters.
 * File names are composed of a maximum of 256 alphanumerical ASCII characters and dots (full stops).
 * There are no spaces in the file names, extensions or MIME types.
 **/
import java.util.*;

class MIMEType {
    private static Map<String,String> keysAndValues = new HashMap<>();
    private static Scanner in = new Scanner(System.in);
    
    public static void main(String args[])throws Exception {
        
        int associationTableSize = in.nextInt();
        associationTableSize = associationTableSize < 10000 ? associationTableSize : 9999;
        int testAmount = in.nextInt();
        
        loadAssociationTable(associationTableSize);
        in.nextLine();
        
        LinkedList<String> results = new LinkedList<>();
        executeTestInputAndGenerateOutput(results,testAmount);
        
        printOutput(results);
    }
    private static void loadAssociationTable(int associationTableSize){
        for (int i = 0; i < associationTableSize; i++) {
            String extension = in.next();
            String mimeType = in.next();
            if (mimeType.length() <=50 && extension.length() <=10) {
                keysAndValues.put(extension.toLowerCase(), mimeType);
            }
        }
    }
    private static List<String> executeTestInputAndGenerateOutput(List<String> results, int testAmount){
        for (int i = 0; i < testAmount; i++) {
            String fileName = in.nextLine();
            
            if (fileName.length() > 256 || fileName.contains(" ")) {
                results.add("UNKNOWN");
                continue;
            } else if (fileName.endsWith(".")){
                results.add("UNKNOWN");
                continue;
            }
            
            String[] nameAndExt = fileName.split("[.]+", 0);
            
            if (nameAndExt.length == 1) {
                results.add("UNKNOWN");
            }
            else {
                String extensionToCheck = nameAndExt[nameAndExt.length - 1];
                extensionToCheck = extensionToCheck.toLowerCase();
                
                if (keysAndValues.containsKey(extensionToCheck)) {
                    String type = keysAndValues.get(extensionToCheck);
                    results.add(type);
                } else {
                    results.add("UNKNOWN");
                }
            }
        }
        return results;
    }
    
    private static void printOutput(List<String> list){
        for (String mimeType : list){
            System.out.println(mimeType);
        }
    }
}