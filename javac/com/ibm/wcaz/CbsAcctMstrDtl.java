package com.ibm.wcaz;

import com.ibm.jzos.fields.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CbsAcctMstrDtl implements Comparable<CbsAcctMstrDtl> {
    private static CobolDatatypeFactory factory = new CobolDatatypeFactory();
    static {
        factory.setStringTrimDefault(true);
    }
    
    private static final BinaryAsIntField ACCOUNT_NUMBER = factory.getBinaryAsIntField(9, true);
    private static final StringField BASE_BRANCH = factory.getStringField(21);
    private static final StringField ACCOUNT_NAME = factory.getStringField(51);
    private static final StringField PRODUCT_CODE = factory.getStringField(6);
    private static final BinaryAsIntField CUSTOMER_ID = factory.getBinaryAsIntField(5, true);
    private static final StringField ACCOUNT_STATUS = factory.getStringField(11);
    private static final BinaryAsIntField PAYMENT_LIMIT = factory.getBinaryAsIntField(5, true);
    private static final StringField CURRENCY = factory.getStringField(4);
    private static final StringField COMPLIANCE_STATUS = factory.getStringField(6);
    private static final StringField LAST_ACTIVITY_DATE = factory.getStringField(8, false);
    private static final StringField UPD_USERID = factory.getStringField(11);
    private static final StringField UPD_TIMESTAMP = factory.getStringField(8, false);
    public static final int SIZE = factory.getOffset();
    private static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");
    private byte[] bytes = new byte[SIZE];
    
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
    public CbsAcctMstrDtl(byte[] bytes) { this.setBytes(bytes); }
    
    
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
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("{ accountNumber=\"");
        s.append(getAccountNumber());
        s.append("\" baseBranch=\"");
        s.append(getBaseBranch());
        s.append("\" accountName=\"");
        s.append(getAccountName());
        s.append("\" productCode=\"");
        s.append(getProductCode());
        s.append("\" customerId=\"");
        s.append(getCustomerId());
        s.append("\" accountStatus=\"");
        s.append(getAccountStatus());
        s.append("\" paymentLimit=\"");
        s.append(getPaymentLimit());
        s.append("\" currency=\"");
        s.append(getCurrency());
        s.append("\" complianceStatus=\"");
        s.append(getComplianceStatus());
        s.append("\" lastActivityDate=\"");
        s.append(getLastActivityDate().toString());
        s.append("\" updUserid=\"");
        s.append(getUpdUserid());
        s.append("\" updTimestamp=\"");
        s.append(getUpdTimestamp().toString());
        s.append("\" }");
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
    
    public byte[] getBytes() {
        ACCOUNT_NUMBER.putInt(accountNumber, bytes);
        BASE_BRANCH.putString(baseBranch, bytes);
        ACCOUNT_NAME.putString(accountName, bytes);
        PRODUCT_CODE.putString(productCode, bytes);
        CUSTOMER_ID.putInt(customerId, bytes);
        ACCOUNT_STATUS.putString(accountStatus, bytes);
        PAYMENT_LIMIT.putInt(paymentLimit, bytes);
        CURRENCY.putString(currency, bytes);
        COMPLIANCE_STATUS.putString(complianceStatus, bytes);
        LAST_ACTIVITY_DATE.putString(lastActivityDate.toLocalDate().format(DATE_FORMATTER), bytes);
        UPD_USERID.putString(updUserid, bytes);
        UPD_TIMESTAMP.putString(updTimestamp.toLocalDate().format(DATE_FORMATTER), bytes);
        return bytes;
    }
    
    public void setBytes(byte[] bytes) {
        accountNumber = ACCOUNT_NUMBER.getInt(bytes);
        baseBranch = BASE_BRANCH.getString(bytes);
        accountName = ACCOUNT_NAME.getString(bytes);
        productCode = PRODUCT_CODE.getString(bytes);
        customerId = CUSTOMER_ID.getInt(bytes);
        accountStatus = ACCOUNT_STATUS.getString(bytes);
        paymentLimit = PAYMENT_LIMIT.getInt(bytes);
        currency = CURRENCY.getString(bytes);
        complianceStatus = COMPLIANCE_STATUS.getString(bytes);
        lastActivityDate = Date.valueOf(LocalDate.parse(LAST_ACTIVITY_DATE.getString(bytes), DATE_FORMATTER));
        updUserid = UPD_USERID.getString(bytes);
        updTimestamp = Date.valueOf(LocalDate.parse(UPD_TIMESTAMP.getString(bytes), DATE_FORMATTER));
        return ;
    }
    
    public int numBytes() {
        int length = SIZE;
        return length;
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
        int c = Integer.compare(this.accountNumber, that.accountNumber);
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
}
