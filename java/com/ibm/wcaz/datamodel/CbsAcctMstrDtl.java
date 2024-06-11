package com.ibm.wcaz.datamodel;

import com.ibm.jzos.fields.CobolDatatypeFactory;
import com.ibm.jzos.fields.ExternalDecimalAsIntField;
import com.ibm.jzos.fields.StringField;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class CbsAcctMstrDtl implements Comparable<CbsAcctMstrDtl> {
    private int accountNumber;
    private String baseBranch = "";
    private String accountName = "";
    private String productCode = "";
    private int customerId;
    private String accountStatus = "";
    private int paymentLimit;
    private String currency = "";
    private String complianceStatus = "";
    private Date lastActivityDate = new Date(0);
    private String updUserid = "";
    private Date updTimestamp = new Date(0);
    
    public CbsAcctMstrDtl() {}
    
    public CbsAcctMstrDtl(int accountNumber, String baseBranch, String accountName, String productCode, int customerId, String accountStatus, int paymentLimit, String currency, String complianceStatus, Date lastActivityDate, String updUserid, Date updTimestamp) {
        this.accountNumber = accountNumber;
        this.baseBranch = baseBranch;
        this.accountName = accountName;
        this.productCode = productCode;
        this.customerId = customerId;
        this.accountStatus = accountStatus;
        this.paymentLimit = paymentLimit;
        this.currency = currency;
        this.complianceStatus = complianceStatus;
        this.lastActivityDate = lastActivityDate;
        this.updUserid = updUserid;
        this.updTimestamp = updTimestamp;
    }
    
    public CbsAcctMstrDtl(CbsAcctMstrDtl that) {
        this.accountNumber = that.accountNumber;
        this.baseBranch = that.baseBranch;
        this.accountName = that.accountName;
        this.productCode = that.productCode;
        this.customerId = that.customerId;
        this.accountStatus = that.accountStatus;
        this.paymentLimit = that.paymentLimit;
        this.currency = that.currency;
        this.complianceStatus = that.complianceStatus;
        this.lastActivityDate = that.lastActivityDate;
        this.updUserid = that.updUserid;
        this.updTimestamp = that.updTimestamp;
    }
    
    protected CbsAcctMstrDtl(byte[] bytes, int offset) {
        setBytes(bytes, offset);
    }
    
    protected CbsAcctMstrDtl(byte[] bytes) {
        this(bytes, 0);
    }
    
    public static CbsAcctMstrDtl fromBytes(byte[] bytes, int offset) {
        return new CbsAcctMstrDtl(bytes, offset);
    }
    
    public static CbsAcctMstrDtl fromBytes(byte[] bytes) {
        return fromBytes(bytes, 0);
    }
    
    public static CbsAcctMstrDtl fromBytes(String bytes) {
        try {
            return fromBytes(bytes.getBytes(factory.getStringEncoding()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public int getAccountNumber() {
        return this.accountNumber;
    }
    
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    public String getBaseBranch() {
        return this.baseBranch;
    }
    
    public void setBaseBranch(String baseBranch) {
        this.baseBranch = baseBranch;
    }
    
    public String getAccountName() {
        return this.accountName;
    }
    
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    
    public String getProductCode() {
        return this.productCode;
    }
    
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    
    public int getCustomerId() {
        return this.customerId;
    }
    
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    
    public String getAccountStatus() {
        return this.accountStatus;
    }
    
    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }
    
    public int getPaymentLimit() {
        return this.paymentLimit;
    }
    
    public void setPaymentLimit(int paymentLimit) {
        this.paymentLimit = paymentLimit;
    }
    
    public String getCurrency() {
        return this.currency;
    }
    
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    
    public String getComplianceStatus() {
        return this.complianceStatus;
    }
    
    public void setComplianceStatus(String complianceStatus) {
        this.complianceStatus = complianceStatus;
    }
    
    public Date getLastActivityDate() {
        return this.lastActivityDate;
    }
    
    public void setLastActivityDate(Date lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }
    
    public String getUpdUserid() {
        return this.updUserid;
    }
    
    public void setUpdUserid(String updUserid) {
        this.updUserid = updUserid;
    }
    
    public Date getUpdTimestamp() {
        return this.updTimestamp;
    }
    
    public void setUpdTimestamp(Date updTimestamp) {
        this.updTimestamp = updTimestamp;
    }
    public void reset() {
        accountNumber = 0;
        baseBranch = "";
        accountName = "";
        productCode = "";
        customerId = 0;
        accountStatus = "";
        paymentLimit = 0;
        currency = "";
        complianceStatus = "";
        lastActivityDate = new Date(0);
        updUserid = "";
        updTimestamp = new Date(0);
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("{ accountNumber=\"");
        s.append(getAccountNumber());
        s.append("\"");
        s.append(", baseBranch=\"");
        s.append(getBaseBranch());
        s.append("\"");
        s.append(", accountName=\"");
        s.append(getAccountName());
        s.append("\"");
        s.append(", productCode=\"");
        s.append(getProductCode());
        s.append("\"");
        s.append(", customerId=\"");
        s.append(getCustomerId());
        s.append("\"");
        s.append(", accountStatus=\"");
        s.append(getAccountStatus());
        s.append("\"");
        s.append(", paymentLimit=\"");
        s.append(getPaymentLimit());
        s.append("\"");
        s.append(", currency=\"");
        s.append(getCurrency());
        s.append("\"");
        s.append(", complianceStatus=\"");
        s.append(getComplianceStatus());
        s.append("\"");
        s.append(", lastActivityDate=\"");
        s.append(getLastActivityDate());
        s.append("\"");
        s.append(", updUserid=\"");
        s.append(getUpdUserid());
        s.append("\"");
        s.append(", updTimestamp=\"");
        s.append(getUpdTimestamp());
        s.append("\"");
        s.append("}");
        return s.toString();
    }
    
    public boolean equals(CbsAcctMstrDtl that) {
        return this.accountNumber == that.accountNumber &&
            this.baseBranch.equals(that.baseBranch) &&
            this.accountName.equals(that.accountName) &&
            this.productCode.equals(that.productCode) &&
            this.customerId == that.customerId &&
            this.accountStatus.equals(that.accountStatus) &&
            this.paymentLimit == that.paymentLimit &&
            this.currency.equals(that.currency) &&
            this.complianceStatus.equals(that.complianceStatus) &&
            this.lastActivityDate.equals(that.lastActivityDate) &&
            this.updUserid.equals(that.updUserid) &&
            this.updTimestamp.equals(that.updTimestamp);
    }
    
    @Override
    public boolean equals(Object that) {
        return (that instanceof CbsAcctMstrDtl) && this.equals((CbsAcctMstrDtl)that);
    }
    
    @Override
    public int hashCode() {
        return Integer.hashCode(accountNumber) ^
            Integer.rotateLeft(baseBranch.hashCode(), 1) ^
            Integer.rotateLeft(accountName.hashCode(), 2) ^
            Integer.rotateLeft(productCode.hashCode(), 3) ^
            Integer.rotateLeft(Integer.hashCode(customerId), 4) ^
            Integer.rotateLeft(accountStatus.hashCode(), 5) ^
            Integer.rotateLeft(Integer.hashCode(paymentLimit), 6) ^
            Integer.rotateLeft(currency.hashCode(), 7) ^
            Integer.rotateLeft(complianceStatus.hashCode(), 8) ^
            Integer.rotateLeft(lastActivityDate.hashCode(), 9) ^
            Integer.rotateLeft(updUserid.hashCode(), 10) ^
            Integer.rotateLeft(updTimestamp.hashCode(), 11);
    }
    
    @Override
    public int compareTo(CbsAcctMstrDtl that) {
        int c = 0;
        c = Integer.compare(this.accountNumber, that.accountNumber);
        if ( c != 0 ) return c;
        c = this.baseBranch.compareTo(that.baseBranch);
        if ( c != 0 ) return c;
        c = this.accountName.compareTo(that.accountName);
        if ( c != 0 ) return c;
        c = this.productCode.compareTo(that.productCode);
        if ( c != 0 ) return c;
        c = Integer.compare(this.customerId, that.customerId);
        if ( c != 0 ) return c;
        c = this.accountStatus.compareTo(that.accountStatus);
        if ( c != 0 ) return c;
        c = Integer.compare(this.paymentLimit, that.paymentLimit);
        if ( c != 0 ) return c;
        c = this.currency.compareTo(that.currency);
        if ( c != 0 ) return c;
        c = this.complianceStatus.compareTo(that.complianceStatus);
        if ( c != 0 ) return c;
        c = this.lastActivityDate.compareTo(that.lastActivityDate);
        if ( c != 0 ) return c;
        c = this.updUserid.compareTo(that.updUserid);
        if ( c != 0 ) return c;
        c = this.updTimestamp.compareTo(that.updTimestamp);
        return c;
    }
    
    // Start of COBOL-compatible binary serialization metadata
    private static CobolDatatypeFactory factory = new CobolDatatypeFactory();
    static {
        factory.setStringTrimDefault(true);
        factory.setStringEncoding("IBM-1047");
    }
    
    private static final ExternalDecimalAsIntField ACCOUNT_NUMBER = factory.getExternalDecimalAsIntField(9, true);
    private static final StringField BASE_BRANCH = factory.getStringField(21);
    private static final StringField ACCOUNT_NAME = factory.getStringField(51);
    private static final StringField PRODUCT_CODE = factory.getStringField(6);
    private static final ExternalDecimalAsIntField CUSTOMER_ID = factory.getExternalDecimalAsIntField(5, true);
    private static final StringField ACCOUNT_STATUS = factory.getStringField(11);
    private static final ExternalDecimalAsIntField PAYMENT_LIMIT = factory.getExternalDecimalAsIntField(5, true);
    private static final StringField CURRENCY = factory.getStringField(4);
    private static final StringField COMPLIANCE_STATUS = factory.getStringField(6);
    private static final StringField LAST_ACTIVITY_DATE = factory.getStringField(8);
    private static final DateTimeFormatter LAST_ACTIVITY_DATE_FMT = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static final StringField UPD_USERID = factory.getStringField(11);
    private static final StringField UPD_TIMESTAMP = factory.getStringField(14);
    private static final DateTimeFormatter UPD_TIMESTAMP_FMT = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    public static final int SIZE = factory.getOffset();
    // End of COBOL-compatible binary serialization metadata
    
    public byte[] getBytes(byte[] bytes, int offset) {
        ACCOUNT_NUMBER.putInt(accountNumber, bytes, offset);
        BASE_BRANCH.putString(baseBranch, bytes, offset);
        ACCOUNT_NAME.putString(accountName, bytes, offset);
        PRODUCT_CODE.putString(productCode, bytes, offset);
        CUSTOMER_ID.putInt(customerId, bytes, offset);
        ACCOUNT_STATUS.putString(accountStatus, bytes, offset);
        PAYMENT_LIMIT.putInt(paymentLimit, bytes, offset);
        CURRENCY.putString(currency, bytes, offset);
        COMPLIANCE_STATUS.putString(complianceStatus, bytes, offset);
        LAST_ACTIVITY_DATE.putString(lastActivityDate.toLocalDate().format(LAST_ACTIVITY_DATE_FMT), bytes, offset);
        UPD_USERID.putString(updUserid, bytes, offset);
        UPD_TIMESTAMP.putString(updTimestamp.toLocalDate().format(UPD_TIMESTAMP_FMT), bytes, offset);
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
            return new String(getBytes(), factory.getStringEncoding()).stripTrailing();
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
        accountNumber = ACCOUNT_NUMBER.getInt(bytes, offset);
        baseBranch = BASE_BRANCH.getString(bytes, offset);
        accountName = ACCOUNT_NAME.getString(bytes, offset);
        productCode = PRODUCT_CODE.getString(bytes, offset);
        customerId = CUSTOMER_ID.getInt(bytes, offset);
        accountStatus = ACCOUNT_STATUS.getString(bytes, offset);
        paymentLimit = PAYMENT_LIMIT.getInt(bytes, offset);
        currency = CURRENCY.getString(bytes, offset);
        complianceStatus = COMPLIANCE_STATUS.getString(bytes, offset);
        lastActivityDate = Date.valueOf(LocalDate.parse(LAST_ACTIVITY_DATE.getString(bytes, offset), LAST_ACTIVITY_DATE_FMT));
        updUserid = UPD_USERID.getString(bytes, offset);
        updTimestamp = Date.valueOf(LocalDate.parse(UPD_TIMESTAMP.getString(bytes, offset), UPD_TIMESTAMP_FMT));
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
