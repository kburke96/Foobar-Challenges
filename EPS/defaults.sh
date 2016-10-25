#/bin/bash

CURRENT_DIR=$(dirname $0)
IMPL_DIR=$CURRENT_DIR/../eps_impl
PRJ_IMPL_DIR=$CURRENT_DIR/Eps/impl
FILE="Node"$1"Impl.java"

cp $IMPL_DIR/$FILE $PRJ_IMPL_DIR
