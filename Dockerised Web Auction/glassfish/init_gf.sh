#!/bin/sh
# change password (it's horrible, but gf seems to accept as password parameters files only...)
echo "AS_ADMIN_PASSWORD=
AS_ADMIN_NEWPASSWORD=password" >> /home/gf-password.txt
asadmin --user=admin --passwordfile=/home/gf-password.txt change-admin-password --domain_name domain1
rm /home/gf-password.txt
# enable secure area
asadmin start-domain
echo "AS_ADMIN_PASSWORD=password" >> /home/gf-password.txt
asadmin --user=admin --passwordfile=/home/gf-password.txt enable-secure-admin
rm /home/gf-password.txt
asadmin enable-secure-admin --port 4848
asadmin --user=admin stop-domain
# finally start db and glassfish
asadmin start-database
asadmin start-domain -v