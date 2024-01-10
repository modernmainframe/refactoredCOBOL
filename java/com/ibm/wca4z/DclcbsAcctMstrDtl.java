package com.ibm.wca4z;

import com.ibm.jzos.fields.*;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class DclcbsAcctMstrDtl implements Comparable<DclcbsAcctMstrDtl> {
    // Start of COBOL-compatible binary serialization metadata
    private static CobolDatatypeFactory factory = new CobolDatatypeFactory();
    static {
        factory.setStringTrimDefault(true);
        factory.setStringEncoding("IBM-1047");
    }
    
    private static final BinaryAsLongField H1ACCOUNTNUMBER = factory.getBinaryAsLongField(18, true);
    private static final StringField H1ACCOUNTNAME = factory.getStringField(50);
    private static final BinaryAsIntField H1CUSTOMERID = factory.getBinaryAsIntField(9, true);
    protected static final int SIZE = factory.getOffset();
    // End of COBOL-compatible binary serialization metadata
    
    private long h1AccountNumber;
    private String h1AccountName = "";
    private int h1CustomerId;
    
    public DclcbsAcctMstrDtl() {
    }
    
    public DclcbsAcctMstrDtl(long h1AccountNumber, String h1AccountName, int h1CustomerId) {
        this.h1AccountNumber = h1AccountNumber;
        this.h1AccountName = h1AccountName;
        this.h1CustomerId = h1CustomerId;
    }
    
    public DclcbsAcctMstrDtl(DclcbsAcctMstrDtl that) {
        this.h1AccountNumber = that.h1AccountNumber;
        this.h1AccountName = that.h1AccountName;
        this.h1CustomerId = that.h1CustomerId;
    }
    
    protected DclcbsAcctMstrDtl(byte[] bytes, int offset) {
        setBytes(bytes, offset);
    }
    
    protected DclcbsAcctMstrDtl(byte[] bytes) {
        this(bytes, 0);
    }
    
    public static DclcbsAcctMstrDtl fromBytes(byte[] bytes, int offset) {
        return new DclcbsAcctMstrDtl(bytes, offset);
    }
    
    public static DclcbsAcctMstrDtl fromBytes(byte[] bytes) {
        return fromBytes(bytes, 0);
    }
    
    public static DclcbsAcctMstrDtl fromBytes(String bytes) {
        try {
            return fromBytes(bytes.getBytes(factory.getStringEncoding()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public long getH1AccountNumber() {
        return this.h1AccountNumber;
    }
    
    public void setH1AccountNumber(long h1AccountNumber) {
        this.h1AccountNumber = h1AccountNumber;
    }
    
    public String getH1AccountName() {
        return this.h1AccountName;
    }
    
    public void setH1AccountName(String h1AccountName) {
        this.h1AccountName = h1AccountName;
    }
    
    public int getH1CustomerId() {
        return this.h1CustomerId;
    }
    
    public void setH1CustomerId(int h1CustomerId) {
        this.h1CustomerId = h1CustomerId;
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("{ h1AccountNumber=\"");
        s.append(getH1AccountNumber());
        s.append("\" h1AccountName=\"");
        s.append(getH1AccountName());
        s.append("\" h1CustomerId=\"");
        s.append(getH1CustomerId());
        s.append("\" }");
        return s.toString();
    }
    
    public boolean equals(DclcbsAcctMstrDtl that) {
        return this.h1AccountNumber == that.h1AccountNumber &&
            this.h1AccountName.equals(that.h1AccountName) &&
            this.h1CustomerId == that.h1CustomerId;
    }
    
    @Override
    public boolean equals(Object that) {
        return (that instanceof DclcbsAcctMstrDtl) && this.equals((DclcbsAcctMstrDtl)that);
    }
    
    @Override
    public int hashCode() {
        return Long.hashCode(h1AccountNumber) ^
            Integer.rotateLeft(h1AccountName.hashCode(), 1) ^
            Integer.rotateLeft(Integer.hashCode(h1CustomerId), 2);
    }
    
    @Override
    public int compareTo(DclcbsAcctMstrDtl that) {
        int c = Long.compare(this.h1AccountNumber, that.h1AccountNumber);
        if ( c != 0 ) return c;
        c = this.h1AccountName.compareTo(that.h1AccountName);
        if ( c != 0 ) return c;
        c = Integer.compare(this.h1CustomerId, that.h1CustomerId);
        return c;
    }
    
    public byte[] getBytes(byte[] bytes, int offset) {
        H1ACCOUNTNUMBER.putLong(h1AccountNumber, bytes, offset);
        H1ACCOUNTNAME.putString(h1AccountName, bytes, offset);
        H1CUSTOMERID.putInt(h1CustomerId, bytes, offset);
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
        h1AccountNumber = H1ACCOUNTNUMBER.getLong(bytes, offset);
        h1AccountName = H1ACCOUNTNAME.getString(bytes, offset);
        h1CustomerId = H1CUSTOMERID.getInt(bytes, offset);
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
