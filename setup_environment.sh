#!/bin/sh

curl https://get.sdkman.io | bash

sdk update

sdk install java 19.0.2-grl
sdk install gradle
