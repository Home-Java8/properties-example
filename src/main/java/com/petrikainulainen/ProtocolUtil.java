package com.petrikainulainen;

import org.apache.commons.lang3.StringUtils;

public final class ProtocolUtil {

    private static ProtocolUtil instance;

    private String protocol = Protocol.HTTP.getName();

    private String host = "localhost";

    private int port = 80;

    private ProtocolUtil() {
    }

    public static synchronized ProtocolUtil getInstance(String host) {
        instance = new ProtocolUtil();
        if (StringUtils.isNotBlank(host)) {
            instance.host = host.replace(Protocol.HTTPS.getValue(), "").replace(Protocol.HTTP.getValue(), "").replace("://", "");
            if (host.contains(Protocol.HTTPS.getValue())) instance.protocol = Protocol.HTTPS.getName();
            else if (!host.contains("://") || host.contains(Protocol.HTTP.getValue())) instance.protocol = Protocol.HTTP.getName();
        }
        return instance;
    }

    public static synchronized ProtocolUtil getInstance(String host, String port) {
        instance = getInstance(host);
        if (StringUtils.isNotBlank(port) && isInteger(port)) instance.port = Integer.parseInt(port);
        return instance;
    }

    public static synchronized ProtocolUtil getInstance(String host, int port) {
        instance = getInstance(host);
        instance.port = port;
        return instance;
    }

    public String getHost() {
        return host;
    }

    public String getProtocol() {
        return protocol;
    }

    public int getPort() {
        return port;
    }

    private static boolean isInteger(Object obj) {
        if(obj instanceof Integer) {
            return true;
        } else {
            try {
                Integer.parseInt(obj.toString());
            } catch(NumberFormatException ex) {
                return false;
            }
        }

        return true;
    }
}
