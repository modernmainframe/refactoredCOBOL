      ******************************************************************
      * Created: Mon, 8 Jan 2024 06:28:08 GMT
      * Generated by: IBM watsonx Code Assistant for Z Refactoring
      * Assistant
      * Workbook name: CBSBSDG
      * Workbook id: 52341f96-abf5-4da5-988d-b09f3c886a87
      * Project: $clientCOBOL_e12b6659-4368-4b8a-94fb-adca092197fe
      ******************************************************************

       IDENTIFICATION DIVISION.
       PROGRAM-ID. CBSBSDG.

       DATA DIVISION.
       WORKING-STORAGE SECTION.
      ******************************************************************
      * PATH : .../zOS Cobol/CBSBSDG.cbl
        01 WS-ACCOUNT-STATUS  PIC X(10).
        01 WK-CONSTANTS.
           05 WK-INACTIVE              PIC X(10) VALUE 'INACTIVE'.
        01 WG-WORK-AREA.
           02 CSDGRES.
      ******************************************************************
           COPY CSDGRES.
      * PATH : .../Cobol Include/CSDGRES.cpy
      * THE FOLLOWING VARIABLES ARE USED FROM THE COPYBOOK :
      *    03 CSRGRES.
      *         05 CUSTOMER-NAME PIC X(50).
      *         05 CUSTOMER-ID PIC S9(9).
      *         05 MESSAGES PIC X(100).
      ******************************************************************
      *COPY CBSMST.
      * PATH : .../Cobol Include/CBSMST.cpy
      * THE FOLLOWING VARIABLES ARE USED FROM THE COPYBOOK :
      *01  DCLCBS-ACCT-MSTR-DTL.
      *    10 H1-ACCOUNT-NUMBER    PIC S9(18) USAGE COMP.
      *    10 H1-ACCOUNT-NAME      PIC X(50).
      *    10 H1-CUSTOMER-ID       PIC S9(9) USAGE COMP.
      ******************************************************************
      * COPY SQLCA.
      * PATH : .../Cobol Include/SQLCA
      * THE FOLLOWING VARIABLES ARE USED FROM THE COPYBOOK :
      * 01 SQLCA.
      *     05 SQLCODE     PIC S9(9) COMP-5.
      ******************************************************************

      * SQLCA DB2 communications area
           EXEC SQL
             INCLUDE SQLCA
           END-EXEC.

	      EXEC SQL
             INCLUDE CBSMST
            END-EXEC.

       LINKAGE SECTION.

       PROCEDURE DIVISION.
      ******************************************************************
      * PROGRAM NAME : Program:COBOL:CBSBSDG
      * PROGRAM PATH : .../zOS Cobol/CBSBSDG.cbl
      * STMT START LINE NUMBER : 131
      * STMT END LINE NUMBER : 144
       CHECK-ACCT-STATUS.
           DISPLAY 'CHECK STATUS PARA'
           EVALUATE WS-ACCOUNT-STATUS
              WHEN 'ACTIVE    '
               DISPLAY 'DEREGISTER STARTING'
               MOVE 'ACCOUNT DEREGISTERING' TO MESSAGES
               PERFORM DEREG-ACCT-STATS
      * TODO : CHECK THE FOLLOWING <CONTINUE/NEXT SENTENCE/GO TO/GO
      * BACK/RETURN/STOP RUN/EXIT/EXIT PROGRAM> STATEMENT
                  THRU DEREG-ACCT-STATS-EXIT
              WHEN 'INACTIVE'
               MOVE 'CUSTOMER IS NOT REGISTERED' TO MESSAGES
              WHEN 'OTHER'
               DISPLAY 'NOT Y OR N'
               MOVE 'PLEASE CONTACT BANK' TO MESSAGES
           END-EVALUATE.
      ******************************************************************
      * PROGRAM NAME : Program:COBOL:CBSBSDG
      * PROGRAM PATH : .../zOS Cobol/CBSBSDG.cbl
      * STMT START LINE NUMBER : 148
      * STMT END LINE NUMBER : 158
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
      ******************************************************************
      * PROGRAM NAME : Program:COBOL:CBSBSDG
      * PROGRAM PATH : .../zOS Cobol/CBSBSDG.cbl
      * STMT START LINE NUMBER : 159
      * STMT END LINE NUMBER : 160
      * TODO : CHECK THE FOLLOWING <CONTINUE/NEXT SENTENCE/GO TO/GO
      * BACK/RETURN/STOP RUN/EXIT/EXIT PROGRAM> STATEMENT
       DEREG-ACCT-STATS-EXIT.
      * TODO : CHECK THE FOLLOWING <CONTINUE/NEXT SENTENCE/GO TO/GO
      * BACK/RETURN/STOP RUN/EXIT/EXIT PROGRAM> STATEMENT
            EXIT.
      ******************************************************************
           EXIT PROGRAM.
