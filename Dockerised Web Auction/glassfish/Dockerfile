FROM glassfish 

ADD mysql-connector-java-5.1.45-bin.jar /usr/local/glassfish4/glassfish/domains/domain1/lib/mysql-connector-java-5.1.34.jar

COPY domain.xml /usr/local/glassfish4/glassfish/domains/domain1/config/domain.xml

ADD WebAuction.war /usr/local/glassfish4/glassfish/domains/domain1/autodeploy/

ADD init_gf.sh /home/
RUN chmod +x /home/init_gf.sh
CMD /home/init_gf.sh

EXPOSE 8080 4848 