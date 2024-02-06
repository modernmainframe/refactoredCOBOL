package com.ibm.wca4z;

import com.ibm.jzos.fields.*;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Csrgres implements Comparable<Csrgres> {
    // Start of COBOL-compatible binary serialization metadata
    private static CobolDatatypeFactory factory = new CobolDatatypeFactory();
    static {
        factory.setStringTrimDefault(true);
        factory.setStringEncoding("IBM-1047");
    }
    
    private static final StringField CUSTOMERNAME = factory.getStringField(50);
    private static final ExternalDecimalAsIntField CUSTOMERID = factory.getExternalDecimalAsIntField(9, true);
    private static final StringField MESSAGES = factory.getStringField(100);
    protected static final int SIZE = factory.getOffset();
    // End of COBOL-compatible binary serialization metadata
    
    private String customerName = "";
    private int customerId;
    private String messages = "";
    
    public Csrgres() {
    }
    
    public Csrgres(String customerName, int customerId, String messages) {
        this.customerName = customerName;
        this.customerId = customerId;
        this.messages = messages;
    }
    
    public Csrgres(Csrgres that) {
        this.customerName = that.customerName;
        this.customerId = that.customerId;
        this.messages = that.messages;
    }
    
    protected Csrgres(byte[] bytes, int offset) {
        setBytes(bytes, offset);
    }
    
    protected Csrgres(byte[] bytes) {
        this(bytes, 0);
    }
    
    public static Csrgres fromBytes(byte[] bytes, int offset) {
        return new Csrgres(bytes, offset);
    }
    
    public static Csrgres fromBytes(byte[] bytes) {
        return fromBytes(bytes, 0);
    }
    
    public static Csrgres fromBytes(String bytes) {
        try {
            return fromBytes(bytes.getBytes(factory.getStringEncoding()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public String getCustomerName() {
        return this.customerName;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    public int getCustomerId() {
        return this.customerId;
    }
    
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    
    public String getMessages() {
        return this.messages;
    }
    
    public void setMessages(String messages) {
        this.messages = messages;
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("{ customerName=\"");
        s.append(getCustomerName());
        s.append("\" customerId=\"");
        s.append(getCustomerId());
        s.append("\" messages=\"");
        s.append(getMessages());
        s.append("\" }");
        return s.toString();
    }
    
    public boolean equals(Csrgres that) {
        return this.customerName.equals(that.customerName) &&
            this.customerId == that.customerId &&
            this.messages.equals(that.messages);
    }
    
    @Override
    public boolean equals(Object that) {
        return (that instanceof Csrgres) && this.equals((Csrgres)that);
    }
    
    @Override
    public int hashCode() {
        return customerName.hashCode() ^
            Integer.rotateLeft(Integer.hashCode(customerId), 1) ^
            Integer.rotateLeft(messages.hashCode(), 2);
    }
    
    @Override
    public int compareTo(Csrgres that) {
        int c = this.customerName.compareTo(that.customerName);
        if ( c != 0 ) return c;
        c = Integer.compare(this.customerId, that.customerId);
        if ( c != 0 ) return c;
        c = this.messages.compareTo(that.messages);
        return c;
    }
    
    public byte[] getBytes(byte[] bytes, int offset) {
        CUSTOMERNAME.putString(customerName, bytes, offset);
        CUSTOMERID.putInt(customerId, bytes, offset);
        MESSAGES.putString(messages, bytes, offset);
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
        customerName = CUSTOMERNAME.getString(bytes, offset);
        customerId = CUSTOMERID.getInt(bytes, offset);
        messages = MESSAGES.getString(bytes, offset);
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
