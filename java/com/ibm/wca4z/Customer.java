package com.ibm.wca4z;

import com.ibm.jzos.fields.*;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Customer implements Comparable<Customer> {
    // Start of COBOL-compatible binary serialization metadata
    private static CobolDatatypeFactory factory = new CobolDatatypeFactory();
    static {
        factory.setStringTrimDefault(true);
        factory.setStringEncoding("IBM-1047");
    }
    
    private static final ExternalDecimalAsIntField CUID = factory.getExternalDecimalAsIntField(5, true);
    private static final StringField CUSTNAME = factory.getStringField(61);
    private static final StringField ADDRESS1 = factory.getStringField(251);
    private static final ExternalDecimalAsIntField AGE = factory.getExternalDecimalAsIntField(5, true);
    private static final StringField STATUS1 = factory.getStringField(2);
    protected static final int SIZE = factory.getOffset();
    // End of COBOL-compatible binary serialization metadata
    
    private int cuid;
    private String custname = "";
    private String address1 = "";
    private int age;
    private String status1 = "";
    
    public Customer() {
    }
    
    public Customer(int cuid, String custname, String address1, int age, String status1) {
        this.cuid = cuid;
        this.custname = custname;
        this.address1 = address1;
        this.age = age;
        this.status1 = status1;
    }
    
    public Customer(Customer that) {
        this.cuid = that.cuid;
        this.custname = that.custname;
        this.address1 = that.address1;
        this.age = that.age;
        this.status1 = that.status1;
    }
    
    protected Customer(byte[] bytes, int offset) {
        setBytes(bytes, offset);
    }
    
    protected Customer(byte[] bytes) {
        this(bytes, 0);
    }
    
    public static Customer fromBytes(byte[] bytes, int offset) {
        return new Customer(bytes, offset);
    }
    
    public static Customer fromBytes(byte[] bytes) {
        return fromBytes(bytes, 0);
    }
    
    public static Customer fromBytes(String bytes) {
        try {
            return fromBytes(bytes.getBytes(factory.getStringEncoding()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public int getCuid() {
        return this.cuid;
    }
    
    public void setCuid(int cuid) {
        this.cuid = cuid;
    }
    
    public String getCustname() {
        return this.custname;
    }
    
    public void setCustname(String custname) {
        this.custname = custname;
    }
    
    public String getAddress1() {
        return this.address1;
    }
    
    public void setAddress1(String address1) {
        this.address1 = address1;
    }
    
    public int getAge() {
        return this.age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getStatus1() {
        return this.status1;
    }
    
    public void setStatus1(String status1) {
        this.status1 = status1;
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("{ cuid=\"");
        s.append(getCuid());
        s.append("\" custname=\"");
        s.append(getCustname());
        s.append("\" address1=\"");
        s.append(getAddress1());
        s.append("\" age=\"");
        s.append(getAge());
        s.append("\" status1=\"");
        s.append(getStatus1());
        s.append("\" }");
        return s.toString();
    }
    
    public boolean equals(Customer that) {
        return this.cuid == that.cuid &&
            this.custname.equals(that.custname) &&
            this.address1.equals(that.address1) &&
            this.age == that.age &&
            this.status1.equals(that.status1);
    }
    
    @Override
    public boolean equals(Object that) {
        return (that instanceof Customer) && this.equals((Customer)that);
    }
    
    @Override
    public int hashCode() {
        return Integer.hashCode(cuid) ^
            Integer.rotateLeft(custname.hashCode(), 1) ^
            Integer.rotateLeft(address1.hashCode(), 2) ^
            Integer.rotateLeft(Integer.hashCode(age), 3) ^
            Integer.rotateLeft(status1.hashCode(), 4);
    }
    
    @Override
    public int compareTo(Customer that) {
        int c = Integer.compare(this.cuid, that.cuid);
        if ( c != 0 ) return c;
        c = this.custname.compareTo(that.custname);
        if ( c != 0 ) return c;
        c = this.address1.compareTo(that.address1);
        if ( c != 0 ) return c;
        c = Integer.compare(this.age, that.age);
        if ( c != 0 ) return c;
        c = this.status1.compareTo(that.status1);
        return c;
    }
    
    public byte[] getBytes(byte[] bytes, int offset) {
        CUID.putInt(cuid, bytes, offset);
        CUSTNAME.putString(custname, bytes, offset);
        ADDRESS1.putString(address1, bytes, offset);
        AGE.putInt(age, bytes, offset);
        STATUS1.putString(status1, bytes, offset);
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
        cuid = CUID.getInt(bytes, offset);
        custname = CUSTNAME.getString(bytes, offset);
        address1 = ADDRESS1.getString(bytes, offset);
        age = AGE.getInt(bytes, offset);
        status1 = STATUS1.getString(bytes, offset);
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
