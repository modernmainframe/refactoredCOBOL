      ******************************************************************
      * Created: Wed, 28 Feb 2024 05:31:04 GMT
      * Generated by: IBM watsonx Code Assistant for Z Refactoring
      * Assistant
      * Workbook name: TCSCUSC1
      * Workbook id: d927a3b3-8c1c-4243-ba65-c1ec91d82bef
      * Project: $clientCOBOL_537404f3-898a-4ca1-85f1-2549f1b358cd
      ******************************************************************

       IDENTIFICATION DIVISION.
       PROGRAM-ID. TCSCUSC1.

       ENVIRONMENT DIVISION.
       INPUT-OUTPUT SECTION.
       FILE-CONTROL.
      ******************************************************************
            SELECT OUT-FILE ASSIGN TO OUTFILE
            ORGANIZATION IS SEQUENTIAL
            ACCESS IS SEQUENTIAL
            FILE STATUS IS OUTFILE-STATUS.
      ******************************************************************

       DATA DIVISION.
       FILE SECTION.
      ******************************************************************
       FD OUT-FILE
            RECORD CONTAINS 80
            RECORDING MODE IS F.

      ******************************************************************
      * PATH : .../zOS Cobol/TCSCUSCR.cbl
       01 OUT-FILEREC                  PIC X(80).
      ******************************************************************

       WORKING-STORAGE SECTION.
      ******************************************************************
      * COPY SQLCA.
      * PATH : .../Cobol Include/SQLCA
      * THE FOLLOWING VARIABLES ARE USED FROM THE COPYBOOK :
      * 01 SQLCA.
      *     05 SQLCODE     PIC S9(9) COMP-5.
      ******************************************************************
      * PATH : .../zOS Cobol/TCSCUSCR.cbl
       01  CUSTOMER-COPY.
      ******************************************************************
           COPY LCUST.
      * PATH : .../Cobol Include/LCUST
      * THE FOLLOWING VARIABLES ARE USED FROM THE COPYBOOK :
      *    10 L-CUSTOMER-ID              PIC S9(9) USAGE COMP.
      *    10 L-CUSTOMER-NAME            PIC X(60).
      *    10 L-CUSTOMER-ADDRESS         PIC X(250).
      *    10 L-CUSTOMER-AGE             PIC 999 USAGE COMP.
      *01  CUSTOMER.
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
       01 OUTFILE-STATUS               PIC X(02) VALUE SPACES.
          88 OUTFILE-STATUS-OK         VALUE '00'.
       01 CUST-RETURN-CODE             PIC 99.
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

           OPEN OUTPUT OUT-FILE                                        
           IF NOT OUTFILE-STATUS-OK                                    
              DISPLAY 'ERROR OPENING OUTPUT FILE.'                     
              STOP RUN                                                 
           END-IF. 

      ******************************************************************
      * PROGRAM NAME : Program:COBOL:TCSCUSCR
      * PROGRAM PATH : .../zOS Cobol/TCSCUSCR.cbl
      * STMT START LINE NUMBER : 179
      * STMT END LINE NUMBER : 218
       CREATE-CUSTOMER.
           MOVE L-CUSTOMER-NAME TO CUSTOMER-NAME.
           MOVE L-CUSTOMER-ADDRESS TO CUSTOMER-ADDRESS.
           MOVE L-CUSTOMER-AGE TO CUSTOMER-AGE.
           MOVE 'A' TO CUSTOMER-STATUS.
      * GET-CUSTOMER-ID.
           EXEC SQL
                SELECT COUNT(*)
                  INTO :CUSTOMER-ID
                  FROM CUSTOMER
           END-EXEC.
           IF SQLCODE NOT = 0
              IF SQLCODE = +100
                 PERFORM INSERT-NEW-CUSTOMER
              ELSE
                 MOVE CUSTOMER-OPERFAIL TO CUST-RETURN-CODE
                 DISPLAY '(TCSCUSCR) SELECT OPERATION FAILED.'
                   ' SQLCODE=' SQLCODE
                 DISPLAY '(TCSCUSCR) ASSUMING CUSTOMER-ID 0'
                 MOVE 0 TO CUSTOMER-ID
                 PERFORM INSERT-NEW-CUSTOMER
              END-IF
           ELSE
              PERFORM INSERT-NEW-CUSTOMER
           END-IF.
           MOVE L-CUSTOMER-ID         TO CUSTOMER-ID
           IF CUST-RETURN-CODE = CUSTOMER-OPERSUCC
              DISPLAY 'CUSTOMER CREATION SUCCEEDED.'
              DISPLAY 'CUSTOMER-ID IS ' L-CUSTOMER-ID
              MOVE 'CUSTOMER CREATION SUCCEEDED.' TO OUT-FILEREC
      *       PERFORM WRITE-OUTFILE
              STRING 'CUSTOMER-ID IS ' CUSTOMER-ID
                      DELIMITED BY SIZE
                      INTO OUT-FILEREC
              END-STRING
              PERFORM WRITE-OUTFILE
           ELSE
              DISPLAY 'CUSTOMER CREATION FAILED.'
           END-IF.
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
      * PROGRAM NAME : Program:COBOL:TCSCUSCR
      * PROGRAM PATH : .../zOS Cobol/TCSCUSCR.cbl
      * STMT START LINE NUMBER : 258
      * STMT END LINE NUMBER : 263
       WRITE-OUTFILE.
            WRITE OUT-FILEREC
            INITIALIZE OUT-FILEREC
            IF NOT OUTFILE-STATUS-OK
               DISPLAY 'ERROR WRITING OUTPUT FILE.'
            END-IF.
      ******************************************************************
           EXIT PROGRAM.