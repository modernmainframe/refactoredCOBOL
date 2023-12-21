package com.ibm.wcaz;

import com.ibm.jzos.fields.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CBSBSDG implements Comparable<CBSBSDG> {
    private static CobolDatatypeFactory factory = new CobolDatatypeFactory();
    static {
        factory.setStringTrimDefault(true);
    }
    
    private byte[] bytes = null;
    public CBSBSDG() {}
    
    
    public CBSBSDG(CBSBSDG that) {
    }
    
    public static void deregAcctStats() {}
    
    public static void checkAcctStatus() {}
    
    public static void deregAcctStatsExit() {}
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("\" }");
        return s.toString();
    }
    
    public boolean equals(CBSBSDG that) {
        return true;
    }
    
    @Override
    public boolean equals(Object that) {
        return (that instanceof CBSBSDG) && this.equals((CBSBSDG)that);
    }
    
    public byte[] getBytes() {
        bytes = null;
        return bytes;
    }
    
    public void setBytes(byte[] bytes) {
        return ;
    }
    
    public int numBytes() {
        int length = 0;
        return length;
    }
    
    @Override
    public int hashCode() {
        return 0;
    }
    
    @Override
    public int compareTo(CBSBSDG that) {
        int c = 0;
        return c;
    }
}
