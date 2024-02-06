package com.ibm.wca4z;

import com.ibm.jzos.fields.*;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;

public class CBSBSDG implements Comparable<CBSBSDG> {
    // Start of COBOL-compatible binary serialization metadata
    private static CobolDatatypeFactory factory = new CobolDatatypeFactory();
    static {
        factory.setStringTrimDefault(true);
        factory.setStringEncoding("IBM-1047");
    }
    
    protected static final int SIZE = factory.getOffset();
    // End of COBOL-compatible binary serialization metadata
    public CBSBSDG() {
    }
    
    public CBSBSDG(CBSBSDG that) {
    }
    
    protected CBSBSDG(byte[] bytes, int offset) {
        setBytes(bytes, offset);
    }
    
    protected CBSBSDG(byte[] bytes) {
        this(bytes, 0);
    }
    
    public static CBSBSDG fromBytes(byte[] bytes, int offset) {
        return new CBSBSDG(bytes, offset);
    }
    
    public static CBSBSDG fromBytes(byte[] bytes) {
        return fromBytes(bytes, 0);
    }
    
    public static CBSBSDG fromBytes(String bytes) {
        try {
            return fromBytes(bytes.getBytes(factory.getStringEncoding()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void deregAcctStats(String[] args){
    Csrgres csrgres = new Csrgres();
    DclcbsAcctMstrDtl dclcbsAcctMstrDtl = new DclcbsAcctMstrDtl();
    String wkInactive = "INACTIVE";

    csrgres.setCustomerName(dclcbsAcctMstrDtl.getH1AccountName());
    csrgres.setCustomerId(dclcbsAcctMstrDtl.getH1CustomerId());
    System.out.println("DEREGISTER PARA");
    try {
        // sql select
        String sql0 = "update CBS_ACCT_MSTR_DTL set ACCOUNT_STATUS = ? where (ACCOUNT_NUMBER = ?)";
        PreparedStatement ps0 = DriverManager.getConnection("endpoint_url").prepareStatement(sql0);
        ps0.setString(1, wkInactive);
        ps0.setLong(2, dclcbsAcctMstrDtl.getH1AccountNumber());
        ps0.executeUpdate();
        ps0.close();
    } catch (SQLException e) {
        System.out.println(e);
    }
    System.out.println(e);
    csrgres.setMessages("CUSTOMER DEREGISTERED SUCESSFULLY");
}


    
    public static void deregAcctStats(String[] args) {}
    
    public static void main(String[] args) {}
    
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
    
    @Override
    public int hashCode() {
        return 0;
    }
    
    @Override
    public int compareTo(CBSBSDG that) {
        int c = 0;
        return c;
    }
    
    public byte[] getBytes(byte[] bytes, int offset) {
        return bytes;
    }
    
    public final byte[] getBytes(byte[] bytes) {
        return getBytes(bytes, 0);
    }
    
    public final byte[] getBytes() {
        return getBytes(new byte[numBytes()]);
    }
    
    public final String toByteString() {
        try {
            return new String(getBytes(), factory.getStringEncoding());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void setBytes(byte[] bytes, int offset) {
        if (bytes.length < SIZE + offset) {
            byte[] newBytes = Arrays.copyOf(bytes, SIZE + offset);
            Arrays.fill(newBytes, bytes.length, SIZE + offset, (byte)0x40 /*default EBCDIC space character*/);
            bytes = newBytes;
        }
    }
    
    public final void setBytes(byte[] bytes) {
        setBytes(bytes, 0);
    }
    
    public final void setBytes(String bytes) {
        try {
            setBytes(bytes.getBytes(factory.getStringEncoding()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public int numBytes() {
        return SIZE;
    }
}
