#!/bin/sh

java -agentlib:native-image-agent=config-output-dir=$PWD/src/main/resources/META-INF/native-image/org.apache.activemq/artemis-jakarta-client,experimental-conditional-config-filter-file=$PWD/src/main/resources/META-INF/native-image/org.apache.activemq/artemis-jakarta-client/metadata-user-code-filter.json  -jar target/artemis-native-demo-0.0.1-SNAPSHOT.jar