javac -classpath c:\tomcat\common\lib\servlet-api.jar;. -d .\WEB-INF\classes *.java
jar -cvf FormWar.war *
copy FormWar.war c:\tomcat\webapps\.
pause
