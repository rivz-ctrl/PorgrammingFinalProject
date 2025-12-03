package org.reeves;

public class Address {
    int streetNo;
    String street;
    String city;
    Province province;
    String postalCode;

    public enum Province {
        AB, BC, MB, NB, NL, NT, NS, NU, ON, PE, QC, SK, YT
    }
}
