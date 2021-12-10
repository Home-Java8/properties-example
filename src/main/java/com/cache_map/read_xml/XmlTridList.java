package com.cache_map.read_xml;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class XmlTridList {
    List<String> trid;

    public List<String> getTrid() {
        return trid;
    }

    @XmlElement(name = "TRID")
    public void setTrid(List<String> trid) {
        this.trid = trid;
    }

    @Override
    public String toString() {
        return trid.toString();
    }
}
