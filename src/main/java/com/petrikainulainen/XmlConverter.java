package com.petrikainulainen;

/**
 * @see https://www.journaldev.com/1237/java-convert-string-to-xml-document-and-xml-document-to-string
 */
public class XmlConverter {

    public static void main(String[] args) {

        String messageFaultReason = "<ns3:tokenStatusUpdated xmlns:ns3=\"http://sab/\" xmlns:ns4=\"http://ws.wso2.org/dataservice\"><ns3:requestId>01a3e0c5-d876-4fa0-a91e-56bb8c7e7bc6</ns3:requestId><ns3:tokenRefId>DTC1MC0000171740bf9605c539fe4c41834520eeb0719137</ns3:tokenRefId><ns3:tokenRequestorId>40010030273</ns3:tokenRequestorId><ns3:messageReasonCode>STATUS_UPDATE</ns3:messageReasonCode><ns3:status>S</ns3:status><ns3:ips>M</ns3:ips><ns3:panInternalId>CardID12</ns3:panInternalId><ns3:panInternalGUID>CardID1111111112</ns3:panInternalGUID></ns3:tokenStatusUpdated>";
        String tagName = "ns3:requestId";

        System.out.println("tagValue = " + StringUtil.getElementsByTagName(messageFaultReason, tagName));

    }
}