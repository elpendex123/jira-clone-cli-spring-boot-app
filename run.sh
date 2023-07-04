#!/bin/sh
cd $(dirname $0)


echo -e "\n\nMVNW CLEAN PACKAGE"
./mvnw clean package
ret=$?
if [ $ret -ne 0 ]; then
exit $ret
fi
rm -rf target

echo -e "\n\nGRADLEW BUILD"
./gradlew build
ret=$?
if [ $ret -ne 0 ]; then
exit $ret
fi
rm -rf build

echo -e "\n\nMVNW CLEAN COMPILE"
./mvnw clean compile
ret=$?
if [ $ret -ne 0 ]; then
exit $ret
fi
rm -rf target

echo -e "\n\nGRADLEW COMPILEJAVA"
./gradlew compileJava
ret=$?
if [ $ret -ne 0 ]; then
exit $ret
fi
rm -rf build

exit
