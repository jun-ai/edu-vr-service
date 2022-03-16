#!/bin/sh
pid=`ps aux | grep java.*edu-vr-admin-1.0-SNAPSHOT.jar | grep -v grep | awk '{print $2}'`
if [ $pid ]
then
    kill -9 $pid
fi
nohup java -Xms512m -Xmx512m -jar edu-vr-admin-1.0-SNAPSHOT.jar --spring.profiles.active=test --server.port=2090 >edu_vr_service.out 2>&1 &
echo "success"
echo "==================================================log==============================================="
tail -200f edu_vr_service.out
