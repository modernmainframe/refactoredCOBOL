package com.ibm.wcaz.implementation;

import com.ibm.jzos.fields.BinaryAsBigDecimalField;
import com.ibm.jzos.fields.BinaryAsLongField;
import com.ibm.jzos.fields.CobolDatatypeFactory;
import com.ibm.jzos.fields.StringField;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Arrays;

public class DclcbsAcctMstrDtl implements Comparable<DclcbsAcctMstrDtl> {
    private BigDecimal h1AccountNumber = BigDecimal.ZERO;
    private String h1AccountName = "";
    private long h1CustomerId;
    
    public DclcbsAcctMstrDtl() {}
    
    public DclcbsAcctMstrDtl(BigDecimal h1AccountNumber, String h1AccountName, long h1CustomerId) {
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
    
    public BigDecimal getH1AccountNumber() {
        return this.h1AccountNumber;
    }
    
    public void setH1AccountNumber(BigDecimal h1AccountNumber) {
        this.h1AccountNumber = h1AccountNumber;
    }
    
    public String getH1AccountName() {
        return this.h1AccountName;
    }
    
    public void setH1AccountName(String h1AccountName) {
        this.h1AccountName = h1AccountName;
    }
    
    public long getH1CustomerId() {
        return this.h1CustomerId;
    }
    
    public void setH1CustomerId(long h1CustomerId) {
        this.h1CustomerId = h1CustomerId;
    }
    
    public void reset() {
        h1AccountNumber = BigDecimal.ZERO;
        h1AccountName = "";
        h1CustomerId = 0;
    }
    
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("{ h1AccountNumber=\"");
        s.append(getH1AccountNumber());
        s.append("\"");
        s.append(", h1AccountName=\"");
        s.append(getH1AccountName());
        s.append("\"");
        s.append(", h1CustomerId=\"");
        s.append(getH1CustomerId());
        s.append("\"");
        s.append("}");
        return s.toString();
    }
    
    public boolean equals(DclcbsAcctMstrDtl that) {
        return this.h1AccountNumber.compareTo(that.h1AccountNumber) == 0 &&
            this.h1AccountName.equals(that.h1AccountName) &&
            this.h1CustomerId == that.h1CustomerId;
    }
    
    @Override
    public boolean equals(Object that) {
        return (that instanceof DclcbsAcctMstrDtl) && this.equals((DclcbsAcctMstrDtl)that);
    }
    
    @Override
    public int hashCode() {
        return h1AccountNumber.unscaledValue().hashCode() ^
            Integer.rotateLeft(h1AccountName.hashCode(), 1) ^
            Integer.rotateLeft(Long.hashCode(h1CustomerId), 2);
    }
    
    @Override
    public int compareTo(DclcbsAcctMstrDtl that) {
        int c = 0;
        c = this.h1AccountNumber.compareTo(that.h1AccountNumber);
        if ( c != 0 ) return c;
        c = this.h1AccountName.compareTo(that.h1AccountName);
        if ( c != 0 ) return c;
        c = Long.compare(this.h1CustomerId, that.h1CustomerId);
        return c;
    }
    
    // Start of COBOL-compatible binary serialization metadata
    private static CobolDatatypeFactory factory = new CobolDatatypeFactory();
    static {
        factory.setStringTrimDefault(true);
        factory.setStringEncoding("IBM-1047");
    }
    
    private static final BinaryAsBigDecimalField H1ACCOUNTNUMBER = factory.getBinaryAsBigDecimalField(19, 0, true);
    private static final StringField H1ACCOUNTNAME = factory.getStringField(50);
    private static final BinaryAsLongField H1CUSTOMERID = factory.getBinaryAsLongField(10, true);
    public static final int SIZE = factory.getOffset();
    // End of COBOL-compatible binary serialization metadata
    
    public byte[] getBytes(byte[] bytes, int offset) {
        H1ACCOUNTNUMBER.putBigDecimal(h1AccountNumber, bytes, offset);
        H1ACCOUNTNAME.putString(h1AccountName, bytes, offset);
        H1CUSTOMERID.putLong(h1CustomerId, bytes, offset);
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
        h1AccountNumber = H1ACCOUNTNUMBER.getBigDecimal(bytes, offset);
        h1AccountName = H1ACCOUNTNAME.getString(bytes, offset);
        h1CustomerId = H1CUSTOMERID.getLong(bytes, offset);
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
