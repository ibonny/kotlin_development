#!/bin/sh

curl https://get.sdkman.io | bash

sh ~/.sdkman/bin/sdkman-init.sh

sdk update

sdk install java 19.0.2-grl
sdk install gradle
