#Script to start Jboss server with global access!!!
echo 
echo ========================================================================================
echo
echo "Starting Jboss-EAP(7.0)-Server"
echo 
echo ========================================================================================
echo

function isJbossServerRunning {
    (echo >/dev/tcp/localhost/8080) &> /dev/null

    if [ "$?" == 0 ]; then
        echo "Server is already running"
        exit 1;
    else
        echo "Starting Jboss..."
    fi
}

# Check if Jboss server running.
isJbossServerRunning

# Remove the tmp folder before starting the server to clean up the old data.
rm -rf /opt/ansible_app/jboss-eap-7.0/standalone/tmp

# Remove logs older than 7 days.
find /springboot/log/ -maxdepth 1 -mtime +6 -print -exec rm -rf {} \;

JAVA_OPTS="$JAVA_OPTS $JAVA_OPTS -Xrs -Xms1024m -Xmx1024m -XX:MaxPermSize=256m -XX:+UseConcMarkSweepGC -XX:+CMSPermGenSweepingEnabled -XX:+CMSClassUnloadingEnabled -Djava.net.preferIPv4Stack=true -Ddeployment-logging-config=false -DdbType=mysql -Dspring_rest_controller_enabled='false'"
export JAVA_OPTS

# Now call the standalone.sh which will bound the Server to accessible via IP.
# Run the Jboss Server in Background after closing the terminal session too.
$(dirname "$0")/standalone.sh -b 0.0.0.0 &
 
