package com.petrikainulainen;

import java.net.URL;

/**
 * @see https://prog.kiev.ua/forum/index.php?topic=375.0
 */

public final class AddressUtil2 {

    private static AddressUtil2 instance;

    private String protocol;

    private String host;

    private int port;

    private String path;

    private String parameters;

    private AddressUtil2() {

    }

    public static synchronized AddressUtil2 getInstance(String address) {
        instance = new AddressUtil2();
        try {
            URL url = new URL(address);
            instance.protocol = url.getProtocol();
            instance.host = url.getHost();
            instance.port = url.getPort() != -1 ? url.getPort() : 80;
            instance.path = url.getPath();
            instance.parameters = url.getQuery();
        } catch (Exception e) { }
        return instance;
    }

    public String getProtocol() {
        return protocol;
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

    public String getParameters() {
        return parameters;
    }

    public static void main(String[] args) {
//        String address = "http://server.com:80/page?a=1&b=2";
//        String address = "http://ww.example.com:78/dresses/real.htm?productid=1202938";
//        String address = "http://ww.example.com:78/dresses/real.htm";
//        String address = "http://ww.example.com/dresses/real.htm";

        ///
//        String address = "https://sandbox.api.mastercard.com/mdes/csapi/v2/";
        String address = "https://sandbox.api.mastercard.com:443/mdes/csapi/v2/";

        AddressUtil2 parser = AddressUtil2.getInstance(address);

        StringBuilder sb = new StringBuilder();
        sb.append("Protocol = " + parser.getProtocol() + "\n")
                .append("Host = " + parser.getHost() + " \n")
                .append("Port = " + parser.getPort() + "\n")
                .append("Path = " + parser.getPath() + " \n")
                .append("Parameters = " + parser.getParameters() + " \n");
        System.out.println(sb.toString());

        ///
        address = "http://ww.example.com/dresses/real.htm";

        parser = AddressUtil2.getInstance(address);

        sb = new StringBuilder();
        sb.append("Host = " + parser.getHost() + " \n")
                .append("Port = " + parser.getPort() + "\n")
                .append("Path = " + parser.getPath() + " \n")
                .append("Parameters = " + parser.getParameters() + " \n");
        System.out.println(sb.toString());

///
        address = "https://ww.example.com:78/dresses/real.htm?productid=1202938";
//        address = "http://ww.example.com:78/dresses/real.htm?productid=1202938";

        parser = AddressUtil2.getInstance(address);

        sb = new StringBuilder();
        sb.append("Protocol = " + parser.getProtocol() + "\n")
                .append("Host = " + parser.getHost() + " \n")
                .append("Port = " + parser.getPort() + "\n")
                .append("Path = " + parser.getPath() + " \n")
                .append("Parameters = " + parser.getParameters() + " \n");
        System.out.println(sb.toString());

///
//        address = null;
//        address = "";
//        address = "192.168.1.95";
//        address = "http://192.168.1.95";
        address = "https://192.168.1.95";

//        ProtocolUtil proxy = ProtocolUtil.getInstance(address);
//        ProtocolUtil proxy = ProtocolUtil.getInstance(address, null);
//        ProtocolUtil proxy = ProtocolUtil.getInstance(address, "");
//        ProtocolUtil proxy = ProtocolUtil.getInstance(address, "  ");
//        ProtocolUtil proxy = ProtocolUtil.getInstance(address, "a");
//        ProtocolUtil proxy = ProtocolUtil.getInstance(address, 81);
        ProtocolUtil proxy = ProtocolUtil.getInstance(address, "82");
        System.out.println("Protocol = " + proxy.getProtocol());
        System.out.println("Host = " + proxy.getHost());
        System.out.println("Port = " + proxy.getPort());
    }
}
