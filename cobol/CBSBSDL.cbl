      ******************************************************************
      * Created: Wed, 3 Apr 2024 09:29:12 GMT
      * Generated by: IBM watsonx Code Assistant for Z Refactoring
      * Assistant
      * Workbook name: CBSBSDG
      * Workbook id: 68d89a8d-181e-481f-a914-da89d389ae0d
      * Project: $clientCOBOL_e4c1a474-d37d-42c9-bc62-16424fcbedb5
      ******************************************************************

       IDENTIFICATION DIVISION.
       PROGRAM-ID. CBSBSDL.

       DATA DIVISION.
       WORKING-STORAGE SECTION.
        01 WS-ACCOUNT-STATUS  PIC X(10).
        01 WK-CONSTANTS.
           05 WK-INACTIVE              PIC X(10) VALUE 'INACTIVE'.
        01 WG-WORK-AREA.
           02 CSDGRES.
           COPY CSDGRES.
      *COPY CBSMST.
      * COPY SQLCA.

           EXEC SQL
             INCLUDE SQLCA
           END-EXEC.

           EXEC SQL
             INCLUDE CBSMST
           END-EXEC.

       LINKAGE SECTION.

       PROCEDURE DIVISION.
       CHECK-ACCT-STATUS.
           DISPLAY 'CHECK STATUS PARA'
           EVALUATE WS-ACCOUNT-STATUS
              WHEN 'ACTIVE    '
               DISPLAY 'DEREGISTER STARTING'
               MOVE 'ACCOUNT DEREGISTERING' TO MESSAGES
               PERFORM DEREG-ACCT-STATS
                  THRU DEREG-ACCT-STATS-EXIT
              WHEN 'INACTIVE'
               MOVE 'CUSTOMER IS NOT REGISTERED' TO MESSAGES
              WHEN 'OTHER'
               DISPLAY 'NOT Y OR N'
               MOVE 'PLEASE CONTACT BANK' TO MESSAGES
           END-EVALUATE.

       DEREG-ACCT-STATS.
           MOVE H1-ACCOUNT-NAME TO CUSTOMER-NAME.
           MOVE H1-CUSTOMER-ID  TO CUSTOMER-ID.
           DISPLAY 'DEREGISTER PARA'
           EXEC SQL
                UPDATE CBS_ACCT_MSTR_DTL
                   SET ACCOUNT_STATUS = :WK-INACTIVE
                 WHERE ACCOUNT_NUMBER = :H1-ACCOUNT-NUMBER
           END-EXEC.
           DISPLAY SQLCODE
            MOVE "CUSTOMER DEREGISTERED SUCESSFULLY" TO MESSAGES.

       DEREG-ACCT-STATS-EXIT.
            EXIT.

           EXIT PROGRAM.