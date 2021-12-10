package com.petrikainulainen;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;

/**
 * @see https://prog.kiev.ua/forum/index.php?topic=375.0
 */

public class AddressUtil {

    private String address;

    private String host;

    private int port;

    private String path;

    private HashMap<String, String> parameters = new HashMap<>();

    public AddressUtil() {
    }

    public AddressUtil(String address) {
        this.address = address;
    }

    public void parse() {
        String[] hostAndOther = address.split(":");
        host = hostAndOther[0] + ":" + hostAndOther[1];
        host = host.replace("https://", "").replace("http://", "");

        String other = "";
        if (2<hostAndOther.length) {
            other = hostAndOther[2];
            String[] portAndOther = other.split("/");
            port = Integer.valueOf(portAndOther[0]);
        }

//        other = "";
//        for(int i = 1; i < portAndOther.length; i++) other = other + portAndOther[i] + "/";
//        other = other.substring(0, other.length()-1);
//
////        if (other.contains("\\")) {
//            String[] pageAndOther = other.split("\\?");
//            path = pageAndOther[0];
//
//            if (1<pageAndOther.length) {
//            other = pageAndOther[1];
//            String[] map = other.split("&");
//            for (String parametr : map) {
//                String key = parametr.split("=")[0];
//                String value = parametr.split("=")[1];
//                parameters.put(key, value);
//            }
//        }
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getPath() {
        return path;
    }

    public HashMap<String, String> getParameters() {
        return parameters;
    }

    public static void main(String[] args) {
//        String address = "http://ww.example.com:78/dresses/real.htm?productid=1202938";
//        String address = "http://ww.example.com:78/dresses/real.htm";
        String address = "http://ww.example.com/dresses/real.htm";
//        String address = "https://sandbox.api.mastercard.com/mdes/csapi/v2/";

        if (StringUtils.isNotBlank(address)) {
            AddressUtil parser = new AddressUtil(address);
            parser.parse();

            System.out.println("Host : " + parser.getHost());
            System.out.println("Port : " + parser.getPort());
            System.out.println("Path : " + parser.getPath());
            System.out.println("Parameters : " + parser.getParameters());
        }
    }
}
