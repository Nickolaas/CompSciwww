@REM ---------------------------------------------------------
@REM -- This batch file is an example of how to start ij in 
@REM -- an embedded environment.
@REM --
@REM -- REQUIREMENTS: 
@REM -- You must have the Cloudscape libraries in your classpath
@REM -- 
@REM -- See the setEmbeddedCP.bat for an example of
@REM -- how to do this.
@REM --
@REM -- This file for use on Windows systems
@REM ---------------------------------------------------------


@REM ---------------------------------------------------------
@REM -- start ij
@REM ---------------------------------------------------------
java -Dij.protocol=jdbc:db2j: com.ibm.db2j.tools.ij %1

@REM ---------------------------------------------------------
@REM -- To use Microsoft's JView JVM, use the following command
@REM ---------------------------------------------------------
@REM -- jview /d:ij.protocol=jdbc:db2j: com.ibm.db2j.tools.ij

@REM ---------------------------------------------------------
@REM -- To use a different JVM with a different syntax, simply edit
@REM -- this file
@REM ---------------------------------------------------------

