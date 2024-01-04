      ******************************************************************
      * DCLGEN TABLE(COREBK.CBS_ACCT_MSTR_DTL)                         *
      *        LIBRARY(IBMUSER.DCLGEN.CASE(CBSMST))                    *
      *        LANGUAGE(COBOL)                                         *
      *        NAMES(H1-)                                              *
      *        QUOTE                                                   *
      *        LABEL(YES)                                              *
      *        COLSUFFIX(YES)                                          *
      *        INDVAR(YES)                                             *
      * ... IS THE DCLGEN COMMAND THAT MADE THE FOLLOWING STATEMENTS   *
      ******************************************************************
           EXEC SQL DECLARE CBS_ACCT_MSTR_DTL TABLE
           ( ACCOUNT_NUMBER                 BIGINT NOT NULL,
             BASE_BRANCH                    CHAR(20) NOT NULL,
             ACCOUNT_NAME                   CHAR(50) NOT NULL,
             PRODUCT_CODE                   CHAR(5) NOT NULL,
             CUSTOMER_ID                    INTEGER NOT NULL,
             ACCOUNT_STATUS                 CHAR(10) NOT NULL,
             PAYMENT_LIMIT                  INTEGER NOT NULL,
             CURRENCY                       CHAR(3) NOT NULL,
             COMPLIANCE_STATUS              CHAR(5) NOT NULL,
             LAST_ACTIVITY_DATE             DATE NOT NULL,
             UPD_USERID                     CHAR(10) NOT NULL,
             UPD_TIMESTAMP                  TIMESTAMP NOT NULL
           ) END-EXEC.