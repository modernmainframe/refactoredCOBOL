package com.ibm.wcaz;

import com.ibm.jzos.fields.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Csrgres implements Comparable<Csrgres> {
    private static CobolDatatypeFactory factory = new CobolDatatypeFactory();
    static {
        factory.setStringTrimDefault(true);
    }
    
    private static final StringField CUSTOMER_NAME = factory.getStringField(50);
    private static final BinaryAsIntField CUSTOMER_ID = factory.getBinaryAsIntField(9, true);
    private static final StringField MESSAGES = factory.getStringField(100);
    public static final int SIZE = factory.getOffset();
    private static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");
    private byte[] bytes = new byte[SIZE];
    
    private String customerName = "";
    private int customerId;
    private String messages = "";
    
    public Csrgres() {}
    public Csrgres(byte[] bytes) { this.setBytes(bytes); }
    
    
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
    
    public byte[] getBytes() {
        CUSTOMER_NAME.putString(customerName, bytes);
        CUSTOMER_ID.putInt(customerId, bytes);
        MESSAGES.putString(messages, bytes);
        return bytes;
    }
    
    public void setBytes(byte[] bytes) {
        customerName = CUSTOMER_NAME.getString(bytes);
        customerId = CUSTOMER_ID.getInt(bytes);
        messages = MESSAGES.getString(bytes);
        return ;
    }
    
    public int numBytes() {
        int length = SIZE;
        return length;
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
}
