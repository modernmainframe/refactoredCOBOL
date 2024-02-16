package com.ibm.wca4z;

import com.ibm.jzos.fields.*;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class CustomerConstants implements Comparable<CustomerConstants> {
    // Start of COBOL-compatible binary serialization metadata
    private static CobolDatatypeFactory factory = new CobolDatatypeFactory();
    static {
        factory.setStringTrimDefault(true);
        factory.setStringEncoding("IBM-1047");
    }
    
    private static final ExternalDecimalAsIntField CUSTOMEROPERFAIL = factory.getExternalDecimalAsIntField(2, true);
    private static final ExternalDecimalAsIntField CUSTOMEROPERSUCC = factory.getExternalDecimalAsIntField(2, true);
    protected static final int SIZE = factory.getOffset();
    // End of COBOL-compatible binary serialization metadata
    
    private int customerOperfail = 0;
    private int customerOpersucc = 3;
    
    public CustomerConstants() {
    }
    
    public CustomerConstants(int customerOperfail, int customerOpersucc) {
        this.customerOperfail = customerOperfail;
        this.customerOpersucc = customerOpersucc;
    }
    
    public CustomerConstants(CustomerConstants that) {
        this.customerOperfail = that.customerOperfail;
        this.customerOpersucc = that.customerOpersucc;
    }
    
    protected CustomerConstants(byte[] bytes, int offset) {
        setBytes(bytes, offset);
    }
    
    protected CustomerConstants(byte[] bytes) {
        this(bytes, 0);
    }
    
    public static CustomerConstants fromBytes(byte[] bytes, int offset) {
        return new CustomerConstants(bytes, offset);
    }
    
    public static CustomerConstants fromBytes(byte[] bytes) {
        return fromBytes(bytes, 0);
    }
    
    public static CustomerConstants fromBytes(String bytes) {
        try {
            return fromBytes(bytes.getBytes(factory.getStringEncoding()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public int getCustomerOperfail() {
        return this.customerOperfail;
    }
    
    public void setCustomerOperfail(int customerOperfail) {
        this.customerOperfail = customerOperfail;
    }
    
    public int getCustomerOpersucc() {
        return this.customerOpersucc;
    }
    
    public void setCustomerOpersucc(int customerOpersucc) {
        this.customerOpersucc = customerOpersucc;
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("{ customerOperfail=\"");
        s.append(getCustomerOperfail());
        s.append("\" customerOpersucc=\"");
        s.append(getCustomerOpersucc());
        s.append("\" }");
        return s.toString();
    }
    
    public boolean equals(CustomerConstants that) {
        return this.customerOperfail == that.customerOperfail &&
            this.customerOpersucc == that.customerOpersucc;
    }
    
    @Override
    public boolean equals(Object that) {
        return (that instanceof CustomerConstants) && this.equals((CustomerConstants)that);
    }
    
    @Override
    public int hashCode() {
        return Integer.hashCode(customerOperfail) ^
            Integer.rotateLeft(Integer.hashCode(customerOpersucc), 1);
    }
    
    @Override
    public int compareTo(CustomerConstants that) {
        int c = Integer.compare(this.customerOperfail, that.customerOperfail);
        if ( c != 0 ) return c;
        c = Integer.compare(this.customerOpersucc, that.customerOpersucc);
        return c;
    }
    
    public byte[] getBytes(byte[] bytes, int offset) {
        CUSTOMEROPERFAIL.putInt(customerOperfail, bytes, offset);
        CUSTOMEROPERSUCC.putInt(customerOpersucc, bytes, offset);
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
        customerOperfail = CUSTOMEROPERFAIL.getInt(bytes, offset);
        customerOpersucc = CUSTOMEROPERSUCC.getInt(bytes, offset);
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
