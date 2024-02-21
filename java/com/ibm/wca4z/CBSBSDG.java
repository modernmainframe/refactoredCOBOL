package com.ibm.wca4z;

import com.ibm.jzos.fields.CobolDatatypeFactory;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;

public class CBSBSDG implements Comparable<CBSBSDG> {
    public CBSBSDG() {}
    
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
    
    
    
    public static void checkAcctStatus(){
    Csrgres csrgres = new Csrgres();
    String wsAccountStatus = "";

    csrgres.setMessages("CHECK STATUS PARA");
    if (wsAccountStatus.equals("ACTIVE    ")) {
        csrgres.setMessages("DEREGISTER STARTING");
        csrgres.deregAcctStats();
    }
    else if (wsAccountStatus.equals("INACTIVE")) {
        csrgres.setMessages("CUSTOMER IS NOT REGISTERED");
    }
    else if (wsAccountStatus.equals("OTHER")) {
        csrgres.setMessages("NOT Y OR N");
        csrgres.setMessages("PLEASE CONTACT BANK");
    }
}

    
    public static void deregAcctStats(){
    Csrgres csrgres = new Csrgres();
    DclcbsAcctMstrDtl dclcbsAcctMstrDtl = new DclcbsAcctMstrDtl();
    String wkInactive = "INACTIVE";

    csrgres.setCustomerName(dclcbsAcctMstrDtl.getH1AccountName());
    csrgres.setCustomerId(dclcbsAcctMstrDtl.getH1CustomerId());
    System.out.println("DEREGISTER PARA");
    try {
        String sql = "UPDATE CBS_ACCT_MSTR_DTL SET ACCOUNT_STATUS = ? WHERE ACCOUNT_NUMBER = ?";
        PreparedStatement ps = JdbcConnection.connection.prepareStatement(sql);
        ps.setString(1, wkInactive);
        ps.setBigDecimal(2, dclcbsAcctMstrDtl.getH1AccountNumber());
        ps.executeUpdate();
        ps.close();
    }
    catch(SQLException exception){
        System.out.println(exception);
        return;
    }
    System.out.println(exception);
    csrgres.setMessages("CUSTOMER DEREGISTERED SUCESSFULLY");
}

    
    public static void deregAcctStatsExit() {}
    
    public static void main(String[] args) {
        checkAcctStatus();
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("}");
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
    
    // Start of COBOL-compatible binary serialization metadata
    private static CobolDatatypeFactory factory = new CobolDatatypeFactory();
    static {
        factory.setStringTrimDefault(true);
        factory.setStringEncoding("IBM-1047");
    }
    
    public static final int SIZE = factory.getOffset();
    // End of COBOL-compatible binary serialization metadata
    
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
