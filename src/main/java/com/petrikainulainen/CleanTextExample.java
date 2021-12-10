package com.petrikainulainen;

public class CleanTextExample {

    public static void main(String[] args) {
        String uncleanContent = "Ж~öäü how to do in java . com A função, Ãugent";
        System.out.println(uncleanContent);

        String cleanContent = cleanTextContent(uncleanContent);
        System.out.println(cleanContent);
    }

    private static String cleanTextContent(String text) {
        text = text.replaceAll("[^\\x00-\\x7F]", ""); //TODO:  strips off all non-ASCII characters
        text = text.replaceAll("[\\p{Cntrl}&&[^\r\n\t]]", ""); //TODO:   erases all the ASCII control characters
        text = text.replaceAll("\\p{C}", ""); //TODO:   removes non-printable characters from Unicode
        return text.trim();
    }

}
