echo 
echo ========================================================================================
echo
echo "Stopping Jboss-EAP(7.0)-Server"
echo 
echo ========================================================================================
echo

(echo /dev/tcp/localhost/8080) &> /dev/null

if [ "$?" -eq "0" ]; then
    echo "Stopping the Jboss server!!!"
    $(dirname "$0")/jboss-cli.sh --connect ":shutdown"
else
    echo "Process not found - exiting"
fi

exit 0;
