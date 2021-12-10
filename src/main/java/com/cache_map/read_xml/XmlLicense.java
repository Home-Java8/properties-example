package com.cache_map.read_xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "License")
public class XmlLicense {

    XmlDescription description;

    public XmlDescription getDescription() {
        return description;
    }

    @XmlElement(name = "Description")
    public void setDescription(XmlDescription description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "License{ " +
                description +
                " }";
    }
}
