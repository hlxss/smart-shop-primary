FROM  ubuntu:18.04
# 将jdk拷贝到容器中的opt目录下并解压
ADD  ./jdk-8u221-linux-x64.tar.gz  /opt/
# 配置jdk环境变量
ENV JAVA_HOME /opt/jdk1.8.0_221/
ENV  CLASSPATH ${JAVA_HOME}/lib;${JAVA_HOME}/jre/lib;
ENV PATH $JAVA_HOME/bin:$PATH
COPY ./smart.jar  /
RUN chmod 777 /smart.jar
#其他文件不要与Dockerfile文件放同级目录或者下级目录,把Dockerfile单独放,不然运行时Dockerfile会扫描其他文件,导致程序变慢
CMD ["java", "-jar" ,"smart.jar"]