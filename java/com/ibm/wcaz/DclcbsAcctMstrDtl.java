package com.ibm.wcaz;

import com.ibm.jzos.fields.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DclcbsAcctMstrDtl implements Comparable<DclcbsAcctMstrDtl> {
    private static CobolDatatypeFactory factory = new CobolDatatypeFactory();
    static {
        factory.setStringTrimDefault(true);
    }
    
    private static final StringField H1_ACCOUNT_NAME = factory.getStringField(50);
    private static final BinaryAsIntField H1_CUSTOMER_ID = factory.getBinaryAsIntField(9, true);
    public static final int SIZE = factory.getOffset();
    private static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");
    private byte[] bytes = new byte[SIZE];
    
    private long h1AccountNumber;
    private String h1AccountName = "";
    private int h1CustomerId;
    
    public DclcbsAcctMstrDtl() {}
    public DclcbsAcctMstrDtl(byte[] bytes) { this.setBytes(bytes); }
    
    
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
    
    public byte[] getBytes() {
        H1_ACCOUNT_NAME.putString(h1AccountName, bytes);
        H1_CUSTOMER_ID.putInt(h1CustomerId, bytes);
        return bytes;
    }
    
    public void setBytes(byte[] bytes) {
        h1AccountName = H1_ACCOUNT_NAME.getString(bytes);
        h1CustomerId = H1_CUSTOMER_ID.getInt(bytes);
        return ;
    }
    
    public int numBytes() {
        int length = SIZE;
        return length;
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
}
