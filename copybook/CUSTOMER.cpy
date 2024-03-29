      ******************************************************************
      * DCLGEN TABLE(COREBK.CUSTOMER)                                  *
      *        LANGUAGE(COBOL)                                         *
      *        QUOTE                                                   *
      * ... IS THE DCLGEN COMMAND THAT MADE THE FOLLOWING STATEMENTS   *
      ******************************************************************
           EXEC SQL DECLARE CUSTOMER TABLE
           ( CUID                       INTEGER NOT NULL PRIMARY KEY,
             CUSTNAME                   CHAR(60) NOT NULL,
             ADDRESS1                   CHAR (250) NOT NULL,
             AGE                        INTEGER NOT NULL,
             STATUS1                    CHAR (1) NOT NULL
           ) END-EXEC.
      ******************************************************************
      * COBOL DECLARATION FOR TABLE CUSTOMER                           *
      ******************************************************************
       01  DCLCUSTOMER.
           10 CUID                 PIC S9(9) USAGE COMP.
           10 CUSTNAME             PIC X(60).
           10 ADDRESS1             PIC X(250).
           10 AGE                  PIC S9(9) USAGE COMP.
           10 STATUS1              PIC X(1).
      ******************************************************************
      * THE NUMBER OF COLUMNS DESCRIBED BY THIS DECLARATION IS 5       *
      ******************************************************************
