package com.ibm.wcaz.implementation;

import com.ibm.jzos.fields.CobolDatatypeFactory;
import com.ibm.jzos.fields.ExternalDecimalAsLongField;
import com.ibm.jzos.fields.StringField;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Csrgres implements Comparable<Csrgres> {
    private String customerName = "";
    private long customerId;
    private String messages = "";
    
    public Csrgres() {}
    
    public Csrgres(String customerName, long customerId, String messages) {
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
    
    public long getCustomerId() {
        return this.customerId;
    }
    
    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
    
    public String getMessages() {
        return this.messages;
    }
    
    public void setMessages(String messages) {
        this.messages = messages;
    }
    
    public void reset() {
        customerName = "";
        customerId = 0;
        messages = "";
    }
    
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("{ customerName=\"");
        s.append(getCustomerName());
        s.append("\"");
        s.append(", customerId=\"");
        s.append(getCustomerId());
        s.append("\"");
        s.append(", messages=\"");
        s.append(getMessages());
        s.append("\"");
        s.append("}");
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
            Integer.rotateLeft(Long.hashCode(customerId), 1) ^
            Integer.rotateLeft(messages.hashCode(), 2);
    }
    
    @Override
    public int compareTo(Csrgres that) {
        int c = 0;
        c = this.customerName.compareTo(that.customerName);
        if ( c != 0 ) return c;
        c = Long.compare(this.customerId, that.customerId);
        if ( c != 0 ) return c;
        c = this.messages.compareTo(that.messages);
        return c;
    }
    
    // Start of COBOL-compatible binary serialization metadata
    private static CobolDatatypeFactory factory = new CobolDatatypeFactory();
    static {
        factory.setStringTrimDefault(true);
        factory.setStringEncoding("IBM-1047");
    }
    
    private static final StringField CUSTOMERNAME = factory.getStringField(50);
    private static final ExternalDecimalAsLongField CUSTOMERID = factory.getExternalDecimalAsLongField(10, true);
    private static final StringField MESSAGES = factory.getStringField(100);
    public static final int SIZE = factory.getOffset();
    // End of COBOL-compatible binary serialization metadata
    
    public byte[] getBytes(byte[] bytes, int offset) {
        CUSTOMERNAME.putString(customerName, bytes, offset);
        CUSTOMERID.putLong(customerId, bytes, offset);
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
        customerId = CUSTOMERID.getLong(bytes, offset);
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
