#!/bin/bash
# init
echo -n "Do you want to create javadocs ? (Y/n) "
read answer
if echo "$answer" | grep -iq "^Y" ;then
    javadoc -d progdoc -author -version -private -linksource  *.java
    javadoc -d userdoc -author -version *.java
else
    echo "Javadocs aren't created"
fi
