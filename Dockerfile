# Use latest ubuntu image as the base
FROM ubuntu:17.10

RUN useradd -m visakh ; echo visakh: | chpasswd ; usermod -a -G root visakh

RUN echo "hello"

# Set the default command to run on boot
# This will boot JBoss EAP in the standalone mode and bind to all interface
CMD bin/bash

