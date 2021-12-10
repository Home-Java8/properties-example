package com.cache_map.read_xml;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * @see https://mkyong.com/java/jaxb-hello-world-example
 */

public class JAXBExample {
    public static void main(String[] args) {
        try {
//            File file = new File("/home/alexandr/devel/IdeaProjects/FASTTACK-1.5.0/staff.xml");
            File file = new File("/home/alexandr/devel/IdeaProjects/FASTTACK-1.5.0/license.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(XmlLicense.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            XmlLicense license = (XmlLicense) jaxbUnmarshaller.unmarshal(file);
            System.out.println(license);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
