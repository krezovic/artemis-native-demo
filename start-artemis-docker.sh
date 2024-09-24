#!/bin/bash

docker run -d --name artemis -p 61616:61616 apache/activemq-artemis:2.37.0
