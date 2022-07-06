javac *.java -d .\WEB-INF\classes
jar -cvf BookBean.war *
copy scope.war c:\tomcat\webapps\.
pause
