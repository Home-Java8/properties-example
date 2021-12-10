package com.cache_map.read_xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "XmlDescription")
public class XmlDescription {

    int id;

    String bankName;

    String validUntilDate;

    XmlTridList allowed;

    XmlTridList forbidden;

    boolean pushProvisioning;

    boolean inAppProvisioning;

    public int getId() {
        return id;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public String getBankName() {
        return bankName;
    }

    @XmlElement(name = "BankName")
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getValidUntilDate() {
        return validUntilDate;
    }

    @XmlElement(name = "ValidUntilDate")
    public void setValidUntilDate(String validUntilDate) {
        this.validUntilDate = validUntilDate;
    }

    public XmlTridList getAllowed() {
        return allowed;
    }

    @XmlElement(name = "Allowed")
    public void setAllowed(XmlTridList allowed) {
        this.allowed = allowed;
    }

    public XmlTridList getForbidden() {
        return forbidden;
    }

    @XmlElement(name = "Forbidden")
    public void setForbidden(XmlTridList forbidden) {
        this.forbidden = forbidden;
    }

    public boolean isPushProvisioning() {
        return pushProvisioning;
    }

    @XmlElement(name = "PushProvisioning")
    public void setPushProvisioning(boolean pushProvisioning) {
        this.pushProvisioning = pushProvisioning;
    }

    public boolean isInAppProvisioning() {
        return inAppProvisioning;
    }

    @XmlElement(name = "InAppProvisioning")
    public void setInAppProvisioning(boolean inAppProvisioning) {
        this.inAppProvisioning = inAppProvisioning;
    }

    @Override
    public String toString() {
        return "Description{ " +
                "id=" + id +
                ", bankName='" + bankName + '\'' +
                ", validUntilDate='" + validUntilDate + '\'' +
                ", allowed=" + allowed +
                ", forbidden=" + forbidden +
                ", pushProvisioning=" + pushProvisioning +
                ", inAppProvisioning=" + inAppProvisioning +
                " }";
    }
}
