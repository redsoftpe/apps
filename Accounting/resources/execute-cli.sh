#!/bin/sh
echo "================================================================"
echo "                                                                "
echo "    Ejecutando los scripts cli de configuracion de recursos     "
echo "                                                                "
echo "================================================================"
$JBOSS_HOME/bin/jboss-cli.sh --connect --file=./create-accountingds.cli
$JBOSS_HOME/bin/jboss-cli.sh --connect --file=./enable-accountingds.cli
$JBOSS_HOME/bin/jboss-cli.sh --connect --file=./create-accountingjaas.cli
$JBOSS_HOME/bin/jboss-cli.sh --connect --file=./create-security.cli
