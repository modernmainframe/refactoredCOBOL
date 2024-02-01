      ******************************************************************
      * Created: Thu, 1 Feb 2024 10:23:59 GMT
      * Generated by: IBM watsonx Code Assistant for Z Refactoring
      * Assistant
      * Workbook name: TCSCUSCR
      * Workbook id: 89b107c1-eeb6-460a-aa09-88cb6c952a93
      * Project: $clientCOBOL_26adc4dd-ca1f-49f8-a75e-d1b44b0ce646
      ******************************************************************

       IDENTIFICATION DIVISION.
       PROGRAM-ID. TCSCUSCR.

       DATA DIVISION.
       WORKING-STORAGE SECTION.
      ******************************************************************
      *  COPY SQLCA.
      * PATH : .../Cobol Include/SQLCA
      * THE FOLLOWING VARIABLES ARE USED FROM THE COPYBOOK :
      * 01 SQLCA.
      *     05 SQLCODE     PIC S9(9) COMP-5.
      ******************************************************************
      * PATH : .../zOS Cobol/TCSCUSCR.cbl
       01  CUSTOMER.
      ******************************************************************
           COPY CUSTCPY.
      * PATH : .../Cobol Include/CUSTCPY
      * THE FOLLOWING VARIABLES ARE USED FROM THE COPYBOOK :
      *    10 CUSTOMER-ID                PIC 9(9).
      *    10 CUSTOMER-NAME              PIC X(60).
      *    10 CUSTOMER-ADDRESS           PIC X(250).
      *    10 CUSTOMER-AGE               PIC 999.
      *    10 CUSTOMER-STATUS            PIC X.
      ******************************************************************
      * PATH : .../zOS Cobol/TCSCUSCR.cbl
       01 CUST-RETURN-CODE             PIC 99.
       01  CUSTOMER-COPY.
      ******************************************************************
           COPY LCUST.
      * PATH : .../Cobol Include/LCUST
      * THE FOLLOWING VARIABLES ARE USED FROM THE COPYBOOK :
      *    10 L-CUSTOMER-ID              PIC S9(9) USAGE COMP.
      ******************************************************************
       COPY CUSTCONS.
      * PATH : .../Cobol Include/CUSTCONS
      * THE FOLLOWING VARIABLES ARE USED FROM THE COPYBOOK :
      *01  CUSTOMER-CONSTANTS.
      *    10 CUSTOMER-OPERFAIL   PIC 99 VALUE 0.
      *    10 CUSTOMER-OPERSUCC   PIC 99 VALUE 3.
      ******************************************************************

      * SQLCA DB2 communications area
           EXEC SQL
             INCLUDE SQLCA
           END-EXEC.

           EXEC SQL
             INCLUDE CUSTOMER
           END-EXEC.

       LINKAGE SECTION.

       PROCEDURE DIVISION.
      ******************************************************************
      * PROGRAM NAME : Program:COBOL:TCSCUSCR
      * PROGRAM PATH : .../zOS Cobol/TCSCUSCR.cbl
      * STMT START LINE NUMBER : 220
      * STMT END LINE NUMBER : 244
       INSERT-NEW-CUSTOMER.
           EXEC SQL
             INSERT INTO
                    CUSTOMER
                    ( CUID ,
                      CUSTNAME ,
                      ADDRESS ,
                      AGE ,
                      STATUS )
             VALUES
                    ( :CUSTOMER-ID ,
                      :CUSTOMER-NAME ,
                      :CUSTOMER-ADDRESS ,
                      :CUSTOMER-AGE ,
                      :CUSTOMER-STATUS )
           END-EXEC.
           IF SQLCODE NOT = 0
              MOVE CUSTOMER-OPERFAIL TO CUST-RETURN-CODE
              DISPLAY '(TCSCUSCR) INSERT OPERATON FAILED.'
               ' SQLCODE=' SQLCODE
           ELSE
              MOVE CUSTOMER-OPERSUCC TO CUST-RETURN-CODE
              MOVE CUSTOMER-ID TO L-CUSTOMER-ID
              DISPLAY '(TCSCUSCR) CUSTOMER ADDED TO DATABASE.'
           END-IF.
      ******************************************************************
           EXIT PROGRAM.
